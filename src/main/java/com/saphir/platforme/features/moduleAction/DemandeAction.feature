@tag
Feature: Creation de Demande Action

  @AjoutDemandeAction
  Scenario Outline: Ajouter Demande Action
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que <declencheur> de l <exemple> du <module>
    And saisir <Filaile> action filaile
    When Consulter demande Action
    And saisir <exemple> action
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
    And Saisir A l origine de l action <origine>
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
      | exemple |  | Filaile     | declencheur | module   | RespRealise | respSuivi   | origine     |
      | 1       |  | "Group"     | 26          | "Action" | "Filiale 2" | "Filiale 2" | "Groupe"    |
      | 2       |  | "Filiale 1" | 26          | "Action" | "Filiale 1" | "Filiale 2" | "Filiale 1" |
      | 3       |  | "Filiale 2" | 26          | "Action" | "Filiale 2" | "Filiale 2" | "Filiale 2" |

