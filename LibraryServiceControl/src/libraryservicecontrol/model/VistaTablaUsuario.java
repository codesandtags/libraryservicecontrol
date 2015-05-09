package libraryservicecontrol.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VistaTablaUsuario extends AbstractTableModel{

    private List<Usuario> usuarios;
            
    public VistaTablaUsuario(List<Usuario> usuarios) {
        this.usuarios = new ArrayList<Usuario>(usuarios);
    }
    
    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = "??";
        Usuario user = usuarios.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                value = user.getTipoDocumento();
                break;
            case 1:
                value = user.getNombreCompleto();
                break;
            case 2:
                value = user.getDireccion();
                break;
            case 3:
                value = user.getCorreo();
                break;
            case 4:
                value = user.getTelefono();
                break;
        }

        return value;

    }
}
