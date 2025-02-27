package radar;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Alfonso
 */
public class pnlRadar extends javax.swing.JPanel {

    radar.Radar radar;

    /**
     * Creates new form Rad
     */
    public pnlRadar() {
        initComponents();
        radar = new Radar();
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
        setMinimumSize(new java.awt.Dimension(500, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int radio = (int) (Math.min(getWidth(), getHeight()) * 0.4);
        moverGrafico(getWidth() / 2, getHeight() / 2, radio);

        radar.dibujarRadar(g);
        radar.dibujarGrafico(g);
    }

    public void actualizarGrafico(int velocidad, int posesion, int remate) {
        radar.asignarDatosRadar(velocidad, posesion, remate);
        repaint(); // Repinta el panel para mostrar el nuevo gráfico
    }

    public void actualizarGrafico(double[] promedio) {
        radar.asignarDatosRadar(promedio);
        repaint(); // Repinta el panel para mostrar el nuevo gráfico
    }

    public void moverGrafico(int x, int y, int radio) {
        radar.setPosicion(x, y, radio);
//        repaint();
    }

}
