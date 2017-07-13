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
import personas.Clientes;

/**
 *
 * @author 19052403-5
 */
public class OperacionesEmb {
    Conectar conn = new Conectar();
    DabaEmb cn = new DabaEmb();
    Connection con = cn.AccederBD();
    
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
    
    public boolean guadarRegistro(Clientes cli){
            boolean ingreso=false;
           String q = "insert into cliente values('"+cli.getRut()+"', '"+cli.getNombre()+"' , '"+cli.getApPat()+"','"+cli.getApMat()+"','"+cli.getFono()+"','"+cli.getEmail()+"')"; 
        try{
            PreparedStatement contr = con.prepareStatement(q);
            contr.execute();
            contr.close();
            ingreso=true;
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
         System.err.println("Error");
      }
     
        return ingreso;
    }
    
}
