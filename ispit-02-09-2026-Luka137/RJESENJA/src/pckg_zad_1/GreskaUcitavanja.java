package pckg_zad_1;

public class GreskaUcitavanja {

    private final int brojRetka;
    private final String sadrzajRetka;
    private final String objasnjenje;

    public GreskaUcitavanja(int brojRetka, String sadrzajRetka, String objasnjenje) {
        this.brojRetka = brojRetka;
        this.sadrzajRetka = sadrzajRetka;
        this.objasnjenje = objasnjenje;
    }

    public int getBrojRetka() {
        return brojRetka;
    }

    public String getSadrzajRetka() {
        return sadrzajRetka;
    }

    public String getObjasnjenje() {
        return objasnjenje;
    }

    @Override
    public String toString() {
        return brojRetka + " -> " + sadrzajRetka + " -> " + objasnjenje;
    }
}