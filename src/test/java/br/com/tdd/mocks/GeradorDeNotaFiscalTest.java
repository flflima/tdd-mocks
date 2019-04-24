package br.com.tdd.mocks;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class GeradorDeNotaFiscalTest {

    @Test
    public void deveGerarNFComValorDeImpostoDescontado() {
        GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(new NFDao(), new SAP());
        Pedido pedido = new Pedido("Mauricio", 1000, 1);
        NotaFiscal nf = gerador.gera(pedido);
        assertEquals(1000 * 0.94, nf.getValor(), 0.0001);
    }

    @Test
    public void devePersistirNFGerada() { // criando o mock
        NFDao dao = Mockito.mock(NFDao.class);
        final SAP sap = Mockito.mock(SAP.class);
        GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(dao, sap);
        Pedido pedido = new Pedido("Mauricio", 1000, 1);
        NotaFiscal nf = gerador.gera(pedido);

        // verificando que o método foi invocado
        Mockito.verify(dao).persiste(nf);
    }

    @Test
    public void deveEnviarNFGeradaParaSAP() {
        final NFDao dao = Mockito.mock(NFDao.class);
        final SAP sap = Mockito.mock(SAP.class);

        final GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(dao, sap);

        final Pedido pedido = new Pedido("Mauricio", 1000, 1);

        final NotaFiscal nf = gerador.gera(pedido);

        Mockito.verify(sap).envia(nf);
    }
}