@AllLogin
Feature: Login Functionality
  As a user of OpenCart website
  I want to be able to login in my account
  So that I can review my account details

Background:
  Given I am on the Application login page with Title "Account Login"

@Smoke
Scenario: Successful login with valid credentials
  Given I have entered a valid username and password
  When I click on the login button
  Then I Should see 93 Links on page
  Then I should be logged in successfully


Scenario Outline: Unsuccessful login with invalid or empty credentails
  Given I have entered invalid "<username>" and "<password>"
  When I click on the login button
  Then I should see an error message indicating "<error_message>"

  Examples:
    | username               | password           | error_message                                                           |
    | invalid@gmail.com  | invalidPassword  | Warning: No match for E-Mail Address and/or Password. |
    | abcccc                   | validPassword     | Warning: No match for E-Mail Address and/or Password. |
    | valid@gmail.com     | abccc                | Warning: No match for E-Mail Address and/or Password. |
    
@Regression
Scenario: Navigating to forgotten password page
  When I click on the "Forgotten Password" link
  Then I should be redirected to the password reset page
  
  