package br.com.tdd.copiadora;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CopiadoraTest {

    @Test
    public void deveLerEEnviarOConteudoLido() {
        Escritor e = Mockito.mock(Escritor.class);
        Leitor l = Mockito.mock(Leitor.class);

        Mockito.when(l.temCaracteres()).thenReturn(true, false);
        Mockito.when(l.leCaracteres()).thenReturn("mauricio");

        Copiadora c = new Copiadora(l, e);

        c.copiar();

        Mockito.verify(e).escreve("mauricio");
    }

}