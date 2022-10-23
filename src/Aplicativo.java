import java.io.File;
import java.util.Scanner;

public class Aplicativo {
    public static Jogo[] listaJogos = new Jogo[1000];
    public static FilaCircular filaJogos = new FilaCircular(350);

    public static void main(String[] args) {
        int jogoIndex = 0;
        try {
            File arquivo = new File("./src/tmp/partidas.txt");
            Scanner lerArquivo = new Scanner(arquivo);
            while (lerArquivo.hasNextLine()) {
                Jogo novoJogo = new Jogo(lerArquivo.nextLine());
                listaJogos[jogoIndex] = novoJogo;
                jogoIndex++;
            }
            lerArquivo.close();
        } catch (Exception error) {
            //System.out.println(error.getMessage());
        }
        lerEnfileiramento();
    }

    public static void lerEnfileiramento() {
        Scanner lerEntrada = new Scanner(System.in);
        String entrada = lerEntrada.nextLine();
        do {
            for (int i = 0; ((i < listaJogos.length) && (listaJogos[i] != null)); i++) {
                if (listaJogos[i].comparar(entrada)) {
                    try {
                        filaJogos.adicionarFila(listaJogos[i]);
                        System.out.println( Math.round(filaJogos.obterMediaGols()) );
                        break;
                    } catch (Exception e) {
                        //System.out.println(e.getMessage());
                    }
                }
            }
            entrada = lerEntrada.nextLine();
        } while (! entrada.equals("FIM"));

        lerEntrada.nextLine(); // Linhas, mas não vou usar

        while (lerEntrada.hasNextLine()) {
            entrada = lerEntrada.nextLine();
            char tipo = entrada.charAt(0);
            try {
                switch (tipo) {
                    case 'E':
                        String[] divideEntradas = entrada.split(" ");
                        for (int i = 0; ((i < listaJogos.length) && (listaJogos[i] != null)); i++) {
                            if (listaJogos[i].comparar(divideEntradas[1])) {
                                try {
                                    filaJogos.adicionarFila(listaJogos[i]);
                                    System.out.println( Math.round(filaJogos.obterMediaGols()) );
                                    break;
                                } catch (Exception e) {
                                    filaJogos.removerFila();
                                    filaJogos.adicionarFila(listaJogos[i]);
                                }
                            }
                        }
                        break;

                    case 'D':
                        Jogo desenfilerado = filaJogos.removerFila();
                        System.out.printf("(D) ");
                        desenfilerado.imprimir();
                        break;

                    default:
                        break;
                }
            } catch (Exception e) {
                //System.out.println(e.getMessage());
            }
        }
    }
}