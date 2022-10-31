import java.io.File;
import java.util.Scanner;

public class Aplicativo {
    public static Jogo[] listaJogos = new Jogo[1000];
    private static void gerarVetor() {
        try {
            int jogoIndex = 0;
            File arquivo = new File("./src/tmp/partidas.txt");
            Scanner lerArquivo = new Scanner(arquivo);
            while (lerArquivo.hasNextLine()) {
                Jogo novoJogo = new Jogo(lerArquivo.nextLine());
                listaJogos[jogoIndex] = novoJogo;
                jogoIndex++;
            }
            lerArquivo.close();
        } catch (Exception error) {}
    }

    public static void main(String[] args) {
        gerarVetor();

        Pilha pilha = new Pilha(1000);

        try {
            pilha.empilhar(listaJogos[5]);
            pilha.mostrar();
            pilha.desempilhar();
            pilha.mostrar();
        } catch (Exception err){
            System.out.println(err.getMessage());
        }
    }

}