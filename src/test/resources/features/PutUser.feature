Feature: Update user

  @PutUser
  Scenario: Update user successfully.
    When I consume the endpoint and I send the User Information
    Then I can validate the response code