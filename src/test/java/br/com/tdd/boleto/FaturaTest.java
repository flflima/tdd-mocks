package br.com.tdd.boleto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FaturaTest {

    @Test
    public void deveMarcarFaturaComoPagaCasoBoletoUnicoPagueTudo() {
        ProcessadorDeBoletos processador = new ProcessadorDeBoletos();
        Fatura fatura = new Fatura("Cliente", 150.0);
        Boleto b1 = new Boleto(150.0);
        List<Boleto> boletos = Arrays.asList(b1);
        processador.processa(boletos, fatura);
        assertTrue(fatura.isPago());
    }
}