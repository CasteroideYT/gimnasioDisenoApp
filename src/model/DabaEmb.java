package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DabaEmb {

    private Connection conn = null;

    public Connection CrearBD() {
        try {
            //obtenemos el driver de para mysql
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //obtenemos la conexión
            conn = DriverManager.getConnection("jdbc:derby:.\\data;create=true");
            if (conn != null) {
                String crearEmpleado = "create table empleado(codigoEmpleado varchar(50), Nombre varchar(50), Apellido varchar(50), Contrasena varchar(40), Tipo varchar(40), primary key (codigoEmpleado))";
                String crearCliente = "create table cliente(rut varchar(13) NOT NULL , Nombre varchar(30), ApPat varchar(20), ApMat varchar(20), fono varchar(11), email varchar (45), Primary Key (rut))";
                String crearPlanTrabajo = "create table planTrabajo(idPlanTrabajo integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), DuracionMeses integer, DescuentoPlan integer, Primary Key (idPlanTrabajo))";
                String crearPlanContratado = "create table planContratado(idPlanContratado integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), FechaInicio Date, FechaTermino Date, rut varchar(13) NOT NULL,  Primary Key (idPlanContratado), Foreign Key (rut) references cliente(rut))";
                String crearSucursal = "create table sucursal(idSucursal integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), NombreSucursal varchar(45), Direccion varchar(45), Comuna varchar(30), Fono integer, Primary Key (idSucursal))";
                String alter = "alter table planContratado add idPlanTrabajo integer ";
                String ingresarEmpleados = "INSERT INTO empleado VALUES ( 'Admin01', 'Administrador', 'Administrador', 'Admin01', 'Administrador' ) ";
                String desc = "disconnect;";
                try {
                   PreparedStatement pstm = conn.prepareStatement(crearEmpleado);
                   pstm.execute();
                   pstm.close();
                   System.err.print("a");
                    PreparedStatement pstm5 = conn.prepareStatement(crearSucursal);
                    pstm5.execute();
                    pstm5.close();
                    System.err.print("b");
                    PreparedStatement pstm2 = conn.prepareStatement(crearCliente);
                    pstm2.execute();
                    pstm2.close();
                    System.err.print("c");
                    PreparedStatement pstm4 = conn.prepareStatement(crearPlanTrabajo);
                    pstm4.execute();
                    pstm4.close();
                    System.err.print("d");
                    PreparedStatement pstm3 = conn.prepareStatement(crearPlanContratado);
                    pstm3.execute();
                    pstm3.close();
                    System.err.print("e");
                    PreparedStatement pstm6 = conn.prepareStatement(alter);
                    pstm6.execute();
                    pstm6.close();
                    System.err.print("alter");
                    JOptionPane.showMessageDialog(null, "BD Creada correctamente");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
                }
                try {
                    PreparedStatement pstm = conn.prepareStatement(ingresarEmpleados);
                    pstm.execute();
                    pstm.close();
                    JOptionPane.showMessageDialog(null, "Insertado correctamente");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return conn;
    }

    public Connection AccederBD() {
        try {
            //obtenemos el driver de para mysql
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //obtenemos la conexión
            conn = DriverManager.getConnection("jdbc:derby:.\\data");
            //if (conn != null) {
            //    JOptionPane.showMessageDialog(null, "OK base de datos listo");
            //}
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }

    public void cerracon() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
