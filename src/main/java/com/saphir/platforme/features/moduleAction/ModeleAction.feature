@ModèleAction
Feature: Qualipro- Test fiche Action
  En tant que utilisateur je souhaite remplir une fiche modèle d'action

  @creationModele
  Scenario Outline: Qualipro- Creation Modèle Action
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que <declencheur> de l <exemple> du <module>
    And saisir <Filaile> action filaile
    When  Consulter Modèle Action
    And   cliquer sur ajouter modèle Action
    And   saisir <exemple> action
    And   Ajouter Source
    And   Saisir Désignation
    And   choisir Type Action
    And   Saisir Description problème/objet
    And   choisir Types de causes
    #And   choisir Types causes
    And   Saisir Causes possibles
    And   choisir Site
    And   Choisir Processus
    And   choisir Activité
    And   choisir direction modele
    And   choisir service
    When  cliquer sur valider Modele
    Then  Fiche Action ajouté
    Then  récuperer numéro fiche
    When  choisir plusieurs responsables de suivi
    Then  cliquer sur ajouter sous action
    When  saisir désignation sous action
    And saisir cout sous action
    And  saisir responsable de réalisation modele action
    And  saisir délais de réalisation modele
    And  choisir un responsable de suivi modele action
    And  choisir délais de suivi modele
    When  cliquer sur valider sous action
    Then  sous action ajouté a la liste des sous actions
    Then  cliquer sur ajouter sous action
    When  saisir désignation sous action
    And saisir cout sous action
    And  saisir responsable de réalisation modele action
    And  saisir délais de réalisation modele
    And  choisir un responsable de suivi modele action
    And  choisir délais de suivi modele
    When  cliquer sur valider sous action
    Then  sous action ajouté a la liste des sous actions
    When  Consulter Action
    And     cliquer sur ajouter Action détaillée
    And   rattacher modele action
    And Vérifier Site
    And Vérifier processus
    And Vérifier activité
    And Vérifier direction
    And Vérifier service
    When  cliquer sur valider Action
    Then  Fiche Action ajouté
    Then vérifier les dates
     #When  Exporter apercu action
     #Then vérifier les données importés
    Examples:
      | exemple | Filaile     | declencheur | module   |
      | 1       | "Group"     | 26          | "Action" |
      | 2       | "Filiale 1" | 26          | "Action" |
      | 3       | "Filiale 2" | 26          | "Action" |



  @RattachementModele
  Scenario Outline:  Qualipro- En tant qu utilisateur, je souhaite vérifier les données importés d un modele
    Given Ouvrir le site QualiProWeb
    And   saisir Login et PW
    And   cliquer sur ouvrir une session
    When  Consulter Action
    And     cliquer sur ajouter Action détaillée
    And   rattacher <modele> action
    When  cliquer sur valider Action
    Then  Fiche Action ajouté
    When  Exporter apercu action
    Then vérifier les données importés

    Examples:
      | modele |
      | "149"  |

 