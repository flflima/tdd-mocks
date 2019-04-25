package br.com.tdd.mocks;

import java.util.Calendar;
import java.util.List;

public class GeradorDeNotaFiscal {

    private List<AcaoAposGerarNota> acaoAposGerarNota;

    public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acaoAposGerarNota) {
        this.acaoAposGerarNota = acaoAposGerarNota;
    }

    public NotaFiscal gera(Pedido pedido) {
        NotaFiscal nf = new NotaFiscal(pedido.getCliente(), pedido.getValorTotal() * 0.94, Calendar.getInstance());

        for (AcaoAposGerarNota acao : acaoAposGerarNota) {
            acao.executa(nf);
        }

        return nf;
    }
}
