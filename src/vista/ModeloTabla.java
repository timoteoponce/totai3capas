/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author oscarribera
 */
public class ModeloTabla extends AbstractTableModel {

    private String[] nombreColumnas = new String[]{};
    private List<Object[]> datos = new ArrayList<Object[]>();

    public ModeloTabla(String[] nombreColumnas) {
        this.nombreColumnas = nombreColumnas;
    }

    public int getRowCount() {
        return datos.size();
    }

    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] fila = datos.get(rowIndex);
        return fila[columnIndex];
    }

    public Class getColumnClass(int columna) {
        return getValueAt(0, columna).getClass();
    }

    public boolean isCellEditable(int fila, int columna) {
        return false;
    }
    
    public void clear(){
        this.datos.clear();
        fireTableDataChanged();
    }
    
    public void setDatos(List<Object[]> datos){
        this.datos.clear();
        this.datos.addAll(datos);
        fireTableDataChanged();
    }

    public Object[] getRow(int indexFila) {
        return this.datos.get(indexFila); 
    }
}
