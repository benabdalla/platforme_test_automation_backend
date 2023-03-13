Feature: Qualipro- Test fiche Action En tant que utilisateur,je souhaite vérifier les données du etat des sous actions par Processus

  @ActionSousActNorealise
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
      |       1 |

  @VerificationetatSousActionsParProcessus
  Scenario Outline: Qualipro- En tant qu utilisateur, je souhaite vérifier les données du etat des sous actions par Processus
    Given Ouvrir le site QualiProWeb
    And saisir Login et PW
    And cliquer sur ouvrir une session
    When consulter reporting
    When cliquer sur etat des sous actions par Processus
    And choisir <type_R> de réalisation des actions par processus
    And choisir <type_C> de cloture des actions par  processus
    And choisir <GroupParSite> de regroupement des actions par processus
    When récupérer filtre reporting liste des actions
    And saisir filtre reporting
    Then Exporter tracabilite
    And vérifier les données rapport
    Then delete file
    Examples:
      | type_R        | type_C        | GroupParSite |
      | "NONREALISEE" | "NONCLOTUREE" | "oui"        |

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
    And Clôturée Action
    Examples:
      | exemple | A taux realisation | N taux realisation | taux suivi |
      |       1 |                 50 |                 30 |         70 |
      | 1       | 80                | 100                | 100        |

  @VerificationetatSousActionsParProcessusRealise
  Scenario Outline: Qualipro- En tant qu utilisateur, je souhaite vérifier les données du etat des sous actions par Processus
    Given Ouvrir le site QualiProWeb
    And saisir Login et PW
    And cliquer sur ouvrir une session
    Then delete file
    When consulter reporting
    When cliquer sur etat des sous actions par Processus
    And choisir <type_R> de réalisation des actions par processus
    And choisir <type_C> de cloture des actions par  processus
    And choisir <GroupParSite> de regroupement des actions par processus
    When récupérer filtre reporting liste des actions
    And saisir filtre reporting
    Then Exporter tracabilite
    And vérifier les données rapport
    Examples:
      | type_R     | type_C     | GroupParSite |
      | "REALISEE" | "CLOTUREE" | "oui"        |
