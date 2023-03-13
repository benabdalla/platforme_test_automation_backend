Feature: Qualipro- Test fiche Action En tant que utilisateur,je souhaite vérifier les données de Liste des actions réalisées par personne

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

  @RealisationetSuiviAction
  Scenario Outline: Qualipro- En tant que responsable, je souhaite traiter et suivre l action avec des taux différents
    Given Ouvrir le site QualiProWeb
    And saisir Login et PW
    And cliquer sur ouvrir une session
    And saisir <exemple> action
    When Consulter action a traiter
    And Réaliser action avec <A taux realisation>
    Then Vérifier etat action realisé
    And Consulter action a suivre
    Then vérifier taux réalisation
    When suivre action avec <N taux realisation> et <taux suivi>
    Then Vérifier etat action suivi
    #And Clôturée Action
    Examples:
      | exemple | A taux realisation | N taux realisation | taux suivi |
      | 1       | 50                 | 30                 | 70         |
      | 1       | 80                 | 100                | 100        |


  @ReportingListeActionRealiseeParPersonne
  Scenario Outline: reporting liste des actions realisees par personne
    Given Ouvrir le site QualiProWeb
    When saisir Login et PW
    When cliquer sur ouvrir une session
    And saisir <exemple> d'action réalisées par personne
    When Consulter reporting liste des actions réalisées par personne
    When récupérer filtre reporting liste des actions realisees par personne
    And saisir filtre reporting
    Then Exporter tracabilite
    And vérifier les données rapport liste des actions realisees par personne
    Then delete file
    Examples:
      | exemple |
      | 1       |