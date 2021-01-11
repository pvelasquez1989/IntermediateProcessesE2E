#Author: PITT JARVIS

Feature: Organizational changes and remuneration changes
  As a certification team for the project COnectados,
  It is necessary to make organizational changes and remuneration changes to promotion an employee.

  Scenario Outline: Organizational change and remuneration change <description>
    Given that the Analyst needs to make an employee promotion so he postules a candidate <scenarioNumber>
    When he makes an organizational change and remuneration change in HCM
    Then he validate that organizational change is registered in SSFF successfully

    Examples: 
      | description                      | scenarioNumber |
#		  | CO, reason Promotion             |             15 |
#			| CO, reason Patronal substitution |             16 |
			| PA, reason Horizontal transfer   |             17 |