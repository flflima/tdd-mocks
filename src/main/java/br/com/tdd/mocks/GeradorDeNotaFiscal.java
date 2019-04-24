package br.com.tdd.mocks;

import java.util.Calendar;

public class GeradorDeNotaFiscal {

    private NFDao dao;
    private SAP sap;

    public GeradorDeNotaFiscal(NFDao dao, SAP sap) {
        this.dao = dao;
        this.sap = sap;
    }

    public NotaFiscal gera(Pedido pedido) {
        NotaFiscal nf = new NotaFiscal(pedido.getCliente(), pedido.getValorTotal() * 0.94, Calendar.getInstance());

        this.dao.persiste(nf);
        this.sap.envia(nf);

        return nf;
    }
}
