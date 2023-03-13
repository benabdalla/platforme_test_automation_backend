Feature: Qualipro- Test fiche Action En tant que utilisateur,je souhaite vérifier les données de nombre d'actions par source

  @FicheActionDetaille
  Scenario Outline: Creation fiche Action
    Given Ouvrir le site QualiProWeb
    And saisir Login et PW
    And cliquer sur ouvrir une session
    When Consulter Action
    And cliquer sur ajouter Action détaillée
    And saisir <exemple> action
    And Ajouter Source
    And Saisir Date Création
    And Saisir A l origine de l action
    And Saisir Désignation
    And choisir Type Action
    And Saisir Description problème/objet
    And choisir Produit
    And choisir Types de causes
    And Saisir Causes possibles
    And saisir Objectif
    And saisir référence Audit
    And choisir Site
    And Choisir Processus
    And choisir Activité
    And choisir Direction
    And choisir service
    And choisir un responsable de clôture
    When cliquer sur valider Action
    Then Fiche Action ajouté
    When choisir plusieurs responsables de suivi
    Then cliquer sur ajouter sous action
    When saisir désignation sous action
    And saisir responsable de réalisation
    And saisir délais de réalisation
    And choisir un responsable de suivi
    And choisir délais de suivi
    And choisir gravité action
    And choisir Priorité SA
    And saisir cout previ SA
    And saisir Risque SA
    When cliquer sur valider sous action
    Then sous action ajouté a la liste des sous actions
    Examples:
      | exemple |
      | 1       |

  @ReportingListeActionRealiseeParSource
  Scenario Outline: reporting de nombre d'actions par source
    Given Ouvrir le site QualiProWeb
    When saisir Login et PW
    When cliquer sur ouvrir une session
    When Consulter reporting Nombre d'actions par source
    When choisir <type_Rg> de regroupement des actions par type
    When récupérer filtre reporting liste des actions
    And saisir filtre reporting liste des actions
    Then vérifier les données rapport liste des actions par source
    Then delete file
    Examples:
      | type_Rg      |
      | "Cloture"    |
      | "NONCloture" |