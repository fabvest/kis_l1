package GUI;

import Data.Criterion;
import Data.WorkValues;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fab on 17.04.2017.
 */
public class EndTable implements TableModel {
    private Set<TableModelListener> listeners = new HashSet<>();
    private ArrayList<WorkValues> list;
    private int[][] matr;

    public EndTable(ArrayList<WorkValues> list) {
        this.list = list;
    }

    public EndTable(int[][] matr) {
        this.matr = matr;
    }

    @Override
    public int getRowCount() {
        return matr.length;
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "  ";
            case 1:
                return "Р1";
            case 2:
                return "Р2";
            case 3:
                return "Р3";
            case 4:
                return "Р4";
            case 5:
                return "Р5";
            case 6:
                return "Р6";
            case 7:
                return "Р7";
            case 8:
                return "Р8";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0) return String.class;
        return Integer.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex){
            case 0:
                return Criterion.tableRowNames[rowIndex];
            case 1:
                return matr[rowIndex][columnIndex - 1];
            case 2:
                return matr[rowIndex][columnIndex - 1];
            case 3:
                return matr[rowIndex][columnIndex - 1];
            case 4:
                return matr[rowIndex][columnIndex - 1];
            case 5:
                return matr[rowIndex][columnIndex - 1];
            case 6:
                return matr[rowIndex][columnIndex - 1];
            case 7:
                return matr[rowIndex][columnIndex - 1];
            case 8:
                return matr[rowIndex][columnIndex - 1];
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }
}
