Feature: Qualipro- Test fiche Action En tant que utilisateur,je souhaite vérifier les données de Liste des Etat des
  sous actions par produit

  @ReportingListeSousActionParPriorite
  Scenario Outline: reporting liste des Etat des sous actions par Priorite
    Given Ouvrir le site QualiProWeb
    When saisir Login et PW
    When cliquer sur ouvrir une session
    And saisir <exemple> d'action  des sous actions par Priorite
    When Consulter reporting sous action par priorité
    When récupérer filtre reporting liste des sous actions par Priorite
    And saisir filtre reporting liste des actions
    And saisir filtre reporting
    Then Exporter tracabilite
    And vérifier les données rapport liste des sous actions par Priorite
    Then delete file
    Examples:
      | exemple |
      | 1       |