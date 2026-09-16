package pckg_zad_2;

public interface FormPanelListener {

    void ucitajEvent();
    void spremiEvent();
    void dodajVoziloEvent(String oznaka, String model, TipVozila tipVozila, int brojSjedala, String napomena);
}
