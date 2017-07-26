package core.steps;

import org.jbehave.core.annotations.*;
public class MySteps{
	
    private String api;
    private String nonExistentUser;
    private int githubResponseCode;
	
	
	@Given("step represents a precondition to an event <UserName>")
	public void givenStepRepresentsAPreconditionToAnEventUserName(@Named("UserName") String  UserName){
		System.out.println("#######Do Somthing in step-1" + "UserName : " + UserName);
	}
	
	
	@When("step represents the occurrence of the event")
	public void whenStepRepresentsTheOccurrenceOfTheEvent(){
		System.out.println("#######Do Somthing in step-2");
	}
	
	@Then("step represents the outcome of the event")
	public void steprepresentstheoutcomeoftheevent(){
		System.out.println("#######Do Somthing in step-3");
	}
	 

}