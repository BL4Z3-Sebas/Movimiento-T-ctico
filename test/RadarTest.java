
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;


public class RadarTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Radar Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        // Añadimos un JPanel para dibujar en él
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Crear y dibujar radar en una ubicación cualquiera
//                Radar radar = new Radar(300, 300, 200, 50, 75, 90);
//                radar.dibujarRadar(g);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }
}
