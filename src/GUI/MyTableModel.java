package GUI;

import Data.Criteria;
import Data.Reliability;
import Data.Subcontractor;
import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by fab on 14.02.2017.
 */
public class MyTableModel implements TableModel {
    private Set<TableModelListener> listeners = new HashSet<>();
    private List<Subcontractor> sub;

    public MyTableModel(List<Subcontractor> sub) {
        this.sub = sub;
    }

    @Override
    public int getRowCount() {
        return  sub.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "Name";
            case 1:
                return "Price";
            case 2:
                return "Time";
            case 3:
                return "Quality";
            case 4:
                return "Opportunities";
            case 5:
                return "Safety";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return Integer.class;
            case 2:
                return Integer.class;
            case 3:
                return Integer.class;
            case 4:
                return Integer.class;
            case 5:
                return Double.class;
        }
        return Integer.class;
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
                return c.getPrice();
            case 2:
                return c.getTime();
            case 3:
                return c.getQuality();
            case 4:
                return c.getOpportunities();
            case 5:
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
