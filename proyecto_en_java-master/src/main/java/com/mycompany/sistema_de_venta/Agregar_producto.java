/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sistema_de_venta;

import Conexiones.mysqlconnector;
import Modelos.Productos;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author franc
 */
public class Agregar_producto extends javax.swing.JFrame {
    public Agregar_producto() {
        initComponents();
        Mostrar();
    }

    mysqlconnector connector = new mysqlconnector();
    Connection conexion = connector.conectar();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmb_uom = new javax.swing.JComboBox<>();
        Precio = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_cantidad_disponible = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_pro = new javax.swing.JTable();
        cmb_producto_in = new javax.swing.JComboBox<>();
        Guardar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        Elimina = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Producto");

        cmb_uom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "U", "Lb", "Kg", "qq" }));

        Precio.setText("Precio");

        jLabel3.setText("Cantidad_disponible");

        jLabel4.setText("UOM");

        Tabla_pro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla_pro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_proMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_pro);

        cmb_producto_in.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maiz", "Frijol", "Carne de pollo", "Carne de res", " " }));

        Guardar.setText("Guardar Producto");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });

        Elimina.setText("Eliminar");
        Elimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Elimina, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cantidad_disponible, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(32, 32, 32)
                                .addComponent(cmb_uom, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(Precio))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_producto_in, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmb_producto_in, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Precio)
                            .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cantidad_disponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmb_uom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Elimina, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void Limpiar()
    {
        txt_precio.setText("");
        txt_cantidad_disponible.setText("");
    }
    private void EliminarProducto()
    {
        try
        {
            int fila = Tabla_pro.getSelectedRow();
            String Codigo = Tabla_pro.getValueAt(fila, 0).toString();
            String delete = "DELETE FROM `productos_disponibles` WHERE Codigo = ?";
            PreparedStatement pst = conexion.prepareStatement(delete);
            pst.setString(1, Codigo);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Eliminado Exitosamente");
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error de Eliminado");
        }
    }
    private void GuardarProducto()
    {
         try
        {
            Productos NuevoProducto = new Productos();
            NuevoProducto.setProducto(cmb_producto_in.getSelectedItem().toString());
            NuevoProducto.setPrecio(Double.parseDouble(txt_precio.getText()));
            NuevoProducto.setCantidad_disponible(Integer.parseInt(txt_cantidad_disponible.getText()));
            NuevoProducto.setUom(cmb_uom.getSelectedItem().toString());
            
            String sql_NuevoProducto = "INSERT INTO `productos_disponibles`(`Productos`, `Precio`, `Cantidad_disponible`, `UOM`) VALUES (?,?,?,?)";
            PreparedStatement  pst = conexion.prepareStatement(sql_NuevoProducto);
            pst.setString(1, NuevoProducto.getProducto());
            pst.setDouble(2, NuevoProducto.getPrecio());
            pst.setInt(3, NuevoProducto.getCantidad_disponible());
            pst.setString(4, NuevoProducto.getUom());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Guardado");
        }
        catch(HeadlessException | NumberFormatException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "error al guardar: "+e);
        }
    }
    
    private void Modificar()
    {
        try
        {
            Productos NuevoProducto = new Productos();
            NuevoProducto.setProducto(cmb_producto_in.getSelectedItem().toString());
            NuevoProducto.setPrecio(Double.parseDouble(txt_precio.getText()));
            NuevoProducto.setCantidad_disponible(Integer.parseInt(txt_cantidad_disponible.getText()));
            NuevoProducto.setUom(cmb_uom.getSelectedItem().toString());
           
            int fila = Tabla_pro.getSelectedRow();
            String codigo = Tabla_pro.getValueAt(fila, 0).toString();
            String update = "UPDATE `productos_disponibles` SET " +"Productos = ?, " +"Precio = ?, " +"Cantidad_disponible = ?, " +"UOM = ? " +"WHERE Codigo = ?";
                    PreparedStatement pst = conexion.prepareStatement(update);
                    pst.setString(1, NuevoProducto.getProducto());
                    pst.setDouble(2, NuevoProducto.getPrecio());
                    pst.setInt   (3, NuevoProducto.getCantidad_disponible());
                    pst.setString(4, NuevoProducto.getUom());
                    pst.setString(5, codigo);
                    pst.execute();
            JOptionPane.showMessageDialog(null, "Modificacion exitosa");
        }
        catch(HeadlessException | NumberFormatException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error en la modificacion: "+e);
        }
    }
    private void Mostrar()
    {
        String sql_mostrar = "SELECT *FROM productos_disponibles";
        Statement st;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo");
        model.addColumn("Producto");
        model.addColumn("Precio");
        model.addColumn("Cantidad_Disponible");
        model.addColumn("UOM");
        Tabla_pro.setModel(model);
        String[] dato = new String[5];
        
        try
        {
            st = conexion.createStatement();
            ResultSet result = st.executeQuery(sql_mostrar);
            while(result.next())
            {
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);
                dato[4] = result.getString(5);
                model.addRow(dato);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
       GuardarProducto();
       Mostrar();
       
    }//GEN-LAST:event_GuardarActionPerformed


    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        Modificar();
        Mostrar();
    }//GEN-LAST:event_modificarActionPerformed

    private void Tabla_proMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_proMouseClicked
        int fila = Tabla_pro.rowAtPoint(evt.getPoint());
        cmb_producto_in.setToolTipText(Tabla_pro.getValueAt(fila, 1).toString());
        txt_precio.setText(Tabla_pro.getValueAt(fila, 2).toString());
        txt_cantidad_disponible.setText(Tabla_pro.getValueAt(fila, 3).toString());
        cmb_producto_in.setToolTipText(Tabla_pro.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_Tabla_proMouseClicked

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_LimpiarActionPerformed

    private void EliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminaActionPerformed
        EliminarProducto();
        Mostrar();
    }//GEN-LAST:event_EliminaActionPerformed
    
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
            java.util.logging.Logger.getLogger(Agregar_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Elimina;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Limpiar;
    private javax.swing.JLabel Precio;
    private javax.swing.JTable Tabla_pro;
    private javax.swing.JComboBox<String> cmb_producto_in;
    private javax.swing.JComboBox<String> cmb_uom;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField txt_cantidad_disponible;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
