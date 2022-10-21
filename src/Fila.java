public class Fila {

    private Jogo[] filaJogo;
    private int trasSoma = 0;
    private int frenteSoma = 0;
    private int tamanho;

    public Fila(int _tamanho) {
        filaJogo = new Jogo[(_tamanho + 1)];
        tamanho = (_tamanho + 1);
    }

    private int getTras() {
        return (trasSoma % tamanho);
    }

    private int getFrente() {
        return (frenteSoma % tamanho);
    }

    private boolean isVazia() {
        if (getFrente() == getTras()) {
            return true;
        }
        return false;
    }
}
