package modelo;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Alfonso
 */
public class Circulo {

    private int x;
    private int y;
    private int radio;
    private Color color;

    public Circulo() {
    }

    public Circulo(int x, int y, int radio, Color color) {
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.color = color;
    }

    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radio, y - radio, radio * 2, radio * 2);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
