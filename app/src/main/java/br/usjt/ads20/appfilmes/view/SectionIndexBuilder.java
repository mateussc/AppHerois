package br.usjt.ads20.appfilmes.view;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TreeSet;

import br.usjt.ads20.appfilmes.model.Heroi;

public class SectionIndexBuilder {
    public static Object[] buildSectionHeaders(Heroi[] herois) {
        ArrayList<String> results = new ArrayList<>();
        TreeSet<String> used = new TreeSet<>();

        if (herois != null) {
            for (Heroi heroi : herois) {
                String letter = heroi.getNome().substring(0, 1);
                if (!used.contains(letter)) {
                    results.add(letter);
                }
                used.add(letter);
            }
        }
        return results.toArray(new Object[0]);
    }

    public static Hashtable<Integer, Integer> buildPositionForSectionMap(Heroi[] herois) {
        Hashtable<Integer, Integer> results = new Hashtable<>();
        TreeSet<String> used = new TreeSet<>();
        int section = -1;

        if (herois != null) {
            for (int i = 0; i < herois.length; i++) {
                String letter = herois[i].getNome().substring(0, 1);
                if (!used.contains(letter)) {
                    section++;
                    used.add(letter);
                    results.put(section, i);
                }
            }
        }
        return results;
    }

    public static Hashtable<Integer, Integer> buildSectionForPosition(Heroi[] herois) {
        Hashtable<Integer, Integer> results = new Hashtable<>();

        TreeSet<String> used = new TreeSet<>();
        int section = -1;

        if (herois != null) {
            for (int i = 0; i < herois.length; i++) {
                String letter = herois[i].getNome().substring(0, 1);
                if (!used.contains(letter)) {
                    section++;
                    used.add(letter);
                }
                results.put(i, section);
            }
        }
        return results;
    }
}
