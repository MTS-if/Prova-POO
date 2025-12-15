package Semestre2Ano2025.AulaPratica8SimuladoProvaPratica;

public class Main {
    public static void main(String[] args) {
        Sabor morango = new Sabor("Morango", 5.0, false);
        Sabor cremeLeitinho = new Sabor("Creme Leitinho", 8.0, false);
        Sabor cremeRafaello = new Sabor("Creme Rafaello", 6.0, false);
        Sabor nutella = new Sabor("Nutella", 10.0, false);
        Sabor pacoca = new Sabor("Paçoca", 0, true);

        AcaiPequeno acaiPequeno = new AcaiPequeno("Açaí Pequeno", 10.0);
        acaiPequeno.adicionarSaborEValidarLimite(morango);
        acaiPequeno.adicionarSaborEValidarLimite(cremeRafaello);
        acaiPequeno.adicionarSaborEValidarLimite(cremeLeitinho);

//        acaiPequeno.removerSabor(cremeLeitinho);

//        acaiPequeno.adicionarSaborEValidarLimite(nutella);
        acaiPequeno.calcularValorTotalDosSaboresPagos();

        Pedido pedido = new Pedido(TipoPagamento.PIX, acaiPequeno);
        pedido.calcularValorTotalDoAcaiComSeusSabores();

//        acaiPequeno.removerSabor(pacoca);
    }
}
