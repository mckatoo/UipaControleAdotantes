/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.uteis;

import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Milton Carlos Katoo
 */
public class FormManager {
    private static FormManager instance;
    
    private static FormManager getInstance() {
        if (instance == null) {
            instance = new FormManager();
        }
        return instance;
    }
    
    public static void openInternalForm(JInternalFrame jinternalframe, JDesktopPane jdesktoppane) throws PropertyVetoException {
        jinternalframe.setMaximum(true);
        ((BasicInternalFrameUI)jinternalframe.getUI()).setNorthPane(null);
        jdesktoppane.add(jinternalframe);
        jinternalframe.setVisible(true);
    }
    
    public static void openForm(JFrame jframe) throws PropertyVetoException {
        jframe.setExtendedState(jframe.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        jframe.setVisible(true);
    }
}
