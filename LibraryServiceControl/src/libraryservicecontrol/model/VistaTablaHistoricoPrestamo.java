package libraryservicecontrol.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VistaTablaHistoricoPrestamo extends AbstractTableModel{

    private List<HistoricoPrestamo> historicos;
            
    public VistaTablaHistoricoPrestamo(List<HistoricoPrestamo> historicos) {
        this.historicos = new ArrayList<HistoricoPrestamo>(historicos);
    }
    
    @Override
    public int getRowCount() {
        return historicos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = "??";
        HistoricoPrestamo historico = historicos.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                value = historico.getElementoAsociado().getId();
                break;
            case 1:
                value = historico.getElementoAsociado().getTitulo();
                break;
            case 2:
                value = historico.getFechaPrestamo();
                break;
            case 3:
                value = historico.getEstado();
                break;
            case 4:
                value = (historico.getEstado().equals("PRESTADO"))? "DEVOLVER" : "DEVUELTO";
                break;
        }

        return value;

    }
}
