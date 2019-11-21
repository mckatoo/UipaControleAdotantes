/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.uteis;

import java.util.Arrays;

/**
 *
 * @author mckatoo
 */
public class Sanitize {
    public static String sanitizar(char[] in) {
        String inString = Arrays.toString(in);
        String out = inString.replace("[", "");
        out = out.replace(", ", "");
        out = out.replace("]", "");
        return out;
    }
}
