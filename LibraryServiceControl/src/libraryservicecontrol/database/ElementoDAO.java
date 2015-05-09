package libraryservicecontrol.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import libraryservicecontrol.model.Elemento;

public class ElementoDAO extends ManejadorDAO<Elemento>{

    @Override
    public Elemento buscarPorId(Integer id) {
        StringBuilder sql   = new StringBuilder("SELECT * FROM elemento WHERE id = ").append(id);
        ResultSet resultado = null;
        Elemento elemento   = null;
        resultado           = consultar(sql.toString());

        try {
            if(resultado != null && resultado.next() ){
                elemento = new Elemento();
                elemento.setId(resultado.getInt("id"));
                elemento.setTitulo(resultado.getString("titulo"));
                elemento.setAutor(resultado.getString("autor"));
                elemento.setEditorial(resultado.getString("editorial"));
                elemento.setFechaPublicacion(resultado.getDate("fecha_publicacion"));
                elemento.setObservaciones(resultado.getString("titulo"));
                elemento.setCategoriaId(resultado.getInt("categoria_id"));
                elemento.setAreaId(resultado.getInt("area_id"));
                elemento.setGeneroId(resultado.getInt("genero_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return elemento;
    }

    @Override
    public List<Elemento> buscarTodos() {
        StringBuilder sql 	= new StringBuilder("SELECT * FROM elemento ");
        ResultSet resultado 	= null;
        List<Elemento> elementos= new ArrayList<Elemento>();
        resultado 		= consultar(sql.toString());

        try {
            while(resultado != null && resultado.next() ){
                Elemento elemento = new Elemento();
                elemento.setId(resultado.getInt("id"));
                elemento.setTitulo(resultado.getString("titulo"));
                elemento.setAutor(resultado.getString("autor"));
                elemento.setEditorial(resultado.getString("editorial"));
                elemento.setFechaPublicacion(resultado.getDate("fecha_publicacion"));
                elemento.setObservaciones(resultado.getString("titulo"));
                elemento.setCategoriaId(resultado.getInt("categoria_id"));
                elemento.setAreaId(resultado.getInt("area_id"));
                elemento.setGeneroId(resultado.getInt("genero_id"));
                elementos.add(elemento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return elementos;
    }
    
    public Boolean crearElemento(Elemento elemento){

        Boolean isCreado    = false;
        StringBuilder sql 	= new StringBuilder("INSERT INTO elemento ")
        .append("(titulo, autor, editorial, fecha_publicacion, observaciones, categoria_id, area_id, genero_id) ")
        .append("VALUES (?,?,?,?,?,?,?,?) ");

        Connection conexion	 = Conexion.getConexion();
        PreparedStatement consulta	 = null;
        Integer insertados  = null;	

        try {
            consulta 		= conexion.prepareStatement(sql.toString());
            consulta.setString(1, elemento.getTitulo());
            consulta.setString(2, elemento.getAutor());
            consulta.setString(3, elemento.getEditorial());
            consulta.setDate(4, (Date) elemento.getFechaPublicacion());
            consulta.setString(5, elemento.getObservaciones());
            consulta.setInt(6, elemento.getCategoriaId());
            consulta.setInt(7, elemento.getAreaId());
            consulta.setInt(8, elemento.getGeneroId());
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
}
