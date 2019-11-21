/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.uteis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mckatoo
 */
public class Validador {
    public static boolean emailValido(String email) {
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
