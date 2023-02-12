
package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author fedec
 */
public class Productos extends javax.swing.JFrame {

    /** Creates new form Productos */
    public Productos() {
        initComponents();
        LlenarCombo.conectar();
        mostrarProductos();
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.LEFT);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        jTextField1.requestFocus();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Productos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton2.setText("Limpiar campos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 255, 51));
        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTI�N DE PRODUCTOS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel2.setText("C�digo:");

        jTextField1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel3.setText("Descripci�n:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("-");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel5.setText("Precio: $");

        jLabel6.setFont(new java.awt.Font("Calibri", 3, 22)); // NOI18N
        jLabel6.setText("-");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel7.setText("Stock:");

        jLabel9.setText("Filtrar (por DESCRIPCI�N):");

        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jTextField3.setEnabled(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 102, 0));
        jButton3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton3.setText("Modificar stock");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setEditingColumn(0);
        jTable1.setEditingRow(0);
        jScrollPane1.setViewportView(jTable1);

        jButton4.setBackground(new java.awt.Color(255, 204, 0));
        jButton4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton4.setText("Informe de stock");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jMenu1.setText("Control de stock");

        jMenuItem1.setText("Rangos de producto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(7, 7, 7))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jButton3.isVisible()){
        VentanaPrincipal inicio = new VentanaPrincipal();
        //inicio.setDefaultCloseOperation(inicio.HIDE_ON_CLOSE);
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);
        this.dispose();
        }else{
            /*
            FacturacionRemito remitoafacturar = new FacturacionRemito();
            remitoafacturar.setEnabled(true);
            remitoafacturar.toFront();
            remitoafacturar.requestFocus();
            */
            this.toBack();
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextField1.setForeground(Color.black);
        jLabel4.setForeground(Color.black);
        jTextField1.setText("");
        jTextField2.setText("");
        jTable1.setRowSorter(null);
        jTable1.removeEditor();
        jLabel4.setText("-");
        jLabel6.setText("-");
        jTextField3.setText("");
        jTextField3.setEnabled(false);
        jTextField1.requestFocus();
        mostrarProductos();
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.LEFT);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
    }//GEN-LAST:event_jButton2ActionPerformed
    public class BuscarProductoC{
        public BuscarProductoC(){
        }
        public String buscarProducto(String idproducto){
            try{
                Statement st = LlenarCombo.conexion.createStatement();
                ResultSet registroproducto = st.executeQuery("SELECT * FROM picar_db.productos WHERE productos.codigo='"+idproducto+"';");
                if(registroproducto.next()){
                String traerdescripcion = registroproducto.getString("descripcion");
                String traerprecio = registroproducto.getString("precio");
                int traerstock = registroproducto.getInt("stock");
                jTextField1.setForeground(new Color(0,153,255));
                jLabel4.setForeground(new Color(0,153,255));
                jLabel4.setText(traerdescripcion);
                jLabel6.setText(traerprecio);
                jTextField3.setEnabled(true);
                jTextField3.setText(String.valueOf(traerstock));
                if(jButton3.isVisible()){
                //jTextField3.requestFocus();
                }else{
                    jTextField1.requestFocus();
                }
                }else{
                    jTextField1.setForeground(Color.red);
                    jLabel4.setForeground(Color.red);
                    jLabel4.setText("NO ENCONTRADO");
                    jLabel6.setText("-");
                    jTextField3.setText("");
                    jTextField3.setEnabled(false);
                    //jTextField1.requestFocus();
                }
            } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR: "+e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            return idproducto;
        }
    }
    private transient BuscarProductoC bproducto = new BuscarProductoC();
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        String idproducto = this.jTextField1.getText();
        bproducto.buscarProducto(idproducto.replace(" ", "").trim());
        if (jTextField3.isEnabled()) {
            jTextField3.requestFocus();
        }else{
            jTextField1.requestFocus();
        }
    }//GEN-LAST:event_jTextField1ActionPerformed
    public class Logica {
        public DefaultTableModel mostrarProductos()
        {
            String [] nombresColumnas = {"C�digo","Descripci�n","Precio lista","Stock","Rango"};
            Object [] registros = new Object [5];
            //DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
            DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas){
                @Override
                public Class getColumnClass(int columna){
                if(columna==3 || columna==4){
                    return Integer.class;
                }else{
                    return String.class;
                    }}
            };
            String sql = "SELECT * FROM picar_db.productos ORDER BY productos.descripcion ASC;";
            Connection cn = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            try
            {
                cn = LlenarCombo.conexion;
                pst = cn.prepareStatement(sql);                        
                rs = pst.executeQuery();
                while(rs.next())
                {
                    registros[0] = rs.getString("codigo");
                    registros[1] = rs.getString("descripcion");
                    registros[2] = rs.getString("precio");
                    registros[3] = rs.getInt("stock");
                    registros[4] = rs.getFloat("rango");
                    //registros[3] = Integer.parseInt(rs.getString("stock").toString());
                    //registros[3] = rs.getString("stock");
                    modelo.addRow(registros);
                }
            }
            catch(SQLException e)
            {
                System.out.println("ERROR: "+e);
                JOptionPane.showMessageDialog(null, "ERROR: "+e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            return modelo;
        }
        
    }
    
    public void mostrarProductos()
    {
        Logica logica = new Logica();
        DefaultTableModel modelo = logica.mostrarProductos();
        jTable1.setModel(modelo);
        TableColumnModel columnmodel = jTable1.getColumnModel();
        columnmodel.getColumn(4).setMaxWidth(0);
        columnmodel.getColumn(4).setMinWidth(0);
        columnmodel.getColumn(4).setPreferredWidth(0);
        columnmodel.getColumn(1).setPreferredWidth(650);
    } 
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
        jButton3.requestFocus();
    }//GEN-LAST:event_jTextField3ActionPerformed
    public class ModificarStockC{
        public ModificarStockC(){
        }
        private String ultimoMensajeMySQL="";
        public String modificarStock (String idproducto, String stocknuevo){
        String sql = "UPDATE picar_db.productos SET stock="+stocknuevo+" WHERE codigo='"+idproducto+"';";
            try{
                Statement st = LlenarCombo.conexion.createStatement();
                st.executeUpdate(sql);
                ultimoMensajeMySQL="El stock del producto con el c�digo "+idproducto+" fue actualizado con �xito.";
                ResultSet registroproducto = st.executeQuery("SELECT * FROM picar_db.productos WHERE codigo='"+idproducto+"';");
                if(registroproducto.next()){
                    JOptionPane.showMessageDialog(null, ultimoMensajeMySQL, "INFORMACI�N DEL SISTEMA", JOptionPane.INFORMATION_MESSAGE);
                    String traercodigo = registroproducto.getString("codigo");
                    String traerdescripcion = registroproducto.getString("descripcion");
                    String traerprecio = registroproducto.getString("precio");
                    String traerstock = registroproducto.getString("stock");
                    jTextField1.setText(traercodigo);
                    jLabel4.setText(traerdescripcion);
                    jLabel6.setText(traerprecio);
                    jTextField3.setEnabled(true);
                    jTextField3.setText(traerstock);
                    jTable1.setRowSorter(null);
                    jTable1.removeEditor();
                    mostrarProductos();
                    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                    rightRenderer.setHorizontalAlignment(JLabel.LEFT);
                    jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
                    jTable1.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
                    jTable1.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
                    jTable1.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
                    jTable1.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
                    jTextField3.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null, "La producto con el c�digo N�"+idproducto+" ingresado no se encuentra en el sistema.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    /*jTextField1.setText("");
                    jTextField2.setText("");
                    jLabel4.setText("-");
                    jLabel6.setText("-");
                    jTextField3.setText("");*/
                    jTextField1.requestFocus();
                }
            } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR: "+e, "ERROR", JOptionPane.ERROR_MESSAGE);
            jTextField3.requestFocus();
        }
            return ultimoMensajeMySQL;
    }
    }
    private transient ModificarStockC mstock = new ModificarStockC();
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String idproducto = this.jTextField1.getText();
        String stocknuevo = this.jTextField3.getText();
        mstock.modificarStock(idproducto.replace(" ", "").trim().toUpperCase(),stocknuevo.replace(" ", "").replace(",",".").trim());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
        String idproducto = this.jTextField1.getText();
        bproducto.buscarProducto(idproducto.replace(" ", "").trim());
    }//GEN-LAST:event_jTextField1FocusLost
    private TableRowSorter TRSFiltro;
    
    public void Filtro(){
        int ColumnaTabla = 1;
        TRSFiltro.setRowFilter(RowFilter.regexFilter(jTextField2.getText().toUpperCase().trim(),ColumnaTabla));
        }
    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        jTextField2.addKeyListener(new KeyAdapter(){
        public void keyReleased (final KeyEvent e){
        String cadena = (jTextField2.getText());
        jTextField2.setText(cadena);
        Filtro();
        }
        });
        TRSFiltro = new TableRowSorter(jTable1.getModel());
        jTable1.setRowSorter(TRSFiltro);
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2FocusLost
    public class MiRenderer extends DefaultTableCellRenderer {
        @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
                float numero = Float.parseFloat(table.getValueAt(row,3).toString());
                float rango = Float.parseFloat(table.getValueAt(row,4).toString());
                if(numero<rango){
                    setBackground(colorRojo);
                    setForeground(Color.white);
                }else{
                    setBackground(Color.white);
                    setForeground(Color.black);
                }
            
                return super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
            }
    }
    Color colorCelda = new Color(242, 242, 242);
    Color colorRojo = new Color(220,20,60);
    Color colorNaranja = new Color(255,140,0);
    Color colorAmarillo = new Color(255,215,0);
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        mostrarProductos();
        jTextField2.setText("");
        DefaultTableModel tabla = (DefaultTableModel) this.jTable1.getModel();
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabla);
        jTable1.setRowSorter(sorter);
        jTable1.getRowSorter().toggleSortOrder(3);
        this.jTable1.setDefaultRenderer(Object.class, new MiRenderer());
        jTextField1.requestFocus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        // TODO add your handling code here:
        //Color colorAzul = new Color(0,153,255);
        if (Color.red.equals(jLabel5.getBackground()) || Color.black.equals(jLabel5.getBackground())) {
            jTextField3.setText("");
            jTextField3.setEnabled(false);
            }
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE || karakter == '.')))){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        AltaRangos rangos = new AltaRangos(this,true);
        this.dispose();
        rangos.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        rangos.setLocationRelativeTo(null);
        rangos.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing
                                                                   .UIManager
                                                                   .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing
                         .UIManager
                         .setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util
                .logging
                .Logger
                .getLogger(Productos.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util
                .logging
                .Logger
                .getLogger(Productos.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util
                .logging
                .Logger
                .getLogger(Productos.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util
                .logging
                .Logger
                .getLogger(Productos.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt
            .EventQueue
            .invokeLater(new Runnable() {
                public void run() {
                    new Productos().setVisible(true);
                }
            });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

}