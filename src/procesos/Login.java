package procesos;

import java.sql.Connection;
import javax.swing.JOptionPane;
import model.DabaEmb;
import model.OperacionesEmb;

public class Login {

    DabaEmb cn = new DabaEmb();
    Connection con = cn.AccederBD();
    OperacionesEmb opemb = new OperacionesEmb();

    public boolean iniciarSecion(String user, String pass) {
        boolean logeado = false;
        String contrasena = "";
        try {
            contrasena = opemb.obtenerContrasena(user, con);
            System.out.println("procesos.login.iniciarSecion()" + contrasena);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario no existe");
        }
        if (pass.equals(contrasena)) {
            logeado = true;

        }
        return logeado;
    }

}
