package libraryservicecontrol.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libraryservicecontrol.model.Categoria;
import libraryservicecontrol.model.Usuario;

public class CategoriaDAO extends ManejadorDAO<Categoria>{
	
    @Override
    public Categoria buscarPorId(Integer id) {
        StringBuilder sql 	= new StringBuilder("SELECT * FROM categoria WHERE id = ").append(id);
        ResultSet resultado = null;
        Categoria	categoria				= null;
        resultado 			= consultar(sql.toString());

        try {
            if(resultado != null && resultado.next() ){
                categoria = new Categoria();
                categoria.setId(resultado.getInt("id"));
                categoria.setCategoria(resultado.getString("categoria"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoria;
    }

    @Override
    public List<Categoria> buscarTodos() {
        StringBuilder sql 		= new StringBuilder("SELECT * FROM categoria ");
        ResultSet resultado 	= null;
        List<Categoria> categorias	= new ArrayList<Categoria>();
        resultado 				= consultar(sql.toString());

        try {
                while(resultado != null && resultado.next() ){
                        Categoria categoria = new Categoria();
                        categoria.setId(resultado.getInt("id"));
                        categoria.setCategoria(resultado.getString("categoria"));
                        categorias.add(categoria);
                }
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return categorias;
    }
    
    public Categoria buscarPorCategoria(String nombreCategoria){
        StringBuilder sql = new StringBuilder("SELECT * FROM categoria WHERE categoria=? ");
        Connection conexion = Conexion.getConexion();
        PreparedStatement consulta	 = null;
        Categoria categoria	= null;
        ResultSet resultado = null;

        try {
            consulta 		= conexion.prepareStatement(sql.toString());
            consulta.setString(1, nombreCategoria);
            resultado		= consulta.executeQuery();

            if(resultado != null && resultado.next() ){
                categoria= new Categoria();
                categoria.setId(resultado.getInt("id"));
                categoria.setCategoria(resultado.getString("categoria"));
            }

            Conexion.cerrarConexion(conexion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoria;
    }

}
