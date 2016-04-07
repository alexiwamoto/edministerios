package com.eministerios.www.business.workerUi.list.model;

import com.eministerios.www.business.entity.domain.Worker;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by alexandre on 15/03/16.
 */
public class WorkerTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<Worker> rows;

    private String[] columns = new String[]{"Nome:", "Sobrenome:", "Email:", "Profissão:"};

    public WorkerTableModel() {
        rows = new ArrayList<Worker>();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public String getColumnName(int indexCol) {
        return columns[indexCol];
    }

    @Override
    public Class<?> getColumnClass(int indexCol) {
        switch (indexCol) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("A coluna com o \u00EDndice:" + indexCol + " n\u00E3o existe!");
        }
    }

    @Override
    public Object getValueAt(int indexRow, int indexCol) {
        Worker worker = rows.get(indexRow);
        switch (indexCol) {
            case 0:
                return worker.getName();
            case 1:
                return worker.getLastname();
            case 2:
                return worker.getEmail1();
            case 3:
                return worker.getProfession();
            default:
                throw new IndexOutOfBoundsException("A coluna com o \u00EDndice:" + indexCol + " n\u00E3o existe!");
        }
    }

    public void setValueAt(Object value, int indexRow, int indexCol) {
        switch (indexCol) {
            case 4:

                break;
        }
        fireTableRowsUpdated(0, rows.size() - 1);
    }

    public Worker getItem(int indexRow) {
        return rows.get(indexRow);
    }

    public void removeItem(int indexRow) {
        rows.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    public void addItem(Worker worker) {
        rows.add(worker);
        int lastIndex = getRowCount() - 1;
        fireTableRowsInserted(lastIndex, lastIndex);
    }

    public void addItems(Collection<Worker> workers) {
        if (workers != null) {
            int oldSize = getRowCount();
            rows.addAll(workers);
            fireTableRowsInserted(oldSize, getRowCount() - 1);
        }
    }

    public Collection<Worker> getAllItems(){
        return rows;
    }

    public void clear() {
        rows.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return rows.isEmpty();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 4) return true;
        return false;
    }
}
