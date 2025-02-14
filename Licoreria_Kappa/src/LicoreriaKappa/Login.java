package LicoreriaKappa;

import com.sun.awt.AWTUtilities;                        // Constructor
import java.awt.Color;                                  // TimerTask_Tarea1
import java.awt.Font;                                   // Original_Labels
import java.awt.Shape;                                  // Constructor
import java.awt.font.TextAttribute;                     // label 1
import java.awt.geom.RoundRectangle2D;                  // Constructor
import java.io.File;                                    // Archivo
import java.util.Map;                                   // label 1
import java.util.Scanner;                               // Leer el archivo
import java.util.Timer;                                 // Animaciones
import java.util.TimerTask;                             // Animaciones
import javax.swing.ImageIcon;                           // Constructor_Banks
import javax.swing.JLabel;                              // Constructor
import javax.swing.JLayeredPane;                        // Constructor
import javax.swing.JOptionPane;                         // txtUsuario + txtContraseña
import javax.swing.JPanel;                              // Constructor

public class Login extends javax.swing.JFrame {

    int x, y;
    int controP = 1, c = 0;
    
    File f;
    Scanner sc;
    
    public Login() {
        initComponents();
        
        setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 27, 27);
        AWTUtilities.setWindowShape(this, forma);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Icon.png")).getImage());

//****************************************************************************************************************  
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon imagen = new ImageIcon(this.getClass().getResource("/imagenes/Fondo.jpeg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(imagen);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, imagen.getIconWidth(), imagen.getIconHeight());

//**************************************************************************************************************** 
                        
        for (int i = 11; i < 35; i++) {
          // javax.swing.ImageIcon(getClass().getResource("/imagenes/CarltonBanks/Frame11.gif"))); 
            //crear el cajon y colocar la foto
            Vec[i] = new ImageIcon(getClass().getResource("/imagenes/CarltonBanks/Frame" + i + ".gif")); // NOI18N
        }

        timy2= new Timer();
        timy2.scheduleAtFixedRate(tarea2, 0, 58);

//*************************************************************************************************

        try{ f= new File("D:/BD_DatosPersonales.txt"); }
        catch(Exception e) {  System.out.println(e.getMessage());  }
        
        txtUsuario.requestFocus();
        
    }

    Timer timy2;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtContraseña = new javax.swing.JPasswordField();
        lblTiTulo1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        btnSalida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        txtContraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });

        lblTiTulo1.setFont(new java.awt.Font("Bradley Hand ITC", 1, 32)); // NOI18N
        lblTiTulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTiTulo1.setText("Delivery KappaRoss");

        txtUsuario.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txtUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel1.setText("Nombre de Usuario:");

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña:");

        label1.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 51, 204));
        label1.setText("¿Has olvidado tu contraseña?");
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label1MouseExited(evt);
            }
        });

        label2.setFont(new java.awt.Font("Berlin Sans FB", 0, 26)); // NOI18N
        label2.setText("¡REGISTRESE AHORA!");
        label2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label2MouseExited(evt);
            }
        });

        label3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/CarltonBanks/Frame11.gif"))); // NOI18N
        label3.setToolTipText("");
        label3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label3MouseClicked(evt);
            }
        });

        btnSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton02.png"))); // NOI18N
        btnSalida.setBorder(null);
        btnSalida.setBorderPainted(false);
        btnSalida.setContentAreaFilled(false);
        btnSalida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalida.setIconTextGap(-3);
        btnSalida.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton03.png"))); // NOI18N
        btnSalida.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton01.png"))); // NOI18N
        btnSalida.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label1)
                            .addComponent(label2)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(txtUsuario)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTiTulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblTiTulo1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(47, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     Font original;
     
     TimerTask tarea2 = new TimerTask() {
        int i = 11;

        @Override
        public void run() {
            if (i < 35) {
                label3.setIcon(Vec[i]);
                i++;
            } else {
                i = 11;
            }
        }
    };

    ImageIcon[] Vec= new ImageIcon[50]; //aca esta es el esqueleto de la comoda
    
    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        Plataforma ross=new Plataforma();
        try { 
             sc= new Scanner(f);
             
             String mensaje="", UsuarioVerifica=txtUsuario.getText(), ContraVerifica=txtContraseña.getText();
             
             String nombre, apellido,usuario,contrasena,correo,distrito,mes;
             
             int dni,telefono,dia,anerino;
             
       while(sc.hasNext()) {  nombre=sc.next(); //nombre
            apellido=sc.next();  //apellido
            usuario=sc.next();  //usuario VERIFICA
            contrasena=sc.next();   //contraseña
            dni= sc.nextInt();  // DNI
            correo=sc.next();   //Correo
            telefono=sc.nextInt();      //telefono
            distrito=sc.next();     //distrito
            dia=sc.nextInt();       //dia
            mes=sc.next();          //mes
            anerino=sc.nextInt();       //año
            
           if(UsuarioVerifica.equals(usuario) && ContraVerifica.equals(contrasena)){
               ross.setVisible(true);
               dispose();
               Plataforma.labelBienvenido.setText("¡ SEA BIENVENIDO, "+nombre.toUpperCase()+" !");
             }
           
        }
        } catch (Exception e) { JOptionPane.showMessageDialog(this, e.getMessage());  }
        
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void label1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1MouseClicked

        Rec_Cuenta app = new Rec_Cuenta();
        app.setVisible(true);
    }//GEN-LAST:event_label1MouseClicked

    private void label1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1MouseEntered
        original = evt.getComponent().getFont();
        Map attributes = original.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        label1.setForeground(new Color(135, 206, 235));
        evt.getComponent().setFont(original.deriveFont(attributes));
    }//GEN-LAST:event_label1MouseEntered

    private void label1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1MouseExited
        evt.getComponent().setFont(original);
        label1.setForeground(new Color(0, 51, 204));
    }//GEN-LAST:event_label1MouseExited

    private void label2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2MouseClicked
        Reg_Datos gg = new Reg_Datos();
        gg.setVisible(true);
    }//GEN-LAST:event_label2MouseClicked

    TimerTask tarea1 = new TimerTask() {
        @Override
        public void run() {
            if (c == 0) {
                label2.setForeground(Color.YELLOW);
                c = 1;
            } else if (c == 1) {
                label2.setForeground(Color.BLUE);
                c = 2;
            } else if (c == 2) {
                label2.setForeground(Color.RED);
                c = 3;
            } else if (c == 3) {
                label2.setForeground(Color.CYAN);
                c = 4;
            } else if (c == 4) {
                label2.setForeground(Color.GREEN);
                c = 0;
            } else {
                label2.setForeground(Color.BLACK);
            }
        }
    };
    
    Timer timy1 = new Timer();
    
    private void label2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2MouseEntered
        if (controP == 1) {
            timy1.scheduleAtFixedRate(tarea1, 0, 150);
        }
        controP++;
        if (c == 9) {
            c = 0;
        }
    }//GEN-LAST:event_label2MouseEntered

    private void label2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2MouseExited
        c = 9;
    }//GEN-LAST:event_label2MouseExited

    private void btnSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalidaActionPerformed

    private void label3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label3MouseClicked
    }//GEN-LAST:event_label3MouseClicked

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        Plataforma ross=new Plataforma();
        try { 
            
            sc= new Scanner(f);
            
             String mensaje="", UsuarioVerifica=txtUsuario.getText(), ContraVerifica=txtContraseña.getText();
             
             String nombre, apellido,usuario,contrasena,correo,distrito,mes;
             
             int dni,telefono,dia,anerino;
             
       while(sc.hasNext())
        {  
            nombre=sc.next(); //nombre
            apellido=sc.next();  //apellido
            usuario=sc.next();  //usuario VERIFICA
            contrasena=sc.next();   //contraseña
            dni= sc.nextInt();  // DNI
            correo=sc.next();   //Correo
            telefono=sc.nextInt();      //telefono
            distrito=sc.next();     //distrito
            dia=sc.nextInt();       //dia
            mes=sc.next();          //mes
            anerino=sc.nextInt();       //año
            
           if(UsuarioVerifica.equals(usuario) && ContraVerifica.equals(contrasena)){
               ross.setVisible(true);
               dispose();
               Plataforma.labelBienvenido.setText("¡ SEA BIENVENIDO, "+nombre.toUpperCase()+" !");
             }
           
        }
        } catch (Exception e) {  JOptionPane.showMessageDialog(this, e.getMessage());  }
    }//GEN-LAST:event_txtContraseñaActionPerformed

    /**
     * @param args the command line arguments
     */
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel lblTiTulo1;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
