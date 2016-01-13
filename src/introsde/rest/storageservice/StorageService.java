package introsde.rest.storageservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.ejb.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import org.json.*;

import introsde.assignment.soap.Goal;
import introsde.assignment.soap.LifeStatus;
import introsde.assignment.soap.MeasureDefinition;
import introsde.assignment.soap.ParseException_Exception;
import introsde.assignment.soap.People;
import introsde.assignment.soap.People_Service;
import introsde.assignment.soap.Person;


@Stateless // will work only inside a Java EE application
@LocalBean // will work only inside a Java EE application
@Path("/storeservice")
public class StorageService {

	//Getting a picture from instagram
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getPicture")
    public Response getPicture() throws ClientProtocolException, IOException {
    	
    	String ENDPOINT = "https://blooming-taiga-5051.herokuapp.com/adapter/getPictureUrl";

    	String jsonResponse;
    	
    	DefaultHttpClient client = new DefaultHttpClient();
    	HttpGet request = new HttpGet(ENDPOINT);
    	HttpResponse response = client.execute(request);
    	
    	BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

    	StringBuffer result = new StringBuffer();
    	String line = "";
    	while ((line = rd.readLine()) != null) {
    	    result.append(line);
    	}

    	JSONObject o = new JSONObject(result.toString());
    	
    	if(response.getStatusLine().getStatusCode() == 200){
        	
        	String pictureUrl = "\"picture_url\":\"" +o.getString("standard_resolution_url")+"\"";
        	jsonResponse = "{"+pictureUrl+"}";
        	
        	return Response.ok(jsonResponse).build();
    	}
        	
    	return Response.status(204).build();
    }
    
    //Getting a motivation quote from quotesondesign
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getQuote")
    public Response getQuote() throws ClientProtocolException, IOException {
    	
    	String ENDPOINT = "https://blooming-taiga-5051.herokuapp.com/adapter/getQuote";

    	DefaultHttpClient client = new DefaultHttpClient();
    	HttpGet request = new HttpGet(ENDPOINT);
    	HttpResponse response = client.execute(request);
    	
    	BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

    	StringBuffer result = new StringBuffer();
    	String line = "";
    	while ((line = rd.readLine()) != null) {
    	    result.append(line);
    	}
    	
    	JSONObject o = new JSONObject(result.toString());
    	
    	if(response.getStatusLine().getStatusCode() == 200){
    		//Pay attention to the "". They cannot be decoded in a good way
    		String quote = "\"quote\":\"" +o.getString("quote").replaceAll("\"", "")+"\"";
        	String jsonResponse = "{"+quote+"}";
        	
        	return Response.ok(jsonResponse).build();
        }
    	
    	return Response.status(204).build();
    }
    
    //Getting the list of person in the LocalDatabase Service
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/personList")
    public Response getPersonList() throws ClientProtocolException, IOException {
    	
    	System.out.println("IN");
    	
    	People_Service service = new People_Service();
        People people = service.getPeopleImplPort();
        List<Person> pList = people.readPersonList();
        
        //System.out.println("-----"+pList.size());
    	
    	String buildXml = "<people>";
        
    	System.out.println(pList.size());
        for(int i = 0; i < pList.size(); i++){
        	buildXml += "<person><idPerson>"+pList.get(i).getIdPerson()+"</idPerson>";
        	buildXml +="<firstname>"+pList.get(i).getFirstname()+"</firstname>";
        	buildXml += "<lastname>"+pList.get(i).getLastname()+"</lastname>";
        	buildXml += "<birthdate>"+pList.get(i).getBirthdate()+"</birthdate>";
        	buildXml += "<email>"+pList.get(i).getEmail()+"</email>";
        	buildXml += "<username>"+pList.get(i).getUsername()+"</username>";
        	buildXml += "</person>";
        }
        
        buildXml += "</people>";
        
        JSONObject xmlJSONObj = XML.toJSONObject(buildXml);
        String jsonPrettyPrintString = xmlJSONObj.toString(4);
        System.out.println(jsonPrettyPrintString);
        
        if(pList.size() > 0){
        	return Response.ok(jsonPrettyPrintString).build();
        }
        
        return Response.status(204).build();
    }
    
    
    //Getting the person information in the LocalDatabase Service
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/readPerson/{personId}")
    public Response getPerson(@PathParam("personId") int idPerson) throws ClientProtocolException, IOException {
    	
    	People_Service service = new People_Service();
        People people = service.getPeopleImplPort();
        
        String buildXml;
        
        if(people.readPerson(idPerson) == null){
        	return Response.status(204).build();
        }
    	
    	buildXml = "<person><idPerson>"+people.readPerson(idPerson).getIdPerson()+"</idPerson>";
    	buildXml += "<firstname>"+people.readPerson(idPerson).getFirstname()+"</firstname>";
    	buildXml += "<lastname>"+people.readPerson(idPerson).getLastname()+"</lastname>";
    	buildXml += "<birthdate>"+people.readPerson(idPerson).getBirthdate()+"</birthdate>";
    	buildXml += "<email>"+people.readPerson(idPerson).getEmail()+"</email>";
    	buildXml += "<username>"+people.readPerson(idPerson).getUsername()+"</username>";
    	buildXml += "<currentHealth>";
    	
    	if(people.readPerson(idPerson).getCurrentHealth().getLifeStatus().size() > 0)
    	{
    		for(int k = 0; k < people.readPerson(idPerson).getCurrentHealth().getLifeStatus().size(); k++)
    		{
        		buildXml += "<lifeStatus>";
        		buildXml += "<idMeasure>"+people.readPerson(idPerson).getCurrentHealth().getLifeStatus().get(k).getIdMeasure()+"</idMeasure>";
        		buildXml += "<measureType>";
        		buildXml += "<idMeasureDef>"+people.readPerson(idPerson).getCurrentHealth().getLifeStatus().get(k).getMeasureType().getIdMeasureDef()+"</idMeasureDef>";
            	buildXml += "<measureName>"+people.readPerson(idPerson).getCurrentHealth().getLifeStatus().get(k).getMeasureType().getMeasureType()+"</measureName>";
            	buildXml += "<measureValueType>"+people.readPerson(idPerson).getCurrentHealth().getLifeStatus().get(k).getMeasureType().getMeasureValueType()+"</measureValueType>";
            	buildXml += "</measureType>";
            	buildXml += "<dateRegistered>"+people.readPerson(idPerson).getCurrentHealth().getLifeStatus().get(k).getDateRegistered()+"</dateRegistered>";
            	buildXml += "<measureValue>"+people.readPerson(idPerson).getCurrentHealth().getLifeStatus().get(k).getMeasureValue()+"</measureValue>";
            	buildXml += "</lifeStatus>";	
    		}
    	}
    	
    	buildXml += "</currentHealth>";
    	buildXml += "<Goals>";
    	
    	if(people.readPerson(idPerson).getGoals().getGoal().size() > 0)
    	{
    		for(int j = 0; j < people.readPerson(idPerson).getGoals().getGoal().size(); j++)
    		{
        		buildXml += "<Goal>";
        		buildXml += "<idGoal>"+people.readPerson(idPerson).getGoals().getGoal().get(j).getIdGoal()+"</idGoal>";
        		buildXml += "<measureType>";
        		buildXml += "<idMeasureDef>"+people.readPerson(idPerson).getGoals().getGoal().get(j).getMeasureType().getIdMeasureDef()+"</idMeasureDef>";
            	buildXml += "<measureName>"+people.readPerson(idPerson).getGoals().getGoal().get(j).getMeasureType().getMeasureType()+"</measureName>";
            	buildXml += "<measureValueType>"+people.readPerson(idPerson).getGoals().getGoal().get(j).getMeasureType().getMeasureValueType()+"</measureValueType>";
            	buildXml += "</measureType>";
        		//buildXml += "<startDate>"+people.readPerson(idPerson).getGoals().getGoal().get(j).getStartDate()+"</startDate>";
        		//buildXml += "<endDate>"+people.readPerson(idPerson).getGoals().getGoal().get(j).getEndDate()+"</endDate>";
        		buildXml += "<goalValue>"+people.readPerson(idPerson).getGoals().getGoal().get(j).getGoalValue()+"</goalValue>";
            	buildXml += "</Goal>";	
    		}
    	}
    	
    	buildXml += "</Goals></person>";
    	
    	JSONObject xmlJSONObj = XML.toJSONObject(buildXml);
        String jsonPrettyPrintString = xmlJSONObj.toString(4);
        
        return Response.ok(jsonPrettyPrintString).build();
    }

    //Getting the list of goals of a specific person in the LocalDatabaseService
    @GET
    @Path("/readGoals/{idPerson}")
    public Response getListGoals(@PathParam("idPerson") int idPerson) throws ClientProtocolException, IOException {
    	
    	People_Service service = new People_Service();
        People people = service.getPeopleImplPort();
        
        if(people.readPerson(idPerson) == null){
        	return Response.status(404).build();
        }
        
        String buildXml = "<goals>";
        
        System.out.println("size => "+people.readPerson(idPerson).getGoals().getGoal().size());
        
        if(people.readPerson(idPerson).getGoals().getGoal().size() > 0)
    	{
    		for(int k = 0; k < people.readPerson(idPerson).getGoals().getGoal().size(); k++)
    		{
        		buildXml += "<goal>";
        		buildXml += "<idGoal>"+people.readPerson(idPerson).getGoals().getGoal().get(k).getIdGoal()+"</idGoal>";
        		buildXml += "<measureType>";
        		buildXml += "<idMeasureDef>"+people.readPerson(idPerson).getGoals().getGoal().get(k).getMeasureType().getIdMeasureDef()+"</idMeasureDef>";
            	buildXml += "<measureName>"+people.readPerson(idPerson).getGoals().getGoal().get(k).getMeasureType().getMeasureType()+"</measureName>";
            	buildXml += "<measureValueType>"+people.readPerson(idPerson).getGoals().getGoal().get(k).getMeasureType().getMeasureValueType()+"</measureValueType>";
            	buildXml += "</measureType>";
            	//buildXml += "<startDate>"+people.readPerson(idPerson).getGoals().getGoal().get(k).getStartDate()+"</startDate>";
            	//buildXml += "<endDate>"+people.readPerson(idPerson).getGoals().getGoal().get(k).getEndDate()+"</endDate>";
            	buildXml += "<goalValue>"+people.readPerson(idPerson).getGoals().getGoal().get(k).getGoalValue()+"</goalValue>";
            	buildXml += "</goal>";	
    		}
    	}
        
        buildXml += "</goals>";
        
        JSONObject xmlJSONObj = XML.toJSONObject(buildXml);
        String jsonPrettyPrintString = xmlJSONObj.toString(4);
        
        return Response.ok(jsonPrettyPrintString).build();
    }
    
    
    @PUT
    @Path("/updateGoal/{idPerson}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateGoal(@PathParam("idPerson") int idPerson, Goal goal) throws IOException, ParseException_Exception {

    	People_Service service = new People_Service();
        People people = service.getPeopleImplPort();

    	if(people.readPerson(idPerson) == null){
        	return Response.status(404).build();
        }

    	MeasureDefinition md = new MeasureDefinition();
    	
    	md.setIdMeasureDef(goal.getMeasureType().getIdMeasureDef());
    	md.setMeasureType(goal.getMeasureType().getMeasureType());
    	md.setMeasureValueType(goal.getMeasureType().getMeasureValueType());
    	
    	Goal newGoal = new Goal();
    	newGoal.setGoalValue(goal.getGoalValue());
    	newGoal.setMeasureType(md);
    	
    	Goal updateSingleGoal = people.updatePersonGoal(idPerson, newGoal);
    	
    	if(updateSingleGoal.getIdGoal() == -1){
    		return Response.status(400).build();
    	}
    	
    	return Response.ok(updateSingleGoal).build();
    }
    
    
    @PUT
    @Path("/updateProfile/{idPerson}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateHealthProfile(@PathParam("idPerson") int idPerson, LifeStatus ls) throws IOException, ParseException_Exception {

    	People_Service service = new People_Service();
        People people = service.getPeopleImplPort();
        
        boolean find = false;
        String measure = "";
        int id = 0;
        int idMeasure = 0;
        
        if(people.readPerson(idPerson) == null){
        	return Response.status(404).build();
        }
        
        MeasureDefinition md = new MeasureDefinition();
        
        List<LifeStatus> lfList = people.readPerson(idPerson).getCurrentHealth().getLifeStatus();
        
        for (int i = 0; i < lfList.size(); i++){
        	if(lfList.get(i).getMeasureType().getIdMeasureDef() == ls.getMeasureType().getIdMeasureDef() || lfList.get(i).getMeasureType().getMeasureType().equals(ls.getMeasureType().getMeasureType())){
        		measure = lfList.get(i).getMeasureType().getMeasureType();
        		id = lfList.get(i).getIdMeasure();
        		idMeasure = ls.getMeasureType().getIdMeasureDef();
        		System.out.println("id => "+id);
        		find = true;
        	}
        }
        
        if(find == false){
        	return Response.status(404).build();
        }

        LifeStatus lf = new LifeStatus();

        md.setIdMeasureDef(idMeasure);
        md.setMeasureType(measure);
		
		lf.setMeasureType(md);
		lf.setMeasureValue(ls.getMeasureValue());
		lf.setDateRegistered(ls.getDateRegistered());
		lf.setIdMeasure(id);

        //Create a new history for the person
        people.savePersonMeasure(idPerson, lf);
        
        return Response.ok(lf).build();
    }
    
}