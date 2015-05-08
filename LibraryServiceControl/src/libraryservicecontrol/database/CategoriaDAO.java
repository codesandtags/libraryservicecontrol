package libraryservicecontrol.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libraryservicecontrol.model.Categoria;



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

}
