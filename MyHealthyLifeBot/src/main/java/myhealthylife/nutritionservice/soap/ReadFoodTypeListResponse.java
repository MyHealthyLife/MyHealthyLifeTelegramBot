
package myhealthylife.nutritionservice.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per readFoodTypeListResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="readFoodTypeListResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="foodTypeList" type="{http://soap.nutritionservice.myhealthylife/}foodTypeList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readFoodTypeListResponse", propOrder = {
    "foodTypeList"
})
public class ReadFoodTypeListResponse {

    protected FoodTypeList foodTypeList;

    /**
     * Recupera il valore della proprietà foodTypeList.
     * 
     * @return
     *     possible object is
     *     {@link FoodTypeList }
     *     
     */
    public FoodTypeList getFoodTypeList() {
        return foodTypeList;
    }

    /**
     * Imposta il valore della proprietà foodTypeList.
     * 
     * @param value
     *     allowed object is
     *     {@link FoodTypeList }
     *     
     */
    public void setFoodTypeList(FoodTypeList value) {
        this.foodTypeList = value;
    }

}
