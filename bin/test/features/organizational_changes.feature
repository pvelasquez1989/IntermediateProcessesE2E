#Author: PITT JARVIS
Feature: Organizational changes
  As a certification team for the project COnectados,
  It is necessary to make organizational changes to employees from SAP HCM and validate the result of the process in SSFF,
  In order to ensure that the business process is carried out correctly.

  Scenario Outline: Organizational change without change of remuneration <description>
    Given that the Analyst needs to make an organizational change to an employee in HCM <scenarioNumber>
    When he enters SSFF to the profile of the employee
    Then he validate that organizational change is registered in SSFF successfully

    Examples: 
      | description          				 		| scenarioNumber |
#			| CO, reason Decline    					|             10 |
			| CO, reason Refund								|             11 |
			| PA, reason Promotion  					|             12 |
			| Ext, reason Horizontal transfer	|				 		  13 |