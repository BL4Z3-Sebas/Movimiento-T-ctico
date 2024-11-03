/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package botones;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author andre
 */
public class ImageButton extends JButton {

    public ImageButton(String iconPath) {
        setIcon(new ImageIcon(getClass().getResource(iconPath)));
        setPreferredSize(new Dimension(100, 40));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
    }
}
