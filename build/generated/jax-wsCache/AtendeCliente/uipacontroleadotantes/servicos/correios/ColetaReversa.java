
package uipacontroleadotantes.servicos.correios;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de coletaReversa complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="coletaReversa">
 *   &lt;complexContent>
 *     &lt;extension base="{http://cliente.bean.master.sigep.bsb.correios.com.br/}coleta">
 *       &lt;sequence>
 *         &lt;element name="ag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ar" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cartao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="obj_col" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}objeto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="servico_adicional" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "coletaReversa", propOrder = {
    "ag",
    "ar",
    "cartao",
    "numero",
    "objCol",
    "servicoAdicional"
})
public class ColetaReversa
    extends Coleta
{

    protected String ag;
    protected Integer ar;
    protected String cartao;
    protected Integer numero;
    @XmlElement(name = "obj_col", nillable = true)
    protected List<Objeto> objCol;
    @XmlElement(name = "servico_adicional")
    protected String servicoAdicional;

    /**
     * Obtém o valor da propriedade ag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAg() {
        return ag;
    }

    /**
     * Define o valor da propriedade ag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAg(String value) {
        this.ag = value;
    }

    /**
     * Obtém o valor da propriedade ar.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAr() {
        return ar;
    }

    /**
     * Define o valor da propriedade ar.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAr(Integer value) {
        this.ar = value;
    }

    /**
     * Obtém o valor da propriedade cartao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCartao() {
        return cartao;
    }

    /**
     * Define o valor da propriedade cartao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCartao(String value) {
        this.cartao = value;
    }

    /**
     * Obtém o valor da propriedade numero.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Define o valor da propriedade numero.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumero(Integer value) {
        this.numero = value;
    }

    /**
     * Gets the value of the objCol property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objCol property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjCol().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Objeto }
     * 
     * 
     */
    public List<Objeto> getObjCol() {
        if (objCol == null) {
            objCol = new ArrayList<Objeto>();
        }
        return this.objCol;
    }

    /**
     * Obtém o valor da propriedade servicoAdicional.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServicoAdicional() {
        return servicoAdicional;
    }

    /**
     * Define o valor da propriedade servicoAdicional.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServicoAdicional(String value) {
        this.servicoAdicional = value;
    }

}
