package pckg_zad_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CitacPovrata {

    private final ParserRetka parser = new ParserRetka();
    private final List<PovratGradje> ispravniZapisi = new ArrayList<PovratGradje>();
    private final List<GreskaUcitavanja> greske = new ArrayList<GreskaUcitavanja>();

    public void ucitaj(String relativnaPutanja) throws IOException {
        ispravniZapisi.clear();
        greske.clear();

        try (BufferedReader citac = new BufferedReader(new FileReader(relativnaPutanja))) {
            String redak;
            int brojRetka = 0;
            while ((redak = citac.readLine()) != null) {
                brojRetka++;
                try {
                    ispravniZapisi.add(parser.parsiraj(redak));
                } catch (NeispravanZapisException e) {
                    greske.add(new GreskaUcitavanja(brojRetka, redak, e.getMessage()));
                }
            }
        }
    }

    public List<PovratGradje> getIspravniZapisi() {
        return ispravniZapisi;
    }

    public List<GreskaUcitavanja> getGreske() {
        return greske;
    }
}