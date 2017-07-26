package core.steps;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
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
 
    @Then("the value of the counter must be $number greater than previous value")
    public void theValueOfTheCounterMust(@Named("number")int number) {
    	System.out.println("#validate Counter: After IncreaseCounter#" +counter + ", PreviousValue #" + previousValue);
        assertTrue(number == counter - previousValue);
    }
}