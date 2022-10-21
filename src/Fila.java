public class Fila {
    private int trasSoma = 0;
    private int frenteSoma = 0;
    private int tamanho;

    Fila(int _tamanho) {
        
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
