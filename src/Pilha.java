public class Pilha {
    private Jogo pilha[];
    int topo = 0;

    public Pilha (int tamanho) {
        pilha = new Jogo[tamanho];
    }

    public Pilha () {
        pilha = new Jogo[1000];
    }

    public void empilhar(Jogo novo) throws Exception {
        if (! isCheia()) {
            pilha[topo] = novo;
            topo++;
        } else {
            throw new Exception("A fila está cheia!");
        }
    }

    public Jogo desempilhar() throws Exception {
        if (!isVazia()) {
            topo--;
            return pilha[topo];
        } else {
            throw new Exception("A fila está vazia!");
        }
    }

    public void mostrar() throws Exception {
        if (! isVazia()) {
            for (int i = (topo - 1); i >= 0; i--) {
                pilha[i].imprimir();
            }
        } else {
            throw new Exception("A fila está vazia!");
        }
    }

    public boolean isCheia() {
        if (topo == pilha.length) {
            return true;
        }
        return false;
    }

    public boolean isVazia() {
        if (topo == 0) {
            return true;
        }
        return false;
    }
}
