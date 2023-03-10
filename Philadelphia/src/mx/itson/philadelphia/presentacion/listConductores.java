/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.philadelphia.presentacion;


import java.awt.Component;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.transaction.Transactional;
import mx.itson.philadelphia.entidades.Conductor;
import mx.itson.philadelphia.persistencia.ConductorDAO;

/**
 *
 * @author ricardogarcia
 */
public class listConductores extends javax.swing.JFrame {
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    String fecha;
    /**
     * Creates new form listConductores
     */
    DefaultTableModel modelo = new DefaultTableModel();
    public listConductores() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbConductor = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        menuAgregar = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tbConductor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Numero Licencia", "Fecha Alta"
            }
        ));
        jScrollPane1.setViewportView(tbConductor);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jMenu5.setText("Conductor");

        menuAgregar.setText("Agregar");
        menuAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgregarActionPerformed(evt);
            }
        });
        jMenu5.add(menuAgregar);

        menuEditar.setText("Editar");
        menuEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarActionPerformed(evt);
            }
        });
        jMenu5.add(menuEditar);

        jMenuBar2.add(jMenu5);

        jMenu6.setText("Oficial");
        jMenuBar2.add(jMenu6);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnRegresar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgregarActionPerformed
        guardarConductor cf = new guardarConductor(this, true, 0);
        cf.setVisible(true);
        hide();
    }//GEN-LAST:event_menuAgregarActionPerformed

    private void menuEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarActionPerformed
        int filaseleccionada;

        try {

            filaseleccionada = tbConductor.getSelectedRow();

            if (filaseleccionada == -1) {

                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

            } else {

                DefaultTableModel modelotabla = (DefaultTableModel) tbConductor.getModel();

                String nombre = (String) modelotabla.getValueAt(filaseleccionada, 0);
                String numeroLicencia = (String) modelotabla.getValueAt(filaseleccionada, 1);
                String fecha = (String) modelotabla.getValueAt(filaseleccionada, 2);

               }

        } catch (HeadlessException ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInt??ntelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_menuEditarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        List<Conductor> conductores = ConductorDAO.obtenerTodos();
        modelo.setRowCount(0);
        modelo = (DefaultTableModel) tbConductor.getModel();
        for (Conductor c : conductores) {
            modelo.addRow(new Object[]{
                c.getNombre(),
                c.getNumeroLicencia(),
                c.getFechaAlta()
            });
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       int filaseleccionada = tbConductor.getSelectedRow();

        if (filaseleccionada == -1) {

            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

        } else {
            int id = Integer.parseInt(String.valueOf(modelo.getValueAt(tbConductor.getSelectedRow(), 0)));

            guardarConductor cf = new guardarConductor(this, true, id);
            cf.setVisible(true);
            hide();

        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Inicio in = new Inicio();
        in.setVisible(true);
        hide();
    }//GEN-LAST:event_btnRegresarActionPerformed

    

                                         

    
    
    
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
            java.util.logging.Logger.getLogger(listConductores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listConductores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listConductores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listConductores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listConductores().setVisible(true);
            }
        });
    }
                 

    // End of variables declaration                   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuAgregar;
    private javax.swing.JMenuItem menuEditar;
    private javax.swing.JTable tbConductor;
    // End of variables declaration//GEN-END:variables
}