package Semestre2Ano2025.AulaPratica8SimuladoProvaPratica;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Acai implements Adicionavel, Removivel {
    protected String nomeDoAcai;
    protected double precoBaseDoAcai;
    protected List<Sabor> listaDeSabores = new ArrayList<>();
    protected double totalDeSaborsPagos;

    protected Acai(String nomeDoAcai, double precoBaseDoAcai) {
        this.nomeDoAcai = nomeDoAcai;
        this.precoBaseDoAcai = precoBaseDoAcai;
    }

    protected abstract void adicionarSaborEValidarLimite(Sabor sabor);

    @Override
    public void adicionarSabor(Sabor sabor, int limiteDeSabores) {
        if (this.listaDeSabores.size() >= limiteDeSabores) {
            throw new LimiteSaborAdicionalExcedidoException("Ao tentar adicionar o sabor "
                    + sabor.getNomeDoSabor() + ", o limite de sabores adicionais para Açaí Pequeno foi excedido.");
        } else {
            this.listaDeSabores.add(sabor);
            System.out.println("Sabor " + sabor.getNomeDoSabor() + " adicionado ao Açaí Pequeno.");
        }
    }

    @Override
    public void removerSabor(Sabor sabor) {
        if (this.listaDeSabores.removeIf(sabor::equals)) {
            System.out.println("Sabor " + sabor.getNomeDoSabor() + " removido do Açaí " + this.nomeDoAcai + ".");
        } else {
            throw new RemoverSaborInvalidoException("Ao tentar remover o sabor "
                    + sabor.getNomeDoSabor() + ", o sabor não existe no " + this.nomeDoAcai + ".");
        }
    }

    public void calcularValorTotalDosSaboresPagos(){
        for (Sabor sabor : listaDeSabores) {
            if (!sabor.isGratuito()){
                totalDeSaborsPagos += sabor.getPrecoDoSabor();
            }
        }
    }

    public double getPrecoBaseDoAcai() {
        return precoBaseDoAcai;
    }

    public double getTotalDeSaborsPagos() {
        return totalDeSaborsPagos;
    }
}
