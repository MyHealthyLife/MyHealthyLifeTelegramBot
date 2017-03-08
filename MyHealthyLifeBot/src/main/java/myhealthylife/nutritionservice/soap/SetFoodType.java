
package myhealthylife.nutritionservice.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per setFoodType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="setFoodType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="foodId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="typeId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setFoodType", propOrder = {
    "foodId",
    "typeId"
})
public class SetFoodType {

    protected long foodId;
    protected long typeId;

    /**
     * Recupera il valore della proprietà foodId.
     * 
     */
    public long getFoodId() {
        return foodId;
    }

    /**
     * Imposta il valore della proprietà foodId.
     * 
     */
    public void setFoodId(long value) {
        this.foodId = value;
    }

    /**
     * Recupera il valore della proprietà typeId.
     * 
     */
    public long getTypeId() {
        return typeId;
    }

    /**
     * Imposta il valore della proprietà typeId.
     * 
     */
    public void setTypeId(long value) {
        this.typeId = value;
    }

}
