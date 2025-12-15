// ===== ENUMS =====

enum TipoPao {
    TRADICIONAL(12.0), BRIOCHE(15.0), AUSTRALIANO(18.0);
    private final double preco;
    TipoPao(double preco) { this.preco = preco; }
    public double getPreco() { return preco; }
}

enum FormaPagamento {
    PIX, CARTAO, DINHEIRO
}

// ===== EXCEÇÕES =====

class LimiteAdicionalExcedidoException extends Exception {
    public LimiteAdicionalExcedidoException(String msg) { super(msg); }
}

class AdicionalInvalidoException extends Exception {
    public AdicionalInvalidoException(String msg) { super(msg); }
}

class CupomInvalidoException extends Exception {
    public CupomInvalidoException(String msg) { super(msg); }
}

// ===== CLASSE ADICIONAL =====

class Adicional {
    private String nome;
    private double preco;
    private boolean gratuito;

    public Adicional(String nome, double preco, boolean gratuito) {
        this.nome = nome;
        this.preco = preco;
        this.gratuito = gratuito;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public boolean isGratuito() { return gratuito; }
}

// ===== INTERFACES =====

interface Adicionavel {
    void adicionarAdicional(Adicional adicional) throws LimiteAdicionalExcedidoException;
}

interface Removivel {
    void removerAdicional(Adicional adicional) throws AdicionalInvalidoException;
}

interface PrecoCalculavel {
    double calcularPrecoFinal(FormaPagamento formaPagamento, boolean teleEntrega, String cupom)
            throws CupomInvalidoException;
}

// ===== CLASSE ABSTRATA PRODUTO =====

import java.util.ArrayList;
import java.util.List;

abstract class Produto implements Adicionavel, Removivel, PrecoCalculavel {
    protected String nome;
    protected double precoBase;
    protected List<Adicional> adicionais = new ArrayList<>();

    public double calcularTotalAdicionais() {
        double total = 0;
        for (Adicional a : adicionais) {
            if (!a.isGratuito()) total += a.getPreco();
        }
        return total;
    }

    protected abstract int getLimiteAdicionais();

    @Override
    public void adicionarAdicional(Adicional adicional) throws LimiteAdicionalExcedidoException {
        if (adicionais.size() >= getLimiteAdicionais()) {
            throw new LimiteAdicionalExcedidoException("Limite de adicionais excedido");
        }
        adicionais.add(adicional);
    }

    @Override
    public void removerAdicional(Adicional adicional) throws AdicionalInvalidoException {
        if (!adicionais.remove(adicional)) {
            throw new AdicionalInvalidoException("Adicional não encontrado");
        }
    }

    @Override
    public double calcularPrecoFinal(FormaPagamento formaPagamento, boolean teleEntrega, String cupom)
            throws CupomInvalidoException {
        double total = precoBase + calcularTotalAdicionais();

        if (formaPagamento == FormaPagamento.PIX) {
            total -= 5.0;
        }

        if (teleEntrega) {
            total += 7.0;
        }

        if (cupom != null && !cupom.isEmpty()) {
            switch (cupom) {
                case "CUPOM5" -> total -= 5.0;
                case "CUPOM10" -> total -= 10.0;
                default -> throw new CupomInvalidoException("Cupom inválido");
            }
        }
        return total;
    }
}

// ===== CLASSES CONCRETAS =====

class HamburguerTradicional extends Produto {
    public HamburguerTradicional() {
        nome = "Hambúrguer Tradicional";
        precoBase = 20.0;
    }
    protected int getLimiteAdicionais() { return 2; }
}

class HamburguerVegetariano extends Produto {
    public HamburguerVegetariano() {
        nome = "Hambúrguer Vegetariano";
        precoBase = 32.0;
    }
    protected int getLimiteAdicionais() { return 2; }
}

class HamburguerDuplo extends Produto {
    public HamburguerDuplo() {
        nome = "Hambúrguer Duplo";
        precoBase = 38.0;
    }
    protected int getLimiteAdicionais() { return 4; }
}

// ===== MAIN (TESTES) =====

public class Main {
    public static void main(String[] args) {
        try {
            Adicional bacon = new Adicional("Bacon", 8.0, false);
            Adicional alface = new Adicional("Alface", 0.0, true);
            Adicional guacamole = new Adicional("Guacamole", 5.5, false);

            Produto h1 = new HamburguerTradicional();
            h1.adicionarAdicional(bacon);
            h1.adicionarAdicional(alface);
            System.out.println("Total H1: " + h1.calcularPrecoFinal(FormaPagamento.PIX, true, "CUPOM5"));

            Produto h2 = new HamburguerDuplo();
            h2.adicionarAdicional(bacon);
            h2.adicionarAdicional(alface);
            h2.adicionarAdicional(guacamole);
            h2.adicionarAdicional(new Adicional("Pickles", 3.5, false));
            System.out.println("Total H2: " + h2.calcularPrecoFinal(FormaPagamento.CARTAO, false, ""));

            // Exceções
            h1.adicionarAdicional(guacamole); // limite excedido
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Produto h3 = new HamburguerVegetariano();
            h3.calcularPrecoFinal(FormaPagamento.DINHEIRO, false, "INVALIDO");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
