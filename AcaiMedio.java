package Semestre2Ano2025.AulaPratica8SimuladoProvaPratica;

public class AcaiMedio extends Acai{

    protected AcaiMedio(String nomeDoAcai, double precoBaseDoAcai) {
        super(nomeDoAcai, precoBaseDoAcai);
    }

    @Override
    protected void adicionarSaborEValidarLimite(Sabor sabor) {
        super.adicionarSabor(sabor, 5);
    }
}
