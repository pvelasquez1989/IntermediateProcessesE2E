#Author: PITT JARVIS

Feature: Regime Change 
  As a certification team for the project COnectados,
  It is necessary to make regime change to employees from SAP HCM and validate the result of the process in SSFF,
  In order to ensure that the business process is carried out correctly.

  Scenario Outline: Regime change CO <description>
  	Given that the Analyst needs to make an regime change to an employee in HCM <scenarioNumber>
    When he enters SSFF to the profile of the employee
    Then he validate that regime change CO is registered in SSFF successfully

    Examples:
      | description         													 | scenarioNumber |
			| reason change from basic salary to full salary |             14 |