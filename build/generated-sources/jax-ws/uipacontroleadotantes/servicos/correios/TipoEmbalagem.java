
package uipacontroleadotantes.servicos.correios;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tipoEmbalagem.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoEmbalagem">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DE"/>
 *     &lt;enumeration value="PD"/>
 *     &lt;enumeration value="RL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoEmbalagem")
@XmlEnum
public enum TipoEmbalagem {

    DE,
    PD,
    RL;

    public String value() {
        return name();
    }

    public static TipoEmbalagem fromValue(String v) {
        return valueOf(v);
    }

}
