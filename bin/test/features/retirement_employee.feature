#Author: PITT JARVIS
Feature: Retirement employee
  As a certification team for the project COnectados,
  It is necessary retire employees from SAP HCM and validate the result of the process in SSFF,
  In order to ensure that the business process is carried out correctly.

  @retirementEmployee
  Scenario Outline: Retirement employee <description>
    Given that the Analyst needs to make the retirement of an employee in HCM <scenarioNumber>
    When he enters SSFF to the profile of the employee
    Then he validate that retirement of the employee is registered in SSFF successfully

    Examples: 
    | description																			| scenarioNumber |
		| CO, reason retirement for just cause						| 32						 |
#		| CO, reason voluntary retirement									| 34						 |
#		| CO, reason apprentice contract termination			| 36						 |
#		| externo YP In House, reason retirement					| 38						 |
#		| externo Y2 Out House, reason retirement					| 41						 |
#		| PA ZD society8000, reason waive trial period		| 42						 |
#		| CO, reason retirement without just cause				| 19						 |
#		| CO, reason jubilation														| 20						 |
#		| CO, reason voluntary retirement									| 21						 |
#		| CO, reason apprentice contract termination			| 22						 |
#		| PA ZD society8000, reason waive trial period		| 23						 |
#		| PA ZD society8000, reason voluntary retirement	| 24						 |
#		| PA ZF society1200, reason waive trial period		| 25						 |
#		| PA ZF society1200, reason voluntary retirement	| 26						 |
#		| externo YP In House, reason retirement					| 27						 |
#		| externo YP Out House, reason retirement					| 28						 |
#		| externo Y2 In House, reason retirement					| 29						 |
#		| externo Y2 Out House, reason retirement					| 30						 |
