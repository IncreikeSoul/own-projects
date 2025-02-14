package LicoreriaKappa;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicMenuBarUI;

public class Plataforma extends javax.swing.JFrame {

    public Plataforma() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 27, 27);
        AWTUtilities.setWindowShape(this, forma);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Icon.png")).getImage());
        
        //******************************************************************************************************************
        
        MenuBar.setUI ( new BasicMenuBarUI () {
        @Override
        public void paint ( Graphics g, JComponent c )
        {
            g.setColor ( Color.BLACK);
            g.fillRect ( 0, 0, c.getWidth (), c.getHeight () );
        }
            } 
        );
        
        //*******************************************************************************************************************
        
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon imagen = new ImageIcon(this.getClass().getResource("/imagenes/images_opt.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(imagen);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, imagen.getIconWidth(), imagen.getIconHeight());
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelBienvenido = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmVerPerfil = new javax.swing.JMenuItem();
        jmRegistrarPedido = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmCerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/MADAFAQA.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelBienvenido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelBienvenido.setForeground(new java.awt.Color(0, 0, 102));

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        jLabel3.setText("Te brindamos el mejor servicio a domicilio de licores");

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        jLabel4.setText("de grandes variedades, sabores y marcas de todo el");

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        jLabel5.setText("mundo. Puede acceder a \"Ver Perfil\" en caso que quiera");

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        jLabel6.setText("modificar o verificar su cuenta; de igual manera puede");

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        jLabel7.setText("acceder a \"Registrar Compra\" para hacer su pedido.");

        MenuBar.setBackground(new java.awt.Color(255, 255, 255));

        jMenu1.setForeground(new java.awt.Color(204, 102, 0));
        jMenu1.setText("   MENU  ");
        jMenu1.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jmVerPerfil.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jmVerPerfil.setText("  Ver perfil");
        jmVerPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmVerPerfilActionPerformed(evt);
            }
        });
        jMenu1.add(jmVerPerfil);

        jmRegistrarPedido.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jmRegistrarPedido.setText("  Registrar pedido");
        jmRegistrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRegistrarPedidoActionPerformed(evt);
            }
        });
        jMenu1.add(jmRegistrarPedido);
        jMenu1.add(jSeparator1);

        jmCerrarSesion.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jmCerrarSesion.setText("  Cerrar sesión");
        jmCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(jmCerrarSesion);

        MenuBar.add(jMenu1);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(labelBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(labelBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1)))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCerrarSesionActionPerformed
        Login app=new Login();
        app.setVisible(true);
        dispose();
    }//GEN-LAST:event_jmCerrarSesionActionPerformed

    private void jmRegistrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRegistrarPedidoActionPerformed
        Dimension d=new Dimension(365,90);
        Dimension e=new Dimension(475,70);
        
        Cat_Ped x1=new Cat_Ped();
        Monitor x2=new Monitor();
        x1.setVisible(true);
        x2.setVisible(true);
        
        JPanel panel=new JPanel();
        JFrame body=new JFrame();
        body.setLocation(770, 615);
        body.setPreferredSize(d);
        body.setUndecorated(true);
        
        body.setVisible(true);
        body.add(panel);
        panel.setSize(365, 90);
        panel.setBackground(Color.BLACK);
        body.pack();
        
        JPanel panel2=new JPanel();
        JFrame body2=new JFrame();
        body2.setLocation(720,650);
        body2.setPreferredSize(e);
        dispose();
        body2.setUndecorated(true);
        body2.setVisible(true);
        body2.add(panel2);
        panel2.setSize(475,70);
        panel2.setBackground(Color.BLACK);
        body2.pack();
        
        dispose();
        
    }//GEN-LAST:event_jmRegistrarPedidoActionPerformed

    private void jmVerPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmVerPerfilActionPerformed
        VerPerfil vp=new VerPerfil();
        vp.setVisible(true);
    }//GEN-LAST:event_jmVerPerfilActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Plataforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Plataforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Plataforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Plataforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Plataforma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem jmCerrarSesion;
    private javax.swing.JMenuItem jmRegistrarPedido;
    private javax.swing.JMenuItem jmVerPerfil;
    public static javax.swing.JLabel labelBienvenido;
    // End of variables declaration//GEN-END:variables
}
