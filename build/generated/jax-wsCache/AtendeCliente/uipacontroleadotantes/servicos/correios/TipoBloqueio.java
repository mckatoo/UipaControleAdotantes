
package uipacontroleadotantes.servicos.correios;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tipoBloqueio.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoBloqueio">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FRAUDE_BLOQUEIO"/>
 *     &lt;enumeration value="EXTRAVIO_VAREJO_PRE_INDENIZADO"/>
 *     &lt;enumeration value="EXTRAVIO_VAREJO_POS_INDENIZADO"/>
 *     &lt;enumeration value="EXTRAVIO_CORPORATIVO"/>
 *     &lt;enumeration value="INTERNACIONAL_LDI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoBloqueio")
@XmlEnum
public enum TipoBloqueio {

    FRAUDE_BLOQUEIO,
    EXTRAVIO_VAREJO_PRE_INDENIZADO,
    EXTRAVIO_VAREJO_POS_INDENIZADO,
    EXTRAVIO_CORPORATIVO,
    INTERNACIONAL_LDI;

    public String value() {
        return name();
    }

    public static TipoBloqueio fromValue(String v) {
        return valueOf(v);
    }

}
