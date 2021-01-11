#Author: PITT JARVIS
Feature: modify employee id CO, PA and External
  As a certification team for the project COnectados,
  It is necessary modify employee id from SAP HCM and validate the result of the process in SSFF,
  In order to ensure that the business process is carried out correctly.

  Scenario Outline: Modify employee id <description>
    Given that the Analyst needs modify employee id in HCM <scenarioNumber>
    When he enters SSFF to the profile of the employee <transaction>
    Then he validate that employee id be modified in SSFF successfully

    Examples: 
      | description | scenarioNumber | transaction |
      | Colombia Z1 |              7 | PA30        |
#			| Colombia Z1  |  					  7 |
#			| Panama ZD    | 					    8 |
#			| Externo  	   | 					    9 |
