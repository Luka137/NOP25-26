package pckg_zad_2;

public class TerminRadionice {

    private String naziv;
    private String voditelj;
    private TipTermina tipTermina;
    private int brojMjesta;
    private String napomena;

    public TerminRadionice(String naziv, String voditelj, TipTermina tipTermina, int brojMjesta, String napomena) {
        this.naziv = naziv;
        this.voditelj = voditelj;
        this.tipTermina = tipTermina;
        this.brojMjesta = brojMjesta;
        this.napomena = napomena;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getVoditelj() {
        return voditelj;
    }

    public TipTermina getTipTermina() {
        return tipTermina;
    }

    public int getBrojMjesta() {
        return brojMjesta;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setVoditelj(String voditelj) {
        this.voditelj = voditelj;
    }

    public void setTipTermina(TipTermina tipTermina) {
        this.tipTermina = tipTermina;
    }

    public void setBrojMjesta(int brojMjesta) {
        this.brojMjesta = brojMjesta;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String uRedDatoteke() {
        return naziv + ";" + voditelj + ";" + tipTermina + ";" + brojMjesta + ";" + napomena;
    }

    @Override
    public String toString() {
        return tipTermina + " | " + naziv + " | " + voditelj
                + " | mjesta: " + brojMjesta + " | " + napomena;
    }
}