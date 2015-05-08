package libraryservicecontrol.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libraryservicecontrol.model.Genero;

public class GeneroDAO extends ManejadorDAO<Genero>{
	
	@Override
	public Genero buscarPorId(Integer id) {
		StringBuilder sql 	= new StringBuilder("SELECT * FROM genero WHERE id = ").append(id);
		ResultSet resultado = null;
		Genero	genero				= null;
		resultado 			= consultar(sql.toString());
		
		try {
			if(resultado != null && resultado.next() ){
				genero = new Genero();
				genero.setId(resultado.getInt("id"));
				genero.setGenero(resultado.getString("genero"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return genero;
	}

	@Override
	public List<Genero> buscarTodos() {
		StringBuilder sql 		= new StringBuilder("SELECT * FROM genero ");
		ResultSet resultado 	= null;
		List<Genero> generos			= new ArrayList<Genero>();
		resultado 				= consultar(sql.toString());
		
		try {
			while(resultado != null && resultado.next() ){
				Genero genero = new Genero();
				genero.setId(resultado.getInt("id"));
				genero.setGenero(resultado.getString("genero"));
				generos.add(genero);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return generos;
	}

}
