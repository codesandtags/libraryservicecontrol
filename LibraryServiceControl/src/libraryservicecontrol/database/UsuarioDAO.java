package libraryservicecontrol.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libraryservicecontrol.model.Usuario;


public class UsuarioDAO extends ManejadorDAO<Usuario>{	
	
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

    public Usuario validarUsuario(String usuario, String clave) {
        StringBuilder sql 	= new StringBuilder("SELECT * FROM usuario WHERE usuario=? AND clave=? ");
        Connection conexion	= Conexion.getConexion();
        PreparedStatement consulta	 = null;
        Usuario u		 	= null;
        ResultSet resultado = null;

        try {
            consulta 		= conexion.prepareStatement(sql.toString());
            consulta.setString(1, usuario);
            consulta.setString(2, clave);
            resultado		= consulta.executeQuery();

            if(resultado != null && resultado.next() ){
                u= new Usuario();
                u.setId(resultado.getInt("id"));
                u.setNombres(resultado.getString("nombres"));
                u.setApellidos(resultado.getString("apellidos"));
                u.setUsuario(resultado.getString("usuario"));
                u.setClave(resultado.getString("clave"));
                u.setFechaCreado(resultado.getDate("fecha_creado"));
                u.setFechaNacimiento(resultado.getDate("fecha_nacimiento"));
                u.setTipoDocumento(resultado.getString("tipo_documento"));
                u.setTelefono(resultado.getString("telefono"));
                u.setCorreo(resultado.getString("correo"));
                u.setDireccion(resultado.getString("direccion"));
                u.setCiudad(resultado.getString("ciudad"));
                u.setRolId(resultado.getInt("rol_id"));
            }

            Conexion.cerrarConexion(conexion);
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return u;
    }

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
                usuario.setFechaNacimiento(resultado.getDate("fecha_nacimiento"));
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

    @Override
    public List<Usuario> buscarTodos() {
        StringBuilder sql 		= new StringBuilder("SELECT * FROM usuario ");
        ResultSet resultado 	= null;
        List<Usuario> usuarios	= new ArrayList<Usuario>();
        resultado 				= consultar(sql.toString());

        try {
                while(resultado != null && resultado.next() ){
                        Usuario usuario = new Usuario();
                        usuario.setId(resultado.getInt("id"));
                        usuario.setNombres(resultado.getString("nombres"));
                        usuario.setApellidos(resultado.getString("apellidos"));
                        usuario.setUsuario(resultado.getString("usuario"));
                        usuario.setClave(resultado.getString("clave"));
                        usuario.setFechaCreado(resultado.getDate("fecha_creado"));
                        usuario.setFechaNacimiento(resultado.getDate("fecha_nacimiento"));
                        usuario.setTipoDocumento(resultado.getString("tipo_documento"));
                        usuario.setTelefono(resultado.getString("telefono"));
                        usuario.setCorreo(resultado.getString("correo"));
                        usuario.setDireccion(resultado.getString("direccion"));
                        usuario.setCiudad(resultado.getString("ciudad"));
                        usuario.setRolId(resultado.getInt("rol_id"));
                        usuarios.add(usuario);
                }
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return usuarios;
    }
    
    public Usuario buscarPorDocumento(String tipoDocumento, String documento) {
        StringBuilder sql 	= new StringBuilder("SELECT * FROM usuario WHERE tipo_documento=? AND numero_documento=? ");
        Connection conexion	= Conexion.getConexion();
        PreparedStatement consulta	 = null;
        Usuario u		 	= null;
        ResultSet resultado = null;

        try {
            consulta 		= conexion.prepareStatement(sql.toString());
            consulta.setString(1, tipoDocumento);
            consulta.setString(2, documento);
            resultado		= consulta.executeQuery();

            if(resultado != null && resultado.next() ){
                u= new Usuario();
                u.setId(resultado.getInt("id"));
                u.setNombres(resultado.getString("nombres"));
                u.setApellidos(resultado.getString("apellidos"));
                u.setUsuario(resultado.getString("usuario"));
                u.setClave(resultado.getString("clave"));
                u.setFechaCreado(resultado.getDate("fecha_creado"));
                u.setFechaNacimiento(resultado.getDate("fecha_nacimiento"));
                u.setTipoDocumento(resultado.getString("tipo_documento"));
                u.setTelefono(resultado.getString("telefono"));
                u.setCorreo(resultado.getString("correo"));
                u.setDireccion(resultado.getString("direccion"));
                u.setCiudad(resultado.getString("ciudad"));
                u.setRolId(resultado.getInt("rol_id"));
            }

            Conexion.cerrarConexion(conexion);
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return u;
    }
	
}
