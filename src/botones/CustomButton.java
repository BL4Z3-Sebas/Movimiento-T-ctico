/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package botones;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 *
 * @author andre
 */
public class CustomButton extends JButton {

    public CustomButton(String text) {
        super(text);
        // Establecer colores
        setBackground(new Color(70, 130, 180)); // SteelBlue
        setForeground(Color.WHITE);

        // Establecer fuente
        setFont(new Font("Arial", Font.BOLD, 14));

        // Quitar el borde predeterminado y agregar uno personalizado
        setBorder(new LineBorder(new Color(70, 130, 180), 2, true));

        // Quitar el foco del borde
        setFocusPainted(false);
    }
}
