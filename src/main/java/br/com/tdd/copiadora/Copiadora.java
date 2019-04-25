package br.com.tdd.copiadora;

public class Copiadora {

    private Leitor leitor;
    private Escritor escritor;

    public Copiadora(Leitor l, Escritor e) {
        this.leitor = l;
        this.escritor = e;
    }

    public void copiar() {
        while (leitor.temCaracteres()) {
            escritor.escreve(leitor.leCaracteres());
        }
    }
}
