Feature: As a user i want to visit another cucumber pages

  Scenario Outline: Visit cucumber pages
    Given I go to <blog> page
    Then I should be on <blog> page
    When I go to <events> page
    Then I should be on <events> page
    Examples:
      |blog                     |events                     |
      |https://cucumber.io/blog |https://cucumber.io/events |


Scenario: Visit another cucumber pages
  Given I go to https://cucumber.io/docs page
    Then I should be on https://cucumber.io/docs page
    When I go to https://cucumber.io/docs/cucumber/ page
    Then I should be on https://cucumber.io/docs/cucumber/ page
