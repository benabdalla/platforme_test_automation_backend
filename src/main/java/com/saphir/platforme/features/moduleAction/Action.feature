@ModuleAction
Feature: Qualipro- Test fiche Action
  En tant que utilisateur je souhaite remplir une fiche Action

  @ParemétrageFicheActionDetaille
  Scenario Outline: Création Parametrage de fiche action
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de  action
    When cliquer sur ouvrir une session
    And saisir action filaile declencheur
    And saisir <exemple> action
    And ajouter Responsable Cloture
    And Saisir Responsable Cloture
    Then verifier Responsable Cloture
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
    And ajuter type de causeso
    And saisir  type   de causes
    And  verifier type de causes
    And ajouter  priorité
    And saisir  priorité
    And  verifier priorité
    And ajouter gravité
    And saisir  gravité
    And verifier gravité
    Examples:
      | exemple |
      | 1       |
  @FicheActionDetaille
  Scenario Outline: Creation fiche Action
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de  action
    When cliquer sur ouvrir une session
    And saisir action filaile declencheur
    When Consulter Action
    And cliquer sur ajouter Action détaillée
    And saisir <exemple> action
    And Ajouter Source
    And Saisir Date Création
    And Saisir A l origine de l action
    And Saisir Désignation
    And choisir Type Action
    And Saisir Description problème/objet
   # And choisir Produit
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
    And Choisir FG responsble réalisation et responsble Suivi
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
  @RealisationAction
  Scenario Outline: Qualipro- En tant que responsable, je souhaite traiter  l action avec des taux différents
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que responsable réalisation
    When cliquer sur ouvrir une session
    And saisir <exemple> action
    And saisir action  responsable réalisation
    And Saisir a l'origine de l'action
    When Consulter action a traiter
    And Réaliser action avec <exemple>
    Then Vérifier etat action realisé
    Examples:
      | exemple |
      | 1       |
  @SuiviAction
  Scenario Outline: Qualipro- En tant que responsable, je souhaite  suivre l action avec des taux différents
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que responsable suivi
    When cliquer sur ouvrir une session
    And saisir <exemple> action
    And saisir action  responsable Suivi
    And Saisir A l origine de l action
    And Consulter action a suivre
    Then vérifier taux réalisation
    When suivre action avec <exemple>
    Then Vérifier etat action suivi
    Examples:
      | exemple |
      | 1       |
  @RealisationActionRetour
  Scenario Outline: Qualipro- En tant que responsable, je souhaite  retourne traiter et suivre l action avec des taux différents
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que responsable réalisation
    When cliquer sur ouvrir une session
    And saisir <exemple> action
    And saisir action  responsable réalisation
    And Saisir a l'origine de l'action
    When Consulter action a traiter
    And Réaliser action avec <exemple>
    Then Vérifier etat action realisé
    Examples:
      | exemple |
      | 2       |

  @SuiviActionRetour
  Scenario Outline: Qualipro- En tant que responsable, je souhaite traiter et suivre l action avec des taux différents
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que responsable suivi
    When cliquer sur ouvrir une session
    And saisir <exemple> action
    And saisir action  responsable Suivi
    And Saisir A l origine de l action
    And Consulter action a suivre
    Then vérifier taux réalisation
    When suivre action <exemple>
    Then Vérifier etat action suivi
   # And Clôturée Action
    Examples:
      | exemple |
      | 2     |

  @SuiviCloture
  Scenario: Qualipro- En tant que responsable, je souhaite traiter et suivre l action avec des taux différents
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que responsable cloture
    When cliquer sur ouvrir une session
    And Clôturée Action
    Then Verifier  etat  de  suivi

  @AfficherTracabilite
  Scenario: Qualipro-En tant que responsable, je souhaite afficher la tracabilite de l'action
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de  action
    When cliquer sur ouvrir une session
    And saisir action filaile declencheur
    When Consulter Action
    When Consulter fiche action
    Then Exporter tracabilite
    And Vérifier les donnes de traçabilite




