package Semestre2Ano2025.AulaPratica8SimuladoProvaPratica;

public class Pedido {
    private TipoPagamento tipoPagamento;
    private Acai acai;

    public Pedido(TipoPagamento tipoPagamento, Acai acai) {
        this.tipoPagamento = tipoPagamento;
        this.acai = acai;
    }

    public void calcularValorTotalDoAcaiComSeusSabores() {
        double valorTotalDeTudo = acai.getPrecoBaseDoAcai() + acai.getTotalDeSaborsPagos();

        if (this.tipoPagamento.equals(TipoPagamento.PIX)) {
            valorTotalDeTudo -= 7.0;
            System.out.println("Valor total do açaí com seus sabores pagos e desconto no PIX: R$ " + valorTotalDeTudo);
        } else {
            System.out.println("Valor total do açaí com seus sabores: R$ " + valorTotalDeTudo);
        }
    }
}
