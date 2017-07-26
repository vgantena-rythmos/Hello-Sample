package core.steps;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class StorySteps {
    private int counter;
    private int previousValue;
 
    @Given("a counter")
    public void aCounter() {
    }
 
    @Given("the counter has any integral value")
    public void counterHasAnyIntegralValue() {
        counter = new Random().nextInt();
        previousValue = counter;
    }
 
    @When("the user increases the counter")
    public void increasesTheCounter() {
        counter++;
    }
 
    @Then("the value of the counter must be 1 greater than previous value")
    public void theValueOfTheCounterMustBe1Greater() {
    	System.out.println("Counter #" +counter + "  PreviousValue #" + previousValue);
        assertTrue(1 == counter - previousValue);
    }
    
    @When("step represents the occurrence of the event")
	public void whenStepRepresentsTheOccurrenceOfTheEvent(){
		 System.out.println("Step-------------------One");
	}
	
	@Given("step represents a precondition to an event")
	public void givenStepRepresentsAPreconditionToAnEvent(){
		 System.out.println("Step-------------------Two");
	}
	
	@Then("step represents the outcome of the event")
	public void thenStepRepresentsTheOutcomeOfTheEvent(){
		 System.out.println("Step-------------------Three");
	}
}