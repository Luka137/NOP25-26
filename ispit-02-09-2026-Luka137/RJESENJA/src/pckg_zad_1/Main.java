package pckg_zad_1;

import java.io.IOException;

public class Main {

    private static final String ULAZNA_DATOTEKA = "DATA/podaci_zad_1.txt";
    private static final String IZVJESTAJ = "izvjestaj.txt";
    private static final String GRESKE = "greske.txt";

    public static void main(String[] args) {
        CitacPovrata citac = new CitacPovrata();
        ZapisivacIzvjestaja zapisivac = new ZapisivacIzvjestaja();

        try {
            citac.ucitaj(ULAZNA_DATOTEKA);
            zapisivac.zapisiIzvjestaj(IZVJESTAJ, citac.getIspravniZapisi());
            zapisivac.zapisiGreske(GRESKE, citac.getGreske());

            System.out.println("Ucitano ispravnih zapisa: " + citac.getIspravniZapisi().size());
            System.out.println("Neispravnih redaka: " + citac.getGreske().size());
            System.out.println("Izlazne datoteke: " + IZVJESTAJ + ", " + GRESKE);
        } catch (IOException e) {
            System.err.println("Greska pri radu s datotekama: " + e.getMessage());
        }
    }
}