package Semestre2Ano2025.AulaPratica8SimuladoProvaPratica;

public class AcaiPequeno extends Acai implements Adicionavel {

    protected AcaiPequeno(String nomeDoAcai, double precoBaseDoAcai) {
        super(nomeDoAcai, precoBaseDoAcai);
    }

    @Override
    protected void adicionarSaborEValidarLimite(Sabor sabor) {
        super.adicionarSabor(sabor, 3);
    }
}
