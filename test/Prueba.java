
import botones.CustomLookAndFeel;
import botones.HoverButton;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import radar.pnlRadar;
import vista.Menu_Principal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author andre
 */
public class Prueba {

    public static void main(String[] args) {
        CustomLookAndFeel.setNimbusLookAndFeel();
        Menu_Principal mp = new Menu_Principal();
        JFrame frame = new JFrame("");
        // Quitar la barra de título
        frame.setUndecorated(true);
        // Hacer la ventana no redimensionable
        frame.setResizable(false);
        frame.add(mp);
        frame.setSize(626, 417);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Centramos el frame en la pantalla
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
