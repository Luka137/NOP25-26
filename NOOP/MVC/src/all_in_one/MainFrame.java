package all_in_one;

import model_pckg.Programmer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class MainFrame extends JFrame {

    private ViewPanel viewPanel;
    private FormPanel formPanel;
    private MenuBar menuBar;
    private JFileChooser fileChooser;

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
        adaptFileChooser();
    }

    private void adaptFileChooser() {
        FileNameExtensionFilter txtFileFilter = new FileNameExtensionFilter("*.txt", "txt");
        FileNameExtensionFilter binFileFilter = new FileNameExtensionFilter("*.bin", "bin");
        fileChooser.addChoosableFileFilter(txtFileFilter);
        fileChooser.addChoosableFileFilter(binFileFilter);
        fileChooser.setFileFilter(txtFileFilter);
        fileChooser.isAcceptAllFileFilterUsed();
    }

    private void activateMainFrame() {
        formPanel.setFormPanelListener(new FormPanelListener() {
            @Override
            public void formEventOccurred(Programmer programmer) {
                viewPanel.appendText(programmer.toString());
            }
        });

        menuBar.setMenuBarListener(new MenuBarListener() {

            @Override
            public void menuBarEventOccured(String actionCommand) {
                if(actionCommand.equals("exit")){
                    System.exit(0);
                }
                if(actionCommand.equals("export")){
                    int returnVal = fileChooser.showSaveDialog(MainFrame.this);
                    if(returnVal == JFileChooser.APPROVE_OPTION){
                        File file = fileChooser.getSelectedFile();
                        String data = viewPanel.getAllFromViewPanel();
                        IOUtils.saveTxTDataToFile(file, data);
                    }
                }
                if(actionCommand.equals("import")){
                    int returnVal = fileChooser.showOpenDialog(MainFrame.this);
                    if(returnVal == JFileChooser.APPROVE_OPTION){
                        File file = fileChooser.getSelectedFile();
                        String data = IOUtils.importTxtDataFromFile(file);
                        viewPanel.appendText(data);
                    }
                }
            }
        });
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());
        add(viewPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.SOUTH);
        setJMenuBar(this.menuBar);
    }

    private void initComponents() {
        this.viewPanel = new ViewPanel();
        this.formPanel = new FormPanel();
        this.menuBar = new MenuBar();
        this.fileChooser = new JFileChooser("./DATA");
    }
}
