@ModuleAction
Feature: Qualipro- Test fiche Action
  En tant que utilisateur je souhaite remplir une fiche Action

  @ParemétrageFicheActionDetaille
  Scenario Outline: Creation fiche Action
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de  action
    When cliquer sur ouvrir une session
    And saisir action filaile declencheur
    And saisir <exemple> action
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
    And Saisir Responsable Cloture
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




  @RetourCorrection
  Scenario Outline: Qualipro- En tant qu utilisateur, je souhaite vérifier le retour pour correction entre le responsable traitement et le responsable suivi
    Given Ouvrir le site QualiProWeb
    And saisir Login et PW
    And cliquer sur ouvrir une session
    And saisir <exemple> action
    When Consulter action a traiter
    And Réaliser action avec <A taux realisation>
    And Consulter action a suivre
    Then vérifier taux réalisation
    When suivre action avec <N taux realisation> et <taux suivi>
    #And   Consulter <action a traiter> a realiser
    #Then  vérifier taux réalisation responsable traitement
    When Consulter Action
    When Consulter fiche action
    Then Exporter tracabilite
    And Vérifier <A taux realisation> et <N taux realisation>
    Examples:
      | exemple | A taux realisation | N taux realisation | taux suivi |
      | 1       | 50                 | 30                 | 70         |

  @VérificationActionNonClôturée
  Scenario Outline: Vérification Action Non Clôturée
    Given Ouvrir le site QualiProWeb
    And saisir Login et PW
    And cliquer sur ouvrir une session
    When Consulter Action
    And saisir <Filaile> action filaile
    And saisir <exemple> action
    When Consulter action a cloture
    When cliquer  sur   action   Cloture
    When cliquer   sur  non cloture
    When Consulter Action
    When vérfier  etat action Module
    Then vérfier etat   action  agenda
    Examples:
      | exemple | Filaile  |
      | 1       | "Groupe" |


  @AfficherTracabilite
  Scenario Outline: Qualipro-En tant que responsable, je souhaite afficher la tracabilite de l'action
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que <declencheur> de l <exemple> du <module>
    And saisir <exemple> action
    And saisir <Filaile> action filaile
    When Consulter Action
    When Consulter fiche action
    Then Exporter tracabilite
    And Vérifier les donnes de traçabilite
    Then delete file
    Examples:
      | exemple |  | Filaile | declencheur | module   |
      | 1       |  | "Group" | 26          | "Action" |
#      | 2       |  | "Filiale 1" | 26          | "Action" |
#      | 3       |  | "Filiale 2" | 26          | "Action" |

  @RattachementModele
  Scenario Outline: Qualipro- En tant qu utilisateur, je souhaite vérifier les données importés d un modele
    Given Ouvrir le site QualiProWeb
    And saisir Login et PW
    And cliquer sur ouvrir une session
    When Consulter Action
    And cliquer sur ajouter Action détaillée
    And rattacher <modele> action
    When cliquer sur valider Action
    Then Fiche Action ajouté
    When Exporter apercu action
    Then vérifier les données importés

    Examples:
      | modele |
      | "149"  |

  @VerificationBilanAction
  Scenario: Qualipro- En tant qu utilisateur, je souhaite vérifier les données du bilan d action
    Given Ouvrir le site QualiProWeb
    And saisir Login et PW
    And cliquer sur ouvrir une session
    When consulter reporting
    When cliquer sur bilan des actions
    When récupérer filtre reporting
    And saisir filtre reporting
    Then Exporter tracabilite
    And vérifier les données rapport
    Then delete file

  @VerificationBilanActionParFiltre
  Scenario Outline: Qualipro- En tant qu utilisateur, je souhaite vérifier les données du bilan d action
    Given Ouvrir le site QualiProWeb
    And saisir Login et PW
    And cliquer sur ouvrir une session
    When consulter reporting
    When cliquer sur bilan des actions
    When récupérer <Nomfiltre> reporting
    And choisir <type_R> de réalisation des actions
    And choisir <type_C> de cloture des actions
    And choisir <modele> bilan des actions
    And choisir <type_Rg> de regroupement des actions
    And saisir filtre reporting
    Then Exporter tracabilite
    And vérifier les données rapport
    Then delete file

    Examples:
      | Nomfiltre | type_R     | type_C     | modele     | type_Rg |
      | "source"  | "REALISEE" | "CLOTUREE" | "MODELE 1" | "SITE"  |

  #Amira
  @ReportingListeActionRealiseeParPersonne
  Scenario: reporting liste des actions realisees par personne
    Given Ouvrir le site QualiProWeb
    When saisir Login et PW
    When cliquer sur ouvrir une session
    When Consulter reporting liste des actions réalisées par personne
    When récupérer filtre reporting liste des actions realisees par personne
    And saisir filtre reporting
    Then Exporter tracabilite
    And vérifier les données rapport liste des actions realisees par personne
    Then delete file

  @ReportingEtatActionParResponsable
  Scenario: reporting Etat des actions par responsable
    Given Ouvrir le site QualiProWeb
    When saisir Login et PW
    When cliquer sur ouvrir une session
    When Consulter reporting Etat des actions par responsable
    When récupérer filtre reporting Etat action
    And saisir filtre reporting
    Then Exporter tracabilite
    And vérifier les données rapport Etat action
    Then delete file
     
