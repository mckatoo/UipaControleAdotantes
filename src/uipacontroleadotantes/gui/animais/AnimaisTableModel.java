/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.gui.animais;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import uipacontroleadotantes.banco.animais.AnimaisBean;

/**
 *
 * @author mckatoo
 */
public class AnimaisTableModel extends AbstractTableModel {
    
    private final List<AnimaisBean> dados = new ArrayList<>();
    private final String[] colunas = {"CÓDIGO", "NOME", "ESPÉCIE", "SEXO", "DATA DE NASC.", "PORTE", "CASTRADO", "ADOTANTE", "DATA DE ADOÇÃO"};
    
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
                return dados.get(rowIndex).getCodAnimal();
            case 1:
                return dados.get(rowIndex).getNome();
            case 2:
                return dados.get(rowIndex).getEspecie();
            case 3:
                return "" + Arrays.toString(dados.get(rowIndex).getSexo()).charAt(1);
            case 4:
                return dados.get(rowIndex).getDataNasc();
            case 5:
                return "" + Arrays.toString(dados.get(rowIndex).getPorte()).charAt(1);
            case 6:
                return "" + Arrays.toString(dados.get(rowIndex).getCastrado()).charAt(1);
            case 7:
                return dados.get(rowIndex).getCodAdotante();
            case 8:
                return dados.get(rowIndex).getDataAdocao();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                dados.get(rowIndex).setCodAnimal(Integer.parseInt((String) aValue));
                break;
            case 1:
                dados.get(rowIndex).setNome((String) aValue);
                break;
            case 2:
                dados.get(rowIndex).setEspecie((String) aValue);
                break;
            case 3:
                dados.get(rowIndex).setSexo(((String) aValue).toCharArray());
                break;
            case 4:
                dados.get(rowIndex).setDataNasc(LocalDate.parse((String) aValue));
                break;
            case 5:
                dados.get(rowIndex).setPorte(((String) aValue).toCharArray());
                break;
            case 6:
                dados.get(rowIndex).setCastrado(((String) aValue).toCharArray());
                break;
            case 7:
                dados.get(rowIndex).setCodAdotante(Integer.parseInt((String) aValue));
                break;
            case 8: 
                dados.get(rowIndex).setDataNasc(LocalDate.parse((String) aValue));
                break;
        }
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public void addRow(AnimaisBean animal) {
        this.dados.add(animal);
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
