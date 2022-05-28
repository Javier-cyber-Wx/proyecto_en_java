/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sistema_de_venta;

import Conexiones.mysqlconnector;
import Modelos.Clientes;
import Modelos.ventas;
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
public class Sistema_venta extends javax.swing.JFrame {
    PreparedStatement ps;
    ResultSet rs;

    mysqlconnector connector = new mysqlconnector();
    Connection conexion = connector.conectar();
    /**
     * Creates new form Sistema_venta
     */
    public Sistema_venta() {
        initComponents();
        //MostrarVentas();
    }
    
    
        private void GuardarVenta()
    {
         try
        {
            ventas NuevaVenta = new ventas();

            NuevaVenta.setCodigo(Integer.parseInt(Code.getText()));
            NuevaVenta.setProducto(Producto.getSelectedItem().toString());
            NuevaVenta.setUOM(UOM.getSelectedItem().toString());
            NuevaVenta.setCantidad(Integer.parseInt(Cantidad.getText()));
            NuevaVenta.setPrecio(Double.parseDouble(Precio.getText()));
            
            int monto = (int)(NuevaVenta.getCantidad() * NuevaVenta.getPrecio());
            MontoFinal1.setText(Integer.toString(monto));
            
            String IVA = "12%";
            Otros.setText(IVA);
            
            double TotalIva = (NuevaVenta.getPrecio() * 0.12);
            double total = (NuevaVenta.getPrecio() + TotalIva);
            Total.setText(Double.toString(total));

            String sql_NuevoProducto = "INSERT INTO `servicio`(`Codigo`, `Producto`, `UOM`, `Cantidad`,`Precio`)" + "VALUES (?,?,?,?,?)";
            PreparedStatement pst = conexion.prepareStatement(sql_NuevoProducto);
            pst.setInt(1, NuevaVenta.getCodigo());
            pst.setString(2, NuevaVenta.getProducto());
            pst.setString(3, NuevaVenta.getUOM());
            pst.setInt(4, NuevaVenta.getCantidad());
            pst.setDouble(5, NuevaVenta.getPrecio());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Guardado");
        }
        catch(HeadlessException | NumberFormatException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "error al guardar: "+e);
        }
    }
       private void EliminarVentas() {
        try {
            int fila = TablaBD.getSelectedRow();
            String Codigo = TablaBD.getValueAt(fila, 0).toString();
            String eliminar = "DELETE FROM `servicio` WHERE Codigo = ?";
            PreparedStatement pst = conexion.prepareStatement(eliminar);
            pst.setString(1, Codigo);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Venta Eliminada");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error de Eliminar");
        }
    }

    private void MostrarVentas() {
        try {

            String[] titulos = {"Codigo", "Producto", "UOM", "Cantidad", "Precio"};
            String[] registros = new String[5];
            DefaultTableModel model = new DefaultTableModel(null, titulos);
            String sql_muestra = "SELECT * FROM `servicio`";
            Statement st = conexion.createStatement();
            ResultSet resulta = st.executeQuery(sql_muestra);

            while (resulta.next()) {
                registros[0] = resulta.getString(1);
                registros[1] = resulta.getString(2);
                registros[2] = resulta.getString(3);
                registros[3] = resulta.getString(4);
                registros[4] = resulta.getString(5);

                model.addRow(registros);
            }
            TablaBD.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void BuscarDatos() {
        Connection con = null;

        try {
            con = connector.conectar();
            ps = con.prepareStatement("Select * From productos_disponibles Where Codigo = ?");
            ps.setString(1, Code.getText());

            rs = ps.executeQuery();
            if (rs.next()) {
                Producto.setSelectedItem(rs.getString("Productos"));
                UOM.setSelectedItem(rs.getString("UOM"));
                Precio.setText(rs.getString("Precio"));

            } else {
                JOptionPane.showMessageDialog(null, "No hay nada");

            }

        } catch (Exception e) {
            System.err.print(e);
        }
    }

    private void Nuevo() {
        Code.setText("");
        Producto.setSelectedItem("Selecccione");
        UOM.setSelectedItem("Seleccione");
        Cantidad.setText("");
        Precio.setText("");
        MontoFinal1.setText("");
        Otros.setText("");
        Total.setText("");
        Cliente.setText("");
        NumContacto.setText("");
        Comentario.setText("");
        TipoVenta.setSelectedItem("Cash");

    }

    private void CancelarVenta() {
        try {
            TablaBD.setModel(new DefaultTableModel());
            String eliminar = "DELETE FROM `servicio`";
            PreparedStatement pst = conexion.prepareStatement(eliminar);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Venta Cancelada");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al Cancelar");
        }
    }

    private void DescontarCantidad() {
        Connection con = null;
        try {
            //String Consulta = "SELECT * FROM `productos_disponibles` WHERE Producto = ? ";
            //String Consulta = "SELECT `Cantidad_disponible` FROM `productos_disponibles`" +"WHERE Producto = ?";
            //Statement st = conexion.createStatement();
            //ResultSet result = st.executeQuery(Consulta);
            /*PreparedStatement st = conexion.prepareStatement();
                st.setString(1, Producto.setSelectedItem());
                int CantidadProducto = Integer.parseInt(.getString("Cantidad_disponible"));*/
            con = connector.conectar();
            ps = con.prepareStatement("Select * From productos_disponibles Where Productos = ?");
            ps.setString(1, Producto.getSelectedItem().toString());
            int CantidadProducto;
            rs = ps.executeQuery();
            if (rs.next()) {
                CantidadProducto = Integer.parseInt(rs.getString("Cantidad_disponible"));
                ventas NuevaVenta = new ventas();
                NuevaVenta.setCantidad(Integer.parseInt(Cantidad.getText()));

                String Update = "UPDATE `produtos_disponibles` SET " + "`Cantidad_disponible` = ?" + "WHERE `Productos` = ?";
                PreparedStatement pst = conexion.prepareStatement(Update);
                pst.setString(1, Producto.getSelectedItem().toString());
                ResultSet result = pst.executeQuery();
                if (result.next()) {
                    pst.setInt(1, CantidadProducto - NuevaVenta.getCantidad());
                    JOptionPane.showMessageDialog(null, CantidadProducto - NuevaVenta.getCantidad());
                }
                pst.execute();
            } else {
                JOptionPane.showMessageDialog(null, "No hay nada");

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se establecio Conexion!!");
        }

    }

    private void Venta() {
        try {
            Clientes NuevoCliente = new Clientes();
            NuevoCliente.setCliente(Cliente.getText().toString());
            NuevoCliente.setNumero(NumContacto.getText().toString());
            NuevoCliente.setComentario(Comentario.getText().toString());
            NuevoCliente.setForma_Pago(TipoVenta.getSelectedItem().toString());
            NuevoCliente.setProducto(Producto.getSelectedItem().toString());

            String Insert = "INSERT INTO `ventas` (`Cliente`, `Numero`, `Comentario`, `Forma_Pago`, `Producto`)" + "VALUES (?,?,?,?,?)";
            PreparedStatement pst = conexion.prepareStatement(Insert);
            pst.setString(1, NuevoCliente.getCliente());
            pst.setString(2, NuevoCliente.getNumero());
            pst.setString(3, NuevoCliente.getComentario());
            pst.setString(4, NuevoCliente.getForma_Pago());
            pst.setString(5, NuevoCliente.getProducto());
            pst.execute();

            DescontarCantidad();
            JOptionPane.showMessageDialog(null, "Guardado Exitosamente");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro de Guardado");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddActulizar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Nuevo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Code = new javax.swing.JTextField();
        Producto = new javax.swing.JComboBox<>();
        Catálogo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        UOM = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Precio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Monto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NumContacto = new javax.swing.JTextField();
        Cliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Comentario = new javax.swing.JTextField();
        GuardarVenta = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        TipoVenta = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaBD = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        Total = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        MontoFinal1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Otros = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        VentasCreadas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AddActulizar.setText("Agregar/Actualizar");
        AddActulizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActulizarActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Nuevo.setText("Nuevo");
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });

        jLabel1.setText("Producto");

        jLabel2.setText("Código:");

        Producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Maiz", "Frijol", "Carne de pollo", "Carne de res", "" }));
        Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductoActionPerformed(evt);
            }
        });

        Catálogo.setText("Catálogo");
        Catálogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatálogoActionPerformed(evt);
            }
        });

        jLabel3.setText("UOM");

        UOM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "U", "Lb", "Kg", "qq" }));

        jLabel4.setText("Cantidad");

        jLabel5.setText("Precio");

        jLabel6.setText("Monto");

        jLabel7.setText("Cliente");

        jLabel8.setText("Num de contacto");

        jLabel9.setText("Comentario");
        jLabel9.setToolTipText("comentario");

        GuardarVenta.setText("Guardar");
        GuardarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarVentaActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        TipoVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Credito" }));
        TipoVenta.setToolTipText("");

        TablaBD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaBD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaBDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaBD);

        jLabel10.setText("Monto");

        jLabel11.setText("Otros");

        jLabel12.setText("Total");

        jButton1.setText("Agregar Producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        VentasCreadas.setText("Ver Ventas");
        VentasCreadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentasCreadasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Code, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Catálogo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(UOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(Buscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(VentasCreadas)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(AddActulizar)
                                .addGap(18, 18, 18)
                                .addComponent(Eliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Nuevo))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Monto, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NumContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(Comentario, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(TipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(GuardarVenta)
                        .addGap(18, 18, 18)
                        .addComponent(Cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(MontoFinal1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Otros, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Catálogo)
                    .addComponent(jLabel3)
                    .addComponent(UOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(Monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Eliminar)
                            .addComponent(Nuevo)
                            .addComponent(AddActulizar)
                            .addComponent(jButton1)
                            .addComponent(VentasCreadas)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Buscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(NumContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(Comentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GuardarVenta)
                            .addComponent(Cancelar)
                            .addComponent(TipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MontoFinal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Otros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addGap(13, 13, 13)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        // TODO add your handling code here:
        Nuevo();
    }//GEN-LAST:event_NuevoActionPerformed

    private void CatálogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatálogoActionPerformed
        Catalogo cat = new Catalogo();
        cat.setVisible(true);
    }//GEN-LAST:event_CatálogoActionPerformed

    private void AddActulizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActulizarActionPerformed
    GuardarVenta();
    MostrarVentas();
    }//GEN-LAST:event_AddActulizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Agregar_producto add = new Agregar_producto();
        add.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        BuscarDatos();
    }//GEN-LAST:event_BuscarActionPerformed

    private void ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductoActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
        EliminarVentas();
        MostrarVentas();
    }//GEN-LAST:event_EliminarActionPerformed

    private void TablaBDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaBDMouseClicked
        // TODO add your handling code he
    }//GEN-LAST:event_TablaBDMouseClicked

    private void GuardarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarVentaActionPerformed
        // TODO add your handling code here:
        Venta();
    }//GEN-LAST:event_GuardarVentaActionPerformed

    private void VentasCreadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentasCreadasActionPerformed
        // TODO add your handling code here:
        VentasCreadas add = new VentasCreadas();
        add.setVisible(true);
    }//GEN-LAST:event_VentasCreadasActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        CancelarVenta();
    }//GEN-LAST:event_CancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Sistema_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema_venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddActulizar;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextField Cantidad;
    private javax.swing.JButton Catálogo;
    private javax.swing.JTextField Cliente;
    private javax.swing.JTextField Code;
    private javax.swing.JTextField Comentario;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton GuardarVenta;
    private javax.swing.JTextField Monto;
    private javax.swing.JTextField MontoFinal1;
    private javax.swing.JButton Nuevo;
    private javax.swing.JTextField NumContacto;
    private javax.swing.JTextField Otros;
    private javax.swing.JTextField Precio;
    private javax.swing.JComboBox<String> Producto;
    private javax.swing.JTable TablaBD;
    private javax.swing.JComboBox<String> TipoVenta;
    private javax.swing.JTextField Total;
    private javax.swing.JComboBox<String> UOM;
    private javax.swing.JButton VentasCreadas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
