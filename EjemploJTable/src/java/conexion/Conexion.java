package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    String bd = "crud";
    String forName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/" + bd;
    String user = "root";
    String pass = "";

    public Connection cx;

    public Connection conectar() {
        try {            
            Class.forName(forName);
            cx = (Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("SE CONECTO");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("NO SE CONECTO");
        }
        return cx;
    }
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            ex.printStackTrace();            
        }
        
    }
    public static void main(String[] args) {
         Conexion c = new Conexion();
         c.conectar();
         
        
    }

}
