package ui;

import javax.swing.*;
import java.awt.*;

public class PaintedPanel extends JPanel {

    private boolean isDrawTriangle = true;

    public PaintedPanel() {
    }

    public void setDrawTriangle(boolean isDrawTriangle) {
        this.isDrawTriangle = isDrawTriangle;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isDrawTriangle) {

            g.setColor(Color.red);

            g.drawLine(1, getHeight() - 1, getWidth() / 2, 1);
            g.drawLine(getWidth() / 2, 1, getWidth() - 1, getHeight() - 1);
            g.drawLine(getWidth() - 1, getHeight() - 1, 1, getHeight() - 1);
        }
    }
}
