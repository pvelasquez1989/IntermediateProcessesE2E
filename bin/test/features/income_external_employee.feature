#Author: PITT JARVIS
Feature: Income external employee YP, Y2 and Y7
  As a certification team for the project COnectados,
  It is necessary to make the entry of external employees YP, Y2 and Y7 from SAP HCM and validate the result of the process in SSFF,
  In order to ensure that the business process is carried out correctly.

  Scenario Outline: Income external employee <description>
    Given that the Analyst needs to perform the income of an external employee in HCM <scenarioNumber>
    When he enters SSFF to the profile of the employee
    Then he validate that the new employee is registered in SSFF successfully

    Examples:
		| description															|	scenarioNumber	|
#		| Recontratacion empleado banco a externo	|									|
		| YP In House															|								2	|
#		| YP Out House														|								3	|
#		| Y2 In House															|								4	|
#		| Y2 Out House														|								5	|
#		| Y7																			|									|
