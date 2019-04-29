package br.com.tdd.mocks;

import java.util.Calendar;
import java.util.List;

public class GeradorDeNotaFiscal {

    private final List<AcaoAposGerarNota> acaoAposGerarNota;
    private final Relogio relogio;

    public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acaoAposGerarNota,
                               Relogio relogio) {
        this.acaoAposGerarNota = acaoAposGerarNota;
        this.relogio = relogio;
    }

    public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acaoAposGerarNotarelogio) {
        this(acaoAposGerarNotarelogio, new RelogiodoSistema());
    }

    public NotaFiscal gera(Pedido pedido) {
        NotaFiscal nf = new NotaFiscal(pedido.getCliente(), pedido.getValorTotal() * 0.94, relogio.hoje());

        for (AcaoAposGerarNota acao : acaoAposGerarNota) {
            acao.executa(nf);
        }

        return nf;
    }
}
