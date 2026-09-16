package pckg_zad_2;

import java.util.ArrayList;

public class RezultatUcitavanja {

    private final ArrayList<Vozilo> vozila;
    private final int brojPreskocenih;

    public RezultatUcitavanja(ArrayList<Vozilo> vozila, int brojPreskocenih) {
        this.vozila = vozila;
        this.brojPreskocenih = brojPreskocenih;
    }

    public ArrayList<Vozilo> getVozila() {
        return vozila;
    }

    public int getBrojPreskocenih() {
        return brojPreskocenih;
    }
}