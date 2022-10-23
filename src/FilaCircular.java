public class FilaCircular {

    private Jogo[] filaJogo;
    private int trasSoma = 0;
    private int frenteSoma = 0;
    private int tamanho;

    public FilaCircular(int _tamanho) {
        filaJogo = new Jogo[(_tamanho + 1)];
        tamanho = (_tamanho + 1);
    }

    FilaCircular(){}

    private int getTras() {
        return (trasSoma % tamanho);
    }

    private int getFrente() {
        return (frenteSoma % tamanho);
    }

    public boolean isVazia() {
        if (getFrente() == getTras()) {
            return true;
        }
        return false;
    }

    public boolean isCheia() {
        if (getFrente() == ((trasSoma + 1) % tamanho)) {
            return true;
        }
        return false;
    }

    public void adicionarFila(Jogo obj) throws Exception {
        if (! isCheia()) {
            filaJogo[getTras()] = obj;
            trasSoma++;
        } else {
            throw new Exception("A fila está cheia!");
        }
    }

    public Jogo removerFila() throws Exception {
        if (! isVazia()) {
            Jogo desenfilerado = filaJogo[getFrente()];
            frenteSoma++;
            return desenfilerado;
        } else {
            throw new Exception("A fila está vazia!");
        }
    }

    public void mostrar() throws Exception {
        if (! isVazia()) {
            for (int i = frenteSoma; i < trasSoma; i++) {
                int posicao = (i % tamanho);
                System.out.print(posicao);
                (filaJogo[posicao]).imprimir();
            }
        } else {
            throw new Exception("A fila está vazia!");
        }
    }

    public double obterMediaGols() throws Exception {
        int quantidade = 0;
        int soma = 0;
        double media = (soma / quantidade);
        if (! isVazia()) {
            for (int i = frenteSoma; i < trasSoma; i++) {
                int posicao = (i % tamanho);
                Jogo obj = filaJogo[posicao];
                soma += obj.getGols();
                quantidade++;
            }
        } else {
            throw new Exception("A fila está vazia!");
        }
        return media;
    }
}
