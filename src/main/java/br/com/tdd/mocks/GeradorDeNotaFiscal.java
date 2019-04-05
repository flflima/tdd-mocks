package br.com.tdd.mocks;

import java.util.Calendar;

public class GeradorDeNotaFiscal {

    private NFDao dao;

    public GeradorDeNotaFiscal(NFDao dao) {
        this.dao = dao;
    }

    public NotaFiscal gera(Pedido pedido) {
        NotaFiscal nf = new NotaFiscal(pedido.getCliente(), pedido.getValorTotal() * 0.94, Calendar.getInstance());

        this.dao.persiste(nf);
        return nf;
    }
}
