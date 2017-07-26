package com.restful;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.Matchers;
import org.junit.Test;

import com.Utils.GitHubUser;
import com.Utils.RetrieveUtil;

public class RestFulApiTest {
	
	
	@Test
	public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
	  throws ClientProtocolException, IOException {
	   // Given
	   String name = RandomStringUtils.randomAlphabetic( 8 );
	   System.out.println("Random Name :" + name);
	   HttpUriRequest request = new HttpGet( "https://api.github.com/users/" + name );
	 
	   // When
	   HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	   	System.out.println(httpResponse.getStatusLine());
	   // Then
	   assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
	}
	@Test
	public void
	  givenUserExists_whenUserInformationIsRetrieved_thenRetrievedResourceIsCorrect()
	  throws ClientProtocolException, IOException {
	  
	    // Given
	    HttpUriRequest request = new HttpGet( "https://api.github.com/users/vgantena-rythmos" );
	 
	    // When
	    HttpResponse response = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    GitHubUser resource = RetrieveUtil.retrieveResourceFromResponse(response, GitHubUser.class);
	    System.out.println(resource.toString());
	    assertThat( "vgantena-rythmos", Matchers.is( resource.getLogin() ) );
	}
	
	@Test
	public void
	givenRequestWithNoAcceptHeader_whenRequestIsExecuted_thenDefaultResponseContentTypeIsJson()
	  throws ClientProtocolException, IOException {
	  
	   // Given
	   String jsonMimeType = "application/json";
	   HttpUriRequest request = new HttpGet( "https://api.github.com/users/eugenp" );
	 
	   // When
	   HttpResponse response = HttpClientBuilder.create().build().execute( request );
	 
	   // Then
	   String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
	   System.out.println("Mime Type :" + mimeType);
	   
	   assertEquals( jsonMimeType, mimeType );
	}

}
