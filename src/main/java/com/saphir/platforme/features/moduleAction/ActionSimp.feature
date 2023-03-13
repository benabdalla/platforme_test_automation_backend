Feature: Qualipro- Test fiche Action
  En tant que utilisateur je souhaite remplir une fiche Action Simplifiée


  @ParemétrageFicheActionsimplifiée
  Scenario Outline: Creation fiche Action
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que <declencheur> de l <exemple> du <module>
    And saisir <Filaile> action filaile
    And saisir <exemple> action
    And cliquer sur action simplifiée "action_simplifiée" parametrage
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
      | exemple | Filaile     | declencheur | module   |
      | 1       | "Group"     | 26          | "Action" |
      | 2       | "Filiale 1" | 26          | "Action" |
      | 3       | "Filiale 2" | 26          | "Action" |

  @FicheActionsimplifiée
  Scenario Outline: Qualipro- Test fiche Action Simplifiée
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que <declencheur> de l <exemple> du <module>
    And saisir <Filaile> action filaile
    When  Consulter Action
    And   cliquer sur action simplifiée "action_simplifiée"
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
    And Choisir FG responsble réalisation <RespRealise> et  responsble Suivi <respSuivi>
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
      | exemple |  | Filaile     | declencheur | module   | RespRealise | respSuivi   |
      | 1       |  | "Group"     | 26          | "Action" | "Filiale 2" | "Filiale 2" |
      | 2       |  | "Filiale 1" | 26          | "Action" | "Filiale 1" | "Filiale 2" |
      | 3       |  | "Filiale 2" | 26          | "Action" | "Filiale 2" | "Filiale 2" |

  @RealisationetSuiviAction
  Scenario Outline: Qualipro- En tant que responsable, je souhaite traiter et suivre l action avec des taux différents
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que <responsable> de l <exemple> du <module>
    And saisir <exemple> action
    And saisir <Filaile> action filaile
    And Saisir A l origine de l action <origine>
    When Consulter action a traiter
    And Réaliser action avec <A taux realisation>
    Then Vérifier etat action realisé
    And Consulter action a suivre
    Then vérifier taux réalisation
    When suivre action avec <N taux realisation> et <taux suivi>
    Then Vérifier etat action suivi
    And Clôturée Action
    Examples:
      | exemple | A taux realisation | N taux realisation | taux suivi | Filaile     | responsable | module   | origine     |
      | 1       | 50                 | 30                 | 70         | "Filiale 2" | 4           | "Action" | "Groupe"    |
      | 1       | 80                 | 100                | 100        | "Filiale 2" | 4           | "Action" | "Groupe"    |
      | 2       | 50                 | 30                 | 70         | "Filiale 1" | 4           | "Action" | "Filiale 1" |
      | 2       | 80                 | 100                | 100        | "Filiale 1" | 4           | "Action" | "Filiale 1" |
      | 3       | 50                 | 30                 | 70         | "Filiale 2" | 4           | "Action" | "Filiale 2" |
      | 3       | 80                 | 100                | 100        | "Filiale 2" | 4           | "Action" | "Filiale 2" |


  