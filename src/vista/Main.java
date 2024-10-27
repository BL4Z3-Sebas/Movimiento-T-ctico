package vista;

import radar.pnlRadar;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Alfonso
 */
public class Main extends javax.swing.JFrame {

    ImageIcon cesped = new ImageIcon("imagenes/cesped_p.jpg");
    ImageIcon lineas = new ImageIcon("imagenes/lineas_blancas.png");
    pnlJugadores cancha;
    pnlRadar radar;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        cancha = new pnlJugadores();
        cancha.setSize(516, 688);
        cancha.setLocation(776, 40);
        cancha.setBackground(new Color(0, 0, 0, 0));

        pnlCampo.setSize(1366, 768);
        pnlCampo.setLocation(0, 0);

        pnlMenu.setSize(660, 688);
        pnlMenu.setLocation(74, 40);

        radar = new pnlRadar();
        radar.setSize(500, 300);
        radar.setLocation(154, 240);
        radar.setBackground(new Color(0, 0, 0, 0));
        radar.actualizarGrafico(70, 20, 95);

        pnlBG.add(radar);
        pnlBG.add(pnlMenu);
        pnlBG.add(cancha);
        pnlBG.add(pnlCampo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCampo = new javax.swing.JPanel();
        pnlSombra = new javax.swing.JPanel();
        lblCancha = new javax.swing.JLabel();
        pnlCesped = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        lblSeleccionar = new javax.swing.JLabel();
        lblEquipo = new javax.swing.JLabel();
        pnlSombra1 = new javax.swing.JPanel();
        pnlBG = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();

        pnlCampo.setLayout(null);

        pnlSombra.setBackground(new Color(0, 0, 0, 70));
        pnlSombra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlSombra.setLayout(null);

        lblCancha.setIcon(new ImageIcon(lineas.getImage().getScaledInstance(576, 768, Image.SCALE_SMOOTH)));
        lblCancha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCanchaMouseClicked(evt);
            }
        });
        pnlSombra.add(lblCancha);
        lblCancha.setBounds(-30, -40, 576, 768);

        pnlCampo.add(pnlSombra);
        pnlSombra.setBounds(776, 40, 516, 688);

        pnlCesped.setIcon(new ImageIcon(cesped.getImage().getScaledInstance(1366, 768, Image.SCALE_SMOOTH)));
        pnlCampo.add(pnlCesped);
        pnlCesped.setBounds(0, 0, 1366, 768);

        pnlMenu.setBackground(new Color(0, 0, 0, 70));
        pnlMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlMenu.setMinimumSize(new java.awt.Dimension(660, 688));
        pnlMenu.setPreferredSize(new java.awt.Dimension(680, 688));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Footlight MT Light", 1, 56)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 204, 51));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Movimiento Táctico");
        pnlMenu.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 80));

        btnAnterior.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        btnAnterior.setForeground(new java.awt.Color(255, 255, 255));
        btnAnterior.setText("< Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        pnlMenu.add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 140, 40));

        btnSiguiente.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("Siguiente >");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        pnlMenu.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 140, 40));

        lblSeleccionar.setBackground(new java.awt.Color(255, 255, 255));
        lblSeleccionar.setFont(new java.awt.Font("Footlight MT Light", 0, 24)); // NOI18N
        lblSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        lblSeleccionar.setText("Seleccionar equipo:");
        pnlMenu.add(lblSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 260, 40));

        lblEquipo.setBackground(new Color(255, 225, 255, 50));
        lblEquipo.setFont(new java.awt.Font("Footlight MT Light", 0, 28)); // NOI18N
        lblEquipo.setForeground(new java.awt.Color(255, 255, 255));
        lblEquipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEquipo.setText("Equipo 1");
        lblEquipo.setOpaque(true);
        pnlMenu.add(lblEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 260, 40));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSombra1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlSombra1.setOpaque(false);
        pnlSombra1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnlSombra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(776, 40, 516, 688));

        pnlBG.setLayout(null);

        lblCerrar.setBackground(new java.awt.Color(102, 0, 0));
        lblCerrar.setFont(new java.awt.Font("Papyrus", 0, 36)); // NOI18N
        lblCerrar.setForeground(new java.awt.Color(255, 255, 255));
        lblCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCerrar.setText("×");
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCerrarMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblCerrarMouseReleased(evt);
            }
        });
        pnlBG.add(lblCerrar);
        lblCerrar.setBounds(1326, 0, 40, 25);

        getContentPane().add(pnlBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblCanchaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCanchaMouseClicked
        // TODO add your handling code here:
        System.out.println(evt.getX() + ", " + evt.getY());
    }//GEN-LAST:event_lblCanchaMouseClicked

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseEntered
        // TODO add your handling code here:
        lblCerrar.setOpaque(true);
        lblCerrar.setBackground(new Color(204, 0, 0));
        lblCerrar.setForeground(new Color(255, 255, 255));
        lblCerrar.repaint();
    }//GEN-LAST:event_lblCerrarMouseEntered

    private void lblCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseExited
        // TODO add your handling code here:
        lblCerrar.setOpaque(false);
        lblCerrar.repaint();
    }//GEN-LAST:event_lblCerrarMouseExited

    private void lblCerrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseReleased
        // TODO add your handling code here:
        if (lblCerrar.contains(evt.getX(), evt.getY())) {
            lblCerrarMouseClicked(evt);
        }
    }//GEN-LAST:event_lblCerrarMouseReleased

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        cancha.mostraJugadores('a');
        revalidate();
        repaint();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        cancha.mostraJugadores('b');
        revalidate();
        repaint();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel lblCancha;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblEquipo;
    private javax.swing.JLabel lblSeleccionar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBG;
    private javax.swing.JPanel pnlCampo;
    private javax.swing.JLabel pnlCesped;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlSombra;
    private javax.swing.JPanel pnlSombra1;
    // End of variables declaration//GEN-END:variables

    //Fuente para el menu principal Footlight o Goudy Old Style
}
