package libraryservicecontrol.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import libraryservicecontrol.model.Categoria;

import libraryservicecontrol.model.Rol;

public class RolDAO extends ManejadorDAO<Rol>{

    @Override
    public Rol buscarPorId(Integer id) {
        StringBuilder sql 	= new StringBuilder("SELECT * FROM rol WHERE id = ").append(id);
        ResultSet resultado = null;
        Rol	rol				= null;
        resultado 			= consultar(sql.toString());

        try {
                if(resultado != null && resultado.next() ){
                        rol = new Rol();
                        rol.setId(resultado.getInt("id"));
                        rol.setRol(resultado.getString("rol"));
                }
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return rol;
    }

    @Override
    public List<Rol> buscarTodos() {
        StringBuilder sql 		= new StringBuilder("SELECT * FROM rol ");
        ResultSet resultado 	= null;
        List<Rol> roles			= new ArrayList<Rol>();
        resultado 				= consultar(sql.toString());

        try {
                while(resultado != null && resultado.next() ){
                        Rol rol = new Rol();
                        rol.setId(resultado.getInt("id"));
                        rol.setRol(resultado.getString("rol"));
                        roles.add(rol);
                }
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return roles;
    }
    
    public Rol buscarPorRol(String nombreRol){
        StringBuilder sql = new StringBuilder("SELECT * FROM rol WHERE rol=? ");
        Connection conexion = Conexion.getConexion();
        PreparedStatement consulta	 = null;
        Rol rol	= null;
        ResultSet resultado = null;

        try {
            consulta 		= conexion.prepareStatement(sql.toString());
            consulta.setString(1, nombreRol);
            resultado		= consulta.executeQuery();

            if(resultado != null && resultado.next() ){
                rol= new Rol();
                rol.setId(resultado.getInt("id"));
                rol.setRol(resultado.getString("rol"));
            }

            Conexion.cerrarConexion(conexion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rol;
    }

}
