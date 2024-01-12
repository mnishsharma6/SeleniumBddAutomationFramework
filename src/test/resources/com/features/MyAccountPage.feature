@AllMyAccount
Feature: Verify My Accont Page Contents

Background:
  Given User has logged in to the Application
  | Username | Password |
  | qatestertest@gmail.com | Test@123 |


Scenario: Verify Account Page Title
  Given User is on Account Page
  Then Account Page title should be "My Account"

Scenario: Verify My Account Section Contents
  Given User is on Account Page
  Then I should see following contents for My Account section
  | Edit your account information |
  | Change your password |
  | Modify your address book entries |
  | Modify your wish list |