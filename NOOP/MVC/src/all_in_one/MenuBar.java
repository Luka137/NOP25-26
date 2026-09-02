package all_in_one;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar implements ActionListener {
    private JMenu fileMenu;
    private JMenuItem exportMenuItem;
    private JMenuItem importMenuItem;
    private JMenuItem exitApp;
    private JMenuItem serverMenu;
    private JMenuItem connectTo;
    private JMenuItem disconnect;
    private MenuBarListener menuBarListener;

    public MenuBar() {

        initMenuBar();
        activateMenuBar();
    }

    public void setMenuBarListener(MenuBarListener menuBarListener) {
        this.menuBarListener = menuBarListener;
    }

    private void initMenuBar() {

        fileMenu = new JMenu("File");
        serverMenu = new JMenu("Server");
        exportMenuItem = new JMenuItem("Export data...");
        importMenuItem = new JMenuItem("Import data...");
        exitApp = new JMenuItem("Exit");
        connectTo = new JMenuItem("Connect to server");
        disconnect = new JMenuItem("Disconnect");

        exportMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        importMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
        exitApp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        connectTo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        disconnect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));

        exportMenuItem.setActionCommand("export");
        importMenuItem.setActionCommand("import");
        exitApp.setActionCommand("exit");
        connectTo.setActionCommand("connect");
        disconnect.setActionCommand("disconnect");
        fileMenu.add(exportMenuItem);
        fileMenu.add(importMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitApp);
        serverMenu.add(connectTo);
        serverMenu.add(disconnect);
        add(fileMenu);
        add(serverMenu);
    }

    private void activateMenuBar() {
        exportMenuItem.addActionListener(this);
        importMenuItem.addActionListener(this);
        exitApp.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(menuBarListener != null) {
            menuBarListener.menuBarEventOccured(ae.getActionCommand());
        }
    }
}
