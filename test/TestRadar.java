import java.awt.Color;
import javax.swing.JFrame;
import radar.Rad;

public class TestRadar {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Radar");
        Rad radarPanel = new Rad();
        frame.add(radarPanel);
        frame.setSize(500, 500);  // Tamaño del JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        radarPanel.setBackground(Color.black);
        radarPanel.actualizarGrafico(70, 88, 90);
        radarPanel.repaint();
    }
}
