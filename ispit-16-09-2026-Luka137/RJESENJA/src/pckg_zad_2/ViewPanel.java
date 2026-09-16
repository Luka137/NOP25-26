package pckg_zad_2;

import javax.swing.*;
import java.awt.*;

public class ViewPanel extends JPanel {

    private JTextArea prikazArea;

    public ViewPanel() {
        initComps();
        layoutComps();
    }

    private void initComps() {
        prikazArea = new JTextArea();
        prikazArea.setEditable(false);
    }

    private void layoutComps(){
        setBorder(BorderFactory.createTitledBorder("ViewPanel"));
        setLayout(new BorderLayout());
        add(new JScrollPane(prikazArea), BorderLayout.CENTER);
    }

    public void azurirajPrikaz(String tekst){
        prikazArea.setText(tekst);
    }
}
