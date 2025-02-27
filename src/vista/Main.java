package vista;

import radar.pnlRadar;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Campo;
import modelo.Jugador;
import modelo.ManejadorCampo;

/**
 *
 * @author Alfonso
 */
public class Main extends javax.swing.JFrame {

    ImageIcon cesped = new ImageIcon("imagenes/cesped_p.jpg");
    ImageIcon lineas = new ImageIcon("imagenes/lineas_blancas.png");
    ImageIcon fondo = new ImageIcon("imagenes/estadio.png");
    ImageIcon atras = new ImageIcon("imagenes/backs.png");

    ManejadorCampo mc = new ManejadorCampo();
    ButtonGroup bg = new ButtonGroup();

    pnlJugadores cancha;
    pnlRadar radar;
    Campo campo;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        cargarPaneles();

        bg.add(tbtn352);
        bg.add(tbtn4231);
        bg.add(tbtn433);
        bg.add(tbtn442);

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
        pnlSeleccion = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        lblSeleccionar = new javax.swing.JLabel();
        lblEquipo = new javax.swing.JLabel();
        pnlEstrategia = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        lblFormacion = new javax.swing.JLabel();
        tbtn4231 = new javax.swing.JToggleButton();
        tbtn433 = new javax.swing.JToggleButton();
        tbtn352 = new javax.swing.JToggleButton();
        tbtn442 = new javax.swing.JToggleButton();
        lbl442 = new javax.swing.JLabel();
        lbl4231 = new javax.swing.JLabel();
        lbl433 = new javax.swing.JLabel();
        lbl352 = new javax.swing.JLabel();
        lblEstategia = new javax.swing.JLabel();
        btnVelocidad = new javax.swing.JButton();
        btnRemate = new javax.swing.JButton();
        btnPosesion = new javax.swing.JButton();
        lblVelocidad = new javax.swing.JLabel();
        lblRemate = new javax.swing.JLabel();
        lblPosesion = new javax.swing.JLabel();
        lblAtras = new javax.swing.JLabel();
        pnlCesped = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        lbltitulo1 = new javax.swing.JLabel();
        lbltitulo = new javax.swing.JLabel();
        btnComenzar = new javax.swing.JButton();
        btnAcercaDe = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        estadioImage = new javax.swing.JLabel();
        pnlBG = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();

        pnlCampo.setMinimumSize(new java.awt.Dimension(1366, 768));
        pnlCampo.setPreferredSize(new java.awt.Dimension(1366, 768));
        pnlCampo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSombra.setBackground(new Color(0, 0, 0, 70));
        pnlSombra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlSombra.setLayout(null);

        lblCancha.setIcon(new ImageIcon(lineas.getImage().getScaledInstance(576, 768, Image.SCALE_SMOOTH)));
        pnlSombra.add(lblCancha);
        lblCancha.setBounds(-30, -40, 576, 768);

        pnlCampo.add(pnlSombra, new org.netbeans.lib.awtextra.AbsoluteConstraints(776, 40, 516, 688));

        pnlSeleccion.setBackground(new Color(0, 0, 0, 70));
        pnlSeleccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlSeleccion.setMinimumSize(new java.awt.Dimension(660, 688));
        pnlSeleccion.setPreferredSize(new java.awt.Dimension(660, 688));
        pnlSeleccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Footlight MT Light", 1, 56)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 204, 51));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Movimiento Táctico");
        pnlSeleccion.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 80));

        btnContinuar.setBackground(new java.awt.Color(153, 153, 153));
        btnContinuar.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        btnContinuar.setForeground(new java.awt.Color(255, 255, 255));
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        pnlSeleccion.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 610, 140, 40));

        btnSiguiente.setBackground(new java.awt.Color(153, 153, 153));
        btnSiguiente.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        pnlSeleccion.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 140, 40));

        btnAnterior.setBackground(new java.awt.Color(153, 153, 153));
        btnAnterior.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        btnAnterior.setForeground(new java.awt.Color(255, 255, 255));
        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        pnlSeleccion.add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 140, 40));

        lblSeleccionar.setBackground(new java.awt.Color(255, 255, 255));
        lblSeleccionar.setFont(new java.awt.Font("Footlight MT Light", 0, 24)); // NOI18N
        lblSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        lblSeleccionar.setText("Seleccionar equipo:");
        pnlSeleccion.add(lblSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 260, 40));

        lblEquipo.setBackground(new Color(255, 225, 255, 50));
        lblEquipo.setFont(new java.awt.Font("Footlight MT Light", 0, 28)); // NOI18N
        lblEquipo.setForeground(new java.awt.Color(255, 255, 255));
        lblEquipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEquipo.setOpaque(true);
        pnlSeleccion.add(lblEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 260, 40));

        pnlCampo.add(pnlSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 40, 660, 688));

        pnlEstrategia.setBackground(new Color(0, 0, 0, 70));
        pnlEstrategia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlEstrategia.setPreferredSize(new java.awt.Dimension(660, 688));
        pnlEstrategia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo1.setFont(new java.awt.Font("Footlight MT Light", 1, 56)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 204, 51));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Movimiento Táctico");
        pnlEstrategia.add(lblTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 80));

        lblFormacion.setFont(new java.awt.Font("Footlight MT Light", 0, 24)); // NOI18N
        lblFormacion.setForeground(new java.awt.Color(255, 255, 255));
        lblFormacion.setText("Cambiar Formacion:");
        pnlEstrategia.add(lblFormacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 230, 40));

        tbtn4231.setBackground(new java.awt.Color(153, 153, 153));
        tbtn4231.setFont(new java.awt.Font("Footlight MT Light", 0, 18)); // NOI18N
        tbtn4231.setForeground(new java.awt.Color(255, 255, 255));
        tbtn4231.setText("4-2-3-1");
        tbtn4231.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtn4231ActionPerformed(evt);
            }
        });
        pnlEstrategia.add(tbtn4231, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 130, 40));

        tbtn433.setBackground(new java.awt.Color(153, 153, 153));
        tbtn433.setFont(new java.awt.Font("Footlight MT Light", 0, 18)); // NOI18N
        tbtn433.setForeground(new java.awt.Color(255, 255, 255));
        tbtn433.setText("4-3-3");
        tbtn433.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtn433ActionPerformed(evt);
            }
        });
        pnlEstrategia.add(tbtn433, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 130, 40));

        tbtn352.setBackground(new java.awt.Color(153, 153, 153));
        tbtn352.setFont(new java.awt.Font("Footlight MT Light", 0, 18)); // NOI18N
        tbtn352.setForeground(new java.awt.Color(255, 255, 255));
        tbtn352.setText("3-5-2");
        tbtn352.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtn352ActionPerformed(evt);
            }
        });
        pnlEstrategia.add(tbtn352, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 130, 40));

        tbtn442.setBackground(new java.awt.Color(153, 153, 153));
        tbtn442.setFont(new java.awt.Font("Footlight MT Light", 0, 18)); // NOI18N
        tbtn442.setForeground(new java.awt.Color(255, 255, 255));
        tbtn442.setText("4-4-2");
        tbtn442.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtn442ActionPerformed(evt);
            }
        });
        pnlEstrategia.add(tbtn442, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 130, 40));

        lbl442.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alfonso\\Documents\\EDD_II\\Movimiento_Tactico\\imagenes\\formaciones\\442.png")); // NOI18N
        pnlEstrategia.add(lbl442, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 160, 120, 190));

        lbl4231.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alfonso\\Documents\\EDD_II\\Movimiento_Tactico\\imagenes\\formaciones\\4231.png")); // NOI18N
        pnlEstrategia.add(lbl4231, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 160, 120, 190));

        lbl433.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alfonso\\Documents\\EDD_II\\Movimiento_Tactico\\imagenes\\formaciones\\433.png")); // NOI18N
        pnlEstrategia.add(lbl433, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 160, 120, 190));

        lbl352.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alfonso\\Documents\\EDD_II\\Movimiento_Tactico\\imagenes\\formaciones\\352.png")); // NOI18N
        pnlEstrategia.add(lbl352, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 160, 120, 190));

        lblEstategia.setFont(new java.awt.Font("Footlight MT Light", 0, 24)); // NOI18N
        lblEstategia.setForeground(new java.awt.Color(255, 255, 255));
        lblEstategia.setText("Cambiar Estrategia:");
        pnlEstrategia.add(lblEstategia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 230, 40));

        btnVelocidad.setBackground(new java.awt.Color(153, 153, 153));
        btnVelocidad.setFont(new java.awt.Font("Footlight MT Light", 0, 18)); // NOI18N
        btnVelocidad.setForeground(new java.awt.Color(255, 255, 255));
        btnVelocidad.setText("Velocidad");
        btnVelocidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVelocidadActionPerformed(evt);
            }
        });
        pnlEstrategia.add(btnVelocidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 130, 40));

        btnRemate.setBackground(new java.awt.Color(153, 153, 153));
        btnRemate.setFont(new java.awt.Font("Footlight MT Light", 0, 18)); // NOI18N
        btnRemate.setForeground(new java.awt.Color(255, 255, 255));
        btnRemate.setText("Remate");
        btnRemate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemateActionPerformed(evt);
            }
        });
        pnlEstrategia.add(btnRemate, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 420, 130, 40));

        btnPosesion.setBackground(new java.awt.Color(153, 153, 153));
        btnPosesion.setFont(new java.awt.Font("Footlight MT Light", 0, 18)); // NOI18N
        btnPosesion.setForeground(new java.awt.Color(255, 255, 255));
        btnPosesion.setText("Posesion");
        btnPosesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosesionActionPerformed(evt);
            }
        });
        pnlEstrategia.add(btnPosesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 130, 40));

        lblVelocidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVelocidad.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alfonso\\Documents\\EDD_II\\Movimiento_Tactico\\imagenes\\poses\\velocidad.png")); // NOI18N
        lblVelocidad.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        pnlEstrategia.add(lblVelocidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 130, 190));

        lblRemate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRemate.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alfonso\\Documents\\EDD_II\\Movimiento_Tactico\\imagenes\\poses\\remate.png")); // NOI18N
        lblRemate.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        pnlEstrategia.add(lblRemate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 180, 190));

        lblPosesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPosesion.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alfonso\\Documents\\EDD_II\\Movimiento_Tactico\\imagenes\\poses\\posesion.png")); // NOI18N
        lblPosesion.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        pnlEstrategia.add(lblPosesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, 250, 190));

        pnlCampo.add(pnlEstrategia, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 40, 660, 688));

        lblAtras.setBackground(new java.awt.Color(0, 0, 204));
        lblAtras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAtras.setIcon(new ImageIcon(atras.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
        lblAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtrasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAtrasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAtrasMouseExited(evt);
            }
        });
        pnlCampo.add(lblAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 25));

        pnlCesped.setIcon(new ImageIcon(cesped.getImage().getScaledInstance(1366, 768, Image.SCALE_SMOOTH)));
        pnlCampo.add(pnlCesped, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        pnlMenu.setPreferredSize(new java.awt.Dimension(626, 417));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbltitulo1.setFont(new java.awt.Font("Footlight MT Light", 0, 80)); // NOI18N
        lbltitulo1.setForeground(new java.awt.Color(255, 204, 51));
        lbltitulo1.setText("Movimiento Tactico");
        pnlMenu.add(lbltitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        lbltitulo.setFont(new java.awt.Font("Footlight MT Light", 0, 80)); // NOI18N
        lbltitulo.setForeground(new Color(0, 50, 255, 150));
        lbltitulo.setText("Movimiento Tactico");
        pnlMenu.add(lbltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 205, -1, -1));

        btnComenzar.setBackground(new java.awt.Color(0, 0, 102));
        btnComenzar.setFont(new java.awt.Font("Footlight MT Light", 0, 30)); // NOI18N
        btnComenzar.setForeground(new java.awt.Color(255, 255, 255));
        btnComenzar.setText("Comenzar");
        btnComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarActionPerformed(evt);
            }
        });
        pnlMenu.add(btnComenzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 250, 60));

        btnAcercaDe.setBackground(new java.awt.Color(0, 0, 102));
        btnAcercaDe.setFont(new java.awt.Font("Footlight MT Light", 0, 30)); // NOI18N
        btnAcercaDe.setForeground(new java.awt.Color(255, 255, 255));
        btnAcercaDe.setText("Acerca de");
        btnAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercaDeActionPerformed(evt);
            }
        });
        pnlMenu.add(btnAcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 580, 250, 60));

        btnSalir.setBackground(new java.awt.Color(0, 0, 102));
        btnSalir.setFont(new java.awt.Font("Footlight MT Light", 0, 30)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        pnlMenu.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 650, 250, 60));

        estadioImage.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(1366, 768, Image.SCALE_SMOOTH)));
        estadioImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estadioImageMouseClicked(evt);
            }
        });
        pnlMenu.add(estadioImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBG.setLayout(null);

        lblCerrar.setBackground(new java.awt.Color(204, 0, 0));
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

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseEntered
        // TODO add your handling code here:
        lblCerrar.setOpaque(true);
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

    private void btnComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarActionPerformed
        pnlMenu.setVisible(false);
        pnlCampo.setVisible(true);
        radar.setVisible(true);
        cancha.setVisible(true);
    }//GEN-LAST:event_btnComenzarActionPerformed

    private void btnAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcercaDeActionPerformed
        new AcercaDeFrame().setVisible(true);
    }//GEN-LAST:event_btnAcercaDeActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void estadioImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estadioImageMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_estadioImageMouseClicked

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        campo = mc.crearCampo(campo.getNombre(), ManejadorCampo.SIGUIENTE);
        cancha.matriz_adyacencia = campo.getMatrizAdyacencia();
        cancha.mostraJugadores(campo.getFormacion());
        radar.actualizarGrafico(campo.getPromedio());
        lblEquipo.setText(campo.getNombre());
        bg.clearSelection();
        //        cancha.revalidate();
        repaint();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        campo = mc.crearCampo(campo.getNombre(), ManejadorCampo.ANTERIOR);
        cancha.matriz_adyacencia = campo.getMatrizAdyacencia();
        cancha.mostraJugadores(campo.getFormacion());
        radar.actualizarGrafico(campo.getPromedio());
        lblEquipo.setText(campo.getNombre());
        bg.clearSelection();
        //        cancha.revalidate();
        repaint();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void tbtn4231ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtn4231ActionPerformed
        // TODO add your handling code here:
        if (campo == null) {
            return;
        }
        campo.setFormacion(4231);
        cancha.mostraJugadores(campo.getFormacion());
        repaint();
    }//GEN-LAST:event_tbtn4231ActionPerformed

    private void tbtn433ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtn433ActionPerformed
        // TODO add your handling code here:
        if (campo == null) {
            return;
        }
        campo.setFormacion(433);
        cancha.mostraJugadores(campo.getFormacion());
        repaint();
    }//GEN-LAST:event_tbtn433ActionPerformed

    private void tbtn352ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtn352ActionPerformed
        // TODO add your handling code here:
        if (campo == null) {
            return;
        }
        campo.setFormacion(352);
        cancha.mostraJugadores(campo.getFormacion());
        repaint();
    }//GEN-LAST:event_tbtn352ActionPerformed

    private void tbtn442ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtn442ActionPerformed
        // TODO add your handling code here:
        if (campo == null) {
            return;
        }
        campo.setFormacion(442);
        cancha.mostraJugadores(campo.getFormacion());
        repaint();
    }//GEN-LAST:event_tbtn442ActionPerformed

    private void lblAtrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasMouseEntered
        // TODO add your handling code here:
        lblAtras.setOpaque(true);
        lblAtras.repaint();
    }//GEN-LAST:event_lblAtrasMouseEntered

    private void lblAtrasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasMouseExited
        // TODO add your handling code here:
        lblAtras.setOpaque(false);
        lblAtras.repaint();
    }//GEN-LAST:event_lblAtrasMouseExited

    private void lblAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasMouseClicked
        // TODO add your handling code here:
        if (pnlEstrategia.isVisible()) {
            pnlEstrategia.setVisible(false);
            pnlSeleccion.setVisible(true);
            radar.setVisible(true);
            return;
        }
        cancha.setVisible(false);
        pnlCampo.setVisible(false);
        radar.setVisible(false);
        pnlMenu.setVisible(true);
    }//GEN-LAST:event_lblAtrasMouseClicked

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
        if (campo.getJugadores().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un equipo");
            return;
        }
        radar.setVisible(false);
        pnlSeleccion.setVisible(false);
        pnlEstrategia.setVisible(true);
        cancha.setVisible(true);
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnVelocidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVelocidadActionPerformed
        // TODO add your handling code here:
        Jugador inicial = campo.getJugadores().get(0);
        int num_finales = campo.getFormacion() % 10;
        ArrayList<Jugador> finales = new ArrayList<>();
        int k = 10;
        do {
            finales.add(campo.getJugadores().get(k));
            k--;
            num_finales--;
        } while (num_finales > 0);
        ArrayList<Jugador> camino = campo.recorridoVelocidad(inicial, finales);
//        cancha.mostraJugadores(campo.getFormacion());
        cancha.dibujarCamino(camino, campo, "velocidad");

    }//GEN-LAST:event_btnVelocidadActionPerformed

    private void btnRemateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemateActionPerformed
        // TODO add your handling code here:
        Jugador inicial = campo.getJugadores().get(0);
        int num_finales = campo.getFormacion() % 10;
        ArrayList<Jugador> finales = new ArrayList<>();
        int k = 10;
        do {
            finales.add(campo.getJugadores().get(k));
            k--;
            num_finales--;
        } while (num_finales > 0);
        ArrayList<Jugador> camino = campo.recorridoRemate(inicial, finales);
        cancha.dibujarCamino(camino, campo, "remate");
//        cancha.repaint();
    }//GEN-LAST:event_btnRemateActionPerformed

    private void btnPosesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosesionActionPerformed
        // TODO add your handling code here:
        Jugador inicial = campo.getJugadores().get(0);
        int num_finales = campo.getFormacion() % 10;
        ArrayList<Jugador> finales = new ArrayList<>();
        int k = 10;
        do {
            finales.add(campo.getJugadores().get(k));
            k--;
            num_finales--;
        } while (num_finales > 0);
        ArrayList<Jugador> camino = campo.recorridoPosesion(inicial, finales);
        cancha.dibujarCamino(camino, campo, "posesion");
        cancha.revalidate();
//        cancha.repaint();
    }//GEN-LAST:event_btnPosesionActionPerformed

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
    private javax.swing.JButton btnAcercaDe;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnPosesion;
    private javax.swing.JButton btnRemate;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVelocidad;
    private javax.swing.JLabel estadioImage;
    private javax.swing.JLabel lbl352;
    private javax.swing.JLabel lbl4231;
    private javax.swing.JLabel lbl433;
    private javax.swing.JLabel lbl442;
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblCancha;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblEquipo;
    private javax.swing.JLabel lblEstategia;
    private javax.swing.JLabel lblFormacion;
    private javax.swing.JLabel lblPosesion;
    private javax.swing.JLabel lblRemate;
    private javax.swing.JLabel lblSeleccionar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblVelocidad;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JLabel lbltitulo1;
    private javax.swing.JPanel pnlBG;
    private javax.swing.JPanel pnlCampo;
    private javax.swing.JLabel pnlCesped;
    private javax.swing.JPanel pnlEstrategia;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlSeleccion;
    private javax.swing.JPanel pnlSombra;
    private javax.swing.JToggleButton tbtn352;
    private javax.swing.JToggleButton tbtn4231;
    private javax.swing.JToggleButton tbtn433;
    private javax.swing.JToggleButton tbtn442;
    // End of variables declaration//GEN-END:variables

    //Fuente para el menu principal Footlight o Goudy Old Style
    private void cargarPaneles() {
        campo = new Campo();
        cancha = new pnlJugadores();
        radar = new pnlRadar();

        radar.setSize(500, 340);
        radar.setLocation(154, 250);
        radar.setVisible(false);

        cancha.setSize(516, 688);
        cancha.setLocation(776, 40);

        pnlCampo.setSize(1366, 768);
        pnlCampo.setLocation(0, 0);
        pnlCampo.setVisible(false);

        pnlMenu.setSize(1366, 768);
        pnlMenu.setLocation(0, 0);

        pnlEstrategia.setVisible(false);

        pnlBG.add(radar);
        pnlBG.add(cancha);
        pnlBG.add(pnlCampo);
        pnlBG.add(pnlMenu);
    }
}
