package pckg_zad_2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame implements FormPanelListener{

    private static final String DATOTEKA = "DATA/vozila_ver_2.txt";

    private ArrayList<Vozilo> vozila;
    private FormPanel formPanel;
    private ViewPanel viewPanel;

    public MainFrame(){
        initFrame();
        initComps();
        layoutComps();
        activateFrame();
    }

    private void initFrame() {
        setTitle("Evidencija službenih vozila");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
    }

    private void initComps() {
        vozila = new ArrayList<>();
        formPanel = new FormPanel();
        viewPanel = new ViewPanel();
    }

    private void layoutComps() {
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.NORTH);
        add(viewPanel, BorderLayout.CENTER);
    }

    private void activateFrame() {
        formPanel.setFormPanelListener(this);
    }

    @Override
    public void ucitajEvent() {
        RezultatUcitavanja rezultat = AUX_RW.ucitajVozila(DATOTEKA);
        vozila = rezultat.getVozila();
        azurirajPrikaz();

        if (rezultat.getBrojPreskocenih() > 0) {
            JOptionPane.showMessageDialog(this,
                    rezultat.getBrojPreskocenih() + " redak(a) nije učitano zbog neispravnih podataka.",
                    "Upozorenje", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void spremiEvent() {
        AUX_RW.spremiVozila(vozila, DATOTEKA);
        JOptionPane.showMessageDialog(this, "Vozila su spremljena u " + DATOTEKA);
    }

    @Override
    public void dodajVoziloEvent(String oznaka, String model, TipVozila tipVozila, int brojSjedala, String napomena) {
        Vozilo vozilo = new Vozilo(oznaka, model, tipVozila, brojSjedala, napomena);
        vozila.add(vozilo);
        azurirajPrikaz();
    }

    private void azurirajPrikaz() {
        StringBuilder sb = new StringBuilder();
        for (Vozilo v : vozila) {
            sb.append(v.toString());
            sb.append("\n");
        }
        viewPanel.azurirajPrikaz(sb.toString());
    }
}
