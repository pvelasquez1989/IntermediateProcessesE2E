#Author: PITT JARVIS

Feature: Remuneration change with stage lect. to productive CO
  As a certification team for the project COnectados,
  It is necessary to make the remuneration change with stage lect. to productive CO from SAP HCM and validate the result of the process in SSFF,
  In order to ensure that the business process is carried out correctly.

 Scenario Outline: Remuneration change <description>
    Given that the Analyst needs to make the remuneration change in HCM <scenarioNumber>
    When he enters SSFF to the profile of the employee
    Then he validate that is reflected the remuneration change in SSFF successfully

    Examples: 
      | description         													 			| scenarioNumber |
      | reason, stage change apprentice lect. to productive |             31 |