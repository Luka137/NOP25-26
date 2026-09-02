package all_in_one;

import javax.swing.*;
import java.awt.*;

public class ViewPanel extends JPanel {

    private JTextArea textArea;
    private JScrollPane txtAreaScrollPane;

    public ViewPanel(){

        initComponents();
        layoutComponents();
    }

    private void initComponents() {
        this.textArea = new JTextArea();
        this.txtAreaScrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());
        add(txtAreaScrollPane, BorderLayout.CENTER);
    }

    public void appendText(String data) {
        textArea.append(data);
        textArea.append("\n");
    }

    public String getAllFromViewPanel(){
        return textArea.getText();
    }
}
