package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Conectar {
    private Connection conn;
    
    private String baseDatos = "gimnasio";
    private String user = "";
    private String password = "";
    
    public Conectar(){
        verificar();
        conectarse(baseDatos, user, password);
        
    }
    
    public String verificar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return "Exito";
        }catch (ClassNotFoundException cl){
            return "Falta conector";
        }
    }
    
    public String conectarse(String db, String user, String password){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+db,user,password);
            return "Exito";
        }catch (SQLException e){
            return "Servidor no encontrado";
        }
    }
    
    public PreparedStatement crearSentencia(String consulta){
        try{
            return conn.prepareStatement(consulta);
            
        }catch (SQLException e){
            return null;
        }
    }
    
    public Statement crearSentencias(){
    try{
        return conn.createStatement();
    }catch(SQLException e){
        return null;
    }
}
}
