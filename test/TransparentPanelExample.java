import javax.swing.*;
import java.awt.*;

public class TransparentPanelExample {
    public static void main(String[] args) {
        // Crear un JFrame
        JFrame frame = new JFrame("Panel Transparente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Crear un JPanel y establecer su color de fondo con transparencia
        JPanel transparentPanel = new JPanel();
        transparentPanel.setBackground(new Color(255, 0, 0, 128)); // Rojo con 50% de opacidad (128)
        
        // Añadir algunos componentes al panel
        transparentPanel.add(new JLabel("Este es un panel transparente"));
        transparentPanel.add(new JButton("Botón"));
        
        // Añadir el panel al frame
        frame.add(transparentPanel);
        
        // Establecer el layout del frame y hacer visible
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}
