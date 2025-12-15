package Semestre2Ano2025.AulaPratica8SimuladoProvaPratica;

public class Sabor {
    private String nomeDoSabor;
    private double precoDoSabor;
    private boolean gratuito;

    public Sabor(String nomeDoSabor, double precoDoSabor, boolean gratuito) {
        this.nomeDoSabor = nomeDoSabor;
        this.precoDoSabor = precoDoSabor;
        this.gratuito = gratuito;
    }

    public String getNomeDoSabor() {
        return nomeDoSabor;
    }

    public double getPrecoDoSabor() {
        return precoDoSabor;
    }

    public boolean isGratuito() {
        return gratuito;
    }
}
