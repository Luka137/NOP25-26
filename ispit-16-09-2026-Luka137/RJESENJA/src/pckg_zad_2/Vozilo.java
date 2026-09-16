package pckg_zad_2;

public class Vozilo {

    private final String oznakaVozila;
    private String model;
    private TipVozila tipVozila;
    private int brojSjedala;
    private String napomena;

    public Vozilo(String oznakaVozila, String model, TipVozila tipVozila, int brojSjedala, String napomena) {
        if (oznakaVozila == null || oznakaVozila.trim().isEmpty()) {
            throw new IllegalArgumentException("Oznaka vozila ne smije biti prazna");
        }
        this.oznakaVozila = oznakaVozila;
        this.setModel(model);
        this.setTipVozila(tipVozila);
        this.setBrojSjedala(brojSjedala);
        this.setNapomena(napomena);
    }

    public void setModel(String model) {
        if(model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model ne smije biti prazan");
        }
        this.model = model;
    }

    public void setTipVozila(TipVozila tipVozila) {
        this.tipVozila = tipVozila;
    }

    public void setBrojSjedala(int brojSjedala) {
        if (brojSjedala < 1 || brojSjedala > 20) {
            throw new IllegalArgumentException("Broj sjedala mora biti u rasponu 1-20");
        }
        this.brojSjedala = brojSjedala;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getOznakaVozila() {
        return oznakaVozila;
    }

    public String getModel() {
        return model;
    }

    public TipVozila getTipVozila() {
        return tipVozila;
    }

    public int getBrojSjedala() {
        return brojSjedala;
    }

    public String getNapomena() {
        return napomena;
    }

    @Override
    public String toString() {
        return tipVozila + " | " + oznakaVozila + " | " + model + " | sjedala: " + brojSjedala + " | " + napomena;
    }
}
