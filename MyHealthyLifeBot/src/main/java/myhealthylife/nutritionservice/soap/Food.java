
package myhealthylife.nutritionservice.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per food complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="food">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idFood" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="calories" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlType(name = "food", propOrder = {
    "idFood",
    "name",
    "calories",
    "foodType"
})
public class Food {

    protected long idFood;
    protected String name;
    protected Integer calories;
    protected FoodType foodType;

    /**
     * Recupera il valore della proprietà idFood.
     * 
     */
    public long getIdFood() {
        return idFood;
    }

    /**
     * Imposta il valore della proprietà idFood.
     * 
     */
    public void setIdFood(long value) {
        this.idFood = value;
    }

    /**
     * Recupera il valore della proprietà name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il valore della proprietà name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Recupera il valore della proprietà calories.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCalories() {
        return calories;
    }

    /**
     * Imposta il valore della proprietà calories.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCalories(Integer value) {
        this.calories = value;
    }

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
