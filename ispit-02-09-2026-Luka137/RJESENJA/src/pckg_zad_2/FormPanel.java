package pckg_zad_2;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class FormPanel extends JPanel {

    private static final String PUTANJA_DATOTEKE = "DATA/termini_radionica.txt";

    private final ArrayList<TerminRadionice> termini;
    private final ViewPanel viewPanel;

    private JTextField poljeNaziv;
    private JTextField poljeVoditelj;
    private JComboBox<TipTermina> poljeTip;
    private JTextField poljeBrojMjesta;
    private JTextArea poljeNapomena;

    private JButton gumbDodaj;
    private JButton gumbSpremi;
    private JButton gumbUcitaj;

    public FormPanel(ArrayList<TerminRadionice> termini, ViewPanel viewPanel) {
        this.termini = termini;
        this.viewPanel = viewPanel;

        setBorder(BorderFactory.createTitledBorder("FormPanel"));
        setLayout(new GridBagLayout());

        izradiKomponente();
    }

    private void izradiKomponente() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        poljeNaziv = new JTextField(15);
        poljeVoditelj = new JTextField(15);
        poljeTip = new JComboBox<TipTermina>(TipTermina.values());
        poljeBrojMjesta = new JTextField(15);
        poljeNapomena = new JTextArea(4, 15);

        int red = 0;
        dodajRed(gbc, red++, "Naziv termina:", poljeNaziv);
        dodajRed(gbc, red++, "Voditelj:", poljeVoditelj);
        dodajRed(gbc, red++, "Tip termina:", poljeTip);
        dodajRed(gbc, red++, "Broj mjesta:", poljeBrojMjesta);
        dodajRed(gbc, red++, "Napomena:", new JScrollPane(poljeNapomena));

        gumbDodaj = new JButton("Dodaj termin");
        gumbSpremi = new JButton("Spremi u TXT");
        gumbUcitaj = new JButton("Učitaj TXT");

        gbc.gridx = 0;
        gbc.gridy = red++;
        gbc.gridwidth = 2;
        add(gumbDodaj, gbc);

        gbc.gridy = red++;
        add(gumbSpremi, gbc);

        gbc.gridy = red;
        add(gumbUcitaj, gbc);

        gumbDodaj.addActionListener(new DodajListener());
        gumbSpremi.addActionListener(new SpremiListener());
        gumbUcitaj.addActionListener(new UcitajListener());
    }

    private void dodajRed(GridBagConstraints gbc, int red, String naziv, java.awt.Component polje) {
        gbc.gridx = 0;
        gbc.gridy = red;
        gbc.gridwidth = 1;
        add(new JLabel(naziv), gbc);

        gbc.gridx = 1;
        add(polje, gbc);
    }

    private void ocistiPolja() {
        poljeNaziv.setText("");
        poljeVoditelj.setText("");
        poljeBrojMjesta.setText("");
        poljeNapomena.setText("");
        poljeTip.setSelectedIndex(0);
    }

    private class DodajListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String naziv = poljeNaziv.getText().trim();
            String voditelj = poljeVoditelj.getText().trim();
            String brojMjestaTekst = poljeBrojMjesta.getText().trim();
            String napomena = poljeNapomena.getText().trim();

            if (naziv.isEmpty() || voditelj.isEmpty()) {
                JOptionPane.showMessageDialog(FormPanel.this,
                        "Naziv termina i voditelj ne smiju biti prazni.",
                        "Neispravan unos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int brojMjesta;
            try {
                brojMjesta = Integer.parseInt(brojMjestaTekst);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(FormPanel.this,
                        "Broj mjesta mora biti cijeli broj.",
                        "Neispravan unos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (brojMjesta <= 0) {
                JOptionPane.showMessageDialog(FormPanel.this,
                        "Broj mjesta mora biti pozitivan broj.",
                        "Neispravan unos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            TipTermina tip = (TipTermina) poljeTip.getSelectedItem();
            termini.add(new TerminRadionice(naziv, voditelj, tip, brojMjesta, napomena));

            viewPanel.osvjeziPrikaz(termini);
            ocistiPolja();
        }
    }

    private class SpremiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                AUX_RW.spremi(termini, PUTANJA_DATOTEKE);
                JOptionPane.showMessageDialog(FormPanel.this,
                        "Termini su spremljeni u " + PUTANJA_DATOTEKE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(FormPanel.this,
                        "Greska pri spremanju: " + ex.getMessage(),
                        "Greska", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class UcitajListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ArrayList<TerminRadionice> ucitani = AUX_RW.ucitaj(PUTANJA_DATOTEKE);
                termini.clear();
                termini.addAll(ucitani);
                viewPanel.osvjeziPrikaz(termini);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(FormPanel.this,
                        "Greska pri ucitavanju: " + ex.getMessage(),
                        "Greska", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}