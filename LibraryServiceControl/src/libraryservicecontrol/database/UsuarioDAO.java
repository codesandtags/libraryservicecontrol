package libraryservicecontrol.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import libraryservicecontrol.model.Usuario;


public class UsuarioDAO extends ManejadorDAO<Usuario>{

	@Override
	public Usuario buscarPorId(Integer id) {
		
		StringBuilder sql 	= new StringBuilder("SELECT * FROM usuario WHERE id = ").append(id);
		ResultSet resultado = null;
		Usuario usuario 	= null;
		resultado 			= consultar(sql.toString());
		
		try {
			if(resultado != null && resultado.next() ){
				usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNombres(resultado.getString("nombres"));
				usuario.setApellidos(resultado.getString("apellidos"));
				usuario.setUsuario(resultado.getString("usuario"));
				usuario.setClave(resultado.getString("clave"));
				usuario.setFechaCreado(resultado.getDate("fecha_creado"));
				usuario.setTipoDocumento(resultado.getString("tipo_documento"));
				usuario.setTelefono(resultado.getString("telefono"));
				usuario.setCorreo(resultado.getString("correo"));
				usuario.setDireccion(resultado.getString("direccion"));
				usuario.setCiudad(resultado.getString("ciudad"));
				usuario.setRolId(resultado.getInt("rol_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	public Boolean crearUsuario(Usuario usuario){
		
		Boolean isCreado    = false;
		StringBuilder sql 	= new StringBuilder("INSERT INTO usuario ")
		.append("(nombres,apellidos,usuario,clave,fecha_creado,tipo_documento,numero_documento,fecha_nacimiento,telefono,correo,direccion,ciudad,rol_id,) ")
		.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		Connection conexion	 = Conexion.getConexion();
		PreparedStatement consulta	 = null;
		Integer insertados  = null;	
		
		try {
			consulta 		= conexion.prepareStatement(sql.toString());
			consulta.setString(1, usuario.getNombres());
			consulta.setString(2, usuario.getApellidos());
			consulta.setString(3, usuario.getUsuario());
			consulta.setString(4, usuario.getClave());
			consulta.setDate(5, usuario.getFechaCreado());
			consulta.setString(6, usuario.getTipoDocumento());
			consulta.setString(7, usuario.getNumeroDocumento());
			consulta.setDate(8, usuario.getFechaNacimiento());
			consulta.setString(9, usuario.getTelefono());
			consulta.setString(10, usuario.getCorreo());
			consulta.setString(11, usuario.getDireccion());
			consulta.setString(12, usuario.getCiudad());
			consulta.setInt(13, usuario.getRolId());
			insertados = consulta.executeUpdate();
			
			if(insertados  > 0){
				isCreado = true;
			}
			
			Conexion.cerrarConexion(conexion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isCreado;
	}
	
	public Boolean actualizarUsuario(Usuario usuario){
		
		Boolean isActualizado = false;
		StringBuilder sql 	 = new StringBuilder("UPDATE usuario ")
		.append("SET nombres=?, apellidos=?, usuario=?, clave=?, fecha_creado=?, tipo_documento=?, numero_documento=?, ")
		.append("fecha_nacimiento=?, telefono=?, correo=?, direccion=?, ciudad=?, rol_id=?  ")
		.append("WHERE id=?");
		
		Connection conexion	 = Conexion.getConexion();
		PreparedStatement consulta	 = null;
		Integer actualizados  = null;	
		
		try {
			consulta 		= conexion.prepareStatement(sql.toString());
			consulta.setString(1, usuario.getNombres());
			consulta.setString(2, usuario.getApellidos());
			consulta.setString(3, usuario.getUsuario());
			consulta.setString(4, usuario.getClave());
			consulta.setDate(5, usuario.getFechaCreado());
			consulta.setString(6, usuario.getTipoDocumento());
			consulta.setString(7, usuario.getNumeroDocumento());
			consulta.setDate(8, usuario.getFechaNacimiento());
			consulta.setString(9, usuario.getTelefono());
			consulta.setString(10, usuario.getCorreo());
			consulta.setString(11, usuario.getDireccion());
			consulta.setString(12, usuario.getCiudad());
			consulta.setInt(13, usuario.getRolId());
			consulta.setInt(14, usuario.getId());
			actualizados = consulta.executeUpdate();
			
			if(actualizados  > 0){
				isActualizado = true;
			}
			
			Conexion.cerrarConexion(conexion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isActualizado;
	}
	
}
