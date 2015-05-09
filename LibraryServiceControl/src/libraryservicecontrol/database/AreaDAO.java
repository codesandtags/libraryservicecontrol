package libraryservicecontrol.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libraryservicecontrol.model.Area;

public class AreaDAO extends ManejadorDAO<Area>{
	
    @Override
    public Area buscarPorId(Integer id) {
        StringBuilder sql 	= new StringBuilder("SELECT * FROM area WHERE id = ").append(id);
        ResultSet resultado = null;
        Area	area				= null;
        resultado 			= consultar(sql.toString());

        try {
                if(resultado != null && resultado.next() ){
                        area = new Area();
                        area.setId(resultado.getInt("id"));
                        area.setArea(resultado.getString("area"));
                }
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return area;
    }

    @Override
    public List<Area> buscarTodos() {
        StringBuilder sql 		= new StringBuilder("SELECT * FROM area ");
        ResultSet resultado 	= null;
        List<Area> areas		= new ArrayList<Area>();
        resultado 			= consultar(sql.toString());

        try {
            while(resultado != null && resultado.next() ){
                Area area = new Area();
                area.setId(resultado.getInt("id"));
                area.setArea(resultado.getString("Area"));
                areas.add(area);
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return areas;
    }
    
    public Area buscarPorArea(String nombreArea){
        StringBuilder sql = new StringBuilder("SELECT * FROM area WHERE area=? ");
        Connection conexion = Conexion.getConexion();
        PreparedStatement consulta	 = null;
        Area area	= null;
        ResultSet resultado = null;

        try {
            consulta 		= conexion.prepareStatement(sql.toString());
            consulta.setString(1, nombreArea);
            resultado		= consulta.executeQuery();

            if(resultado != null && resultado.next() ){
                area= new Area();
                area.setId(resultado.getInt("id"));
                area.setArea(resultado.getString("area"));
            }

            Conexion.cerrarConexion(conexion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return area;
    }

}
