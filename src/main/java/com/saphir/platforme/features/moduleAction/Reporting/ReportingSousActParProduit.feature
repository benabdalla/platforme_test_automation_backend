Feature: Qualipro- Test fiche Action En tant que utilisateur,je souhaite vérifier les données de Liste des Etat des
  sous actions par produit

  @ReportingListeSousActionParProduit
  Scenario Outline: reporting liste des Etat des sous actions par produit
    Given Ouvrir le site QualiProWeb
    When saisir Login et PW
    When cliquer sur ouvrir une session
    And saisir <exemple> d'action  des sous actions par produit
    When Consulter reporting liste des  sous actions par produit
    When récupérer filtre reporting liste des sous actions par produit
    And saisir filtre reporting liste des actions
    Then Exporter tracabilite
    And vérifier les données rapport liste des sous actions par produit
    Then delete file
    Examples:
      | exemple |
      | 1       |