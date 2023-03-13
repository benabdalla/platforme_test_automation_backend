@tag
Feature: Authentification
  I want to use this feature in order to authentify in Qualipro

  @tag1
  Scenario: Se connecter en tant que Auto
    Given Ouvrir le site QualiProWeb
    And saisir Login et PW
    And cliquer sur ouvrir une session

  @tag2
  Scenario Outline: Se connecter avec login et mp saisie en outline
    Given Ouvrir le site QualiProWeb
    When saisir Login <username>
    And saisir password <password>
    And cliquer sur ouvrir une session

    Examples:
      | username    | password    |
      | "TESTAUTO2" | "TESTAUTO2" |

  @tag3
  Scenario Outline: Se connecter puis changer langue Qualipro
    Given Ouvrir le site QualiProWeb
    When saisir Login <username>
    And saisir password <password>
    And cliquer sur ouvrir une session
    And changer la langue en anglais

    Examples:
      | username    | password    |
      | "TESTAUTO2" | "TESTAUTO2" |

  @tag4
  Scenario Outline: Se connecter en tant qu utilisateur saisie en excel
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que <responsable> de l <exemple> du <module>

    Examples:
      | responsable | exemple | module  |
      |          12 |       2 | "Audit" |


