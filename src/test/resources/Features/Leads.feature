#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Leads
Feature: Managing Leads
  Creation and Deletion of Leads

  Background: Logged In
  Given user opens the application
   When user clicks on signin link
  And user enters the username 'singaporeraghav@gmail.com'
  And user clicks on Next button
  And user enters the password 'Patience1234*'
  And clicks on signin button
  And user selects the CRM module
  And user clicks on Leads in top menu
    
    
  @CreateLead
  Scenario: Creation of a Lead
    When I go to create lead page
    And enter and submit lead details
    | FirstName    | LastName     | Email           | Company   |
    | Alex         | Jones        | xyz@gmail.com   | MRF       |
    Then Lead Description Page should load  with leadname 'Alex Jones'
    And I verify lead details
    And user clicks on Leads in top menu 
    Then Lead 'Alex Jones' should 'be present' inside the grid

    
      
    

  @DeleteLead
  Scenario Outline: Deletion of the lead
    When I select the lead <LeadName>
    And I click on delete button
    Then Lead <LeadName> should 'not be present' inside the grid

    Examples: 
      | LeadName  | 
      | Alex Jones |
       
