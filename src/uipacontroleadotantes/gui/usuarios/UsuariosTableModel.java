/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.gui.usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import uipacontroleadotantes.banco.usuarios.UsuariosBean;

/**
 *
 * @author mckatoo
 */
public class UsuariosTableModel extends AbstractTableModel {
    
    private final List<UsuariosBean> dados = new ArrayList<>();
    private final String[] colunas = {"CÓDIGO", "LOGIN"};
    
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
                return dados.get(rowIndex).getCodUsuario();
            case 1:
                return dados.get(rowIndex).getLogin();        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                dados.get(rowIndex).setCodUsuario(Integer.parseInt((String) aValue));
                break;
            case 1:
                dados.get(rowIndex).setLogin((String) aValue);
                break;
        }
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public void addRow(UsuariosBean usuario) {
        this.dados.add(usuario);
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
