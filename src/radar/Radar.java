package radar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

public class Radar {

    private double velocidad;
    private double posesion;
    private double remate;
    private double ataque;
    private double agilidad;
    private double defensa;

    private int x;
    private int y;
    private int radio;

    private final String[] etiquetas = {"Velocidad", "Agilidad", "Posesión", "Defensa", "Remate", "Ataque"};

    public Radar() {
    }

    public Radar(int x, int y, int radio) {
        this.x = x;
        this.y = y;
        this.radio = radio;
    }

    public Radar(int x, int y, int radio, double velocidad, double posesion, double remate) {
        setPosicion(x, y, radio);
        asignarDatosRadar(velocidad, posesion, remate);

    }

    public final void setPosicion(int x, int y, int radio) {
        this.x = x;
        this.y = y;
        this.radio = radio;
    }

    public final void asignarDatosRadar(double velocidad, double posesion, double remate) {
        this.velocidad = velocidad * 0.01;
        this.posesion = posesion * 0.01;
        this.remate = remate * 0.01;

        this.ataque = remate * 0.006 + velocidad * 0.003 + posesion * 0.001;
        this.agilidad = velocidad * 0.006 + posesion * 0.003 + remate * 0.001;
        this.defensa = posesion * 0.006 + remate * 0.003 + velocidad * 0.001;
    }

    public final void asignarDatosRadar(double[] promedio) {
        asignarDatosRadar(promedio[0], promedio[1], promedio[2]);
    }

    private void dibujarEtiquetas(Graphics2D g2) {
        g2.setFont(new Font("Footlight MT Light", Font.PLAIN, (int) (0.2 * radio)));
        FontMetrics metrics = g2.getFontMetrics();

        int[] angulos = {90, 150, 210, 270, 330, 30};
        for (int i = 0; i < etiquetas.length; i++) {
            double angulo = Math.toRadians(angulos[i]);

            // Calculamos la posición inicial de la etiqueta
            int etiquetaX = (int) (x + (radio + 10) * Math.cos(angulo));
            int etiquetaY = (int) (y - (radio + 10) * Math.sin(angulo));

            // Obtenemos el ancho de la etiqueta para ajustar la posición horizontal
            int anchoEtiqueta = metrics.stringWidth(etiquetas[i]);

            // Ajustamos la posición para centrar la etiqueta horizontalmente
            if (angulo == Math.toRadians(90) || angulo == Math.toRadians(270)) {
                etiquetaX -= anchoEtiqueta / 2;
            } else if (angulo < Math.toRadians(270) && angulo > Math.toRadians(90)) {
                etiquetaX -= anchoEtiqueta;
            }

            // Ajuste de la posición vertical
            if (angulo > Math.toRadians(180)) {
                etiquetaY += metrics.getHeight() / 2;
            }

            // Dibujamos la etiqueta
            g2.setColor(Color.white);
            g2.drawString(etiquetas[i], etiquetaX, etiquetaY);
        }
    }

    public void dibujarRadar(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujamos hexágonos concéntricos
        int delta = 10;
        Polygon hexagono = crearPoligono(6, radio);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(new Color(255, 195, 0));
        g2.draw(hexagono);

        for (double factor = 0.8; factor > 0; factor -= 0.2) {
            Polygon hexagonoInterior = crearPoligono(6, radio * factor);
            g2.setColor(new Color(255, 195 + delta, delta));
            g2.draw(hexagonoInterior);
            delta += 10;
        }

        dibujarEtiquetas(g2);
    }

    private Polygon crearPoligono(int numeroLados, double radio) {
        Polygon poligono = new Polygon();
        double grados = 360 / numeroLados;
        for (int i = 0; i < numeroLados; i++) {
            double radianes = Math.toRadians(90 + i * grados);
            int xx = (int) (x + radio * Math.cos(radianes));
            int yy = (int) (y - radio * Math.sin(radianes));
            poligono.addPoint(xx, yy);
        }
        return poligono;
    }

    public void dibujarGrafico(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Path2D graficoEquipo = new Path2D.Double();

        double velocidadX = x + velocidad * radio * Math.cos(Math.toRadians(90));
        double velocidadY = y - velocidad * radio * Math.sin(Math.toRadians(90));
        graficoEquipo.moveTo(velocidadX, velocidadY);

        double agilidadX = x + agilidad * radio * Math.cos(Math.toRadians(150));
        double agilidadY = y - agilidad * radio * Math.sin(Math.toRadians(150));
        graficoEquipo.lineTo(agilidadX, agilidadY);

        double posesionX = x + posesion * radio * Math.cos(Math.toRadians(210));
        double posesionY = y - posesion * radio * Math.sin(Math.toRadians(210));
        graficoEquipo.lineTo(posesionX, posesionY);

        double defensaX = x + defensa * radio * Math.cos(Math.toRadians(270));
        double defensaY = y - defensa * radio * Math.sin(Math.toRadians(270));
        graficoEquipo.lineTo(defensaX, defensaY);

        double remateX = x + remate * radio * Math.cos(Math.toRadians(330));
        double remateY = y - remate * radio * Math.sin(Math.toRadians(330));
        graficoEquipo.lineTo(remateX, remateY);

        double ataqueX = x + ataque * radio * Math.cos(Math.toRadians(30));
        double ataqueY = y - ataque * radio * Math.sin(Math.toRadians(30));
        graficoEquipo.lineTo(ataqueX, ataqueY);

        graficoEquipo.closePath();

        g2d.setColor(Color.blue);
        g2d.setStroke(new BasicStroke(2));
        g2d.draw(graficoEquipo);

        g2d.setColor(Color.white);
        g2d.fillOval((int) velocidadX - 4, (int) velocidadY - 4, 10, 10);
        g2d.fillOval((int) agilidadX - 4, (int) agilidadY - 4, 10, 10);
        g2d.fillOval((int) posesionX - 4, (int) posesionY - 4, 10, 10);
        g2d.fillOval((int) defensaX - 4, (int) defensaY - 4, 10, 10);
        g2d.fillOval((int) remateX - 4, (int) remateY - 4, 10, 10);
        g2d.fillOval((int) ataqueX - 4, (int) ataqueY - 4, 10, 10);
    }
}
