package LicoreriaKappa;
/*Tenemos que hacer el programa:
- Aprueba de tontos   (Funciona)
- Aprueba de Trolls  (Funciona)
- ¡Que funcione 100%! (Funciona)
*/
import java.awt.Color;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Reg_Datos extends javax.swing.JFrame {

    public Reg_Datos() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Icon.png")).getImage());
        
        //*************************************************************************************************
        
        jcbDistrito.addItem("Ate"); jcbDistrito.addItem("Ancón"); jcbDistrito.addItem("Barranco"); jcbDistrito.addItem("Breña");
        jcbDistrito.addItem("Chorrillos"); jcbDistrito.addItem("Independencia"); jcbDistrito.addItem("LaMolina");
        jcbDistrito.addItem("LaVictoria"); jcbDistrito.addItem("Lima"); jcbDistrito.addItem("Lince"); jcbDistrito.addItem("Lurín");
        jcbDistrito.addItem("Miraflores"); jcbDistrito.addItem("PuntaHermosa"); jcbDistrito.addItem("Rimac"); jcbDistrito.addItem("SanBorja");
        jcbDistrito.addItem("SJMiraflores"); jcbDistrito.addItem("SanMiguel"); jcbDistrito.addItem("SantaAnita"); jcbDistrito.addItem("Surco");
        jcbDistrito.addItem("Surquillo"); jcbDistrito.addItem("VMTriunfo");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcbDistrito = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        jcbDia = new javax.swing.JComboBox<>();
        jcbMes = new javax.swing.JComboBox<>();
        jcbAño = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtCorreoElec = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 1, 20)); // NOI18N
        jLabel1.setText("REGISTRO DE DATOS PERSONALES");

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel2.setText("Primer Nombre");

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel3.setText("Apellido Paterno");

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel4.setText("Numero DNI:");

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel5.setText("Correo Electrónico (gmail.com):");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel10.setText("Nombre de Usuario:");

        jLabel11.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel11.setText("Contraseña:");

        txtUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtUsuario.setEnabled(false);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });

        txtContraseña.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtContraseña.setEnabled(false);
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
        });

        lbl6.setBackground(new java.awt.Color(0, 0, 0));
        lbl6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl6.setOpaque(true);

        lbl7.setBackground(new java.awt.Color(0, 0, 0));
        lbl7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl7.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel6.setText("Lugar mas cercano a su ubicacion:");

        jcbDistrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el distrito.." }));
        jcbDistrito.setEnabled(false);
        jcbDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDistritoActionPerformed(evt);
            }
        });
        jcbDistrito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbDistritoKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel8.setText("Fecha de Nacimiento:");

        lbl8.setBackground(new java.awt.Color(0, 0, 0));
        lbl8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl8.setOpaque(true);

        lbl9.setBackground(new java.awt.Color(0, 0, 0));
        lbl9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl9.setOpaque(true);

        jcbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jcbDia.setEnabled(false);
        jcbDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDiaActionPerformed(evt);
            }
        });
        jcbDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbDiaKeyPressed(evt);
            }
        });

        jcbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jcbMes.setEnabled(false);
        jcbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMesActionPerformed(evt);
            }
        });
        jcbMes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbMesKeyPressed(evt);
            }
        });

        jcbAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Año", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959" }));
        jcbAño.setEnabled(false);
        jcbAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAñoActionPerformed(evt);
            }
        });
        jcbAño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbAñoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(txtUsuario))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbDia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbAño, 0, 65, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcbAño, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jcbMes, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(lbl8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbDia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbDistrito, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel7.setText("Telefono Local:");

        txtDNI.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDNI.setEnabled(false);
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDNIKeyPressed(evt);
            }
        });

        txtCorreoElec.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtCorreoElec.setEnabled(false);
        txtCorreoElec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoElecActionPerformed(evt);
            }
        });
        txtCorreoElec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreoElecKeyPressed(evt);
            }
        });

        txtTelefono.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTelefono.setEnabled(false);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setText("*Rellenar obligatoriamente todo el formulario");

        txtApellido.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtApellido.setEnabled(false);
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidoKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel17.setText("Verificar tecleando <Enter> dentro del cuadro si esta correcto o no.");

        lbl1.setBackground(new java.awt.Color(0, 0, 0));
        lbl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl1.setOpaque(true);

        lbl2.setBackground(new java.awt.Color(0, 0, 0));
        lbl2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl2.setOpaque(true);

        lbl3.setBackground(new java.awt.Color(0, 0, 0));
        lbl3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl3.setOpaque(true);

        lbl4.setBackground(new java.awt.Color(0, 0, 0));
        lbl4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl4.setOpaque(true);

        lbl5.setBackground(new java.awt.Color(0, 0, 0));
        lbl5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl5.setOpaque(true);

        txtNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Retrocede casilla: Boton Inicio");

        btnRegistrar.setText("REGISTRARSE");
        btnRegistrar.setEnabled(false);
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
        });
        btnRegistrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnRegistrarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(326, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtDNI)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(jLabel3)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                    .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addGap(18, 18, 18)
                                                .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtTelefono)
                                                    .addComponent(txtCorreoElec, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(14, 14, 14)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel12))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreoElec, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    
    String Nombre;
    String Usuario;
    String Apellido;
    String Correo;
    String Contraseña;
    String DniCop;
    String TelefonoCop;
    
    
    String Distrito = " ";
    int Dia;
    String Mes = "";
    int Año;
    
    Monitor diapo = new Monitor();
    File f = new File("D:/BD_DatosPersonales.txt");
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    }//GEN-LAST:event_formMouseClicked

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        try {
            Apellido = txtApellido.getText();

            if (Apellido.length() == 0) {
                throw new Exception("No dejar en blanco este casillero");
            }

            if (Apellido.startsWith(" ")) {
                throw new Exception("No comenzar con espacios al escribir");
            }

            char[] chApellido = Apellido.toCharArray();

            for (int i = 0; i < Apellido.length(); i++) {
                if (Character.isDigit(chApellido[i])) {

                    throw new Exception("No debe contener digitos");
                }
            }
            //***
            for (int i = 0; i < Apellido.length(); i++) {
                if (!Character.isLetter(chApellido[i])) {

                    throw new Exception("No debe contener simbolos ni espacios en blanco");
                }
            }

            lbl2.setBackground(Color.GREEN); lbl3.setBackground(Color.BLACK);
            txtDNI.setEnabled(true); txtDNI.requestFocus();
            txtApellido.setEnabled(false);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR - Ingrese Apellido",JOptionPane.ERROR_MESSAGE);
            lbl2.setBackground(Color.RED);
            txtApellido.requestFocus();
        }
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        try{
            if(txtDNI.getText().isEmpty()){
                throw new Exception("No dejar en blanco este casillero");
            }
            if(txtDNI.getText().startsWith(" ")){
                throw new Exception("No comenzar con espacios al escribir");
            }
            
            char[] chDNI = txtDNI.getText().toCharArray();

            for (int i = 0; i < txtDNI.getText().length(); i++) {
                if (!Character.isDigit(chDNI[i])) {
                    throw new Exception("No debe contener letras, ni simbolos\n"
                            + "ni dejar espacios");
                }
            }
            
            if(txtDNI.getText().length()!=8){
                throw new Exception("Numero DNI invalido");
            }
            
            lbl3.setBackground(Color.GREEN); lbl4.setBackground(Color.BLACK);
            txtCorreoElec.setEnabled(true); txtCorreoElec.requestFocus();
            txtDNI.setEnabled(false);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR - Ingrese DNI",JOptionPane.ERROR_MESSAGE);
            lbl3.setBackground(Color.RED);
            txtDNI.requestFocus();
        }
    }//GEN-LAST:event_txtDNIActionPerformed

    private void txtCorreoElecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoElecActionPerformed
        try{ Correo=txtCorreoElec.getText();
        
            if(Correo.isEmpty()){
                throw new Exception("No dejar en blanco este casillero");
            }
            
            if(Correo.startsWith(" ")){
                throw new Exception("No comenzar con espacios al escribir");
            }
            
            if(Correo.startsWith("@")){
                throw new Exception("Correo invalido\n"
                        + "asegure escribir bien su correo\n"
                        + "sin dejar ningun espacio");
            }
            
            if(!Correo.endsWith("@gmail.com")){
                throw new Exception("Correo invalido\n"
                        + "asegure colocar bien su correo\n"
                        + "sin dejar ningun espacio");
            }
            
            char[] chCorreo = Correo.toCharArray();

            for (int i = 0; i < Correo.length(); i++) {
                if (Character.isWhitespace(chCorreo[i])) {
                    throw new Exception("Procure dejar espacios");
                }
            }
            
            lbl4.setBackground(Color.GREEN); lbl5.setBackground(Color.BLACK);
            txtTelefono.setEnabled(true); txtTelefono.requestFocus();
            txtCorreoElec.setEnabled(false);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR - Ingrese Correo Electronico",JOptionPane.ERROR_MESSAGE);
            lbl4.setBackground(Color.RED);
            txtCorreoElec.requestFocus();
        }
    }//GEN-LAST:event_txtCorreoElecActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        try{
            if(txtTelefono.getText().isEmpty()){
                throw new Exception("No dejar en blanco este casillero");
            }
            if(txtTelefono.getText().startsWith(" ")){
                throw new Exception("No comenzar con espacios al escribir");
            }
            
            char[] chTelefono = txtTelefono.getText().toCharArray();

            for (int i = 0; i < txtTelefono.getText().length(); i++) {
                if (!Character.isDigit(chTelefono[i])) {
                    throw new Exception("No debe contener letras, ni simbolos\n"
                            + "ni dejar espacios");
                }
            }
            
            if(txtTelefono.getText().length()!=7){
                throw new Exception("Numero de Telefono local invalido");
            }
            
            lbl5.setBackground(Color.GREEN); lbl6.setBackground(Color.BLACK);
            txtUsuario.setEnabled(true); txtUsuario.requestFocus();
            txtTelefono.setEnabled(false);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR - Ingrese DNI",JOptionPane.ERROR_MESSAGE);
            lbl5.setBackground(Color.RED);
            txtTelefono.requestFocus();
        }
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        try {
            Nombre = txtNombre.getText();

            if (Nombre.length() == 0) {
                throw new Exception("No dejar en blanco este casillero");
            }

            if (Nombre.startsWith(" ")) {
                throw new Exception("No comenzar con espacios al escribir");
            }

            char[] chNombres = Nombre.toCharArray();

            for (int i = 0; i < Nombre.length(); i++) {
                if (Character.isDigit(chNombres[i])) {

                    throw new Exception("No debe contener digitos");
                }
            }
            //***
            for (int i = 0; i < Nombre.length(); i++) {
                if (!Character.isLetter(chNombres[i])) {

                    throw new Exception("No debe contener simbolos ni espacios en blanco");
                }
            }

            lbl1.setBackground(Color.GREEN); lbl2.setBackground(Color.BLACK);
            txtApellido.setEnabled(true); txtApellido.requestFocus();
            txtNombre.setEnabled(false);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR - Ingrese Nombre",JOptionPane.ERROR_MESSAGE);
            lbl1.setBackground(Color.RED);
            txtNombre.requestFocus();

        }
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyPressed
        if(evt.getKeyCode()==36){
            txtNombre.setEnabled(true);
            txtNombre.requestFocus();
            txtApellido.setText("");
            lbl1.setBackground(Color.BLACK);
            txtApellido.setEnabled(false);
            lbl2.setBackground(Color.BLACK);
        }
    }//GEN-LAST:event_txtApellidoKeyPressed

    private void txtDNIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyPressed
        if(evt.getKeyCode()==36){
            txtApellido.setEnabled(true);
            txtApellido.requestFocus();
            txtDNI.setText("");
            lbl2.setBackground(Color.BLACK);
            txtDNI.setEnabled(false);
            lbl3.setBackground(Color.BLACK);
        }
    }//GEN-LAST:event_txtDNIKeyPressed

    private void txtCorreoElecKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoElecKeyPressed
        if(evt.getKeyCode()==36){
            txtDNI.setEnabled(true);
            txtDNI.requestFocus();
            txtCorreoElec.setText("");
            lbl3.setBackground(Color.BLACK);
            txtCorreoElec.setEnabled(false);
            lbl4.setBackground(Color.BLACK);
        }
    }//GEN-LAST:event_txtCorreoElecKeyPressed

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        if(evt.getKeyCode()==36){
            txtCorreoElec.setEnabled(true);
            txtCorreoElec.requestFocus();
            txtTelefono.setText("");
            lbl4.setBackground(Color.BLACK);
            txtTelefono.setEnabled(false);
            lbl5.setBackground(Color.BLACK);
        }
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
        if(evt.getKeyCode()==36){
            txtUsuario.setEnabled(true);
            txtUsuario.requestFocus();
            txtContraseña.setText("");
            lbl6.setBackground(Color.BLACK);
            txtContraseña.setEnabled(false);
            lbl7.setBackground(Color.BLACK);
        }
    }//GEN-LAST:event_txtContraseñaKeyPressed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        try{    Contraseña=txtContraseña.getText();

            if(Contraseña.isEmpty()){
                throw new Exception("No dejar en blanco este casillero");
            }
            if(Contraseña.startsWith(" ")){
                throw new Exception("No comenzar con espacios al escribir");
            }

            char[] chContraseña = Contraseña.toCharArray();

            for (int i = 0; i < Contraseña.length(); i++) {
                if (Character.isWhitespace(chContraseña[i])) {
                    throw new Exception("Procure dejar espacios");
                }
            }
            
            for (int i = 0; i < Contraseña.length(); i++) {
                if (!Character.isLetterOrDigit(chContraseña[i])) {
                    throw new Exception("No se admite simbolos");
                }
            }
            
            lbl7.setBackground(Color.GREEN);
            jcbDia.setEnabled(true);
            jcbMes.setEnabled(true);
            jcbAño.setEnabled(true);
            txtContraseña.setEnabled(false);
            jcbDia.requestFocus();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR - Ingrese Usuario",JOptionPane.ERROR_MESSAGE);
            lbl7.setBackground(Color.RED);
            txtContraseña.requestFocus();
        }
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        if(evt.getKeyCode()==36){
            txtTelefono.setEnabled(true);
            txtTelefono.requestFocus();
            txtUsuario.setText("");
            lbl5.setBackground(Color.BLACK);
            txtUsuario.setEnabled(false);
            lbl6.setBackground(Color.BLACK);
        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        try{    Usuario=txtUsuario.getText();

            if(Usuario.isEmpty()){
                throw new Exception("No dejar en blanco este casillero");
            }
            if(Usuario.startsWith(" ")){
                throw new Exception("No comenzar con espacios al escribir");
            }
            
            char[] chUsuario = Usuario.toCharArray();

            for (int i = 0; i < Usuario.length(); i++) {
                if (Character.isWhitespace(chUsuario[i])) {
                    throw new Exception("Procure dejar espacios");
                }
            }
            
            for (int i = 0; i < Usuario.length(); i++) {
                if (!Character.isLetterOrDigit(chUsuario[i])) {
                    throw new Exception("No se admite simbolos");
                }
            }
            
            lbl6.setBackground(Color.GREEN); lbl7.setBackground(Color.BLACK);
            txtContraseña.setEnabled(true); txtContraseña.requestFocus();
            txtUsuario.setEnabled(false);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR - Ingrese Usuario",JOptionPane.ERROR_MESSAGE);
            lbl6.setBackground(Color.RED);
            txtUsuario.requestFocus();
            
//            for (int x=0; x < sTexto.length(); x++) {
//  if (sTexto.charAt(x) != ' ')

//}
        }
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void jcbDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDiaActionPerformed
        try{
            if("Dia".equals(jcbDia.getSelectedItem().toString()) && "Mes".equals(jcbMes.getSelectedItem().toString()) && 
               "Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.BLACK);
         }
             if(!"Dia".equals(jcbDia.getSelectedItem().toString()) && !"Mes".equals(jcbMes.getSelectedItem().toString()) && 
                !"Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.GREEN);
                jcbDistrito.setEnabled(true);
                jcbDistrito.requestFocus();
                jcbDia.setEnabled(false);
                jcbMes.setEnabled(false);
                jcbAño.setEnabled(false);
         }
             if("Dia".equals(jcbDia.getSelectedItem().toString()) && !"Mes".equals(jcbMes.getSelectedItem().toString()) && 
               !"Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
             if(!"Dia".equals(jcbDia.getSelectedItem().toString()) && "Mes".equals(jcbMes.getSelectedItem().toString()) && 
                !"Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
             if(!"Dia".equals(jcbDia.getSelectedItem().toString()) && !"Mes".equals(jcbMes.getSelectedItem().toString()) && 
                 "Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
             if(!"Dia".equals(jcbDia.getSelectedItem().toString()) && "Mes".equals(jcbMes.getSelectedItem().toString()) && 
                 "Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
             if("Dia".equals(jcbDia.getSelectedItem().toString()) && !"Mes".equals(jcbMes.getSelectedItem().toString()) && 
                "Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
             if("Dia".equals(jcbDia.getSelectedItem().toString()) && "Mes".equals(jcbMes.getSelectedItem().toString()) && 
               !"Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jcbDiaActionPerformed

    private void jcbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMesActionPerformed
        try{
            if("Dia".equals(jcbDia.getSelectedItem().toString()) && "Mes".equals(jcbMes.getSelectedItem().toString()) && 
               "Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.BLACK);
         }
             if(!"Dia".equals(jcbDia.getSelectedItem().toString()) && !"Mes".equals(jcbMes.getSelectedItem().toString()) && 
                !"Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.GREEN);
                jcbDistrito.setEnabled(true);
                jcbDistrito.requestFocus();
                jcbDia.setEnabled(false);
                jcbMes.setEnabled(false);
                jcbAño.setEnabled(false);
         }
             if("Dia".equals(jcbDia.getSelectedItem().toString()) && !"Mes".equals(jcbMes.getSelectedItem().toString()) && 
               !"Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
             if(!"Dia".equals(jcbDia.getSelectedItem().toString()) && "Mes".equals(jcbMes.getSelectedItem().toString()) && 
                !"Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
             if(!"Dia".equals(jcbDia.getSelectedItem().toString()) && !"Mes".equals(jcbMes.getSelectedItem().toString()) && 
                 "Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
             if(!"Dia".equals(jcbDia.getSelectedItem().toString()) && "Mes".equals(jcbMes.getSelectedItem().toString()) && 
                 "Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
             if("Dia".equals(jcbDia.getSelectedItem().toString()) && !"Mes".equals(jcbMes.getSelectedItem().toString()) && 
                "Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
             if("Dia".equals(jcbDia.getSelectedItem().toString()) && "Mes".equals(jcbMes.getSelectedItem().toString()) && 
               !"Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jcbMesActionPerformed

    private void jcbAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAñoActionPerformed
        try{
            if("Dia".equals(jcbDia.getSelectedItem().toString()) && "Mes".equals(jcbMes.getSelectedItem().toString()) && 
               "Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.BLACK);
         }
             if(!"Dia".equals(jcbDia.getSelectedItem().toString()) && !"Mes".equals(jcbMes.getSelectedItem().toString()) && 
                !"Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.GREEN);
                jcbDistrito.setEnabled(true);
                jcbDistrito.requestFocus();
                jcbDia.setEnabled(false);
                jcbMes.setEnabled(false);
                jcbAño.setEnabled(false);
         }
             if("Dia".equals(jcbDia.getSelectedItem().toString()) && !"Mes".equals(jcbMes.getSelectedItem().toString()) && 
               !"Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
             if(!"Dia".equals(jcbDia.getSelectedItem().toString()) && "Mes".equals(jcbMes.getSelectedItem().toString()) && 
                !"Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
             if(!"Dia".equals(jcbDia.getSelectedItem().toString()) && !"Mes".equals(jcbMes.getSelectedItem().toString()) && 
                 "Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
             if(!"Dia".equals(jcbDia.getSelectedItem().toString()) && "Mes".equals(jcbMes.getSelectedItem().toString()) && 
                 "Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
             if("Dia".equals(jcbDia.getSelectedItem().toString()) && !"Mes".equals(jcbMes.getSelectedItem().toString()) && 
                "Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
             if("Dia".equals(jcbDia.getSelectedItem().toString()) && "Mes".equals(jcbMes.getSelectedItem().toString()) && 
               !"Año".equals(jcbAño.getSelectedItem().toString())){
                lbl8.setBackground(Color.RED);
                jcbDistrito.setEnabled(false);
                jcbDistrito.setSelectedItem("Seleccione el distrito..");
         }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jcbAñoActionPerformed

    private void jcbDiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbDiaKeyPressed
        if(evt.getKeyCode()==36){
            txtContraseña.setEnabled(true);
            txtContraseña.requestFocus();
            lbl7.setBackground(Color.BLACK);
            jcbDia.setEnabled(false);
            jcbDia.setSelectedItem("Dia");
            jcbMes.setEnabled(false);
            jcbMes.setSelectedItem("Mes");
            jcbAño.setEnabled(false);
            jcbAño.setSelectedItem("Año");
            lbl8.setBackground(Color.BLACK);
        }
    }//GEN-LAST:event_jcbDiaKeyPressed

    private void jcbMesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbMesKeyPressed
        if(evt.getKeyCode()==36){
            txtContraseña.setEnabled(true);
            txtContraseña.requestFocus();
            lbl7.setBackground(Color.BLACK);
            jcbDia.setEnabled(false);
            jcbDia.setSelectedItem("Dia");
            jcbMes.setEnabled(false);
            jcbMes.setSelectedItem("Mes");
            jcbAño.setEnabled(false);
            jcbAño.setSelectedItem("Año");
            lbl8.setBackground(Color.BLACK);
        }
    }//GEN-LAST:event_jcbMesKeyPressed

    private void jcbAñoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbAñoKeyPressed
        if(evt.getKeyCode()==36){
            txtContraseña.setEnabled(true);
            txtContraseña.requestFocus();
            lbl7.setBackground(Color.BLACK);
            jcbDia.setEnabled(false);
            jcbDia.setSelectedItem("Dia");
            jcbMes.setEnabled(false);
            jcbMes.setSelectedItem("Mes");
            jcbAño.setEnabled(false);
            jcbAño.setSelectedItem("Año");
            lbl8.setBackground(Color.BLACK);
        }
    }//GEN-LAST:event_jcbAñoKeyPressed

    private void jcbDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDistritoActionPerformed
        if(!"Seleccione el distrito..".equals(jcbDistrito.getSelectedItem().toString())){
            lbl9.setBackground(Color.GREEN);
            btnRegistrar.setEnabled(true);
            btnRegistrar.requestFocus();
            jcbDistrito.setEnabled(false);
        }
    }//GEN-LAST:event_jcbDistritoActionPerformed

    private void jcbDistritoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbDistritoKeyPressed
        if(evt.getKeyCode()==36){
            jcbDia.setEnabled(true);
            jcbMes.setEnabled(true);
            jcbAño.setEnabled(true);
            jcbDia.requestFocus();
            lbl8.setBackground(Color.BLACK);
            jcbDia.setSelectedItem("Dia");
            jcbMes.setSelectedItem("Mes");
            jcbAño.setSelectedItem("Año");
            jcbDistrito.setEnabled(false);
            jcbDistrito.setSelectedItem("Seleccione el distrito..");
            lbl9.setBackground(Color.BLACK);
        }
    }//GEN-LAST:event_jcbDistritoKeyPressed

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        try {

            fw = new FileWriter("D:/BD_DatosPersonales.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            String datos = txtNombre.getText() + " " + txtApellido.getText() + " " + txtUsuario.getText() + " " + txtContraseña.getText() + " " + txtDNI.getText() + " " + txtCorreoElec.getText() + " " + txtTelefono.getText() + " "
            + jcbDistrito.getSelectedItem().toString() + " " + jcbDia.getSelectedItem().toString() + " " + jcbMes.getSelectedItem().toString() + " " + jcbAño.getSelectedItem().toString() + "  ";

            pw.println(datos);
            pw.close();
            dispose();

        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnRegistrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRegistrarKeyPressed
        if(evt.getKeyCode()==36){
            jcbDistrito.setEnabled(true);
            jcbDistrito.requestFocus();
            jcbDistrito.setSelectedItem("Seleccione el distrito..");
            lbl9.setBackground(Color.BLACK);
            btnRegistrar.setEnabled(false);
        }
    }//GEN-LAST:event_btnRegistrarKeyPressed

    
    
    
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
            java.util.logging.Logger.getLogger(Reg_Datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reg_Datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reg_Datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reg_Datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reg_Datos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jcbAño;
    private javax.swing.JComboBox<String> jcbDia;
    private javax.swing.JComboBox<String> jcbDistrito;
    private javax.swing.JComboBox<String> jcbMes;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreoElec;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
