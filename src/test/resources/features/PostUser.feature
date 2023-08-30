Feature: Create user

  @PostUser
  Scenario: Create user successfully.
    When I consume the endpoint and I send the user information
    Then I can validate the response service code