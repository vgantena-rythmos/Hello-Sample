package core.steps;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jbehave.core.annotations.*;
public class RestfulSteps{

	private String api;
	private String nonExistentUser;
	private int githubResponseCode;

	@When("I look for the random user via the api")
	public void whenILookForTheRandomUserViaTheApi() throws ClientProtocolException, IOException{
		HttpUriRequest request = new HttpGet( "https://api.github.com/users/" + nonExistentUser );	 
		System.out.println("Non-Existing Random Name: " + nonExistentUser);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		System.out.println("HttpResponse : " + httpResponse.getStatusLine());
		githubResponseCode = httpResponse.getStatusLine().getStatusCode();
	}

	@When("I look for $username via the api")
	public void whenILookForEugenp1ViaTheApi(@Named("username") String UserName){
		nonExistentUser = UserName;
	}

	@Given("a random non-existent username")
	public void givenARandomNonexistentUsername(){
		nonExistentUser = RandomStringUtils.randomAlphabetic( 8 );
	}

	@Then("github respond: 404 not found")
	public void thenGithubRespond404NotFound11(){
		assertThat(githubResponseCode, equalTo(HttpStatus.SC_NOT_FOUND)); 
	}

	
	@Given("github user profile api")
	public void givenGithubUserProfileApi(@Named("profileApi") String profileApi){
		api = profileApi ;
	}

	@When("I look for <UserName> via the api")
	public void whenILookForEugenp2ViaTheApi(@Named("username") String UserName){
		nonExistentUser = UserName; 
	}
}