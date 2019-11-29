/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.uteis;

import cep.CEPBean;
import static cep.Cep.consultaCEP;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import org.json.JSONException;

/**
 *
 * @author mckatoo
 */
public class Cep {

    public static Future<CEPBean> consultaCepAsync(String cep) {
        return CompletableFuture.supplyAsync(() -> {
            CEPBean cepBean = null;
            try {
                cepBean = consultaCEP(cep);
            } catch (InterruptedException | ExecutionException | TimeoutException | JSONException ex) {
                java.util.logging.Logger.getLogger(Cep.class.getName()).log(Level.SEVERE, null, ex);
            }
            return cepBean;
        });
    }

}
