package pckg_zad_2;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.util.ArrayList;

public class GlavniProzor extends JFrame {

    private final ArrayList<TerminRadionice> termini;

    public GlavniProzor() {
        super("Evidencija termina radionica");

        termini = new ArrayList<TerminRadionice>();

        postaviProzor();
        postaviPanele();
    }

    private void postaviProzor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
    }

    private void postaviPanele() {
        ViewPanel viewPanel = new ViewPanel();
        FormPanel formPanel = new FormPanel(termini, viewPanel);

        JPanel sadrzaj = new JPanel(new GridLayout(1, 2, 10, 10));
        sadrzaj.add(formPanel);
        sadrzaj.add(viewPanel);

        add(sadrzaj);
    }
}