package all_in_one;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private ViewPanel viewPanel;
    private FormPanel formPanel;

    public MainFrame() {

        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("MVC App");

        initComponents();
        layoutComponents();
        activateMainFrame();   
    }

    private void activateMainFrame() {

    }

    private void layoutComponents() {
        setLayout(new BorderLayout());
        add(viewPanel, BorderLayout.CENTER);
    }

    private void initComponents() {
        this.viewPanel = new ViewPanel();
    }
}
