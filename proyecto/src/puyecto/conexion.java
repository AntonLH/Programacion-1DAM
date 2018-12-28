/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puyecto;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin1
 */
public class conexion {
    public String db ="portal_trabajo";
    public String url="jdbc:mysql://localhost/"+db;
    public String user ="root";
    public String password ="";

    public conexion() {
    }
    public Connection conectar(){
        Connection link=null;
        
        try {
            //cargar driver
            Class.forName("org.gjt.mm.mysql.Driver");
            try {
                link=(Connection) DriverManager.getConnection(url, user,password);
            } catch (SQLException ex) {
                Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return link;
    }
}
