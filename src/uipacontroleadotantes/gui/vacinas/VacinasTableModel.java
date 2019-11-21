/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.gui.vacinas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import uipacontroleadotantes.banco.adotantes.AdotantesBean;

/**
 *
 * @author mckatoo
 */
public class VacinasTableModel extends AbstractTableModel {
    
    private final List<AdotantesBean> dados = new ArrayList<>();
    private final String[] colunas = {"CÓDIGO", "NOME", "TELEFONE", "CELULAR", "ENDEREÇO", "BAIRRO", "CIDADE", "UF", "CPF", "RG", "SEXO", "EMAIL"};
    
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
                return dados.get(rowIndex).getCodAdotante();
            case 1:
                return dados.get(rowIndex).getNome();
            case 2:
                return dados.get(rowIndex).getTelefone();
            case 3:
                return dados.get(rowIndex).getCelular();
            case 4:
                return dados.get(rowIndex).getEndereco();
            case 5:
                return dados.get(rowIndex).getBairro();
            case 6:
                return dados.get(rowIndex).getCidade();
            case 7:
                return dados.get(rowIndex).getUF();
            case 8:
                return dados.get(rowIndex).getCPF();
            case 9:
                return dados.get(rowIndex).getRG();
            case 10:
                return "" + Arrays.toString(dados.get(rowIndex).getSexo()).charAt(1);
            case 11:
                return dados.get(rowIndex).getEmail();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                dados.get(rowIndex).setCodAdotante(Integer.parseInt((String) aValue));
                break;
            case 1:
                dados.get(rowIndex).setNome((String) aValue);
                break;
            case 2:
                dados.get(rowIndex).setTelefone((String) aValue);
                break;
            case 3:
                dados.get(rowIndex).setCelular((String) aValue);
                break;
            case 4:
                dados.get(rowIndex).setEndereco((String) aValue);
                break;
            case 5:
                dados.get(rowIndex).setBairro((String) aValue);
                break;
            case 6:
                dados.get(rowIndex).setCidade((String) aValue);
                break;
            case 7:
                dados.get(rowIndex).setUF((String) aValue);
                break;
            case 8:
                dados.get(rowIndex).setCPF((String) aValue);
                break;
            case 9:
                dados.get(rowIndex).setRG((String) aValue);
                break;
            case 10: 
                dados.get(rowIndex).setSexo(((String) aValue).toCharArray());
                break;
            case 11:
                dados.get(rowIndex).setEmail((String) aValue);
                break;
        }
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public void addRow(AdotantesBean adotante) {
        this.dados.add(adotante);
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
