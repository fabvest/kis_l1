package GUI;

import Data.Criteria;
import Data.Reliability;
import Data.Subcontractor;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by fab on 27.02.2017.
 */
public class ResultTableModel implements TableModel {
    private Set<TableModelListener> listeners = new HashSet<>();
    private List<Subcontractor> sub;

    public ResultTableModel(List<Subcontractor> sub){
        this.sub = sub;
    }


    @Override
    public int getRowCount() {
        return sub.size();
    }
    //TODO new model
    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "Name";
            case 1:
                return "Result";
            case 2:
                return "Criteria";
            case 3:
                return "Safety";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return Double.class;
            case 2:
                return Double.class;
            case 3:
                return Double.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Subcontractor s = sub.get(rowIndex);
        Criteria c = s.getCriteria();
        Reliability r = s.getReliability();
        switch (columnIndex){
            case 0:
                return s.getName();
            case 1:
                return s.getRang();
            case 2:
                return c.getCriteria();
            case 3:
                return r.getResult();

        }
        return "";
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
