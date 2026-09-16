package pckg_zad_2;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class AUX_RW {

    private AUX_RW() {
    }

    public static void primjerMetode(){
    }

    public static void spremi(ArrayList<TerminRadionice> termini, String putanja)
            throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(putanja));
            for (int i = 0; i < termini.size(); i++) {
                writer.write(termini.get(i).uRedDatoteke());
                writer.newLine();
            }
        } finally {
            if (writer != null) writer.close();
        }
    }

    public static ArrayList<TerminRadionice> ucitaj(String putanja) throws IOException {
        ArrayList<TerminRadionice> termini = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(putanja));
            String linija;
            while ((linija = reader.readLine()) != null) {
                if (linija.trim().isEmpty()) {
                    continue;
                }
                TerminRadionice t = parsiraj(linija);
                if (t != null) {
                    termini.add(t);
                }
            }
        } finally {
            if (reader != null) reader.close();
        }
        return termini;
    }

    private static TerminRadionice parsiraj(String linija) {
        String[] polja = linija.split(";");
        if (polja.length != 5) {
            return null;
        }
        String naziv = polja[0].trim();
        String voditelj = polja[1].trim();
        String tipTekst = polja[2].trim();
        String brojMjestaTekst = polja[3].trim();
        String napomena = polja[4].trim();

        if (naziv.isEmpty() || voditelj.isEmpty()) {
            return null;
        }

        TipTermina tip;
        try {
            tip = TipTermina.valueOf(tipTekst);
        } catch (IllegalArgumentException e) {
            return null;
        }

        int brojMjesta;
        try {
            brojMjesta = Integer.parseInt(brojMjestaTekst);
        } catch (NumberFormatException e) {
            return null;
        }

        if (brojMjesta <= 0) {
            return null;
        }

        return new TerminRadionice(naziv, voditelj, tip, brojMjesta, napomena);
    }

    public static class GlavniProzor extends JFrame {

        private final ArrayList<TerminRadionice> termini;

        public GlavniProzor() {
            super("Evidencija termina radionica");

            termini = new ArrayList<TerminRadionice>();

            postaviProzor();
            postaviPanele();
        }

        private void postaviProzor() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(900, 600);
            setLocationRelativeTo(null);
        }

        private void postaviPanele() {
            ViewPanel viewPanel = new ViewPanel();
            FormPanel formPanel = new FormPanel(termini, viewPanel);

            JPanel sadrzaj = new JPanel(new GridLayout(1, 2, 10, 10));
            sadrzaj.add(formPanel);
            sadrzaj.add(viewPanel);

            add(sadrzaj);
        }
    }
}