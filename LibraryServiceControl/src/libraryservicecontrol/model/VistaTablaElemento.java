package libraryservicecontrol.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;

public class VistaTablaElemento extends AbstractTableModel{

    private List<Elemento> elementos;
            
    public VistaTablaElemento(List<Elemento> elementos) {
        this.elementos = new ArrayList<Elemento>(elementos);
    }
    
    @Override
    public int getRowCount() {
        return elementos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = "??";
        Elemento elemento = elementos.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                value = elemento.getId();
                break;
            case 1:
                value = elemento.getTitulo();
                break;
            case 2:
                value = new JCheckBox();
                break;
            case 3:
                value = elemento.getObservaciones();
                break;
        }

        return value;

    }
}
