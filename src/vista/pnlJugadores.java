package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import modelo.Campo;
import modelo.Circulo;
import modelo.Formaciones;
import static modelo.Formaciones.s352;
import static modelo.Formaciones.s4231;
import static modelo.Formaciones.s433;
import static modelo.Formaciones.s442;
import modelo.Jugador;

/**
 *
 * @author Alfonso
 */
public class pnlJugadores extends javax.swing.JPanel {

    ArrayList<Circulo> jugadores;
    int[][] matriz_adyacencia;

    /**
     * Creates new form pnlCancha
     */
    public pnlJugadores() {
        initComponents();
        jugadores = new ArrayList<>();
        revalidate();
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new Color(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(516, 688));
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Circulo jugador : jugadores) {
            dibujarEquipo(g);
        }
    }

    private void crearCirculos(Formaciones formacion) {
        for (int[] pos : formacion.getFormacion()) {
            jugadores.add(new Circulo(pos[0], pos[1], 15, Color.BLUE));
        }
    }

    public void mostraJugadores(int formacion) {
        jugadores.clear();
        switch (formacion) {
            case 442:
                crearCirculos(s442);
                break;

            case 4231:
                crearCirculos(s4231);
                break;

            case 352:
                crearCirculos(s352);
                break;

            case 433:
                crearCirculos(s433);
                break;

            default:
                System.out.println("Formación no válida.");
        }
        repaint();
    }

    public void dibujarEquipo(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setStroke(new BasicStroke(2));
        for (int i = 0; i < 11; i++) {
            Circulo c1 = jugadores.get(i);
            g2.setColor(new Color(255, 219, 54));
            for (int j = i; j < 11; j++) {
                Circulo c2 = jugadores.get(j);
                if (matriz_adyacencia[i][j] == 1) {
                    g2.drawLine(c1.getX(), c1.getY(), c2.getX(), c2.getY());
                }
            }
            c1.dibujar(g);
        }
    }

    public void dibujarCamino(ArrayList<Jugador> camino, Campo campo, String criterio) {
        Graphics g = this.getGraphics();

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3));

        Formaciones f = null;
        switch (campo.getFormacion()) {
            case 442:
                f = s442;
                break;
            case 4231:
                f = s4231;
                break;
            case 352:
                f = s352;
                break;
            case 433:
                f = s433;
                break;
        }
        int puntos[][] = f.getFormacion();

        ArrayList<Jugador> nodos = campo.getJugadores();
        ArrayList<Circulo> circulosCamino = new ArrayList<>();

        for (Jugador j : camino) {
            int pos = nodos.indexOf(j);
            Circulo c1 = new Circulo(puntos[pos][0], puntos[pos][1], 15, Color.green);
            circulosCamino.add(c1);
        }
        
        dibujarEquipo(g);

        for (int i = 0; i < circulosCamino.size(); i++) {
            Circulo c1 = circulosCamino.get(i);
            g2.setColor(new Color(200, 0, 0));
            if (i + 1 < circulosCamino.size()) {
                Circulo c2 = circulosCamino.get(i + 1);
                g2.drawLine(c1.getX(), c1.getY(), c2.getX(), c2.getY());
            }
            c1.dibujar(g);
        }
        mostrarStats(f, nodos, criterio);
    }

    private void mostrarStats(Formaciones formacion, ArrayList<Jugador> jugadores, String criterio) {
        Graphics g = this.getGraphics();
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Footlight MT Light", Font.BOLD, 18));
        FontMetrics metrics = g2.getFontMetrics();
        g2.setColor(Color.black);

        int c = 0;
        for (int[] pos : formacion.getFormacion()) {
            String dato = "";
            switch (criterio) {
                case "velocidad":
                    dato = String.valueOf(jugadores.get(c).getVelocidad());
                    break;
                case "posesion":
                    dato = String.valueOf(jugadores.get(c).getPosesion());
                    break;
                case "remate":
                    dato = String.valueOf(jugadores.get(c).getRemate());
                    break;
            }
            int x = (int) pos[0] - metrics.stringWidth(dato) / 2;
            int y = (int) pos[1] + metrics.getHeight() / 2;
            g2.drawString(dato, x, y);
            c++;
        }
    }
}
