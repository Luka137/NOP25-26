package pckg_zad_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class DatotekaServis {

    private DatotekaServis() {
    }

    public static ArrayList<Posiljka> ucitajPosiljke(String inputPutanja, String errorPutanja) {
        ArrayList<Posiljka> ispravne = new ArrayList<>();
        ArrayList<String> greske = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputPutanja))) {
            String redak;
            int brojRetka = 0;

            while ((redak = br.readLine()) != null) {
                brojRetka++;

                try {
                    String[] polja = redak.split(";");

                    if (polja.length != 5) {
                        throw new IllegalArgumentException("Neispravan broj polja (ocekivano 5)");
                    }

                    String sifra = polja[0];
                    String primatelj = polja[1];
                    double masaKg = Double.parseDouble(polja[2]);
                    double udaljenostKm = Double.parseDouble(polja[3]);
                    PrioritetDostave prioritet = PrioritetDostave.valueOf(polja[4]);

                    Posiljka posiljka = new Posiljka(sifra, primatelj, masaKg, udaljenostKm, prioritet);
                    ispravne.add(posiljka);

                } catch (IllegalArgumentException e) {
                    greske.add(brojRetka + " -> " + redak + " -> " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Greska pri citanju: " + e.getMessage());
        }

        zapisiGreske(errorPutanja, greske);
        return ispravne;
    }

    private static void zapisiGreske(String errorPutanja, ArrayList<String> greske) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(errorPutanja))) {
            for (String greska : greske) {
                bw.write(greska + "\n");
            }
        } catch (IOException e) {
            System.err.println("Greska pri pisanju: " + e.getMessage());
        }
    }

    public static void napisiIzvjestaj(String outputPutanja, ArrayList<Posiljka> ispravnePosiljke) {
        try (BufferedWriter pisac = new BufferedWriter(new FileWriter(outputPutanja))) {

            int brojLokalnih = 0;
            int brojRegionalnih = 0;
            int brojUdaljenih = 0;
            int brojHitnih = 0;
            double ukupnaVrijednost = 0;

            for (Posiljka p : ispravnePosiljke) {
                pisac.write(p.toString() + "\n");

                Zona zona = p.odrediZonu();
                if (zona == Zona.LOKALNA) {
                    brojLokalnih++;
                } else if (zona == Zona.REGIONALNA) {
                    brojRegionalnih++;
                } else {
                    brojUdaljenih++;
                }

                if (p.getPrioritetDostave() == PrioritetDostave.HITNA) {
                    brojHitnih++;
                }

                ukupnaVrijednost += p.izracunajCijenu();
            }

            pisac.write("\n");
            pisac.write("SAZETAK\n");
            pisac.write("Ukupno ispravnih posiljaka: " + ispravnePosiljke.size() + "\n");
            pisac.write("Lokalnih: " + brojLokalnih + "\n");
            pisac.write("Regionalnih: " + brojRegionalnih + "\n");
            pisac.write("Udaljenih: " + brojUdaljenih + "\n");
            pisac.write("Hitnih dostava: " + brojHitnih + "\n");
            pisac.write(String.format("Ukupna vrijednost: %.2f EUR\n", ukupnaVrijednost));

        } catch (IOException e) {
            System.err.println("Greska pri pisanju izvjestaja: " + e.getMessage());
        }
    }
}