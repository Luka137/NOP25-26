package pckg_zad_1;

public class Posiljka {

    private final String sifra;
    private String primatelj;
    private double masaKg;
    private double udaljenostKm;
    private PrioritetDostave prioritetDostave;

    public Posiljka(String sifra, String primatelj, double masaKg, double udaljenostKm,  PrioritetDostave prioritetDostave) {
        this.sifra = sifra;
        this.setPrimatelj(primatelj);
        this.setMasaKg(masaKg);
        this.setUdaljenostKm(udaljenostKm);
        this.setPrioritetDostave(prioritetDostave);
    }

    public void setPrimatelj(String primatelj) {
        this.primatelj = primatelj;
    }

    public void setMasaKg(double masaKg) {
        if(masaKg <= 0 || masaKg > 20) {
            throw new IllegalArgumentException("Masa mora biti veća od 0 i najviše 20kg");
        }
        this.masaKg = masaKg;
    }

    public void setUdaljenostKm(double udaljenostKm) {
        if(udaljenostKm <= 0 || udaljenostKm > 200) {
            throw new IllegalArgumentException("Udaljenost mora biti veća od 0 i najviše 200 km");
        }
        this.udaljenostKm = udaljenostKm;
    }

    public void setPrioritetDostave(PrioritetDostave prioritetDostave) {
        this.prioritetDostave = prioritetDostave;
    }

    public String getSifra() {
        return sifra;
    }

    public String getPrimatelj() {
        return primatelj;
    }

    public double getMasaKg() {
        return masaKg;
    }

    public double getUdaljenostKm() {
        return udaljenostKm;
    }

    public PrioritetDostave getPrioritetDostave() {
        return prioritetDostave;
    }

    public double izracunajCijenu(){
        double cijena = 2;
        cijena += masaKg * 0.75;
        if(udaljenostKm <= 10) {
            cijena += 1.50;
        } else if (udaljenostKm <= 50) {
            cijena += 4;
        } else{
            cijena += 7;
        }
        if(prioritetDostave.equals(PrioritetDostave.HITNA)){
            cijena += 5;
        }
        return cijena;
    }

    public Zona odrediZonu(){
        if(udaljenostKm <= 10){
            return Zona.LOKALNA;
        } else if (udaljenostKm <= 50) {
            return Zona.REGIONALNA;
        } else{
            return Zona.UDALJENA;
        }
    }

    public boolean zahtijevaPotvrdu(){
        return (masaKg > 15 || (prioritetDostave.equals(PrioritetDostave.HITNA) && udaljenostKm > 50));
    }

    @Override
    public String toString() {
        String redak = sifra + " - " + primatelj + " - " + odrediZonu() + " - " + prioritetDostave + " - " + String.format("%.2f", izracunajCijenu()) + " EUR";
        if(zahtijevaPotvrdu()){
            redak = redak + " ! POTVRDA";
        }
        return redak;
    }
}
