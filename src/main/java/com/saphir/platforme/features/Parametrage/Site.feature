Feature:  creation et  verfication  de  parametrage GRH
#Scénario de parametrage Site
  @Site
  Scenario: creation de test  de site
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de  site
    When cliquer sur ouvrir une session
    And saisir site filaile declencheur
    And  Consulter  GRH site
    And  Ajouter   site
    Then Vérifier  site à éte ajouter
#Scénario de parametrage processus
  @Processus
  Scenario: creation de test  de processus
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de  processus
    When cliquer sur ouvrir une session
    And saisir processus filaile declencheur
    And  Consulter  GRH processus
    And  Ajouter   processus
    Then Vérifier  processus à éte ajouter

#Scénario de parametrage activite
  @Activite
  Scenario: creation de test  de activite
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de  activite
    When cliquer sur ouvrir une session
    And saisir activite filaile declencheur
    And  Consulter  GRH activite
    And  Ajouter   activite
    Then Vérifier  activite à éte ajouter
#Scénario de parametrage service
  @ServiceParameter
  Scenario: creation de test  de service
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de  service
    When cliquer sur ouvrir une session
    And saisir service filaile declencheur
    And  Consulter  GRH service
    And  Ajouter   service
    Then Vérifier  service à éte ajouter

  @Direction
  Scenario: creation de test  de direction
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de  direction
    When cliquer sur ouvrir une session
    And saisir direction filaile declencheur
    And  Consulter  GRH direction
    And  Ajouter   direction
    Then Vérifier  direction à éte ajouter