import java.io.File;
import java.util.Scanner;

public class Aplicativo {
    public static FilaCircular filaJogos = new FilaCircular(100);

    public static void main(String[] args) {
        try {
            File arquivo = new File("./src/tmp/partidas.txt");
            Scanner lerArquivo = new Scanner(arquivo);
            while (lerArquivo.hasNextLine()) {
                Jogo novoJogo = new Jogo();
                filaJogos.adicionarFila(novoJogo);
            }
            lerArquivo.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}