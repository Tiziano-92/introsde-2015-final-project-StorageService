
package introsde.assignment.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the introsde.assignment.soap package. 
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

    private final static QName _ReadPersonList_QNAME = new QName("http://soap.assignment.introsde/", "readPersonList");
    private final static QName _ReadPersonGoals_QNAME = new QName("http://soap.assignment.introsde/", "readPersonGoals");
    private final static QName _ReadPersonGoalsResponse_QNAME = new QName("http://soap.assignment.introsde/", "readPersonGoalsResponse");
    private final static QName _ParseException_QNAME = new QName("http://soap.assignment.introsde/", "ParseException");
    private final static QName _ReadPersonListResponse_QNAME = new QName("http://soap.assignment.introsde/", "readPersonListResponse");
    private final static QName _ReadPersonResponse_QNAME = new QName("http://soap.assignment.introsde/", "readPersonResponse");
    private final static QName _UpdatePersonGoal_QNAME = new QName("http://soap.assignment.introsde/", "updatePersonGoal");
    private final static QName _SavePersonMeasure_QNAME = new QName("http://soap.assignment.introsde/", "savePersonMeasure");
    private final static QName _UpdatePersonGoalResponse_QNAME = new QName("http://soap.assignment.introsde/", "updatePersonGoalResponse");
    private final static QName _ReadPerson_QNAME = new QName("http://soap.assignment.introsde/", "readPerson");
    private final static QName _SavePersonMeasureResponse_QNAME = new QName("http://soap.assignment.introsde/", "savePersonMeasureResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: introsde.assignment.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link SavePersonMeasureResponse }
     * 
     */
    public SavePersonMeasureResponse createSavePersonMeasureResponse() {
        return new SavePersonMeasureResponse();
    }

    /**
     * Create an instance of {@link ReadPerson }
     * 
     */
    public ReadPerson createReadPerson() {
        return new ReadPerson();
    }

    /**
     * Create an instance of {@link UpdatePersonGoalResponse }
     * 
     */
    public UpdatePersonGoalResponse createUpdatePersonGoalResponse() {
        return new UpdatePersonGoalResponse();
    }

    /**
     * Create an instance of {@link SavePersonMeasure }
     * 
     */
    public SavePersonMeasure createSavePersonMeasure() {
        return new SavePersonMeasure();
    }

    /**
     * Create an instance of {@link UpdatePersonGoal }
     * 
     */
    public UpdatePersonGoal createUpdatePersonGoal() {
        return new UpdatePersonGoal();
    }

    /**
     * Create an instance of {@link ReadPersonResponse }
     * 
     */
    public ReadPersonResponse createReadPersonResponse() {
        return new ReadPersonResponse();
    }

    /**
     * Create an instance of {@link ReadPersonListResponse }
     * 
     */
    public ReadPersonListResponse createReadPersonListResponse() {
        return new ReadPersonListResponse();
    }

    /**
     * Create an instance of {@link ReadPersonGoalsResponse }
     * 
     */
    public ReadPersonGoalsResponse createReadPersonGoalsResponse() {
        return new ReadPersonGoalsResponse();
    }

    /**
     * Create an instance of {@link ReadPersonGoals }
     * 
     */
    public ReadPersonGoals createReadPersonGoals() {
        return new ReadPersonGoals();
    }

    /**
     * Create an instance of {@link ParseException }
     * 
     */
    public ParseException createParseException() {
        return new ParseException();
    }

    /**
     * Create an instance of {@link ReadPersonList }
     * 
     */
    public ReadPersonList createReadPersonList() {
        return new ReadPersonList();
    }

    /**
     * Create an instance of {@link LifeStatus }
     * 
     */
    public LifeStatus createLifeStatus() {
        return new LifeStatus();
    }

    /**
     * Create an instance of {@link Goal }
     * 
     */
    public Goal createGoal() {
        return new Goal();
    }

    /**
     * Create an instance of {@link MeasureDefinition }
     * 
     */
    public MeasureDefinition createMeasureDefinition() {
        return new MeasureDefinition();
    }

    /**
     * Create an instance of {@link Person.CurrentHealth }
     * 
     */
    public Person.CurrentHealth createPersonCurrentHealth() {
        return new Person.CurrentHealth();
    }

    /**
     * Create an instance of {@link Person.Goals }
     * 
     */
    public Person.Goals createPersonGoals() {
        return new Person.Goals();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.assignment.introsde/", name = "readPersonList")
    public JAXBElement<ReadPersonList> createReadPersonList(ReadPersonList value) {
        return new JAXBElement<ReadPersonList>(_ReadPersonList_QNAME, ReadPersonList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoals }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.assignment.introsde/", name = "readPersonGoals")
    public JAXBElement<ReadPersonGoals> createReadPersonGoals(ReadPersonGoals value) {
        return new JAXBElement<ReadPersonGoals>(_ReadPersonGoals_QNAME, ReadPersonGoals.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoalsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.assignment.introsde/", name = "readPersonGoalsResponse")
    public JAXBElement<ReadPersonGoalsResponse> createReadPersonGoalsResponse(ReadPersonGoalsResponse value) {
        return new JAXBElement<ReadPersonGoalsResponse>(_ReadPersonGoalsResponse_QNAME, ReadPersonGoalsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.assignment.introsde/", name = "ParseException")
    public JAXBElement<ParseException> createParseException(ParseException value) {
        return new JAXBElement<ParseException>(_ParseException_QNAME, ParseException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.assignment.introsde/", name = "readPersonListResponse")
    public JAXBElement<ReadPersonListResponse> createReadPersonListResponse(ReadPersonListResponse value) {
        return new JAXBElement<ReadPersonListResponse>(_ReadPersonListResponse_QNAME, ReadPersonListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.assignment.introsde/", name = "readPersonResponse")
    public JAXBElement<ReadPersonResponse> createReadPersonResponse(ReadPersonResponse value) {
        return new JAXBElement<ReadPersonResponse>(_ReadPersonResponse_QNAME, ReadPersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonGoal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.assignment.introsde/", name = "updatePersonGoal")
    public JAXBElement<UpdatePersonGoal> createUpdatePersonGoal(UpdatePersonGoal value) {
        return new JAXBElement<UpdatePersonGoal>(_UpdatePersonGoal_QNAME, UpdatePersonGoal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavePersonMeasure }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.assignment.introsde/", name = "savePersonMeasure")
    public JAXBElement<SavePersonMeasure> createSavePersonMeasure(SavePersonMeasure value) {
        return new JAXBElement<SavePersonMeasure>(_SavePersonMeasure_QNAME, SavePersonMeasure.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonGoalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.assignment.introsde/", name = "updatePersonGoalResponse")
    public JAXBElement<UpdatePersonGoalResponse> createUpdatePersonGoalResponse(UpdatePersonGoalResponse value) {
        return new JAXBElement<UpdatePersonGoalResponse>(_UpdatePersonGoalResponse_QNAME, UpdatePersonGoalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.assignment.introsde/", name = "readPerson")
    public JAXBElement<ReadPerson> createReadPerson(ReadPerson value) {
        return new JAXBElement<ReadPerson>(_ReadPerson_QNAME, ReadPerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavePersonMeasureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.assignment.introsde/", name = "savePersonMeasureResponse")
    public JAXBElement<SavePersonMeasureResponse> createSavePersonMeasureResponse(SavePersonMeasureResponse value) {
        return new JAXBElement<SavePersonMeasureResponse>(_SavePersonMeasureResponse_QNAME, SavePersonMeasureResponse.class, null, value);
    }

}
