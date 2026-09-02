package pckg_zad_1;

import java.util.List;

public class SazetakIzvjestaja {

    private int ukupnoZapisa;
    private int brojUrednih;
    private int brojKasnjenja;
    private int brojOstecenih;
    private double ukupnaNaknada;

    public SazetakIzvjestaja(List<PovratGradje> zapisi) {
        for (int i = 0; i < zapisi.size(); i++) {
            PovratGradje povrat = zapisi.get(i);
            ukupnoZapisa++;
            ukupnaNaknada += povrat.izracunajNaknadu();

            Status status = povrat.odrediStatus();
            if (status == Status.UREDNO) {
                brojUrednih++;
            } else if (status == Status.KASNJENJE) {
                brojKasnjenja++;
            } else {
                brojOstecenih++;
            }
        }
    }

    public int getUkupnoZapisa() {
        return ukupnoZapisa;
    }

    public int getBrojUrednih() {
        return brojUrednih;
    }

    public int getBrojKasnjenja() {
        return brojKasnjenja;
    }

    public int getBrojOstecenih() {
        return brojOstecenih;
    }

    public double getUkupnaNaknada() {
        return ukupnaNaknada;
    }
}