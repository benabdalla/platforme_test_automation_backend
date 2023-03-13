Feature: Qualipro- Test fiche Action En tant que utilisateur,je souhaite vérifier les données du bilan d action

  @FichActionDetaile
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


  @RealisationetSuiviSousActionSansClot
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
      |       1 |                 50 |                 30 |         70 |
      | 1       | 80                | 100                | 100        |



  @VerificationBilanActionParFiltreModel1
  Scenario Outline: Qualipro- En tant qu utilisateur, je souhaite vérifier les données du bilan d action de modéle 1
    Given Ouvrir le site QualiProWeb
    And saisir Login et PW
    And cliquer sur ouvrir une session
    When consulter reporting
    Then delete file
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
      | Nomfiltre | type_R     | type_C     | modele     | type_Rg                    |
      | "source"  | "REALISEE" | "CLOTUREE" | "MODELE 1" | "Source"                   |
      | "source"  | "REALISEE" | "CLOTUREE" | "MODELE 1" | "Déclencheur de l'action	" |
      | "source"  | "REALISEE" | "CLOTUREE" | "MODELE 1" | "type"                     |
      | "source"  | "REALISEE" | "CLOTUREE" | "MODELE 1" | "Produit"                  |
      | "source"  | "REALISEE" | "CLOTUREE" | "MODELE 1" | "Site"                     |
      | "source"  | "REALISEE" | "CLOTUREE" | "MODELE 1" | "Resp.real"                |
#


  @VerificationBilanActionParFiltreModel2
  Scenario Outline: Qualipro- En tant qu utilisateur, je souhaite vérifier les données du bilan d action de modéle 2
    Given Ouvrir le site QualiProWeb
    And saisir Login et PW
    And cliquer sur ouvrir une session
    Then delete file
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
      #| "source"  | "REALISEE" | "CLOTUREE"    | "MODELE 2" | ""      |
      | "source"  | "REALISEE" | "CLOTUREE" | "MODELE 2" | ""      |
     # | "source"  | "NONREALISEE" | "CLOTUREE"    | "MODELE 2" | ""      |


  @VerificationBilanActionParFiltreModel3
  Scenario Outline: Qualipro- En tant qu utilisateur, je souhaite vérifier les données du bilan d action de modéle 2
    Given Ouvrir le site QualiProWeb
    And saisir Login et PW
    And cliquer sur ouvrir une session
    When consulter reporting
    Then delete file
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
      | Nomfiltre | type_R     | type_C     | modele     | type_Rg       |
      #| "source"  | "REALISEE" | "CLOTUREE"    | "MODELE 3" | "Intervenant" |
      | "source"  | "REALISEE" | "CLOTUREE" | "MODELE 3" | "Intervenant" |
    #  | "source"  | "NONREALISEE" | "CLOTUREE"    | "MODELE 3" | "Intervenant" |











