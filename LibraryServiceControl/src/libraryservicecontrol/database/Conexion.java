package libraryservicecontrol.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Realiza la conexión con la base de datos utilizando un archivo de 
 * propiedades db.properties
 * @author 
 */
public class Conexion {
    
    public static final String DB_DRIVER_CLASS = "DB_DRIVER_CLASS";
    public static final String DB_URL          = "DB_URL";
    public static final String DB_USERNAME     = "DB_USERNAME";
    public static final String DB_PASSWORD     = "DB_PASSWORD";
    
    public static Connection getConexion(){
        Properties propiedades  = new Properties();
        Connection conexion     = null;
        
        try {
            FileInputStream fis = new FileInputStream("db.properties");
            propiedades.load(fis);
            
            System.out.println(" => " + propiedades.getProperty(DB_URL));
            
            // Carga el driver de la base de datos
            Class.forName(propiedades.getProperty(DB_DRIVER_CLASS));
            
            // Realiza la conexion a la base de datos
            conexion    = DriverManager.getConnection(
                    propiedades.getProperty(DB_URL), 
                    propiedades.getProperty(DB_USERNAME),
                    propiedades.getProperty(DB_PASSWORD));
            
        } catch (IOException | ClassNotFoundException |  SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conexion;
    }
    
    public static void main(String[] args) {
        
        Conexion.getConexion();
        
    }
    
}

