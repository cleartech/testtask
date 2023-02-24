import ui.AppFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        AppFrame appFrame = new AppFrame();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                appFrame.pack();
                appFrame.setLocationRelativeTo(null);
                appFrame.setVisible(true);
            }
        });

    }
}
