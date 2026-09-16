package pckg_zad_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {

    private JTextField oznakaField;
    private JTextField modelField;
    private JComboBox<TipVozila> tipBox;
    private JTextField brojSjedalaField;
    private JTextArea napomenaArea;
    private JButton dodajButton;
    private JButton spremiButton;
    private JButton ucitajButton;

    private FormPanelListener listener;

    public void setFormPanelListener(FormPanelListener listener) {
        this.listener = listener;
    }

    public FormPanel() {
        initComps();
        layoutComps();
        activateForm();
    }

    private void initComps() {
        oznakaField = new JTextField(10);
        modelField = new JTextField(14);
        tipBox = new JComboBox<>(TipVozila.values());
        brojSjedalaField = new JTextField(5);
        napomenaArea = new JTextArea(3, 20);

        dodajButton = new JButton("Dodaj vozilo");
        spremiButton = new JButton("Spremi u TXT");
        ucitajButton = new JButton("Učitaj TXT");
    }

    private void layoutComps() {
        setBorder(BorderFactory.createTitledBorder("FormPanel - unos vozila"));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Oznaka vozila:"), gbc);
        gbc.gridx = 1;
        add(oznakaField, gbc);

        gbc.gridx = 2;
        add(new JLabel("Model:"), gbc);
        gbc.gridx = 3;
        add(modelField, gbc);

        gbc.gridx = 4;
        add(new JLabel("Tip vozila:"), gbc);
        gbc.gridx = 5;
        add(tipBox, gbc);

        gbc.gridx = 6;
        add(new JLabel("Broj sjedala:"), gbc);
        gbc.gridx = 7;
        add(brojSjedalaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Napomena:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JScrollPane(napomenaArea), gbc);

        gbc.gridx = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(dodajButton, gbc);

        gbc.gridx = 6;
        add(spremiButton, gbc);

        gbc.gridx = 7;
        add(ucitajButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 8;
        add(new JLabel("FormPanel je iznad ViewPanela. Nakon dodavanja ili učitavanja prikaz se automatski osvježava."), gbc);
    }

    private void activateForm() {
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String oznaka = oznakaField.getText().trim();
                    FormValidator.validirajOznaku(oznaka);

                    String model = modelField.getText().trim();
                    FormValidator.validirajModel(model);

                    TipVozila tip = (TipVozila) tipBox.getSelectedItem();

                    int brojSjedala = FormValidator.validirajBrojSjedala(brojSjedalaField.getText().trim());

                    String napomena = napomenaArea.getText().trim();

                    if (listener != null) {
                        listener.dodajVoziloEvent(oznaka, model, tip, brojSjedala, napomena);
                    }

                    oznakaField.setText("");
                    modelField.setText("");
                    tipBox.setSelectedIndex(0);
                    brojSjedalaField.setText("");
                    napomenaArea.setText("");

                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(FormPanel.this, ex.getMessage(),
                            "Greška u unosu", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        spremiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listener != null) {
                    listener.spremiEvent();
                }
            }
        });

        ucitajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listener != null) {
                    listener.ucitajEvent();
                }
            }
        });
    }
}