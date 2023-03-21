
package app;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author fedec
 */
public class ChequesMostrarTodos extends javax.swing.JDialog {

    /** Creates new form ChequesMostrarTodos */
    public ChequesMostrarTodos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarCheques();
        jTextField1.requestFocus();
    }
    public class Logica {
        public DefaultTableModel mostrarCheques()
        {
            String [] nombresColumnas = {"N� cheque asignado","Banco","Importe","Fecha emisi�n","Fecha pago","Cliente","Destino"};
            Object [] registros = new Object[7];
            DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
            try{
            Statement st = LlenarCombo.conexion.createStatement();
            ResultSet reg = st.executeQuery("SELECT cheques.idcheques, cheques.banco, cheques.importecheque, date_format(cheques.fechaemision,'%d/%m/%Y'), date_format(cheques.fechadepago,'%d/%m/%Y'), clientes.apellido, clientes.nombre, cheques.destino FROM picar_db.cheques JOIN picar_db.clientes ON cheques.cliente_id=clientes.idcliente WHERE cheques.idcheques!=0 ORDER BY cheques.idcheques DESC;"); 
                while(reg.next())
                {   String nombre = reg.getString("nombre");
                    String apellido = reg.getString("apellido");
                    String cliente = apellido+" "+nombre;
                    registros[0] = reg.getString("idcheques");
                    registros[1] = reg.getString("banco");
                    registros[2] = reg.getFloat("importecheque");
                    registros[3] = reg.getString("date_format(cheques.fechaemision,'%d/%m/%Y')");
                    registros[4] = reg.getString("date_format(cheques.fechadepago,'%d/%m/%Y')");
                    registros[5] = (cliente);
                    registros[6] = reg.getString("destino");
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
    
    public void mostrarCheques()
    {
        Logica logica = new Logica();
        DefaultTableModel modelo = logica.mostrarCheques();
        jTable1.setModel(modelo);
        TableColumnModel columnmodel = jTable1.getColumnModel();
        columnmodel.getColumn(1).setPreferredWidth(250);
        columnmodel.getColumn(5).setPreferredWidth(200);
        columnmodel.getColumn(6).setPreferredWidth(250);
        columnmodel.getColumn(3).setPreferredWidth(90);
        columnmodel.getColumn(4).setPreferredWidth(90);
        columnmodel.getColumn(2).setPreferredWidth(100);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cheques | Mostrar todos");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Filtrar (por CLIENTE):");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }//GEN-END:initComponents
    private TableRowSorter TRSFiltro;
    public void Filtro(){
        int ColumnaTabla = 5;
        TRSFiltro.setRowFilter(RowFilter.regexFilter(jTextField1.getText().toUpperCase().trim(),ColumnaTabla));
        }
    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        jTextField1.addKeyListener(new KeyAdapter(){
        public void keyReleased (final KeyEvent e){
        String cadena = (jTextField1.getText());
        jTextField1.setText(cadena);
        Filtro();
        }
        });
        TRSFiltro = new TableRowSorter(jTable1.getModel());
        jTable1.setRowSorter(TRSFiltro);
    }//GEN-LAST:event_jTextField1KeyTyped

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
                .getLogger(ChequesMostrarTodos.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util
                .logging
                .Logger
                .getLogger(ChequesMostrarTodos.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util
                .logging
                .Logger
                .getLogger(ChequesMostrarTodos.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util
                .logging
                .Logger
                .getLogger(ChequesMostrarTodos.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt
            .EventQueue
            .invokeLater(new Runnable() {
                public void run() {
                    ChequesMostrarTodos dialog = new ChequesMostrarTodos(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                }
            });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}