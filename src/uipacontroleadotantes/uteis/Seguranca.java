/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.uteis;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mckatoo
 */
public class Seguranca {

    public static String criptografar(String senha) {
        MessageDigest md;
        String senhaCriptografada = "";
        try {
            md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
            senhaCriptografada = hash.toString(256);
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Seguranca.class.getName()).log(Level.SEVERE, null, ex);
        }
        return senhaCriptografada;
    }
    
}
