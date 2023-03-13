Feature: Qualipro- Test fiche Action En tant que utilisateur,je souhaite vérifier les données de etat d'avancement des plans d'actions

  @ReportingEtatAvancementPlansActions
  Scenario Outline: reporting de nombre Etat d'avancement des plans d'actions
    Given Ouvrir le site QualiProWeb
    When saisir Login et PW
    When cliquer sur ouvrir une session
    When Consulter reporting Etat d'avancement des plans d'actions
    When récupérer filtre reporting liste Etat d'avancement des plans d'actions
    And choisir <type_Rg> de regroupement Etat d'avancement des plans d'actions
    And saisir filtre reporting Etat d'avancement des plans d'actions
    Then Exporter tracabilite
    And vérifier les données rapport Etat d'avancement des plans d'actions
    Then delete file

    Examples:
      | type_Rg |
      #| "Initial" |
      | "avecDate" |
      | "avecTrimestriel" |