import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Aplicativo {
    public static Jogo[] listaJogos = new Jogo[1000];

    public static void main(String[] args) throws FileNotFoundException {
        MyIO.setCharset("UTF-8");
        String texto = new String();
        int jogoIndex = 0;

        try {
            File arquivo = new File("./src/tmp/partidas.txt");
            Scanner lerArquivo = new Scanner(arquivo);
            while (lerArquivo.hasNextLine()) {
                listaJogos[jogoIndex] = new Jogo(lerArquivo.nextLine());
                jogoIndex++;
            }
            lerArquivo.close();
            pesquisarJogos();
        } catch (Error err) {
            System.out.println("Um erro na leitura do arquivo foi encontrada");
        }

    }

    public static void pesquisarJogos() {
        String quantidadeStr = MyIO.readLine();
        int quantidade = Integer.parseInt(quantidadeStr);
        for (int i = 0; i < quantidade; i ++) {

            String proxLeitura = MyIO.readLine();
            String dados[] = proxLeitura.split(";");

            String pais = dados[1];
            String datas[] = dados[0].split("/");

            int dia = Integer.parseInt(datas[0]);
            int mes = Integer.parseInt(datas[1]);
            int ano = Integer.parseInt(datas[2]);

            for (int j = 0; (j < listaJogos.length && listaJogos[j] != null); j++) {
                if (listaJogos[j].comparar(dia, mes, ano, pais)) {
                    listaJogos[j].imprimir();
                }
            }
        }
    }
}
