package restassuredAssnt;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//import org.testng.annotations.Test;

public class Helper {
	
	public static int help(String req,String url) {
		if(req.equals("GET")) {
			return get(url);
		}
		else if(req.equals("POST")) {
			return post(url);
		}
		else if(req.equals("PUT")) {
			return put(url);
		}
		else if(req.equals("DELETE")) {
			return delete(url);
		}
			return 0;
	}
	
	public static int get(String url) {
		Response actualResponse=RestAssured.get(url);
		int actual=actualResponse.getStatusCode();
		return actual;
	}
	public static int post(String url) {
		int id=15410;
		RequestSpecification req = RestAssured.given();
		req.header("Content-Type", "application/json");
		
		JSONObject jsonobj = new JSONObject();
		 jsonobj.put("FirstName", "Virender"); 
		 jsonobj.put("LastName", "Singh");
		 jsonobj.put("UserName", "sdimpleuser2dd2011");
		 jsonobj.put("Password", "password1");
		 jsonobj.put("Email",  "sample2ee26d9@gmail.com");
		 
		 req.body(jsonobj.toString());
		 Response response = req.post(url);
		 int actual=response.getStatusCode();
		 return actual;
	}
	public static int put(String url) {
		int id=15410;
		RequestSpecification req = RestAssured.given();
		req.header("Content-Type", "application/json");
		
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("FirstName", "nehal"); 
		 jsonobj.put("LastName", "aggarwal");
		 jsonobj.put("UserName", "sdimpleuser2dd2011");
		 jsonobj.put("Password", "password1");
		 jsonobj.put("Email",  "sample2ee26d9@gmail.com");
		 
		 req.body(jsonobj.toString());
		 Response response = req.put(url+"/update/"+id);
		 int actual=response.getStatusCode();
		 return actual;
	}
	public static int delete(String url) {
		int id=15410;
		RequestSpecification req = RestAssured.given();
		req.header("Content-Type", "application/json");
		
		 Response response = req.delete(url+"/delete/"+id);
		 int actual=response.getStatusCode();
		 return actual;
	}

}
