package pexeso.desktop;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import pexeso.desktop.gui.ConfigurationFrame;

/**
 *
 * @author Felix
 */
public class Main {

    public static void main(String args[]) {
        // Set look and feel
        setLaF();

        // Run a application
        startApp();
    }

    private static void setLaF() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
    }

    private static void startApp() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConfigurationFrame config = new ConfigurationFrame();
                config.setVisible(true);
            }
        });
    }
}
