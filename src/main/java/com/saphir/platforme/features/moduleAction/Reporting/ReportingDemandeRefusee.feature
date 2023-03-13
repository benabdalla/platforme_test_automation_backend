@tag
Feature: Creation de Demande Action et vérifier les données au niveau reporting de historique demandes refusées
  @ReportingDemandeActionRefusee
  Scenario Outline: Ajouter Demande Action avec de historique demandes refusées
    Given Ouvrir le site QualiProWeb
    When saisir Login et PW
    When cliquer sur ouvrir une session
    When Consulter demande Action
    And saisir <exemple> demande action reporting
    And saisir <exemple> action
    And saisir <exemple> demande action
    And Cliquer sur ajouter
    And Ajouter Source
    And choisir Type Action
    And Selectionner origine
    And Ajouter Type Cause
    And Ajouter Produit
    And Selectionner date creation
    And Saisir Designation
    And Saisir description
    And Saisir Cause
    And Saisir Objective
    And Selectionner Site
    And Selectionner Processus
    And Selectionner Activite
    And Selectionner Direction
    And Selectionner Service
    And Cliquer valider demande action
    When cliquer sur ajouter sous action demande
    And ajouter sous action demande
    When choisir gravité DA
    When choisir Priorité DA
    When saisir cout previ DA
    When saisir Risque DA
    When cliquer sur valider sous action demande
    Then Verifier sous action ajouté a la liste
    Then Verifier fiche Demande Action ajoute
    Then Recuperer responsable validation
    And refusées Demande Action par les responsable
    When Consulter demande Action
    And Saisir Numero Demande
    And Cliquer rechercher Demande
    Then Verifier Demande Action refusées
    When Consulter reporting de historique demandes refusées
    Then Exporter tracabilite
    Then verifier le demande Action dans reporting historique demandes refusées
    Then delete file
    Examples:
      | exemple |
      | 1       |