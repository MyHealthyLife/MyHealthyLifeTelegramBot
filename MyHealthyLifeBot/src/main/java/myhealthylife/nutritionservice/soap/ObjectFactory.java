
package myhealthylife.nutritionservice.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the myhealthylife.nutritionservice.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindFoodByTypeFilteredByCalories_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "findFoodByTypeFilteredByCalories");
    private final static QName _ReadFoodTypeList_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "readFoodTypeList");
    private final static QName _UpdateFoodTypeResponse_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "updateFoodTypeResponse");
    private final static QName _FindFoodByTypeFiltered_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "findFoodByTypeFiltered");
    private final static QName _CreateFoodTypeResponse_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "createFoodTypeResponse");
    private final static QName _FoodType_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "foodType");
    private final static QName _DeleteFoodResponse_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "deleteFoodResponse");
    private final static QName _FindFoodByTypeResponse_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "findFoodByTypeResponse");
    private final static QName _ReadFoodResponse_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "readFoodResponse");
    private final static QName _CreateFood_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "createFood");
    private final static QName _Food_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "food");
    private final static QName _ReadFood_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "readFood");
    private final static QName _UpdateFood_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "updateFood");
    private final static QName _ReadFoodListResponse_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "readFoodListResponse");
    private final static QName _FindFoodByTypeFilteredResponse_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "findFoodByTypeFilteredResponse");
    private final static QName _UpdateFoodType_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "updateFoodType");
    private final static QName _ReadFoodTypeListResponse_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "readFoodTypeListResponse");
    private final static QName _SetFoodTypeResponse_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "setFoodTypeResponse");
    private final static QName _FindFoodByType_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "findFoodByType");
    private final static QName _DeleteFoodType_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "deleteFoodType");
    private final static QName _Foods_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "foods");
    private final static QName _UpdateFoodResponse_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "updateFoodResponse");
    private final static QName _ReadFoodList_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "readFoodList");
    private final static QName _CreateFoodResponse_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "createFoodResponse");
    private final static QName _SetFoodType_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "setFoodType");
    private final static QName _DeleteFoodTypeResponse_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "deleteFoodTypeResponse");
    private final static QName _FindFoodByTypeFilteredByCaloriesResponse_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "findFoodByTypeFilteredByCaloriesResponse");
    private final static QName _FoodTypes_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "foodTypes");
    private final static QName _DeleteFood_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "deleteFood");
    private final static QName _CreateFoodType_QNAME = new QName("http://soap.nutritionservice.myhealthylife/", "createFoodType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: myhealthylife.nutritionservice.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindFoodByType }
     * 
     */
    public FindFoodByType createFindFoodByType() {
        return new FindFoodByType();
    }

    /**
     * Create an instance of {@link DeleteFoodType }
     * 
     */
    public DeleteFoodType createDeleteFoodType() {
        return new DeleteFoodType();
    }

    /**
     * Create an instance of {@link FoodList }
     * 
     */
    public FoodList createFoodList() {
        return new FoodList();
    }

    /**
     * Create an instance of {@link UpdateFoodResponse }
     * 
     */
    public UpdateFoodResponse createUpdateFoodResponse() {
        return new UpdateFoodResponse();
    }

    /**
     * Create an instance of {@link ReadFoodList }
     * 
     */
    public ReadFoodList createReadFoodList() {
        return new ReadFoodList();
    }

    /**
     * Create an instance of {@link CreateFoodResponse }
     * 
     */
    public CreateFoodResponse createCreateFoodResponse() {
        return new CreateFoodResponse();
    }

    /**
     * Create an instance of {@link SetFoodType }
     * 
     */
    public SetFoodType createSetFoodType() {
        return new SetFoodType();
    }

    /**
     * Create an instance of {@link DeleteFoodTypeResponse }
     * 
     */
    public DeleteFoodTypeResponse createDeleteFoodTypeResponse() {
        return new DeleteFoodTypeResponse();
    }

    /**
     * Create an instance of {@link FindFoodByTypeFilteredByCaloriesResponse }
     * 
     */
    public FindFoodByTypeFilteredByCaloriesResponse createFindFoodByTypeFilteredByCaloriesResponse() {
        return new FindFoodByTypeFilteredByCaloriesResponse();
    }

    /**
     * Create an instance of {@link FoodTypeList }
     * 
     */
    public FoodTypeList createFoodTypeList() {
        return new FoodTypeList();
    }

    /**
     * Create an instance of {@link DeleteFood }
     * 
     */
    public DeleteFood createDeleteFood() {
        return new DeleteFood();
    }

    /**
     * Create an instance of {@link CreateFoodType }
     * 
     */
    public CreateFoodType createCreateFoodType() {
        return new CreateFoodType();
    }

    /**
     * Create an instance of {@link ReadFood }
     * 
     */
    public ReadFood createReadFood() {
        return new ReadFood();
    }

    /**
     * Create an instance of {@link UpdateFood }
     * 
     */
    public UpdateFood createUpdateFood() {
        return new UpdateFood();
    }

    /**
     * Create an instance of {@link ReadFoodListResponse }
     * 
     */
    public ReadFoodListResponse createReadFoodListResponse() {
        return new ReadFoodListResponse();
    }

    /**
     * Create an instance of {@link FindFoodByTypeFilteredResponse }
     * 
     */
    public FindFoodByTypeFilteredResponse createFindFoodByTypeFilteredResponse() {
        return new FindFoodByTypeFilteredResponse();
    }

    /**
     * Create an instance of {@link UpdateFoodType }
     * 
     */
    public UpdateFoodType createUpdateFoodType() {
        return new UpdateFoodType();
    }

    /**
     * Create an instance of {@link ReadFoodTypeListResponse }
     * 
     */
    public ReadFoodTypeListResponse createReadFoodTypeListResponse() {
        return new ReadFoodTypeListResponse();
    }

    /**
     * Create an instance of {@link SetFoodTypeResponse }
     * 
     */
    public SetFoodTypeResponse createSetFoodTypeResponse() {
        return new SetFoodTypeResponse();
    }

    /**
     * Create an instance of {@link UpdateFoodTypeResponse }
     * 
     */
    public UpdateFoodTypeResponse createUpdateFoodTypeResponse() {
        return new UpdateFoodTypeResponse();
    }

    /**
     * Create an instance of {@link FindFoodByTypeFiltered }
     * 
     */
    public FindFoodByTypeFiltered createFindFoodByTypeFiltered() {
        return new FindFoodByTypeFiltered();
    }

    /**
     * Create an instance of {@link CreateFoodTypeResponse }
     * 
     */
    public CreateFoodTypeResponse createCreateFoodTypeResponse() {
        return new CreateFoodTypeResponse();
    }

    /**
     * Create an instance of {@link FoodType }
     * 
     */
    public FoodType createFoodType() {
        return new FoodType();
    }

    /**
     * Create an instance of {@link DeleteFoodResponse }
     * 
     */
    public DeleteFoodResponse createDeleteFoodResponse() {
        return new DeleteFoodResponse();
    }

    /**
     * Create an instance of {@link FindFoodByTypeResponse }
     * 
     */
    public FindFoodByTypeResponse createFindFoodByTypeResponse() {
        return new FindFoodByTypeResponse();
    }

    /**
     * Create an instance of {@link ReadFoodResponse }
     * 
     */
    public ReadFoodResponse createReadFoodResponse() {
        return new ReadFoodResponse();
    }

    /**
     * Create an instance of {@link CreateFood }
     * 
     */
    public CreateFood createCreateFood() {
        return new CreateFood();
    }

    /**
     * Create an instance of {@link Food }
     * 
     */
    public Food createFood() {
        return new Food();
    }

    /**
     * Create an instance of {@link FindFoodByTypeFilteredByCalories }
     * 
     */
    public FindFoodByTypeFilteredByCalories createFindFoodByTypeFilteredByCalories() {
        return new FindFoodByTypeFilteredByCalories();
    }

    /**
     * Create an instance of {@link ReadFoodTypeList }
     * 
     */
    public ReadFoodTypeList createReadFoodTypeList() {
        return new ReadFoodTypeList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFoodByTypeFilteredByCalories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "findFoodByTypeFilteredByCalories")
    public JAXBElement<FindFoodByTypeFilteredByCalories> createFindFoodByTypeFilteredByCalories(FindFoodByTypeFilteredByCalories value) {
        return new JAXBElement<FindFoodByTypeFilteredByCalories>(_FindFoodByTypeFilteredByCalories_QNAME, FindFoodByTypeFilteredByCalories.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadFoodTypeList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "readFoodTypeList")
    public JAXBElement<ReadFoodTypeList> createReadFoodTypeList(ReadFoodTypeList value) {
        return new JAXBElement<ReadFoodTypeList>(_ReadFoodTypeList_QNAME, ReadFoodTypeList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFoodTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "updateFoodTypeResponse")
    public JAXBElement<UpdateFoodTypeResponse> createUpdateFoodTypeResponse(UpdateFoodTypeResponse value) {
        return new JAXBElement<UpdateFoodTypeResponse>(_UpdateFoodTypeResponse_QNAME, UpdateFoodTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFoodByTypeFiltered }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "findFoodByTypeFiltered")
    public JAXBElement<FindFoodByTypeFiltered> createFindFoodByTypeFiltered(FindFoodByTypeFiltered value) {
        return new JAXBElement<FindFoodByTypeFiltered>(_FindFoodByTypeFiltered_QNAME, FindFoodByTypeFiltered.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateFoodTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "createFoodTypeResponse")
    public JAXBElement<CreateFoodTypeResponse> createCreateFoodTypeResponse(CreateFoodTypeResponse value) {
        return new JAXBElement<CreateFoodTypeResponse>(_CreateFoodTypeResponse_QNAME, CreateFoodTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FoodType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "foodType")
    public JAXBElement<FoodType> createFoodType(FoodType value) {
        return new JAXBElement<FoodType>(_FoodType_QNAME, FoodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFoodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "deleteFoodResponse")
    public JAXBElement<DeleteFoodResponse> createDeleteFoodResponse(DeleteFoodResponse value) {
        return new JAXBElement<DeleteFoodResponse>(_DeleteFoodResponse_QNAME, DeleteFoodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFoodByTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "findFoodByTypeResponse")
    public JAXBElement<FindFoodByTypeResponse> createFindFoodByTypeResponse(FindFoodByTypeResponse value) {
        return new JAXBElement<FindFoodByTypeResponse>(_FindFoodByTypeResponse_QNAME, FindFoodByTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadFoodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "readFoodResponse")
    public JAXBElement<ReadFoodResponse> createReadFoodResponse(ReadFoodResponse value) {
        return new JAXBElement<ReadFoodResponse>(_ReadFoodResponse_QNAME, ReadFoodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateFood }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "createFood")
    public JAXBElement<CreateFood> createCreateFood(CreateFood value) {
        return new JAXBElement<CreateFood>(_CreateFood_QNAME, CreateFood.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Food }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "food")
    public JAXBElement<Food> createFood(Food value) {
        return new JAXBElement<Food>(_Food_QNAME, Food.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadFood }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "readFood")
    public JAXBElement<ReadFood> createReadFood(ReadFood value) {
        return new JAXBElement<ReadFood>(_ReadFood_QNAME, ReadFood.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFood }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "updateFood")
    public JAXBElement<UpdateFood> createUpdateFood(UpdateFood value) {
        return new JAXBElement<UpdateFood>(_UpdateFood_QNAME, UpdateFood.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadFoodListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "readFoodListResponse")
    public JAXBElement<ReadFoodListResponse> createReadFoodListResponse(ReadFoodListResponse value) {
        return new JAXBElement<ReadFoodListResponse>(_ReadFoodListResponse_QNAME, ReadFoodListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFoodByTypeFilteredResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "findFoodByTypeFilteredResponse")
    public JAXBElement<FindFoodByTypeFilteredResponse> createFindFoodByTypeFilteredResponse(FindFoodByTypeFilteredResponse value) {
        return new JAXBElement<FindFoodByTypeFilteredResponse>(_FindFoodByTypeFilteredResponse_QNAME, FindFoodByTypeFilteredResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFoodType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "updateFoodType")
    public JAXBElement<UpdateFoodType> createUpdateFoodType(UpdateFoodType value) {
        return new JAXBElement<UpdateFoodType>(_UpdateFoodType_QNAME, UpdateFoodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadFoodTypeListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "readFoodTypeListResponse")
    public JAXBElement<ReadFoodTypeListResponse> createReadFoodTypeListResponse(ReadFoodTypeListResponse value) {
        return new JAXBElement<ReadFoodTypeListResponse>(_ReadFoodTypeListResponse_QNAME, ReadFoodTypeListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetFoodTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "setFoodTypeResponse")
    public JAXBElement<SetFoodTypeResponse> createSetFoodTypeResponse(SetFoodTypeResponse value) {
        return new JAXBElement<SetFoodTypeResponse>(_SetFoodTypeResponse_QNAME, SetFoodTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFoodByType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "findFoodByType")
    public JAXBElement<FindFoodByType> createFindFoodByType(FindFoodByType value) {
        return new JAXBElement<FindFoodByType>(_FindFoodByType_QNAME, FindFoodByType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFoodType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "deleteFoodType")
    public JAXBElement<DeleteFoodType> createDeleteFoodType(DeleteFoodType value) {
        return new JAXBElement<DeleteFoodType>(_DeleteFoodType_QNAME, DeleteFoodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FoodList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "foods")
    public JAXBElement<FoodList> createFoods(FoodList value) {
        return new JAXBElement<FoodList>(_Foods_QNAME, FoodList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFoodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "updateFoodResponse")
    public JAXBElement<UpdateFoodResponse> createUpdateFoodResponse(UpdateFoodResponse value) {
        return new JAXBElement<UpdateFoodResponse>(_UpdateFoodResponse_QNAME, UpdateFoodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadFoodList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "readFoodList")
    public JAXBElement<ReadFoodList> createReadFoodList(ReadFoodList value) {
        return new JAXBElement<ReadFoodList>(_ReadFoodList_QNAME, ReadFoodList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateFoodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "createFoodResponse")
    public JAXBElement<CreateFoodResponse> createCreateFoodResponse(CreateFoodResponse value) {
        return new JAXBElement<CreateFoodResponse>(_CreateFoodResponse_QNAME, CreateFoodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetFoodType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "setFoodType")
    public JAXBElement<SetFoodType> createSetFoodType(SetFoodType value) {
        return new JAXBElement<SetFoodType>(_SetFoodType_QNAME, SetFoodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFoodTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "deleteFoodTypeResponse")
    public JAXBElement<DeleteFoodTypeResponse> createDeleteFoodTypeResponse(DeleteFoodTypeResponse value) {
        return new JAXBElement<DeleteFoodTypeResponse>(_DeleteFoodTypeResponse_QNAME, DeleteFoodTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFoodByTypeFilteredByCaloriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "findFoodByTypeFilteredByCaloriesResponse")
    public JAXBElement<FindFoodByTypeFilteredByCaloriesResponse> createFindFoodByTypeFilteredByCaloriesResponse(FindFoodByTypeFilteredByCaloriesResponse value) {
        return new JAXBElement<FindFoodByTypeFilteredByCaloriesResponse>(_FindFoodByTypeFilteredByCaloriesResponse_QNAME, FindFoodByTypeFilteredByCaloriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FoodTypeList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "foodTypes")
    public JAXBElement<FoodTypeList> createFoodTypes(FoodTypeList value) {
        return new JAXBElement<FoodTypeList>(_FoodTypes_QNAME, FoodTypeList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFood }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "deleteFood")
    public JAXBElement<DeleteFood> createDeleteFood(DeleteFood value) {
        return new JAXBElement<DeleteFood>(_DeleteFood_QNAME, DeleteFood.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateFoodType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.nutritionservice.myhealthylife/", name = "createFoodType")
    public JAXBElement<CreateFoodType> createCreateFoodType(CreateFoodType value) {
        return new JAXBElement<CreateFoodType>(_CreateFoodType_QNAME, CreateFoodType.class, null, value);
    }

}
