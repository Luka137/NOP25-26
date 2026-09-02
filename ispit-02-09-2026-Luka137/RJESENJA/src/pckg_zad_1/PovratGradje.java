package pckg_zad_1;

public class PovratGradje {

    private static final double NAKNADA_PO_DANU = 0.50;
    private static final double NAKNADA_PO_OSTECENJU = 3.00;
    private static final int PRAG_DANA_ZA_KONTAKT = 30;
    private static final int PRAG_OSTECENJA_ZA_KONTAKT = 2;

    private String inventarniBroj;
    private String naslov;
    private String korisnik;
    private int daniKasnjenja;
    private int brojOstecenja;

    public PovratGradje(String inventarniBroj, String naslov, String korisnik, int daniKasnjenja, int brojOstecenja) {
        this.inventarniBroj = inventarniBroj;
        this.naslov = naslov;
        this.korisnik = korisnik;
        this.daniKasnjenja = daniKasnjenja;
        this.brojOstecenja = brojOstecenja;
    }

    public String getInventarniBroj() {
        return inventarniBroj;
    }

    public String getNaslov() {
        return naslov;
    }

    public String getKorisnik() {
        return korisnik;
    }

    public int getDaniKasnjenja() {
        return daniKasnjenja;
    }

    public int getBrojOstecenja() {
        return brojOstecenja;
    }

    public void setInventarniBroj(String inventarniBroj) {
        this.inventarniBroj = inventarniBroj;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }

    public void setDaniKasnjenja(int daniKasnjenja) {
        this.daniKasnjenja = daniKasnjenja;
    }

    public void setBrojOstecenja(int brojOstecenja) {
        this.brojOstecenja = brojOstecenja;
    }

    public double izracunajNaknadu() {
        if (daniKasnjenja == 0 && brojOstecenja == 0) {
            return 0.0;
        }
        return daniKasnjenja * NAKNADA_PO_DANU + brojOstecenja * NAKNADA_PO_OSTECENJU;
    }

    public Status odrediStatus() {
        if (brojOstecenja > 0) {
            return Status.OSTECENO;
        }
        if (daniKasnjenja > 0) {
            return Status.KASNJENJE;
        }
        return Status.UREDNO;
    }

    public boolean zahtijevaKontakt() {
        return daniKasnjenja > PRAG_DANA_ZA_KONTAKT || brojOstecenja >= PRAG_OSTECENJA_ZA_KONTAKT;
    }

    @Override
    public String toString() {
        return inventarniBroj + " " + naslov + " - " + korisnik + " (dani kasnjenja: " + daniKasnjenja + ", ostecenja: " + brojOstecenja + ")";
    }
}