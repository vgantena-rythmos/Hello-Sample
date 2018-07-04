#Test Case Design, guidelines & Standards
Test Case writing is a major activity and considered as one of the most important part of testing. It is used by the Testing team, development team as well as the management, it means that test cases clarify what needs to be done to test a system.

### Test Case Design
1. As far as possible, write test cases in such a way that you test only one thing at a time. Do not overlap or complicate test cases. Attempt to make your test cases ‘atomic’.
2. Ensure that all positive scenarios and negative scenarios are covered.
3. Write in simple and easy to understand to user's.
4. Use exact and consistent names (of forms, fields, etc).

### Characteristics of a good test case:
* Accurate: Exacts the purpose.
* Economical: No unnecessary steps or words.
* Traceable: Capable of being traced to requirements.
* Repeatable: Can be used to perform the test over and over.
* Reusable: Can be reused if necessary.

### Test Case Format & Fields
* **Test Case ID:-** Each Test case should have Unique ID. Test management tool will generate these test case IDs automatically.
* **Title:-** It should be short brief about functionality has to be test. Ex. Verify 'TC Expected Results' when 'TC Execution Conditions'.
* **Template:-** Its a mandatory field. it holds the value as format of test case which should be 'Text' format.
* **Type:-** Its mandatory field. User can choose value as type of test case. Ex. API, Functional
* **Priority:-** Its mandatory field. Based on functionality and test steps choose priority. Ex. High, Medium & Low
* **Estimate:-** Its optional field, will describe about estimation of test case.
* **References:-** Its optional filed, map if you've requirement id's (ideally it would be accepts git issue's id)
* **Automation Type:-** Its optional. for now it would be blank.
* **Status:-** Its mandatory field. it holds status of test case design. Ex. in progress, submitted for review & approved.
* **Complexity:-** Its mandatory field. Based on functionality and test steps choose priority like High, Medium & Low
* **Content-Type:-** Its optional field and specific to API test cases to define type of request content type.
* **Description:-** Its mandatory field. Describe what the scenario will accomplish with brief information of the test case functionality.
* **Preconditions:-** Its mandatory field. Any prerequisites or preconditions that must be fulfilled prior to executing the test. Places required precondition in a bullet-point list.
* **Steps:-** Its mandatory field. Mention the test steps in detail and write in the order in which requires to be executed. This is a numbered list. 
* **Expected Result:-**  Its mandatory field. What do you expect to happen when you execute this scenario? What will be true after the scenario is executed according to expectations? This is a bullet-point list.
* **Payload/Body:-** Its optional and specific to API test cases. This field holds JSON data which is required to make a request with minium fields. This JSON schema field values needs to define as below -
1. If field accept random data, then we can define field value with datatype and length of the chars. Ex. `{'name': '#string(1,50)'}`
2. If field accept pre-defined data from API System, then we can define field value with respective pre-defined values with case-sensitive(if required). Ex. `'discountType': { "resources": "Member", "permissions": ["read"] }`
