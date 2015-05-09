package libraryservicecontrol.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import libraryservicecontrol.model.Elemento;
import libraryservicecontrol.model.HistoricoPrestamo;

public class HistoricoPrestamoDAO extends ManejadorDAO<HistoricoPrestamo>{

    @Override
    public HistoricoPrestamo buscarPorId(Integer id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM historico_prestamo WHERE id = ").append(id);
        ResultSet resultado = null;
        HistoricoPrestamo historicoPrestamo = null;
        resultado 	   = consultar(sql.toString());
        try {
            if(resultado != null && resultado.next() ){
                historicoPrestamo = new HistoricoPrestamo();
                historicoPrestamo.setId(resultado.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historicoPrestamo;
    }

    @Override
    public List<HistoricoPrestamo> buscarTodos() {
        StringBuilder sql = new StringBuilder("SELECT * FROM historico_prestamo ");
        ResultSet resultado = null;
        List<HistoricoPrestamo> historicosPrestamo = new ArrayList<>();
        resultado 	   = consultar(sql.toString());
        try {
            if(resultado != null && resultado.next() ){
                HistoricoPrestamo historicoPrestamo = new HistoricoPrestamo();
                historicoPrestamo.setId(resultado.getInt("id"));
                historicosPrestamo.add(historicoPrestamo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historicosPrestamo;
    }
    
    public List<HistoricoPrestamo> buscarPorUsuario(Integer usuarioId){
        StringBuilder sql = new StringBuilder("SELECT  ");
        sql.append("hp.*, e.titulo, e.id as codigoElemento ");
        sql.append("FROM historico_prestamo hp ");
        sql.append("INNER JOIN elemento e ON e.id = hp.elemento_id ");
        sql.append("WHERE hp.usuario_id=? ");
        Connection conexion = Conexion.getConexion();
        PreparedStatement consulta	 = null;
        List<HistoricoPrestamo> historicosPrestamo= new ArrayList<>();
        ResultSet resultado = null;
        
        System.out.println(" => " + sql);
        try {
            consulta 		= conexion.prepareStatement(sql.toString());
            consulta.setInt(1, usuarioId);
            resultado		= consulta.executeQuery();

            while(resultado != null && resultado.next() ){
                HistoricoPrestamo historico= new HistoricoPrestamo();
                Elemento elemento = new Elemento();
                elemento.setId(resultado.getInt("codigoElemento"));
                elemento.setTitulo(resultado.getString("titulo"));
                
                historico.setId(resultado.getInt("id"));
                historico.setEstado(resultado.getString("estado"));
                historico.setFechaPrestamo(resultado.getDate("fecha_publicacion"));
                historico.setElementoAsociado(elemento);
                historicosPrestamo.add(historico);
            }

            Conexion.cerrarConexion(conexion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historicosPrestamo;
    }
    
    public Boolean crearHistorico(HistoricoPrestamo historico){
        Boolean isCreado    = false;
        StringBuilder sql 	= new StringBuilder("INSERT INTO historico_prestamo")
        .append("(elemento_id, usuario_id, fecha_publicacion, estado)  ")
        .append("VALUES (?,?,?,?) ");

        Connection conexion	 = Conexion.getConexion();
        PreparedStatement consulta	 = null;
        Integer insertados  = null;	

        try {
            consulta 		= conexion.prepareStatement(sql.toString());
            consulta.setInt(1, historico.getElementoId());
            consulta.setInt(2, historico.getUsuarioId());
            consulta.setDate(3, historico.getFechaPrestamo());
            consulta.setString(4, historico.getEstado());
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
