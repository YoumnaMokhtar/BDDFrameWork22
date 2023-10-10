Feature: Validating places Api

Scenario Outline: verify is place being added successfully
    Given add place palyload with "<name>" and "<language>"and"<Address>"
    When use calls "/maps/api/place/add/json" with post http request
    Then the response api  call is sucess and status code is 200
     And "status" in response body is "OK"
     Then "scope" in response body is "APP"
  Examples:
    | name   | language | Address |
    | Ahouse |Enlgish   |World cross center |
     |Bhouse  |Spanish   |ITI center         |


