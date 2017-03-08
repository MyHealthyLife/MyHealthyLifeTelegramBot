
package myhealthylife.nutritionservice.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per readFoodListResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="readFoodListResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="foodList" type="{http://soap.nutritionservice.myhealthylife/}foodList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readFoodListResponse", propOrder = {
    "foodList"
})
public class ReadFoodListResponse {

    protected FoodList foodList;

    /**
     * Recupera il valore della proprietà foodList.
     * 
     * @return
     *     possible object is
     *     {@link FoodList }
     *     
     */
    public FoodList getFoodList() {
        return foodList;
    }

    /**
     * Imposta il valore della proprietà foodList.
     * 
     * @param value
     *     allowed object is
     *     {@link FoodList }
     *     
     */
    public void setFoodList(FoodList value) {
        this.foodList = value;
    }

}
