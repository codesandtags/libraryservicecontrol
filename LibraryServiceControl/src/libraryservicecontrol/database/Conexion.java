package libraryservicecontrol.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    public static final String DB_DRIVER_CLASS = "DB_DRIVER_CLASS";
    public static final String DB_URL          = "DB_URL";
    public static final String DB_USERNAME     = "DB_USERNAME";
    public static final String DB_PASSWORD     = "DB_PASSWORD";
    
    /**
     * Obtiene una nueva conexion 
     * @return
     */
    public static Connection getConexion(){
        Properties propiedades  = new Properties();
        Connection conexion     = null;
        try {
            FileInputStream fis = new FileInputStream("db.properties");
            propiedades.load(fis);
            
            // Carga el driver de la base de datos
            Class.forName(propiedades.getProperty(DB_DRIVER_CLASS));
            
            // Realiza la conexion a la base de datos
            conexion    = DriverManager.getConnection(
                    propiedades.getProperty(DB_URL), 
                    propiedades.getProperty(DB_USERNAME),
                    propiedades.getProperty(DB_PASSWORD));
            
        } catch (IOException | ClassNotFoundException |  SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return conexion;
    }
    
    /**
     * Cierra la conexion actual
     */
    public static void cerrarConexion(Connection conexion){
    	try {
			if(conexion != null && !conexion.isClosed()){
				conexion.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
		}
    }
    
    public static void main(String[] args) {
        Conexion.getConexion();
        Conexion.cerrarConexion( Conexion.getConexion() );
    }
    
}