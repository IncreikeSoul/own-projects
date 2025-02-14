package LicoreriaKappa;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.Formatter;
import javax.swing.ImageIcon;

public class Cat_Ped extends javax.swing.JFrame {

    public Cat_Ped() {
        initComponents();
        setLocation(60,50);
        setResizable(false);

//**************************************************************************************        
        this.buttonGroup1.add(jrEfectivo);
        this.buttonGroup1.add(jrTarjetaCredito);
        this.buttonGroup2.add(jrBoleta);
        this.buttonGroup2.add(jrFactura);

        try {
            if (!f.exists()) {
                f.createNewFile(); //nueva linea
            }
            fw = new FileWriter(f, true);
            fo = new Formatter(fw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaLicores = new javax.swing.JList();
        jcMarcas = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jrEfectivo = new javax.swing.JRadioButton();
        jrTarjetaCredito = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jrBoleta = new javax.swing.JRadioButton();
        jrFactura = new javax.swing.JRadioButton();
        txtTC1 = new javax.swing.JTextField();
        txtTC2 = new javax.swing.JTextField();
        txtTC3 = new javax.swing.JTextField();
        txtTC4 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtRUC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnACEPTAR = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jsCantidad = new javax.swing.JSpinner();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        jLabel1.setText("CATÁLOGO VARIADO DE LICORES DEL MUNDO");

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel2.setText("Seleccione que tipo de licor desea:");

        listaLicores.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Brandi", "Cerveza", "Ginebra", "Pisco", "Ron", "Tequila", "Vermouth", "Vino", "Vodka", "Whisky" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaLicores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaLicoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaLicores);

        jcMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcMarcasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel3.setText("Seleccione la marca:");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel6.setText("Modo de pago:");

        jrEfectivo.setText("Efectivo");
        jrEfectivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrEfectivoMouseClicked(evt);
            }
        });
        jrEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrEfectivoActionPerformed(evt);
            }
        });

        jrTarjetaCredito.setText("Tarjeta de Credito");
        jrTarjetaCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrTarjetaCreditoMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel7.setText("Comprobante de pago:");

        jrBoleta.setText("Boleta");
        jrBoleta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrBoletaMouseClicked(evt);
            }
        });

        jrFactura.setText("Factura");
        jrFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrFacturaMouseClicked(evt);
            }
        });

        txtTC1.setEnabled(false);

        txtTC2.setEnabled(false);

        txtTC3.setEnabled(false);

        txtTC4.setEnabled(false);

        txtRUC.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jrEfectivo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrTarjetaCredito)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTC1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTC2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTC3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTC4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrBoleta)
                                    .addComponent(jrFactura))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrEfectivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrTarjetaCredito)
                    .addComponent(txtTC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTC4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(15, 15, 15)
                .addComponent(jrBoleta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrFactura)
                    .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel5.setText("Sugerencias mediante la compra:");

        btnACEPTAR.setText("ACEPTAR");
        btnACEPTAR.setEnabled(false);
        btnACEPTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnACEPTARActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel9.setText("¿Cuantos comprará?");

        jsCantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1)
                                    .addComponent(jcMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jsCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnACEPTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jsCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnACEPTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ImageIcon kappa= new ImageIcon();
    
    
    private void listaLicoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaLicoresMouseClicked
        String mensaje = listaLicores.getSelectedValue().toString();
        switch (mensaje) {
            case "Tequila":
                jcMarcas.removeAllItems();
                jcMarcas.addItem("El_blanco_Jose_Cuervo");
                jcMarcas.addItem("Tequila_Don_Anastacio");
                jcMarcas.addItem("Tequila_Estirpe");
                jcMarcas.addItem("Tequila_1800_Añejo");
                break;
            case "Pisco":
                jcMarcas.removeAllItems();
                jcMarcas.addItem("Pisco_Ocucaje");
                jcMarcas.addItem("Tacama_Premium");
                jcMarcas.addItem("Biondi");
                jcMarcas.addItem("Don_Teofilo");
                jcMarcas.addItem("Bou_Barroeta");
                break;
            case "Ron":
                jcMarcas.removeAllItems();
                jcMarcas.addItem("Havana_Club");
                jcMarcas.addItem("Flor_de_Caña");
                jcMarcas.addItem("Bacardi");
                jcMarcas.addItem("Cartavio");
                jcMarcas.addItem("Medellin");
                jcMarcas.addItem("Malibu");
                jcMarcas.addItem("Columbus");
                jcMarcas.addItem("Stroh");
                jcMarcas.addItem("Toucano");
                break;
            case "Brandi":
                jcMarcas.removeAllItems();
                jcMarcas.addItem("Hennessy");
                jcMarcas.addItem("Honey_Bee");
                jcMarcas.addItem("Martell");
                jcMarcas.addItem("Courvoisier");
                break;
            case "Ginebra":
                jcMarcas.removeAllItems();
                jcMarcas.addItem("Tanqueray");
                jcMarcas.addItem("Beefeater");
                jcMarcas.addItem("Bombay_Sapphire");
                jcMarcas.addItem("Broker");
                break;
            case "Cerveza":
                jcMarcas.removeAllItems();
                jcMarcas.addItem("Heineken");
                jcMarcas.addItem("Guinness");
                jcMarcas.addItem("Budweiser");
                jcMarcas.addItem("Miller_Lite");
                jcMarcas.addItem("Coors_Light");
                jcMarcas.addItem("Sam_Adams");
                jcMarcas.addItem("Yuengling");
                break;
            case "Vermouth":
                jcMarcas.removeAllItems();
                jcMarcas.addItem("Cocchi");
                jcMarcas.addItem("Vya");
                jcMarcas.addItem("Noilly_Prat");
                jcMarcas.addItem("Dolin");
                break;
            case "Vino":
                jcMarcas.removeAllItems();
                jcMarcas.addItem("James_Berry_Vineyard");
                jcMarcas.addItem("Shiraz_Barossa");
                jcMarcas.addItem("Douro");
                jcMarcas.addItem("Cabernet_Sauvignon");
                jcMarcas.addItem("Viña_Queirolo");
                jcMarcas.addItem("Gran_Cruz");
                jcMarcas.addItem("Tacama");
                break;
            case "Vodka":
                jcMarcas.removeAllItems();
                jcMarcas.addItem("Belvedere");
                jcMarcas.addItem("Eristoff");
                jcMarcas.addItem("Russkaya");
                jcMarcas.addItem("Smirnoff");
                jcMarcas.addItem("Absolut");
                jcMarcas.addItem("SKYY");
                break;
            case "Whisky":
                jcMarcas.removeAllItems();
                jcMarcas.addItem("Officer_Choice");
                jcMarcas.addItem("Royal_Stag");
                jcMarcas.addItem("Imperial_Blue");
                jcMarcas.addItem("Jim_Beam");
                jcMarcas.addItem("Bagpiper");
                break;
        }
        
    }//GEN-LAST:event_listaLicoresMouseClicked

    String marcasAsigna;
    
    public void condicional(){

        //DAR VALORES
        String BlancoJose="El_blanco_Jose_Cuervo"; String DonAnastacio="Tequila_Don_Anastacio"; String TequilaEstirpe="Tequila_Estirpe"; String Tequila1800="Tequila_1800_Añejo";                                                                                   //Tequila
        String PiscoOcucaje="Pisco_Ocucaje"; String PiscoTacamaPremium="Tacama_Premium"; String Biondi="Biondi"; String DonTeofilo="Don_Teofilo"; String BouBarroeta="Bou_Barroeta";                                                                                //Pisco
        String HavanaClub="Havana_Club"; String FlorDeCaña="Flor_de_Caña"; String Bacardi="Bacardi"; String Cartavio="Cartavio"; String Medellin="Medellin"; String Malibu="Malibu"; String Columbus="Columbus"; String Stroh="Stroh"; String Toucano="Toucano";    //Ron
        String Hennessy="Hennessy"; String HoneyBee="Honey_Bee"; String Martell="Martell"; String Courvoisier="Courvoisier";                                                                                                                                        //Brandi
        String Tanqueray="Tanqueray"; String Beefeater="Beefeater"; String BombaySapphire="Bombay_Sapphire"; String Broker="Broker";                                                                                                                                //Ginebra
        String Heineken="Heineken"; String Guinness="Guinness"; String Budweiser="Budweiser"; String MillerLite="Miller_Lite"; String CoorsLight="Coors_Light"; String SamAdams="Sam_Adams"; String Yuengling="Yuengling";                                          //Cervezas
        String Cocchi="Cocchi"; String Vya="Vya"; String NoillyPrat="Noilly_Prat"; String Dolin="Dolin";                                                                                                                                                            //Vermouth
        String JamesBarryVineyard="James_Berry_Vineyard"; String ShirazBarossa="Shiraz_Barossa"; String Douro="Douro"; String CabernetSauvignon="Cabernet_Sauvignon"; String ViñaQueirolo="Viña_Queirolo"; String GranCruz="Gran_Cruz"; String TacamaVino="Tacama"; //Vino
        String Belvedere="Belvedere"; String Eristoff="Eristoff"; String Russkaya="Russkaya"; String Smirnoff="Smirnoff"; String Absolut="Absolut"; String Skyy="SKYY";                                                                                             //Vodka
        String OfficerChoice="Officer_Choice"; String RoyalStag="Royal_Stag"; String ImperialBlue="Imperial_Blue"; String JimBeam="Jim_Beam"; String Bagpiper="Bagpiper";                                                                                           //Whisky
        
    //******************************************************************************************************************************************************************************************************************************************************************************    
        
    /*Aqui empieza el condicional para cada diapositiva, para ello se remueve cada imagen para poder pasar la siguiente*/    
    /*SWITCH CASE DEL TIPO DE LICOR COMO OBJETO. DE AHI COMENZARE TODO*/
    
        String mensaje = listaLicores.getSelectedValue().toString();
        switch(mensaje){
            
            case "Tequila":{
                           if( this.jcMarcas.getSelectedIndex()==0) marcasAsigna="El_blanco_Jose_Cuervo";
                           if( this.jcMarcas.getSelectedIndex()==1) marcasAsigna="Tequila_Don_Anastacio";
                           if( this.jcMarcas.getSelectedIndex()==2) marcasAsigna="Tequila_Estirpe";
                           if( this.jcMarcas.getSelectedIndex()==3) marcasAsigna="Tequila_1800_Añejo"; 
                            
                           if(marcasAsigna.equals(BlancoJose)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/11BlancoJoseCuervo.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           } 
                           if(marcasAsigna.equals(DonAnastacio)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/12DonAnastacio.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(TequilaEstirpe)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/13blancoEstirpe.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Tequila1800)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/14Tequila1800.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                        } ;  break;
                        
            case "Pisco":{
                           if( this.jcMarcas.getSelectedIndex()==0) marcasAsigna="Pisco_Ocucaje";
                           if( this.jcMarcas.getSelectedIndex()==1) marcasAsigna="Tacama_Premium";
                           if( this.jcMarcas.getSelectedIndex()==2) marcasAsigna="Biondi";
                           if( this.jcMarcas.getSelectedIndex()==3) marcasAsigna="Don_Teofilo";
                           if( this.jcMarcas.getSelectedIndex()==4) marcasAsigna="Bou_Barroeta";
                
                           if(marcasAsigna.equals(PiscoOcucaje)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/15PiscoOcucaje.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           } 
                           if(marcasAsigna.equals(PiscoTacamaPremium)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/16PiscoTacamaPremium.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Biondi)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/17Biondi.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(DonTeofilo)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/18DonTeofilo.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(BouBarroeta)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/19BouBarroeta.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                        } ;  break;
                        
            case "Ron":{
                            if( this.jcMarcas.getSelectedIndex()==0) marcasAsigna="Havana_Club";
                            if( this.jcMarcas.getSelectedIndex()==1) marcasAsigna="Flor_de_Caña";
                            if( this.jcMarcas.getSelectedIndex()==2) marcasAsigna="Bacardi";
                            if( this.jcMarcas.getSelectedIndex()==3) marcasAsigna="Cartavio";
                            if( this.jcMarcas.getSelectedIndex()==4) marcasAsigna="Medellin";
                            if( this.jcMarcas.getSelectedIndex()==5) marcasAsigna="Malibu";
                            if( this.jcMarcas.getSelectedIndex()==6) marcasAsigna="Columbus";
                            if( this.jcMarcas.getSelectedIndex()==7) marcasAsigna="Stroh";
                            if( this.jcMarcas.getSelectedIndex()==8) marcasAsigna="Toucano";
                            
                           if(marcasAsigna.equals(HavanaClub)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/20HavanaClub.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           } 
                          //+++
                           if(marcasAsigna.equals(FlorDeCaña)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/21FlordeCaña.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Bacardi)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/22Bacardi.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Cartavio)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/23Cartavio.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Medellin)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/24Medellin.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Malibu)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/25Malibu.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Columbus)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/26Columbus.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Stroh)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/27Stroh.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Toucano)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/28Toucano.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                        } ;  break;
                        
            case "Brandi":{
                           if( this.jcMarcas.getSelectedIndex()==0) marcasAsigna="Hennessy";
                           if( this.jcMarcas.getSelectedIndex()==1) marcasAsigna="Honey_Bee";
                           if( this.jcMarcas.getSelectedIndex()==2) marcasAsigna="Martell";
                           if( this.jcMarcas.getSelectedIndex()==3) marcasAsigna="Courvoisier";
                            
                           if(marcasAsigna.equals(Hennessy)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/29Hennessy.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           } 
                          //+++
                           if(marcasAsigna.equals(HoneyBee)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/30HoneyBee.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Martell)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/31Martell.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Courvoisier)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/32Courvoisier.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                        } ;  break;       
                        
            case "Ginebra":{
                           if( this.jcMarcas.getSelectedIndex()==0) marcasAsigna="Tanqueray";
                           if( this.jcMarcas.getSelectedIndex()==1) marcasAsigna="Beefeater";
                           if( this.jcMarcas.getSelectedIndex()==2) marcasAsigna="Bombay_Sapphire";
                           if( this.jcMarcas.getSelectedIndex()==3) marcasAsigna="Broker";
                
                           if(marcasAsigna.equals(Tanqueray)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/33Tanqueray.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           } 
                          //+++
                           if(marcasAsigna.equals(Beefeater)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/34Beefeater.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(BombaySapphire)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/35BombaySapphire.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Broker)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/36Broker.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                        } ;  break;  
                        
            case "Cerveza":{
                           if( this.jcMarcas.getSelectedIndex()==0) marcasAsigna="Heineken";
                           if( this.jcMarcas.getSelectedIndex()==1) marcasAsigna="Guinness";
                           if( this.jcMarcas.getSelectedIndex()==2) marcasAsigna="Budweiser";
                           if( this.jcMarcas.getSelectedIndex()==3) marcasAsigna="Miller_Lite";
                           if( this.jcMarcas.getSelectedIndex()==4) marcasAsigna="Coors_Light";
                           if( this.jcMarcas.getSelectedIndex()==5) marcasAsigna="Sam_Adams";
                           if( this.jcMarcas.getSelectedIndex()==6) marcasAsigna="Yuengling";
                
                           if(marcasAsigna.equals(Heineken)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/37Heineken.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           } 
                          //+++
                           if(marcasAsigna.equals(Guinness)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/38Guinness.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Budweiser)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/39Budweiser.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(MillerLite)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/40MillerLite.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(CoorsLight)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/41CoorsLight.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(SamAdams)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/42SamAdams.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Yuengling)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/43Yuengling.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                        } ;  break;     
                        
            case "Vermouth":{
                           if( this.jcMarcas.getSelectedIndex()==0) marcasAsigna="Cocchi";
                           if( this.jcMarcas.getSelectedIndex()==1) marcasAsigna="Vya";
                           if( this.jcMarcas.getSelectedIndex()==2) marcasAsigna="Noilly_Prat";
                           if( this.jcMarcas.getSelectedIndex()==3) marcasAsigna="Dolin";
                            
                           if(marcasAsigna.equals(Cocchi)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/44Cocchi.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           } 
                          //+++
                           if(marcasAsigna.equals(Vya)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/45Vya.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(NoillyPrat)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/46NoillyPrat.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Dolin)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/47Dolin.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                        } ;  break;   
                        
            case "Vino":{
                           if( this.jcMarcas.getSelectedIndex()==0) marcasAsigna="James_Berry_Vineyard";
                           if( this.jcMarcas.getSelectedIndex()==1) marcasAsigna="Shiraz_Barossa";
                           if( this.jcMarcas.getSelectedIndex()==2) marcasAsigna="Douro";
                           if( this.jcMarcas.getSelectedIndex()==3) marcasAsigna="Cabernet_Sauvignon";
                           if( this.jcMarcas.getSelectedIndex()==4) marcasAsigna="Viña_Queirolo";
                           if( this.jcMarcas.getSelectedIndex()==5) marcasAsigna="Gran_Cruz";
                           if( this.jcMarcas.getSelectedIndex()==6) marcasAsigna="Tacama";
                
                           if(marcasAsigna.equals(JamesBarryVineyard)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/48JamesBerryVineyard.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           } 
                          //+++
                           if(marcasAsigna.equals(ShirazBarossa)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/49ShirazBarossa.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Douro)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/50Douro.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(CabernetSauvignon)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/51CabernetSauvignon.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(ViñaQueirolo)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/52ViñaQueirolo.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(GranCruz)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/53GranCruz.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(TacamaVino)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/54Tacama.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                        } ;  break; 
                        
            case "Vodka":{
                           if( this.jcMarcas.getSelectedIndex()==0) marcasAsigna="Belvedere";
                           if( this.jcMarcas.getSelectedIndex()==1) marcasAsigna="Eristoff";
                           if( this.jcMarcas.getSelectedIndex()==2) marcasAsigna="Russkaya";
                           if( this.jcMarcas.getSelectedIndex()==3) marcasAsigna="Smirnoff";
                           if( this.jcMarcas.getSelectedIndex()==4) marcasAsigna="Absolut";
                           if( this.jcMarcas.getSelectedIndex()==5) marcasAsigna="SKYY";
        
                           if(marcasAsigna.equals(Belvedere)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/55Belvedere.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           } 
                          //+++
                           if(marcasAsigna.equals(Eristoff)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/56Eristoff.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Russkaya)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/57Russkaya.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Smirnoff)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/58Smirnoff.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Absolut)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/59Absolut.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Skyy)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/60Skyy.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                        } ;  break;    
                        
            case "Whisky":{
                           if( this.jcMarcas.getSelectedIndex()==0) marcasAsigna="Officer_Choice";
                           if( this.jcMarcas.getSelectedIndex()==1) marcasAsigna="Royal_Stag";
                           if( this.jcMarcas.getSelectedIndex()==2) marcasAsigna="Imperial_Blue";
                           if( this.jcMarcas.getSelectedIndex()==3) marcasAsigna="Jim_Beam";
                           if( this.jcMarcas.getSelectedIndex()==4) marcasAsigna="Bagpiper";
        
                           if(marcasAsigna.equals(OfficerChoice)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/61OfficerChoice.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           } 
                          //+++
                           if(marcasAsigna.equals(RoyalStag)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/62RoyalStag.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(ImperialBlue)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/63ImperialBlue.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(JimBeam)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/64JimBeam.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                           if(marcasAsigna.equals(Bagpiper)){
                           diapo.lblMostrar.removeAll();
                           kappa = new ImageIcon(getClass().getResource("/diapositivas/65Bagpiper.png"));
                           diapo.lblMostrar.setIcon(kappa);
                           }
                        } ;  break;            
                 }
    }
    
    Monitor diapo = new Monitor();
    File f = new File("D:/BD_RegistroPedido.txt");
    FileWriter fw;
    Formatter fo;

    String numTarjetaCredito = "TARJETA_CREDITO";
    String numFactura = "FACTURA";
    String boleta = "BOLETA";
    String efectivo = "EFECTIVO";

    private void btnACEPTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnACEPTARActionPerformed

        String mensaje;
        
        int valor = JOptionPane.showConfirmDialog(null, "Una vez dada la compra, se deshabilitara toda la ventana; por\n"
                + "lo que tendra que abrir nuevamente el Registro de Pedidos desde el Menú.\n"
                + "¿Esta seguro(a) de continuar?", "ADVERTENCIA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (valor == JOptionPane.YES_NO_OPTION) {
            
            fo.close();
            listaLicores.setEnabled(false);
            jcMarcas.setEnabled(false);
            jsCantidad.setEnabled(false);
            jrEfectivo.setEnabled(false);
            jrTarjetaCredito.setEnabled(false);
            jrBoleta.setEnabled(false);                 //INSTRUCCIONES
            jrFactura.setEnabled(false);
            txtTC1.setEnabled(false);
            txtTC2.setEnabled(false);
            txtTC3.setEnabled(false);
            txtTC4.setEnabled(false);
            txtRUC.setEnabled(false);
            
            try{
                
            }catch(Exception ex){
                
            }
            
            try{
                
            }catch(Exception e){
                
            }
            
            
            
            
            
            
            
            
            
            
            
            
            
        } else btnGuardar.setEnabled(true); btnACEPTAR.setEnabled(false);
        
        
        
//        int a(valor==JOptionPane.YES_NO_OPTION) ? app.setVisible(true) : JOptionPane.showMessageDialog(this, "ups");
    }//GEN-LAST:event_btnACEPTARActionPerformed

    private void jrTarjetaCreditoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrTarjetaCreditoMouseClicked
        txtTC1.setEnabled(true);
        txtTC2.setEnabled(true);
        txtTC3.setEnabled(true);
        txtTC4.setEnabled(true);
    }//GEN-LAST:event_jrTarjetaCreditoMouseClicked

    private void jrEfectivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrEfectivoMouseClicked
        txtTC1.setEnabled(false);
        txtTC2.setEnabled(false);
        txtTC3.setEnabled(false);
        txtTC4.setEnabled(false);
    }//GEN-LAST:event_jrEfectivoMouseClicked

    private void jrBoletaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrBoletaMouseClicked
        txtRUC.setEnabled(false);
    }//GEN-LAST:event_jrBoletaMouseClicked

    private void jrFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrFacturaMouseClicked
        txtRUC.setEnabled(true);
    }//GEN-LAST:event_jrFacturaMouseClicked

    private void jrEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrEfectivoActionPerformed
    }//GEN-LAST:event_jrEfectivoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try{    
            
            if(listaLicores.isSelectionEmpty()){
                throw new Exception("Escoja que tipo de licor desea.");
            }
            if("0".equals(jsCantidad.getValue().toString())){
                throw new Exception("Elija la cantidad que desea comprar.");
            }
            
            
            
            if(!jrEfectivo.isSelected() || jrTarjetaCredito.isSelected()){
                throw new Exception("oe si");
            }
            
            if(jrEfectivo.isSelected() || !jrTarjetaCredito.isSelected()){
                throw new Exception("oe si");
            }            
            
            
        //*****************************************************************************************************************************************************************
            
            int valor = JOptionPane.showConfirmDialog(null, "Al guardar, no podras retroceder ni cambiar los datos que ya tomaste.\n¿Estas seguro guardar este pedido?",
                "REGISTRO DEL PEDIDO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (valor == JOptionPane.YES_NO_OPTION) {
            
            fo.format("\r\n%s %s %d \n", listaLicores.getSelectedValue().toString(), jcMarcas.getSelectedItem().toString(),
                Integer.parseInt(jsCantidad.getValue().toString()));

        if (jrTarjetaCredito.isSelected()) {
            fo.format("%s %d %d %d %d \n", numTarjetaCredito, Integer.parseInt(txtTC1.getText()), Integer.parseInt(txtTC2.getText()),
                    Integer.parseInt(txtTC3.getText()), Integer.parseInt(txtTC4.getText()));
            
        } else if (jrEfectivo.isSelected()) {
            fo.format("%s \n", efectivo);
        }
        
        if (jrFactura.isSelected()) {
            fo.format("%s %d \n", numFactura, Integer.parseInt(txtRUC.getText()));
            
        } else if (jrBoleta.isSelected()) {
            fo.format("%s \n", boleta);
        }
            btnACEPTAR.setEnabled(true);
            btnGuardar.setEnabled(false);
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR - CATALOGO/PEDIDO",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jcMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcMarcasActionPerformed

        this.condicional();
        
    }//GEN-LAST:event_jcMarcasActionPerformed

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
            java.util.logging.Logger.getLogger(Cat_Ped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cat_Ped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cat_Ped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cat_Ped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cat_Ped().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnACEPTAR;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JComboBox jcMarcas;
    private javax.swing.JRadioButton jrBoleta;
    private javax.swing.JRadioButton jrEfectivo;
    private javax.swing.JRadioButton jrFactura;
    private javax.swing.JRadioButton jrTarjetaCredito;
    public static javax.swing.JSpinner jsCantidad;
    private javax.swing.JList listaLicores;
    private javax.swing.JTextField txtRUC;
    private javax.swing.JTextField txtTC1;
    private javax.swing.JTextField txtTC2;
    private javax.swing.JTextField txtTC3;
    private javax.swing.JTextField txtTC4;
    // End of variables declaration//GEN-END:variables
}
