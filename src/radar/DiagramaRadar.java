package radar;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Alfonso
 */
public class DiagramaRadar extends JPanel {

    private Radar radar;

    public DiagramaRadar() {
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
//        radar = new Radar(250, 150, 100, 80, 60, 40);
        radar.dibujarRadar(g);
        radar.dibujarGrafico(g);
        revalidate();
        repaint();
    }
}
