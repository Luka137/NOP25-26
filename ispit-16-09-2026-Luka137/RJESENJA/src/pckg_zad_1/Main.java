package pckg_zad_1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String inputPutanja = "DATA/paketi_zad_1_ver_2.csv";
        String errorPutanja = "DATA/greske_dostave.txt";
        String outputPutanja = "DATA/izvjestaj_dostave.txt";

        ArrayList<Posiljka> ispravnePosiljke = DatotekaServis.ucitajPosiljke(inputPutanja, errorPutanja);
        DatotekaServis.napisiIzvjestaj(outputPutanja, ispravnePosiljke);

        System.out.println("Obrada zavrsena. Ispravnih zapisa: " + ispravnePosiljke.size());
    }
}