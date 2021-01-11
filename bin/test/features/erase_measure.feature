#Author: PITT JARVIS

Feature: Measurement erase
  As a certification team for the COnectados project,
  It is necessary to delete measures
  To validate the deletion of said measure.

  Scenario Outline: Measurement erase <description>
    Given That the Analyst check the last employee measure <scenarioNumber>
    When he performs the erase of the measure
    Then he validate that measure of the employee was deleted correctly

    Examples: 
      | description   						| scenarioNumber |
      | of organizational change	|              1 |
