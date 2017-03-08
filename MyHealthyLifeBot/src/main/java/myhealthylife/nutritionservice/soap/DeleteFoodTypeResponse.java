
package myhealthylife.nutritionservice.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per deleteFoodTypeResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="deleteFoodTypeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idFoodType" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteFoodTypeResponse", propOrder = {
    "idFoodType"
})
public class DeleteFoodTypeResponse {

    protected long idFoodType;

    /**
     * Recupera il valore della proprietà idFoodType.
     * 
     */
    public long getIdFoodType() {
        return idFoodType;
    }

    /**
     * Imposta il valore della proprietà idFoodType.
     * 
     */
    public void setIdFoodType(long value) {
        this.idFoodType = value;
    }

}
