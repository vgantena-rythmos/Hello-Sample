Meta:
@testid 1003
@sprint 001
@globalname sbux


Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development
	
					 
Scenario: when a user checks a non-existent user on github, github would respond 'not found'
 
Given github user profile api
And a random non-existent username
When I look for the random user via the api
Then github respond: 404 not found
When I look for eugenp1 via the api
Then github respond: 404 not found
When I look for <UserName> via the api
Then github respond: 404 not found

Examples:
|profileApi|UserName|
|"https://api.github.com/users/%s";|vgantena|
