package com.Utils;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RetrieveUtil {
    
    public static <T> T retrieveResourceFromResponse(HttpResponse response, Class<T> clazz) 
    		  throws IOException {
    		  
    		    String jsonFromResponse = EntityUtils.toString(response.getEntity());
    		    System.out.println(jsonFromResponse);
    		    ObjectMapper mapper = new ObjectMapper()
    		      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    		    return mapper.readValue(jsonFromResponse, clazz);
    		}
}