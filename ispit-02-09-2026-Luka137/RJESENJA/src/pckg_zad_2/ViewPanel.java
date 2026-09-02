package pckg_zad_2;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.util.ArrayList;

public class ViewPanel extends JPanel {

    private JTextArea prostorPrikaza;

    public ViewPanel() {
        setBorder(BorderFactory.createTitledBorder("ViewPanel"));
        setLayout(new BorderLayout());

        prostorPrikaza = new JTextArea();
        prostorPrikaza.setEditable(false);

        add(new JScrollPane(prostorPrikaza), BorderLayout.CENTER);
    }

    public void osvjeziPrikaz(ArrayList<TerminRadionice> termini) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < termini.size(); i++) {
            sb.append(termini.get(i).toString());
            sb.append("\n");
        }
        prostorPrikaza.setText(sb.toString());
        prostorPrikaza.setCaretPosition(0);
    }
}