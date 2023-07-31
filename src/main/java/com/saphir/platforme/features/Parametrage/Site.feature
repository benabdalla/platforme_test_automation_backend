Feature:  creation et  verfication  de  parametrage GRH

  @Site
  Scenario: creation de test  de site
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de  site
    When cliquer sur ouvrir une session
    And saisir site filaile declencheur
    And  Consulter  GRH site
    And  Ajouter   site
    Then Vérifier  site à éte ajouter

  @Processus
  Scenario: creation de test  de processus
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de  processus
    When cliquer sur ouvrir une session
    And saisir processus filaile declencheur
    And  Consulter  GRH processus
    And  Ajouter   processus
    Then Vérifier  processus à éte ajouter


  @Activite
  Scenario: creation de test  de activite
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de  activite
    When cliquer sur ouvrir une session
    And saisir activite filaile declencheur
    And  Consulter  GRH activite
    And  Ajouter   activite
    Then Vérifier  activite à éte ajouter
