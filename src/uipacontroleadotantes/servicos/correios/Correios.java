/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.servicos.correios;

/**
 *
 * @author mckatoo
 */
public class Correios {

    public static EnderecoERP consultaCEP(String cep) throws SigepClienteException, SQLException_Exception {
        uipacontroleadotantes.servicos.correios.AtendeClienteService service = new uipacontroleadotantes.servicos.correios.AtendeClienteService();
        uipacontroleadotantes.servicos.correios.AtendeCliente port = service.getAtendeClientePort();
        return port.consultaCEP(cep);
    }
    
}
