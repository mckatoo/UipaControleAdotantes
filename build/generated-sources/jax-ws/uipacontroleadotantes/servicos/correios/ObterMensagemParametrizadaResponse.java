
package uipacontroleadotantes.servicos.correios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de obterMensagemParametrizadaResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="obterMensagemParametrizadaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}mensagemParametrizadaTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obterMensagemParametrizadaResponse", propOrder = {
    "_return"
})
public class ObterMensagemParametrizadaResponse {

    @XmlElement(name = "return")
    protected MensagemParametrizadaTO _return;

    /**
     * Obtém o valor da propriedade return.
     * 
     * @return
     *     possible object is
     *     {@link MensagemParametrizadaTO }
     *     
     */
    public MensagemParametrizadaTO getReturn() {
        return _return;
    }

    /**
     * Define o valor da propriedade return.
     * 
     * @param value
     *     allowed object is
     *     {@link MensagemParametrizadaTO }
     *     
     */
    public void setReturn(MensagemParametrizadaTO value) {
        this._return = value;
    }

}
