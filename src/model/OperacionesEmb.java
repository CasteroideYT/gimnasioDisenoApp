/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 19052403-5
 */
public class OperacionesEmb {
    Conectar conn = new Conectar();
    public String obtenerContrasena(String identificador,Connection con){
        String contrasena = null;
        String q = "select Contrasena from empleado where codigoEmpleado = '"+identificador+"'";
        try{
            PreparedStatement contr = con.prepareStatement(q);
            contrasena= contr.executeQuery()+"";
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
      }
        return contrasena; 
    }
    
}
