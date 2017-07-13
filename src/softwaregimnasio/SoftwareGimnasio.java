
package softwaregimnasio;

import java.sql.Connection;
import model.DabaEmb;
import vista.JfLogin;
import vista.JfPrincipal;


public class SoftwareGimnasio {
    public static void main(String[] args) {
        DabaEmb db = new DabaEmb();
        Connection cn;
//        db.CrearBD();
        cn=db.AccederBD();
        
        JfPrincipal  jp= new JfPrincipal();
        jp.setLocationRelativeTo(null);
        jp.setVisible(true);
        //JfLogin login= new JfLogin();
        //login.setLocationRelativeTo(null);
        //login.setVisible(true);
    }
    
}
