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
                if( !(ex instanceof InterruptedException) || !(ex instanceof ExecutionException) || !(ex instanceof TimeoutException) || !(ex instanceof JSONException)){
                    String msg = "Excessão não esperada.\n"
                            + "Por favor, abra uma issue no repositório https://github.com/mckatoo/consultaCepJava\n,ou,\n"
                            + "Entre em contato com o desenvolvedor pelo email: mckatoo@gmail.com\n"
                            + "Obrigado.";
                    System.out.println(msg);
                }
            }
            return cepBean;
        });
    }
    
}
