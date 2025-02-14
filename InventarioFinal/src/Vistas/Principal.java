/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import EDA.HashTable1;
import EDA.Iterator;
import Listas.Articulo;
import Listas.Categoria;
import EDA.ListaSecuencial;
import EDA.NodoN;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhairo-PC
 */
public class Principal extends javax.swing.JFrame {
    
    private HashTable1 categorias;
    private HashTable1 articulos;
    private ListaSecuencial historial;
    private NodoN inventario;
    private NodoN Invent;
    private DefaultListModel model;
    private DefaultListModel modelH;
    /**
     * Creates new form Inventario
     */
    public Principal() {
        initComponents();
        
        categorias = new HashTable1();
        articulos = new HashTable1();
        historial = new ListaSecuencial();
        inventario = new NodoN("Inventario");
        model = new DefaultListModel();
        CategoriasNivel.setModel(model);
        modelH = new DefaultListModel();
        
        categorias.put("Chasis y Suspensión", new Categoria(1, "Chasis y Suspensión", "Bienvenido a la casa de una gran maniobrabilidad y calidad de marcha."));
        categorias.put("Sistema de Frenos", new Categoria(2, "Sistema de Frenos", "Debido a parar es tan importante como ir rápido, Summit Racing es su autoridad freno de rendimiento."));
        categorias.put("Motores y Componentes", new Categoria(3, "Motores y Componentes", "Bienvenido a su sede para caballos de fuerza-el lugar para conseguir todo lo necesario para construir el poder real y el rendimiento."));
        categorias.put("Luces e Iluminación", new Categoria(4, "Luces e Iluminación", "Las luces de automóviles y piezas de iluminación y accesorios le dan la clara visión necesaria para conseguir el trabajo hecho a la derecha."));
        categorias.put("Ruedas y neumáticos", new Categoria(5, "Ruedas y neumáticos", "Se llevan su vehículo de ordinario a la costumbre en cuestión de minutos. Neumáticos hacen el viaje."));
        categorias.put("Refrigeración y calefacción", new Categoria(6, "Refrigeración y calefacción", "El poder que priva de calor aumenta de mantenimiento de la fresca es la clave para obtener el máximo rendimiento"));
        categorias.put("Manómetros y accesorios", new Categoria(7, "Manómetros y accesorios", "Analógico o digital, mecánico o eléctrico, tenemos todas y cada una de calibre del mercado de accesorios del automóvil se puede imaginar en una amplia variedad de estilos y tamaños."));
        
        
        articulos.put("Resortes", new Articulo(1, "Resortes", "0"));
        articulos.put("Amortiguadores", new Articulo(2, "Amortiguadores", "1"));
        articulos.put("Rótulas", new Articulo(3, "Rótulas", "2"));
        articulos.put("Armas de Control", new Articulo(4, "Armas de Control", "3"));
        articulos.put("Brazo oscilante", new Articulo(5, "Brazo oscilante", "4"));
        articulos.put("Bolsa de aire", new Articulo(6, "Bolsa de aire", "5"));
        articulos.put("Abrazaderas", new Articulo(7, "Abrazaderas", "6"));
        articulos.put("Compresor", new Articulo(8, "Compresor", "7"));
        articulos.put("Compresores de aire", new Articulo(9, "Compresores de aire", "8"));
        articulos.put("Resorte de aire", new Articulo(10, "Resorte de aire", "9"));
        articulos.put("Soporte de transmisión", new Articulo(11, "Soporte de transmisión", "10"));
        articulos.put("Vainas de eje", new Articulo(12, "Vainas de eje", "11"));
        articulos.put("Edelbrock Performer Carburadores", new Articulo(13, "Edelbrock Performer Carburadores", "12"));
        articulos.put("Kits Fitech Ir combustible", new Articulo(14, "Kits Fitech Ir combustible", "13"));
        articulos.put("Fitech Ir EFI 4600 Sistemas de inyección HP", new Articulo(15, "Fitech Ir EFI 4600 Sistemas de inyección HP", "14"));
        articulos.put("Bombas Holley Azul de combustible Eléctrico", new Articulo(16, "Bombas Holley Azul de combustible Eléctrico", "15"));
        articulos.put("Edelbrock Performer Carburadores", new Articulo(17, "Edelbrock Performer Carburadores", "16"));
        articulos.put("Válvulas dosificadoras PV-2", new Articulo(18, "Válvulas dosificadoras PV-2", "17"));
        articulos.put("Wilwood freno de dosificación", new Articulo(19, "Wilwood freno de dosificación", "18"));
        articulos.put("Hurst rollo de control Kits", new Articulo(20, "Hurst rollo de control Kits", "19"));
        articulos.put("Bombas eléctricas de SUMA-760152", new Articulo(21, "Bombas eléctricas de SUMA-760152", "20"));
        articulos.put("Biondo Line Locks LL", new Articulo(22, "Biondo Line Locks LL", "21"));
        articulos.put("Bilstein B8 5100 Series Choques 24-186735", new Articulo(23, "Bilstein B8 5100 Series Choques 24-186735", "22"));
        articulos.put("Saginaw potencia Bombas SUM-340103", new Articulo(24, "Saginaw potencia Bombas SUM-340103", "23"));
        articulos.put("QA1 con muelle de choque Kits de cojinete", new Articulo(25, "QA1 con muelle de choque Kits de cojinete", "24"));
        articulos.put("Mustang Choques S6001EM", new Articulo(26, "Mustang Choques S6001EM", "25"));
        articulos.put("Bilstein B7 5200 Series 24-186940", new Articulo(27, "Bilstein B7 5200 Series 24-186940", "26"));
        articulos.put("Flex-a-lite Syclone S-Blades Ventiladores", new Articulo(28, "Flex-a-lite Syclone S-Blades Ventiladores", "27"));
        articulos.put("B & M enfriadores de aceite subenfriador 70266", new Articulo(29, "B & M enfriadores de aceite subenfriador 70266", "28"));
        articulos.put("Dakota Digital doble de ventilación", new Articulo(30, "Dakota Digital doble de ventilación", "29"));
        articulos.put("Desbordamiento de tanques SUM-300103", new Articulo(31, "Desbordamiento de tanques SUM-300103", "30"));
        articulos.put("Fit radiadores de aluminio SUM-380331", new Articulo(32, "Fit radiadores de aluminio SUM-380331", "31"));
        articulos.put("Elevadores hidráulicos SUM-HT817", new Articulo(33, "Elevadores hidráulicos SUM-HT817", "32"));
        articulos.put("ARP Alto Rendimiento Serie Tornillos", new Articulo(34, "ARP Alto Rendimiento Serie Tornillos", "33"));
        articulos.put("Chevrolet Rendimiento Musclecar Cárter", new Articulo(35, "Chevrolet Rendimiento Musclecar Cárter", "34"));
        articulos.put("Chevrolet Rendimiento 350 CID Base Asambleas", new Articulo(36, "Chevrolet Rendimiento 350 CID Base Asambleas", "35"));
        articulos.put("Aceite Rendimiento Melling Bombas 10296", new Articulo(37, "Aceite Rendimiento Melling Bombas 10296", "36"));
        articulos.put("Piezas claves del acero Campanas 0852-035", new Articulo(38, "Piezas claves del acero Campanas 0852-035", "37"));
        articulos.put("Cubre Cumbre Racing® de 4 capas", new Articulo(39, "Cubre Cumbre Racing® de 4 capas", "38"));
        articulos.put("Piezas claves del acero Campanas 0852-038", new Articulo(40, "Piezas claves del acero Campanas 0852-038", "39"));
        articulos.put("Detroit velocidad mini-tinas 040401", new Articulo(41, "Detroit velocidad mini-tinas 040401", "40"));
        articulos.put("iezas claves del acero Campanas 0851-035", new Articulo(42, "iezas claves del acero Campanas 0851-035", "41"));
        articulos.put("Racing® del nivel de combustible SUM-800115", new Articulo(43, "Racing® del nivel de combustible SUM-800115", "42"));
        articulos.put("Medidores de presión de combustible", new Articulo(44, "Medidores de presión de combustible", "43"));
        articulos.put("Dorman OEM remanufacturados Instrumentos", new Articulo(45, "Dorman OEM remanufacturados Instrumentos", "44"));
        articulos.put("Presión Cumbre Racing® al nivel de combustible", new Articulo(46, "Presión Cumbre Racing® al nivel de combustible", "45"));
        articulos.put("AutoMeter Gauge montaje Copas 2204", new Articulo(47, "AutoMeter Gauge montaje Copas 2204", "46"));
        articulos.put("Hella Vision Plus Conversión Faros 002395301", new Articulo(48, "Hella Vision Plus Conversión Faros 002395301", "47"));
        articulos.put("LED faros de trabajo SUM-902011", new Articulo(49, "LED faros de trabajo SUM-902011", "48"));
        articulos.put("Hella Headlight Assemblies 002395801", new Articulo(50, "Hella Headlight Assemblies 002395801", "49"));
        
//        inventario.setHijo(new NodoN(categorias.get("Sistema de Frenos")));
//        inventario.getHijo().setHermano(new NodoN(articulos.get("Resortes")));
//        inventario.getHijo().getHermano().setHermano(new NodoN(categorias.get("Motores y Componentes")));
        
        //Al comboBox se le agrega el texto del campo de texto
        Iterator itC = categorias.keyIterator();
        for (int i = 0; i < categorias.size(); i++) {
            cCategoria.addItem(itC.next());
        }
        
        Iterator itA = articulos.valueIterator();
        for (int i = 0; i < articulos.size(); i++) {
            cArticulo.addItem(itA.next());
        }
        
        //Mostrar historial
        mostrarN(inventario);
        CategoriasNivel.updateUI();
        Invent = inventario;
        mostrarHoja();
        historial.add(historial.length(), Invent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CategoriasNivel = new javax.swing.JList<>();
        RaizAnterior = new javax.swing.JButton();
        RaizPrincipal = new javax.swing.JButton();
        Trayectoria = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Descripcion = new javax.swing.JTextArea();
        bEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        PanelHojas = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cArticulo = new javax.swing.JComboBox();
        cCategoria = new javax.swing.JComboBox();
        rArticulo = new javax.swing.JRadioButton();
        rCatalogo = new javax.swing.JRadioButton();
        btnAgregar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        tNombre = new javax.swing.JTextField();
        bAddArt = new javax.swing.JButton();
        tDesc = new javax.swing.JTextField();
        bAddCat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CategoriasNivel.setBorder(javax.swing.BorderFactory.createTitledBorder("Categorías del nivel actual"));
        CategoriasNivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoriasNivelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CategoriasNivel);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 168, 300, 240));

        RaizAnterior.setText("Raiz anterior");
        RaizAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RaizAnteriorActionPerformed(evt);
            }
        });
        jPanel2.add(RaizAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 68, 115, 40));

        RaizPrincipal.setText("Raiz principal");
        RaizPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RaizPrincipalActionPerformed(evt);
            }
        });
        jPanel2.add(RaizPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 121, 115, 40));

        Trayectoria.setBackground(new java.awt.Color(102, 102, 255));
        Trayectoria.setBorder(javax.swing.BorderFactory.createTitledBorder("Trayecetoria"));
        jPanel2.add(Trayectoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 15, 300, 40));

        Descripcion.setColumns(20);
        Descripcion.setRows(5);
        Descripcion.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción de raíz actual"));
        jScrollPane3.setViewportView(Descripcion);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 300, 130));

        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(bEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 300, -1));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 149, 330, 610));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción de hojas del nivel actual"));

        PanelHojas.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane4.setViewportView(PanelHojas);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 15, 290, 270));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 149, 320, 300));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Poblar Arbol"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cArticulo.setEnabled(false);
        jPanel1.add(cArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 115, -1));

        jPanel1.add(cCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 61, 115, -1));

        buttonGroup1.add(rArticulo);
        rArticulo.setText("Artículo");
        rArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rArticuloActionPerformed(evt);
            }
        });
        jPanel1.add(rArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 115, -1));

        buttonGroup1.add(rCatalogo);
        rCatalogo.setSelected(true);
        rCatalogo.setText("Categoría");
        rCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCatalogoActionPerformed(evt);
            }
        });
        jPanel1.add(rCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 27, 115, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 242, -1));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 610, 310, 130));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Insertar nuevas categorias y productos"));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tNombre.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre"));
        jPanel6.add(tNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 31, 130, -1));

        bAddArt.setText("+Artículo");
        bAddArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddArtActionPerformed(evt);
            }
        });
        jPanel6.add(bAddArt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 115, -1));

        tDesc.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción"));
        tDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tDescActionPerformed(evt);
            }
        });
        jPanel6.add(tDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 31, 131, -1));

        bAddCat.setText("+Categoría");
        bAddCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddCatActionPerformed(evt);
            }
        });
        jPanel6.add(bAddCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 115, -1));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 460, 310, 140));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/summit_0.gif"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 0, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 685, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rArticuloActionPerformed
        // TODO add your handling code here:
        cCategoria.setEnabled(false);
        cArticulo.setEnabled(true);
    }//GEN-LAST:event_rArticuloActionPerformed

    private void rCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rCatalogoActionPerformed
        // TODO add your handling code here:
        cCategoria.setEnabled(true);
        cArticulo.setEnabled(false);
    }//GEN-LAST:event_rCatalogoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        agregarNodo(cCategoria.isEnabled(), Invent);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        // TODO add your handling code here:
        if (!CategoriasNivel.isSelectionEmpty()) {
            eliminarNodo(Invent, model.getElementAt(CategoriasNivel.getSelectedIndex()).toString().trim());
        }
        else {
              JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un elemento","ADVERTENCIA", JOptionPane.PLAIN_MESSAGE); 
        }
    }//GEN-LAST:event_bEliminarActionPerformed

    private void RaizPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RaizPrincipalActionPerformed
        // TODO add your handling code here:
        String mensaje = "";
        Invent = (NodoN) historial.get(0);
        historial.clear();
        historial.add(0, Invent);
        for (int i = 0; i < historial.length(); i++) {
            mensaje += historial.get(i)+"/";
        }
        model.removeAllElements();
        mostrarN(Invent);
        mostrarHoja();
        CategoriasNivel.updateUI();
        Trayectoria.setText(mensaje);
        Descripcion.setText("");
    }//GEN-LAST:event_RaizPrincipalActionPerformed

    private void RaizAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RaizAnteriorActionPerformed
        // TODO add your handling code here:
        String mensaje = "";
        if (historial.length() > 1) {
            historial.remove(historial.length()-1);
            for (int i = 0; i < historial.length(); i++) {
                mensaje += historial.get(i)+"/";
            }
            Invent = (NodoN) historial.get(historial.length()-1);            
        }
        model.removeAllElements();
        mostrarN(Invent);
        mostrarHoja();
        CategoriasNivel.updateUI();
        Trayectoria.setText(mensaje);
    }//GEN-LAST:event_RaizAnteriorActionPerformed

    private void CategoriasNivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoriasNivelMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int index = CategoriasNivel.locationToIndex(evt.getPoint());
            if (index>=0) {
                System.out.println(index);
                Invent = getNodo(Invent, model.getElementAt(CategoriasNivel.getSelectedIndex()).toString().trim());
                if (Invent.getElemento() instanceof Categoria) {
                    historial.add(historial.length(), Invent);
                    model.removeAllElements();
                    mostrarN(Invent);
                    mostrarHoja();
                    CategoriasNivel.updateUI();
                    actualizarHistorial();
                    Categoria temp = (Categoria) Invent.getElemento();
                    Descripcion.setText(temp.getDescripcion());
                }
            }
        }
    }//GEN-LAST:event_CategoriasNivelMouseClicked

    private void bAddArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddArtActionPerformed
        // TODO add your handling code here:
        
        String Desc=tDesc.getText();
        String Nomb=tNombre.getText();
        try {
           if (Nomb.equals("") ) {
                throw new Exception("No debe dejar en blanco el nombre");
            }
           if (Desc.equals("") ) {
                throw new Exception("No debe dejar en blanco la descripción");
            }
           else {
                Articulo temp = new Articulo(articulos.size()+1, tNombre.getText(), tDesc.getText());
                articulos.put(temp.getNombre(), temp);
                cArticulo.addItem(temp.getNombre());
                cArticulo.updateUI();
                tNombre.setText("");
                tDesc.setText("");     
                System.out.println(""+temp.getId());
                }
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "ADVERTENCIA", JOptionPane.PLAIN_MESSAGE);
        }
        
    }//GEN-LAST:event_bAddArtActionPerformed

    private void bAddCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddCatActionPerformed
        // TODO add your handling code here:

        String Desc=tDesc.getText();
        String Nomb=tNombre.getText();
        try {
           if (Nomb.equals("") ) {
                throw new Exception("No debe dejar en blanco el nombre");
            }
           if (Desc.equals("") ) {
                throw new Exception("No debe dejar en blanco la descripción");
            }
           else {
                Categoria temp = new Categoria(categorias.size()+1, tNombre.getText(), tDesc.getText());
                categorias.put(temp.getNombre(), temp);
                cCategoria.addItem(tNombre.getText());
                cCategoria.updateUI();
                tNombre.setText("");
                tDesc.setText("");
                }
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "ADVERTENCIA", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_bAddCatActionPerformed

    private void tDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tDescActionPerformed


    }//GEN-LAST:event_tDescActionPerformed

    public void actualizarHistorial(){
        String mensaje = "";
        for (int i = 0; i < historial.length(); i++) {
            mensaje += historial.get(i)+"/";
        }
        Trayectoria.setText(mensaje);
    }
    
    public void agregarNodo(boolean enable, NodoN actual){
        NodoN raiz = (NodoN) historial.get(0);
        if(enable) {
            if(!existeNodo(raiz.getHijo(), cCategoria.getSelectedItem().toString())) {
                Categoria temp = null;
                Iterator it = categorias.valueIterator();
                for (int i = 0; i < categorias.size(); i++) {
                    temp = (Categoria) it.next();
                    if (temp.getNombre().equals(cCategoria.getSelectedItem().toString())) {
                        break;
                    }
                }
                if (actual.getHijo() == null) {
                    actual.setHijo(new NodoN(temp));
                }
                else {
                    agregarHermano(actual.getHijo().getHermano(), actual.getHijo(), temp);
                }
                model.removeAllElements();
                mostrarN(actual);
                CategoriasNivel.updateUI();
            }
            else {
              JOptionPane.showMessageDialog(this, "Ya existe la categoría escogida.","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            if (!existeNodo(raiz.getHijo(), cArticulo.getSelectedItem().toString())){
                Articulo temp = null;
                Iterator itA = articulos.valueIterator();
                for (int i = 0; i < articulos.size(); i++) {
                    temp = (Articulo) itA.next();
                    if (temp.getNombre().equals(cArticulo.getSelectedItem().toString())) {
                        break;
                    }
                }
                if (actual.getHijo() == null){
                    actual.setHijo(new NodoN(temp));               
                }
                else {
                    agregarHermano(actual.getHijo().getHermano(), actual.getHijo(), temp);
                }
                PanelHojas.add(new PanelArtículo(temp.getNombre(), temp.getDescripcion(), this));
                PanelHojas.updateUI();
            }
            else {
                JOptionPane.showMessageDialog(this, "Ya existe el artículo escogido.","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void eliminarNodo(NodoN nodo, String nombre) {
        if (nodo.getHijo() == null) {
            JOptionPane.showMessageDialog(rootPane, "No existen elementos que pueda eliminar.","ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (nodo.getHijo().getElemento() instanceof Categoria) {
            Categoria temp = (Categoria) nodo.getHijo().getElemento();
            if (temp.getNombre().equals(nombre)) {
                if (nodo.getHijo().getHijo() == null) {
                    nodo.setHijo(nodo.getHijo().getHermano());                    
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "No se puede eliminar una categoría padre","ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                eliminarNodoAux(nodo.getHijo(), nombre);
            }
            model.removeAllElements();
            mostrarN(nodo);
            CategoriasNivel.updateUI();
        }
        else {
            eliminarNodoAux(nodo.getHijo(), nombre);
        }
    }
    
    public void eliminarNodoAux(NodoN nodo, String nombre) {
        if (nodo == null) {
            return;
        }
        if (nodo.getHermano().getElemento() instanceof Categoria) {
            Categoria temp = (Categoria) nodo.getHermano().getElemento();
            if (temp.getNombre().equals(nombre)) {
                if (nodo.getHermano().getHijo() == null) {
                    nodo.setHermano(nodo.getHermano().getHermano());
                    return;                    
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "Elimine los hijos de esta categoria y luego intente de nuevo.");
                }
            }
            else {
                eliminarNodoAux(nodo.getHermano(), nombre);
            }
        }
        else {
            eliminarNodoAux(nodo.getHermano(), nombre);
        }
    }
    
    public void mostrarN(NodoN raiz) {
        if (raiz.getHijo() != null) {
            if (raiz.getHijo().getElemento() instanceof Categoria) {
                model.addElement(raiz.getHijo());            
            }
        }
        if (raiz.getHijo() != null) {
            mostrarNAux(raiz.getHijo().getHermano());            
        }
    }
    
    private void mostrarNAux(NodoN nodo) {
        if(nodo == null) {
            return;
        }
        if (nodo.getElemento() instanceof Categoria) {
            model.addElement(nodo);            
        }
        mostrarNAux(nodo.getHermano());
    }
    
    public void mostrarHoja() {
        PanelHojas.removeAll();
        PanelHojas.setLayout(new GridLayout(0, 1));
        if (Invent.getHijo() != null) {
            if (Invent.getHijo().getElemento() instanceof Articulo) {                
                Articulo temp = (Articulo) Invent.getHijo().getElemento();
                PanelHojas.add(new PanelArtículo(temp.getNombre(), temp.getDescripcion(), this));
            }
        }
        if (Invent.getHijo() != null) {
            mostrarHojaAux(Invent.getHijo().getHermano());            
        }
        PanelHojas.updateUI();
    }
    
    private void mostrarHojaAux(NodoN nodo) {
        if(nodo == null) {
            return;
        }
        if (nodo.getElemento() instanceof Articulo) {
            Articulo temp = (Articulo) nodo.getElemento();
            PanelHojas.add(new PanelArtículo(temp.getNombre(), temp.getDescripcion(), this));
        }
        mostrarHojaAux(nodo.getHermano());
    }
    
    public void eliminarHoja(String nombre) {
        if (Invent.getHijo() == null) {
            JOptionPane.showMessageDialog(this, "No existen elementos que pueda eliminar.");
            return;
        }
        if (Invent.getHijo().getElemento() instanceof Articulo) {
            Articulo temp = (Articulo) Invent.getHijo().getElemento();
            if (temp.getNombre().equals(nombre)) {
                Invent.setHijo(Invent.getHijo().getHermano());
                return;
            }
            else {
                eliminarHojaAux(Invent.getHijo(), nombre);
            }
        }
        else {
            eliminarHojaAux(Invent.getHijo(), nombre);
        }
    }
    
    private void eliminarHojaAux(NodoN nodo, String nombre) {
        if (nodo == null) {
            return;
        }
        if (nodo.getHermano().getElemento() instanceof Articulo) {
            Articulo temp = (Articulo) nodo.getHermano().getElemento();
            if (temp.getNombre().equals(nombre)) {
                nodo.setHermano(nodo.getHermano().getHermano());
                return;
            }
            else {
                eliminarHojaAux(nodo.getHermano(), nombre);                
            }
        }
        else {
            eliminarHojaAux(nodo.getHermano(), nombre);
        }
    }
    
    public void agregarHermano(NodoN nodo, NodoN anterior, Object nombre) {
        if(nodo == null) {
            anterior.setHermano(new NodoN(nombre));
            return;
        }
        agregarHermano(nodo.getHermano(), nodo, nombre);
    }
    
    public boolean existeHermano(NodoN nodo, String nombre, boolean existe) {
        if(nodo == null){
            return existe;
        }
        if (nodo.getElemento() instanceof Categoria) {
            Categoria temp = (Categoria) nodo.getElemento();
            if (temp.getNombre().equals(nombre)) {
                return true;
            }
            else {
                return existeHermano(nodo.getHermano(), nombre, existe);
            }
        }
        else {
            Articulo temp = (Articulo) nodo.getElemento();
            if (temp.getNombre().equals(nombre)) {
                return true;
            }
            else {
                return existeHermano(nodo.getHermano(), nombre, existe);
            }
        }
    }
    
    public NodoN getNodo(NodoN nodo, String nombre) {
        if (nodo.getHijo() == null) {
            return null;
        }
        if (nodo.getHijo().getElemento() instanceof Categoria) {
            Categoria temp = (Categoria) nodo.getHijo().getElemento();
            if (temp.getNombre().equals(nombre)) {
                return nodo.getHijo();                
            }
        }
        return getNodoAux(nodo.getHijo(), nombre);                
    }
    
    public NodoN getNodoAux(NodoN nodo, String nombre) {
        if (nodo == null) {
            return null;
        }
        if (nodo.getHermano().getElemento() instanceof Categoria) {
            Categoria temp = (Categoria) nodo.getHermano().getElemento();
            if (temp.getNombre().equals(nombre)) {
                return nodo.getHermano();                
            }
        }
        return getNodoAux(nodo.getHermano(), nombre);
    }

    public boolean existeNodo(NodoN nodo, String nombre) {
        return existeNodoAux(nodo, nombre, false);
    }

    private boolean existeNodoAux(NodoN nodo, String nombre, boolean existe) {
        if (nodo == null || existe == true) {
            return existe;
        }
        if (nodo.getElemento() instanceof Categoria) {
            Categoria temp = (Categoria) nodo.getElemento();
            if (temp.getNombre().equals(nombre)) {
                return true;
            }
            else {
                if (nodo.getHijo() != null) {
                    return existeNodoAux(nodo.getHijo(), nombre, existe);
                    
                }
                else
                    return existeNodoAux(nodo.getHermano(), nombre, existe);                
            }
        }
        else {
            Articulo temp = (Articulo) nodo.getElemento();
            if (temp.getNombre().equals(nombre)) {
                return true;
            }
            else {
                if (nodo.getHijo() != null) {
                    return existeNodoAux(nodo.getHijo(), nombre, existe);                    
                }
                else {
                    return existeNodoAux(nodo.getHermano(), nombre, existe);                                    
                }
            }
        }
    }
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> CategoriasNivel;
    private javax.swing.JTextArea Descripcion;
    private javax.swing.JPanel PanelHojas;
    private javax.swing.JButton RaizAnterior;
    private javax.swing.JButton RaizPrincipal;
    private javax.swing.JLabel Trayectoria;
    private javax.swing.JButton bAddArt;
    private javax.swing.JButton bAddCat;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cArticulo;
    private javax.swing.JComboBox cCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton rArticulo;
    private javax.swing.JRadioButton rCatalogo;
    private javax.swing.JTextField tDesc;
    private javax.swing.JTextField tNombre;
    // End of variables declaration//GEN-END:variables
}
