
package uipacontroleadotantes.servicos.correios;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de servicoERP complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="servicoERP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataAtualizacao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datajAtualizacao" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="descricao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="horajAtualizacao" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="servicoSigep" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}servicoSigep" minOccurs="0"/>
 *         &lt;element name="servicosAdicionais" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}servicoAdicionalERP" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="tipo1Codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipo1Descricao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipo2Codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipo2Descricao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vigencia" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}vigenciaERP" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "servicoERP", propOrder = {
    "codigo",
    "dataAtualizacao",
    "datajAtualizacao",
    "descricao",
    "horajAtualizacao",
    "id",
    "servicoSigep",
    "servicosAdicionais",
    "tipo1Codigo",
    "tipo1Descricao",
    "tipo2Codigo",
    "tipo2Descricao",
    "vigencia"
})
public class ServicoERP {

    protected String codigo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataAtualizacao;
    protected Integer datajAtualizacao;
    protected String descricao;
    protected Integer horajAtualizacao;
    protected long id;
    protected ServicoSigep servicoSigep;
    @XmlElement(nillable = true)
    protected List<ServicoAdicionalERP> servicosAdicionais;
    protected String tipo1Codigo;
    protected String tipo1Descricao;
    protected String tipo2Codigo;
    protected String tipo2Descricao;
    protected VigenciaERP vigencia;

    /**
     * Obtém o valor da propriedade codigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o valor da propriedade codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Obtém o valor da propriedade dataAtualizacao.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataAtualizacao() {
        return dataAtualizacao;
    }

    /**
     * Define o valor da propriedade dataAtualizacao.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataAtualizacao(XMLGregorianCalendar value) {
        this.dataAtualizacao = value;
    }

    /**
     * Obtém o valor da propriedade datajAtualizacao.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDatajAtualizacao() {
        return datajAtualizacao;
    }

    /**
     * Define o valor da propriedade datajAtualizacao.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDatajAtualizacao(Integer value) {
        this.datajAtualizacao = value;
    }

    /**
     * Obtém o valor da propriedade descricao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define o valor da propriedade descricao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricao(String value) {
        this.descricao = value;
    }

    /**
     * Obtém o valor da propriedade horajAtualizacao.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHorajAtualizacao() {
        return horajAtualizacao;
    }

    /**
     * Define o valor da propriedade horajAtualizacao.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHorajAtualizacao(Integer value) {
        this.horajAtualizacao = value;
    }

    /**
     * Obtém o valor da propriedade id.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade servicoSigep.
     * 
     * @return
     *     possible object is
     *     {@link ServicoSigep }
     *     
     */
    public ServicoSigep getServicoSigep() {
        return servicoSigep;
    }

    /**
     * Define o valor da propriedade servicoSigep.
     * 
     * @param value
     *     allowed object is
     *     {@link ServicoSigep }
     *     
     */
    public void setServicoSigep(ServicoSigep value) {
        this.servicoSigep = value;
    }

    /**
     * Gets the value of the servicosAdicionais property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the servicosAdicionais property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServicosAdicionais().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServicoAdicionalERP }
     * 
     * 
     */
    public List<ServicoAdicionalERP> getServicosAdicionais() {
        if (servicosAdicionais == null) {
            servicosAdicionais = new ArrayList<ServicoAdicionalERP>();
        }
        return this.servicosAdicionais;
    }

    /**
     * Obtém o valor da propriedade tipo1Codigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo1Codigo() {
        return tipo1Codigo;
    }

    /**
     * Define o valor da propriedade tipo1Codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo1Codigo(String value) {
        this.tipo1Codigo = value;
    }

    /**
     * Obtém o valor da propriedade tipo1Descricao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo1Descricao() {
        return tipo1Descricao;
    }

    /**
     * Define o valor da propriedade tipo1Descricao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo1Descricao(String value) {
        this.tipo1Descricao = value;
    }

    /**
     * Obtém o valor da propriedade tipo2Codigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo2Codigo() {
        return tipo2Codigo;
    }

    /**
     * Define o valor da propriedade tipo2Codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo2Codigo(String value) {
        this.tipo2Codigo = value;
    }

    /**
     * Obtém o valor da propriedade tipo2Descricao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo2Descricao() {
        return tipo2Descricao;
    }

    /**
     * Define o valor da propriedade tipo2Descricao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo2Descricao(String value) {
        this.tipo2Descricao = value;
    }

    /**
     * Obtém o valor da propriedade vigencia.
     * 
     * @return
     *     possible object is
     *     {@link VigenciaERP }
     *     
     */
    public VigenciaERP getVigencia() {
        return vigencia;
    }

    /**
     * Define o valor da propriedade vigencia.
     * 
     * @param value
     *     allowed object is
     *     {@link VigenciaERP }
     *     
     */
    public void setVigencia(VigenciaERP value) {
        this.vigencia = value;
    }

}
