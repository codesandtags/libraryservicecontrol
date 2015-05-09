package libraryservicecontrol.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class ManejadorDAO<T> {
	
	/**
	 * Realiza una consulta a partir de una sentencia SQL
	 * @param sql
	 * @return {@link ResultSet} con el Resultado de la consulta
	 */
	public ResultSet consultar(String sql){
            Connection conexion  = Conexion.getConexion();
            Statement consulta 	 = null;
            ResultSet resultado  = null;	
            try {
                    consulta = conexion.createStatement();
                    resultado	= consulta.executeQuery(sql);
                    //Conexion.cerrarConexion(conexion);
            } catch (SQLException e) {
                    e.printStackTrace();
            }
            return resultado;
	}
	
	/**
	 * Realiza un UPDATE a partir de una sentencia SQL
	 * @param sql
	 * @return {@link Integer} con la cantidad de registros actualizados
	 */
	public Integer actualizar(String sql ){
		Connection conexion	 = Conexion.getConexion();
		Statement consulta	 = null;
		Integer actualizados = null;	
		try {
			consulta 		= conexion.createStatement();
			actualizados	= consulta.executeUpdate(sql);
			Conexion.cerrarConexion(conexion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actualizados;
	}
	
	/**
	 * Realiza un DELETE a partir de una sentencia SQL
	 * @param sql
	 * @return {@link Integer} con la cantidad de registros actualizados
	 */
	public Integer eliminar(String sql ){
		return actualizar(sql);
	}
	
	/**
	 * Realiza un INSERT a partir de una sentencia SQL
	 * @param sql
	 * @return {@link Integer} con la cantidad de registros actualizados
	 */
	public Integer insertar(String sql ){
		return actualizar(sql);
	}
	
	/**
	 * Realiza la busqueda de un objeto por id
	 * @param id
	 * @return
	 */
	public abstract T buscarPorId(Integer id);
	
	/**
	 * Realiza una busqueda de todos los objetos en una tabla
	 * @return
	 */
	public abstract List<T> buscarTodos();

}
