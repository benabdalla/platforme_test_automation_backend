Feature: Qualipro- Test fiche Action
  En tant que utilisateur je souhaite remplir une fiche Action Simplifiée


  @ParemétrageFicheActionsimplifiée
  Scenario Outline: Creation fiche Action
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de  action
    When cliquer sur ouvrir une session
    And saisir action filaile declencheur
    And saisir <exemple> action
    And ajouter Responsable Cloture
    And Saisir Responsable Cloture
    Then verifier Responsable Cloture
    And cliquer sur action simplifiée parametrage
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

  @FicheActionsimplifiée
  Scenario Outline: Qualipro- Test fiche Action Simplifiée
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de  action
    When cliquer sur ouvrir une session
    And saisir action filaile declencheur
    When Consulter Action
    And   cliquer sur action simplifiée
    And   saisir <exemple> action
    And   Saisir Date Création
    And   Ajouter Source
    And   choisir Type Action
    And   Saisir Désignation
    And   choisir Site
    And   Choisir Processus
    And   choisir Activité
    And   choisir Direction
    And   choisir service
    And   choisir un responsable de clôture simplifie
    Then  cliquer sur valider Action simplifiée
    Then  Fiche Action ajouté
    And Choisir FG responsble réalisation et responsble Suivi
    When  saisir un seul responsable de suivi
    And   saisir la date de suivi
    Then  cliquer sur ajouter sous action simplifiee
    When saisir désignation sous action
    And saisir responsable de réalisation
    And saisir délais de réalisation
    And Vérifier responsable de suivi
    And Vérifier délais de suivi
    When  cliquer sur valider sous action
#    Then  sous action ajouté a la liste des sous actions simplifiee
#    When  Consulter agenda Action
#    And   Réaliser Action
#    When  Consulter agenda Action
#    And   Suivi Action
#    And   Clôturée Action
    Examples:
      | exemple |
      | 1       |


  @RealisationAction
  Scenario Outline: Qualipro- En tant que responsable, je souhaite traiter et suivre l action avec des taux différents
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
  Scenario Outline: Qualipro- En tant que responsable, je souhaite traiter et suivre l action avec des taux différents
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
  Scenario Outline: Qualipro- En tant que responsable, je souhaite traiter et suivre l action avec des taux différents
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
      | 2       |

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
