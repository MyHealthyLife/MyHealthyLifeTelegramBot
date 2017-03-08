
package myhealthylife.nutritionservice.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per createFoodTypeResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="createFoodTypeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="foodType" type="{http://soap.nutritionservice.myhealthylife/}foodType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createFoodTypeResponse", propOrder = {
    "foodType"
})
public class CreateFoodTypeResponse {

    protected FoodType foodType;

    /**
     * Recupera il valore della proprietà foodType.
     * 
     * @return
     *     possible object is
     *     {@link FoodType }
     *     
     */
    public FoodType getFoodType() {
        return foodType;
    }

    /**
     * Imposta il valore della proprietà foodType.
     * 
     * @param value
     *     allowed object is
     *     {@link FoodType }
     *     
     */
    public void setFoodType(FoodType value) {
        this.foodType = value;
    }

}
