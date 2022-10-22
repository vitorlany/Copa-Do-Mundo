import java.sql.Array;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Jogo {
    private int dia;
    private int mes;
    private int ano;
    private String etapa;
    private String selecao1;
    private String selecao2;
    private int placarSelecao1;
    private int placarSelecao2;
    private String local;

    Jogo(String texto) {
        String dados[] = texto.split("#");
        ano = Integer.parseInt(dados[0]);
        etapa = dados[1];
        dia = Integer.parseInt(dados[2]);
        mes = Integer.parseInt(dados[3]);
        selecao1 = dados[4];
        placarSelecao1 = Integer.parseInt(dados[5]);
        placarSelecao2 = Integer.parseInt(dados[6]);
        selecao2 = dados[7];
        local = dados[8];
    }

    Jogo(int _ano, String _etapa, int _dia, int _mes, String _selecao1, int _placarSelecao1, int _placarSelecao2, String _selecao2, String _local) {
        ano = _ano;
        etapa = _etapa;
        dia = _dia;
        mes = _mes;
        selecao1 = _selecao1;
        placarSelecao1 = _placarSelecao1;
        placarSelecao2 = _placarSelecao2;
        selecao2 = _selecao2;
        local = _local;
    }

    Jogo() {}

    public boolean comparar(int _dia, int _mes, int _ano, String _selecao1) {
        if ((_dia == dia) && (_mes == mes) && (_ano == ano) && (_selecao1.equals(selecao1))) {
            return true;
        }
        return false;
    }

    public Jogo clone() {
        Jogo clone = new Jogo(ano, etapa, dia, mes, selecao1, placarSelecao1, placarSelecao2, selecao2, local);
        return clone;
    }

    public void imprimir() {
        System.out.printf("[COPA " + ano +"] ["+ etapa +"] ["+ dia +"/"+ mes +"] ["+ selecao1 +" ("+ placarSelecao1 +") x ("+ placarSelecao2 +") " + ""+ selecao2 +"] ["+ local +"]\n");
    }

    public int getGols() {
        return this.placarSelecao1 + this.placarSelecao2;
    }


}
