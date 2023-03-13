Feature: Qualipro- Test fiche Action En tant que utilisateur,je souhaite vérifier les données de Etat des
  actions par responsable

  @ReportingEtatActionsParResponsable
  Scenario Outline: reporting de Etat des actions par responsable
    Given Ouvrir le site QualiProWeb
    When saisir Login et PW
    When cliquer sur ouvrir une session
    Then delete file
    When Consulter reporting Etat des actions par responsable
    When récupérer filtre reporting liste des actions
    And choisir <respoReal> de regroupement Etat des actions par responsable
    And saisir filtre reporting
    Then Exporter tracabilite
    And vérifier les données rapport des actions par responsable
    Then delete file

    Examples:
      | respoReal |
      | "AUTO1"   |


