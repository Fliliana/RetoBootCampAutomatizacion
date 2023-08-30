Feature: Delete user

  @DeleteUser
  Scenario: Delete user successfully.
    When I consume the service and I send the user information username
    Then I can validate the phone