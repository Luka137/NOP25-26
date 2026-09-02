package all_in_one;

import model_pckg.Programmer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FormPanel extends JPanel{
    private JTextField userNameField;
    private JTextField emailField;
    private JComboBox<ProgrammingLangEnum> progLangCombo;
    private JList<String> levelList;
    private JRadioButton fullTimeRadio;
    private JRadioButton parTimeRadio;
    private ButtonGroup rButtonGroup;
    private JCheckBox newsLetter;
    private JCheckBox emailUpdate;
    private JButton submitBtn;
    private JScrollPane listScrollPane;
    private FormPanelListener formPanelListener;

    public FormPanel(){
        Dimension dims = getPreferredSize();
        dims.height = 250;
        setPreferredSize(dims);
        initComponents();
        Border titleBorder = BorderFactory.createTitledBorder("Programmer's data:");
        Border innerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        Border formBorder = BorderFactory.createCompoundBorder(titleBorder, innerBorder);
        setBorder(formBorder);
        layoutComponents();
        activateFormPanel();
        resetForm();
    }

    public void setFormPanelListener(FormPanelListener formPanelListener){
        this.formPanelListener = formPanelListener;
    }

    private void initComponents() {
        this.emailField = new JTextField(10);
        this.userNameField = new JTextField(10);
        this.progLangCombo = new JComboBox<>(ProgrammingLangEnum.values());
        this.progLangCombo.setSelectedIndex(-1);
        this.levelList = new JList<>();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Junior");
        listModel.addElement("Mid-level");
        listModel.addElement("Senior");
        listModel.addElement("Lead");
        levelList.setModel(listModel);
        levelList.setVisibleRowCount(3);
        listScrollPane = new JScrollPane(levelList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        fullTimeRadio = new JRadioButton("Full time");
        fullTimeRadio.setSelected(true);
        fullTimeRadio.setActionCommand("Full time");
        parTimeRadio = new JRadioButton("Part time");
        parTimeRadio.setActionCommand("Part time");
        rButtonGroup = new ButtonGroup();
        rButtonGroup.add(fullTimeRadio);
        rButtonGroup.add(parTimeRadio);
        this.newsLetter = new JCheckBox("newsletter");
        this.emailUpdate = new JCheckBox("email update");
        this.submitBtn = new JButton("Submit");
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("User name:"), gbc);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(userNameField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Email:"), gbc);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(emailField, gbc);
        gbc.gridy = 0;
        gbc.gridx++;
        add(Box.createHorizontalStrut(15), gbc);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Programming in: "), gbc);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(progLangCombo, gbc);
        gbc.gridx++;
        add(Box.createHorizontalStrut(15), gbc);
        gbc.gridx++;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Working experience: "), gbc);
        gbc.gridy = 3;
        add(listScrollPane, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(fullTimeRadio, gbc);
        gbc.gridy++;
        add(parTimeRadio, gbc);
        Dimension dims1 = fullTimeRadio.getPreferredSize();
        dims1.width = 100;
        fullTimeRadio.setPreferredSize(dims1);
        Dimension dims2 = parTimeRadio.getPreferredSize();
        dims2.width = 100;
        parTimeRadio.setPreferredSize(dims2);
        gbc.gridy--;
        gbc.gridx+=2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(newsLetter, gbc);
        gbc.gridy++;
        add(emailUpdate, gbc);
        Dimension dims3 = newsLetter.getPreferredSize();
        dims3.width = 120;
        newsLetter.setPreferredSize(dims3);
        emailUpdate.setPreferredSize(dims3);
        gbc.gridy+=2;
        gbc.gridx+=3;
        add(submitBtn, gbc);
        gbc.weighty = 0.8;
    }

    private void resetForm(){
        userNameField.setText("");
        emailField.setText("");
        progLangCombo.setSelectedIndex(-1);
        levelList.clearSelection();
        fullTimeRadio.setSelected(true);
        newsLetter.setSelected(false);
        emailUpdate.setSelected(false);
        userNameField.requestFocus();
        parTimeRadio.setSelected(false);
    }
    private void activateFormPanel() {
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(formPanelListener!=null){
                    String userName = userNameField.getText();
                    String email = emailField.getText();
                    ProgrammingLangEnum programmingLang = (ProgrammingLangEnum) progLangCombo.getSelectedItem();
                    String level = levelList.getSelectedValue();
                    String workingTime = rButtonGroup.getSelection().getActionCommand();
                    List<String> addInfo = new ArrayList<>();
                    String newsLetterString = newsLetter.isSelected() ? "NewsLetter" : "";
                    String updateEmail = emailUpdate.isSelected() ? "EmailUpdate" : "";
                    addInfo.add(newsLetterString);
                    addInfo.add(updateEmail);
                    Programmer programmer = new Programmer(userName, email, programmingLang, level, workingTime, addInfo);
                    formPanelListener.formEventOccurred(programmer);
                }
            }
        });
    }
}
