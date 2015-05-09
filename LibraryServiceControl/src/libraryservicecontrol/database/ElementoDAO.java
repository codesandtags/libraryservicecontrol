package libraryservicecontrol.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import libraryservicecontrol.model.Elemento;
import libraryservicecontrol.model.Usuario;

public class ElementoDAO extends ManejadorDAO<Elemento>{
    
    private CategoriaDAO categoriaDao;

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
    
    
    
    public List<Elemento> buscarPorCategoriaCodigoNombre(String categoria, String codigo, String nombre){
        StringBuilder sql 	= new StringBuilder("SELECT * FROM elemento WHERE 1=1 ");
        Connection conexion	= Conexion.getConexion();
        PreparedStatement consulta	 = null;
        List<Elemento> elementos	= new ArrayList<Elemento>();
        ResultSet resultado = null;
        categoriaDao = new CategoriaDAO();
        Integer categoriaId = null;
        
        if(categoria != null && !categoria.isEmpty()){
            sql.append(" AND categoria_id=?");
            categoriaId = categoriaDao.buscarPorCategoria(categoria).getId();
        }
        if(codigo != null && !codigo.isEmpty()){
            sql.append(" AND id=?");
        }
        if(nombre != null && !nombre.isEmpty()){
            sql.append(" AND titulo LIKE ?");
        }

        try {
            consulta 		= conexion.prepareStatement(sql.toString());
            consulta.setInt(1, categoriaId);
            System.out.println(" => " + sql);
            System.out.println("categoria => " + categoriaId);
            System.out.println("nombre => " + nombre);
            System.out.println("codigo => " + codigo);
            
            if(codigo != null && !codigo.isEmpty()){
                consulta.setString(2, codigo);
                if(nombre != null && !nombre.isEmpty()){
                    consulta.setString(3,  "%" + nombre + "%");
                }
            }else if(nombre != null && !nombre.isEmpty()){
                consulta.setString(2, "%" + nombre + "%");
            }
            
            resultado = consulta.executeQuery();

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
            Conexion.cerrarConexion(conexion);
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return elementos;
    }
}
