Meta:
@testid 1001
@sprint 001
@globalname sbux

Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development
					 
Scenario: when a user increases a counter, its value is increased by 1
Given a counter
And the counter has any integral value
When the user increases the counter
Then the value of the counter must be 1 greater than previous value

Examples:
|UserName|Password|
|vgantena|xxxxxxxx|