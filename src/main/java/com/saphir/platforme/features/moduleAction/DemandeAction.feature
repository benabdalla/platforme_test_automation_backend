@tag
Feature: Creation de Demande Action

  @ParemétrageDemandeAction
  Scenario Outline: Creation fiche Action
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de demande action
    When cliquer sur ouvrir une session
    And saisir demande action filaile declencheur
    And saisir <exemple> action
    And consulter liste de  validateur
    And Saisir site et processus de validateur
    And ajouter validateur
    Then verifier validateur
    And consulter  source d'action
    And Ajouter   source d'action
    And saisir   source d'action
    And clique    source d'action
    And verifier   source d'action
    And consulter  types d'action
    And Ajouter  types d'action
    And saisir  type d'action
    And clique   sur   valider
    And verifier  type d'action
    Examples:
      | exemple |
      | 1       |


  @AjoutDemandeAction
  Scenario Outline: Creation fiche Action
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de demande action
    When cliquer sur ouvrir une session
    And saisir demande action filaile declencheur
    When Consulter demande Action
    And saisir <exemple> action
    And Cliquer sur ajouter
    And Ajouter Source
    And choisir Type Action
    And Selectionner origine
    And Ajouter Type Cause
   # And Ajouter Produit
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
  And Choisir FG responsble réalisation <RespRealise> et  responsble Suivi <respSuivi>
    And ajouter sous action demande
    When choisir gravité DA
    When choisir Priorité DA
    When saisir cout previ DA
    When saisir Risque DA
    When cliquer sur valider sous action demande
    Then Verifier sous action ajouté a la liste
    Then Verifier fiche Demande Action ajoute
    Then Recuperer responsable validation
 #   And Saisir A l origine de l action <origine>
    And Valider Demande Action par les responsable
    When Consulter demande Action
    And Saisir Numero Demande
    And Cliquer rechercher Demande
    Then Verifier Demande Action validé
    When Consulter Action
    When Saisir Code Action
    When Rechercher Action
    Then Afficher Fiche Action
    Examples:
      | exemple |
      | 1       |


