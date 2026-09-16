package pckg_zad_2;

import javax.swing.*;

public class Main {
    static void main() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }
}
