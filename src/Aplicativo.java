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

        Pilha pilha = new Pilha(1500);

        Scanner scan = new Scanner(System.in);
        String texto = scan.nextLine();
        do {
            for (int i = 0; ((i < listaJogos.length) && (listaJogos[i] != null)); i++) {
                if (listaJogos[i].comparar(texto)) {
                    try {
                        pilha.empilhar(listaJogos[i]);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            texto = scan.nextLine();
        } while (!texto.equals("FIM"));

        String tamanho = scan.nextLine();

        do {
            String comando = scan.nextLine();
            char tipo = comando.charAt(0);

            switch (tipo) {
                case 'E':
                    String separar[] = comando.split(" ");
                    for (int i = 0; ((i < listaJogos.length) && (listaJogos[i] != null)); i++) {
                        if (listaJogos[i].comparar(separar[1])) {
                            try {
                                pilha.empilhar(listaJogos[i]);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    break;
                case 'D':
                    try {
                        Jogo desempilhado = pilha.desempilhar();
                        System.out.printf("(D) ");
                        desempilhado.imprimir();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    break;
            }
        } while (scan.hasNextLine());

        try {
            pilha.mostrar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}