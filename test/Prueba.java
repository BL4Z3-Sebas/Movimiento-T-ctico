
import botones.CustomLookAndFeel;
import javax.swing.JFrame;
import vista.pnlMainMenu;

/**
 *
 * @author andre
 */
public class Prueba {

    public static void main(String[] args) {
        CustomLookAndFeel.setNimbusLookAndFeel();
        pnlMainMenu mp = new pnlMainMenu();
        JFrame frame = new JFrame("");
        // Quitar la barra de título
        frame.setUndecorated(true);
        // Hacer la ventana no redimensionable
        frame.setResizable(false);
        frame.add(mp);
        frame.setSize(1366, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Centramos el frame en la pantalla
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
