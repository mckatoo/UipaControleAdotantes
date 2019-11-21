/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.gui.vacinas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import uipacontroleadotantes.banco.vacinas.VacinasBean;

/**
 *
 * @author mckatoo
 */
public class VacinasTableModel extends AbstractTableModel {
    
    private final List<VacinasBean> dados = new ArrayList<>();
    private final String[] colunas = {"CÓDIGO", "NOME", "DESCRICAO"};
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return dados.get(rowIndex).getCodVacina();
            case 1:
                return dados.get(rowIndex).getNome();
            case 2:
                return dados.get(rowIndex).getDescricao();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                dados.get(rowIndex).setCodVacina(Integer.parseInt((String) aValue));
                break;
            case 1:
                dados.get(rowIndex).setNome((String) aValue);
                break;
            case 2:
                dados.get(rowIndex).setDescricao((String) aValue);
                break;
        }
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public void addRow(VacinasBean vacina) {
        this.dados.add(vacina);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void limpar(){
        for (int i = this.getRowCount() - 1; i > -1; i--) {
            this.removeRow(i);
        }
    }
    
}
