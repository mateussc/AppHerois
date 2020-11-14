package br.usjt.ads20.appfilmes.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Dados {
    private static ArrayList<Heroi> herois;

    public static void setHerois(ArrayList<Heroi> pHerois) {
        herois = pHerois;
    }

    public static Heroi[] buscarHerois(String chave) {
        ArrayList<Heroi> lista = herois;
        ArrayList<Heroi> filtro;
        Heroi[] herois;
        if (chave == null || chave.length() == 0) {
            filtro = lista;
        } else {
            filtro = new ArrayList<>();
            for (Heroi heroi : lista) {
                String nome = heroi.getNome();

                if (nome.toUpperCase().contains(chave.toUpperCase())) {
                    filtro.add(heroi);
                }
            }
        }
        herois = filtro.toArray(new Heroi[0]);
        Arrays.sort(herois);
        return herois;
    }
}
