package LicoreriaKappa;

import javax.swing.ImageIcon;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Rec_Cuenta extends javax.swing.JFrame {

    File f;
    Scanner sc;
    
    public Rec_Cuenta() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Icon.png")).getImage());
        
        try{ 
            f= new File("D:/BD_DatosPersonales.txt"); 
        }
        catch(Exception e) {  System.out.println(e.getMessage());  }
                
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtGmail = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSalida = new javax.swing.JTextArea();
        label1 = new javax.swing.JLabel();
        txtContraseñaNueva = new javax.swing.JTextField();
        label2 = new javax.swing.JLabel();
        txtConfirmacion = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnVerifica = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel1.setText("Escriba el correo electronico que registro a su cuenta y");

        txtGmail.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        txtSalida.setEditable(false);
        txtSalida.setBackground(new java.awt.Color(0, 0, 0));
        txtSalida.setColumns(20);
        txtSalida.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSalida.setForeground(new java.awt.Color(51, 204, 255));
        txtSalida.setRows(5);
        jScrollPane1.setViewportView(txtSalida);

        label1.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        label1.setText("Introduzca contraseña nueva:");

        txtContraseñaNueva.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtContraseñaNueva.setEnabled(false);
        txtContraseñaNueva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaNuevaKeyPressed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        label2.setText("Confirma de nuevo la contraseña:");

        txtConfirmacion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtConfirmacion.setEnabled(false);
        txtConfirmacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConfirmacionKeyPressed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnVerifica.setBackground(new java.awt.Color(0, 51, 255));
        btnVerifica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnVerifica.setOpaque(true);
        btnVerifica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerificaMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel3.setText("consiguientemente clickee en el casillero verde para la verificacion.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtConfirmacion, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContraseñaNueva, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(btnVerifica, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtGmail)
                    .addComponent(btnVerifica, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContraseñaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
      String contrasena;
    
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try { 
                if(!txtContraseñaNueva.equals(txtConfirmacion)){
                    throw new Exception("Las ultimas casillas no deben estar en blanco, ni\n"
                            + "dejando espacios ni diferentes al otro.");
                }
                
             sc= new Scanner(f);
             
             String GmailBuscado= txtGmail.getText(), NovaContra=txtConfirmacion.getText();
             
             String nombre, apellido,usuario,correo,distrito,mes;
             
             int dni,telefono,dia,anerino;
             
       /*1º opcion en modificar un registro dentro del archivo para cada linea*/   
       //********************************************************************************//
       while(sc.hasNext()) {  
            nombre=sc.next(); //nombre
            apellido=sc.next();  //apellido
            dni= sc.nextInt();  // DNI
            correo=sc.next();   //Correo verificarlo
            telefono=sc.nextInt();      //telefono
            usuario=sc.next();  //usuario
            contrasena=sc.next();   //contraseña
            dia=sc.nextInt();       //dia
            mes=sc.next();          //mes
            anerino=sc.nextInt();       //año
            distrito=sc.next();     //distrito
            
           if(GmailBuscado.equals(correo)){
               
           } 
           
        }
        
        } catch (Exception e) {  
            System.out.println(e.getMessage());
//            JOptionPane.showMessageDialog(this, e.getMessage(),"ERROR - RECUPERACION DE CUENTA",JOptionPane.ERROR_MESSAGE);  
                }
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnVerificaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerificaMouseClicked
        try {      if(txtGmail.getText().isEmpty()){
                    throw new Exception("Aun no ha ingresado nada dentro del campo.\n"
                            + "Si no tiene una cuenta, puede registrase desde el enlace\n"
                            + "ubicado en el login gratuitamente.");
                }
            
             sc= new Scanner(f);
        
             String mensaje="", GmailBuscado= txtGmail.getText();
             
             String nombre, apellido,usuario,correo,distrito,mes;
             
             int dni,telefono,dia,anerino;
             
       while(sc.hasNext()) {
           
            nombre=sc.next(); //nombre
            apellido=sc.next();  //apellido
            usuario=sc.next();  //usuario
            contrasena=sc.next();   //contraseña
            dni= sc.nextInt();  // DNI
            correo=sc.next();   //Correo verificarlo
            telefono=sc.nextInt();      //telefono
            distrito=sc.next();     //distrito
            dia=sc.nextInt();       //dia
            mes=sc.next();          //mes
            anerino=sc.nextInt();       //año
            
           if(!GmailBuscado.equals(correo)){
                mensaje+="Registro verificado... no concuerda con el correo requerido.\n\n";
           } else{
               if(GmailBuscado.equals(correo)){
               
            mensaje+="▬▬▬▬▬▬▬▬▬▬▬ஜ۩۞۩ஜ▬▬▬▬▬▬▬▬▬▬▬ \n\n"
                   +"Correo electronico encontrado:    "+correo+"\n\n"
                   +"Podra usted ahora cambiar la contraseña libremente,\n"
                   +"por lo que requerira confirmarlo despues.\n\n"
                   +"****************************************************\n"
                   +"\nNombre de usuario:                    "+usuario+
                    "\n\n****************************************************\n"
                   +"\n▬▬▬▬▬▬▬▬▬▬▬ஜ۩۞۩ஜ▬▬▬▬▬▬▬▬▬▬▬ \n\n"; 
           
            txtContraseñaNueva.setEnabled(true);
            txtConfirmacion.setEnabled(true);
            txtContraseñaNueva.requestFocus();
            txtGmail.setEditable(false);
                }
           }
            
        }   //Fin del While
       
        txtSalida.setText(mensaje);
        
        } catch (Exception e) {  
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(),"SUGERENCIA",JOptionPane.INFORMATION_MESSAGE);  }
        
    }//GEN-LAST:event_btnVerificaMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode()==36){
              txtGmail.setEditable(true);
              txtGmail.requestFocus();
              txtContraseñaNueva.setEnabled(false);
              txtConfirmacion.setEnabled(false);
              txtSalida.setText("");
        }
    }//GEN-LAST:event_formKeyPressed

    private void txtContraseñaNuevaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaNuevaKeyPressed
        if(evt.getKeyCode()==36){
              txtGmail.setEditable(true);
              txtGmail.requestFocus();
              txtContraseñaNueva.setEnabled(false);
              txtConfirmacion.setEnabled(false);
              txtSalida.setText("");
        }
    }//GEN-LAST:event_txtContraseñaNuevaKeyPressed

    private void txtConfirmacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmacionKeyPressed
        if(evt.getKeyCode()==36){
              txtGmail.setEditable(true);
              txtGmail.requestFocus();
              txtContraseñaNueva.setEnabled(false);
              txtConfirmacion.setEnabled(false);
              txtSalida.setText("");
        }
    }//GEN-LAST:event_txtConfirmacionKeyPressed

    
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
            java.util.logging.Logger.getLogger(Rec_Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rec_Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rec_Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rec_Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rec_Cuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel btnVerifica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JTextField txtConfirmacion;
    private javax.swing.JTextField txtContraseñaNueva;
    private javax.swing.JTextField txtGmail;
    private javax.swing.JTextArea txtSalida;
    // End of variables declaration//GEN-END:variables
}
