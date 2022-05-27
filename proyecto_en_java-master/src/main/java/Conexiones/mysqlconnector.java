/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author franc
 */
public class mysqlconnector {
    Connection conn = null;
    public Connection conectar()
    {
        String BD = "jdbc:mysql://localhost/proyecto";
        String Usuario = "root";
        String Password = "";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(BD, Usuario, Password);
            JOptionPane.showMessageDialog(null, "Conexione exitosa");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error de Conexion");
        }
        return conn;
        
    }
    
}
