/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.gui.renderers;

import java.awt.Component;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author mckatoo
 */
public class DefaultCellRenderer extends DefaultTableCellRenderer {
    
    NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof BigDecimal) {
            this.setText(numberFormatter.format((BigDecimal) value));
        }else if (value instanceof LocalDate) {
            String valueString = ((LocalDate) value).format(dateTimeFormatter);
            this.setText(valueString);
        }else if (value instanceof LocalTime) {
            this.setText(((LocalTime) value).format(dateTimeFormatter));
        }else if (value instanceof LocalDateTime) {
            this.setText(((LocalDateTime) value).format(dateTimeFormatter));
        }
        return this;
    }
    
}
