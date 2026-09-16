package pckg_zad_2;

import java.io.*;
import java.util.ArrayList;

public final class AUX_RW {

    private static final String RAZDJELNIK = ";";

    private AUX_RW() {

    }

    public static void spremiVozila(ArrayList<Vozilo> listaVozila, String putanja){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(putanja))){
            for(Vozilo v : listaVozila){
                String redak = v.getOznakaVozila() + RAZDJELNIK + v.getModel() + RAZDJELNIK + v.getTipVozila() + RAZDJELNIK + v.getBrojSjedala() + RAZDJELNIK + v.getNapomena();
                bw.write(redak + "\n");
            }
        } catch (IOException e) {
            System.err.println("Greska pri spremanju vozila: " + e.getMessage());
        }
    }

    public static RezultatUcitavanja ucitajVozila(String putanja){
        ArrayList<Vozilo> listaVozila = new ArrayList<>();
        int brojPreskocenih = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(putanja))){
            String redak;
            while ((redak = br.readLine()) != null){

                try{
                    String[] polja = redak.split(";");
                    if(polja.length != 5){
                        throw new IllegalArgumentException("Neispravan broj polja (ocekivano 5)");
                    }

                    String oznaka = polja[0];
                    String model = polja[1];
                    TipVozila tip = TipVozila.valueOf(polja[2]);
                    int brojSjedala = Integer.parseInt(polja[3]);
                    String napomena = polja[4];

                    Vozilo vozilo = new Vozilo(oznaka, model, tip, brojSjedala, napomena);
                    listaVozila.add(vozilo);
                } catch (IllegalArgumentException e) {
                    brojPreskocenih++;
                    System.err.println("Prekocen redak: " + redak + " (" + e.getMessage() + ")");
                }
            }

        } catch (IOException e){
            System.err.println("Greska pri citanju: " + e.getMessage());
        }

        return new RezultatUcitavanja(listaVozila, brojPreskocenih);
    }


}
