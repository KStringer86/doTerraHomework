Feature: Login Feature

  Scenario Outline: Test login with valid credentials
    Given User has Navigated to the login page
    When User enters <username> and <password>
    And User clicks on the login button
    Then User will be logged into the system

    Examples: 
      | username         | password           |
      | John Doe         | ThisIsNotAPassword |
