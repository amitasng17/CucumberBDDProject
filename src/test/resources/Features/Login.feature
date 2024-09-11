Feature: Login
  @PageTitle
  Scenario: Verify the page title
  Given user opens the application
   Then the title of the page should be 'Zoho | Cloud Software Suite for Businesses'

  @Login
  Scenario: Login with correct credentials
  Given user opens the application
    When user clicks on signin link
    And user enters the username 'amita15.puneet@gmail.com'
    And user clicks on Next button
    And user enters the password 'Patience1234*'
    And clicks on signin button
    And user clicks on signin image
    Then username 'Amita15.Puneet' should be displayed in the top right corner
       
    