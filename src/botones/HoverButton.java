/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package botones;

/**
 *
 * @author andre
 */
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoverButton extends CustomButton {
    public HoverButton(String text) {
        super(text);
        
        // Guardar el color original
        Color originalColor = getBackground();
        
        // Agregar un listener para cambiar el color al pasar el mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(originalColor.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(originalColor);
            }
        });
    }
}

