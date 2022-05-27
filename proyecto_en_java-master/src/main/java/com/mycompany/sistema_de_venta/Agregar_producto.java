/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sistema_de_venta;

import Conexiones.mysqlconnector;
import Modelos.Productos;
import java.awt.HeadlessException;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

        txt_code = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Codigo");

        jLabel2.setText("Producto");

        cmb_uom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "u", "lb", "kg", "q" }));

        Precio.setText("Precio");

        jLabel3.setText("Cantidad_disponible");

        jLabel4.setText("UOM");

        Tabla_pro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "codigo", "producto", "precio", "cantidad_disponible", "uom"
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(12, 12, 12)
                                    .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Precio)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cantidad_disponible, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmb_producto_in, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmb_uom, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmb_producto_in, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Precio)
                            .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cantidad_disponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmb_uom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void GuardarProducto()
    {
         try
        {
            Productos NuevoProducto = new Productos();
            NuevoProducto.setCodigo(Integer.parseInt(txt_code.getText()));
            NuevoProducto.setProducto(cmb_producto_in.getSelectedItem().toString());
            NuevoProducto.setPrecio(Double.parseDouble(txt_precio.getText()));
            NuevoProducto.setCantidad_disponible(Integer.parseInt(txt_cantidad_disponible.getText()));
            NuevoProducto.setUom(cmb_uom.getSelectedItem().toString());
            
            String sql_NuevoProducto = "INSERT INTO `productos_disponibles`(`Codigo`, `Productos`, `Precio`, `Cantidad_disponible`, `UOM`) VALUES (?,?,?,?,?)";
            PreparedStatement  pst = conexion.prepareStatement(sql_NuevoProducto);
            pst.setInt(1, NuevoProducto.getCodigo());
            pst.setString(2, NuevoProducto.getProducto());
            pst.setDouble(3, NuevoProducto.getPrecio());
            pst.setInt(4, NuevoProducto.getCantidad_disponible());
            pst.setString(5, NuevoProducto.getUom());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Guardado");
        }
        catch(HeadlessException | NumberFormatException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "error al guardar: "+e);
        }
    }
    private void Mostrar()
    {
        String sql_mostrar = "SELECT *FROM productos_disponibles";
        Statement st;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("codigo");
        model.addColumn("producto");
        model.addColumn("precio");
        model.addColumn("cantidad_disponible");
        model.addColumn("uom");
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
        try//esta parte del codigo no funciona 
        {
            Productos NuevoProducto = new Productos();
            NuevoProducto.setCodigo(Integer.parseInt(txt_code.getText()));
            NuevoProducto.setProducto(cmb_producto_in.getSelectedItem().toString());
            NuevoProducto.setPrecio(Double.parseDouble(txt_precio.getText()));
            NuevoProducto.setCantidad_disponible(Integer.parseInt(txt_cantidad_disponible.getText()));
            NuevoProducto.setUom(cmb_uom.getSelectedItem().toString());
            int fila = Tabla_pro.getSelectedRow();
            String Codigo = Tabla_pro.getValueAt(fila, 0).toString();
            String insert = "UPDATE `productos_disponibles` SET `Productos`= ? ,`Precio`= ? ,`Cantidad_disponible`= ? ,`UOM`= ? WHERE 0";
                    PreparedStatement pst = conexion.prepareStatement(insert);
                    pst.setString(1, NuevoProducto.getProducto());
                    pst.setDouble(2, NuevoProducto.getPrecio());
                    pst.setInt(3, NuevoProducto.getCantidad_disponible());
                    pst.setString(4, NuevoProducto.getUom());
                    pst.setString(5, Codigo);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Modificacion exitosa");
        }
        catch(HeadlessException | NumberFormatException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error en la modificacion: "+e);
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void Tabla_proMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_proMouseClicked
        int fila = Tabla_pro.getSelectedRow();
        if(fila>=0)
        {
            txt_code.setText(Tabla_pro.getValueAt(fila, 0).toString());
            cmb_producto_in.setToolTipText(Tabla_pro.getValueAt(fila, 1).toString());
            txt_precio.setText(Tabla_pro.getValueAt(fila, 2).toString());
            txt_cantidad_disponible.setText(Tabla_pro.getValueAt(fila, 3).toString());
            cmb_uom.setToolTipText(Tabla_pro.getValueAt(fila, 4).toString());
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Selecciona una fila");
        }
        
    }//GEN-LAST:event_Tabla_proMouseClicked
    
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
    private javax.swing.JButton Guardar;
    private javax.swing.JLabel Precio;
    private javax.swing.JTable Tabla_pro;
    private javax.swing.JComboBox<String> cmb_producto_in;
    private javax.swing.JComboBox<String> cmb_uom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField txt_cantidad_disponible;
    private javax.swing.JTextField txt_code;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
