package br.com.tdd.mocks;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class GeradorDeNotaFiscalTest {

    @Test
    public void deveGerarNFComValorDeImpostoDescontado() {
        GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(new NFDao());
        Pedido pedido = new Pedido("Mauricio", 1000, 1);
        NotaFiscal nf = gerador.gera(pedido);
        assertEquals(1000 * 0.94, nf.getValor(), 0.0001);
    }

    @Test
    public void devePersistirNFGerada() { // criando o mock
        NFDao dao = Mockito.mock(NFDao.class);
        GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(dao);
        Pedido pedido = new Pedido("Mauricio", 1000, 1);
        NotaFiscal nf = gerador.gera(pedido);

        // verificando que o método foi invocado
        Mockito.verify(dao).persiste(nf);
    }

}