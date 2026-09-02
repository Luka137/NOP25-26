package pckg_zad_2;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GlavniProzor prozor = new GlavniProzor();
                prozor.setVisible(true);
            }
        });
    }
}