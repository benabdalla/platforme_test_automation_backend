Feature: Qualipro- Test fiche reunion En tant que utilisateur je souhaite remplir une fiche réunion

  @typeRénion
  Scenario Outline: création de type de réunion
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de reunion
    When cliquer sur ouvrir une session
    When saisir reunion filaile
    When consulter type de réunion
    And   saisir <exemple> reunion
    And ajouter type réunion
    And saisir type de réunion
    And saisir périodicité
    And saisir source
    And valider type
    And Affectation des accès par type de réunion
    And Affectation de la liste des personnes à informer automatiquement
    Then type ajouté
    Examples:
      | exemple |
      | 1       |
  @reunion
  Scenario Outline: Qualipro-test creation fiche reunion
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de reunion
    When cliquer sur ouvrir une session
    When saisir reunion filaile
    And consulter reunion
    And cliquer sur ajouter
    And   saisir <exemple> reunion
    Then verifier le declencheur
    When saisir lieu
    And choisir type reunion
    And choisir date prevu
    And saisir ordre de jour
    And choisir site réunion
    And choisir processus réunion
    And choisir activité réunion
    And choisir direction réunion
    And choisir service réunion
    When cliquer sur Valider
    Then fiche reunion validé
    When cliquer sur Ajouter un participant
    Then participant ajouter à Liste des participants
    When verefier compteur agenda
    Then incrementation compteur agenda reunion
    Examples:
      | exemple |
      | 1       |
  @AgendaReunion
  Scenario Outline: confirmation la participant et consulter réunion pour info
    Given Ouvrir le site QualiProWeb
    When Connecter en tant participant que de reunion
    When cliquer sur ouvrir une session
    When saisir reunion filaile
    And   saisir <exemple> reunion
    When consulter agenda reunion
    And consulter réunion planifiée
    And confirmer l’assistance des participants reunion
    And consulter réunion pour info
    Then  verfier réunion  consulter
    Examples:
      | exemple |
      | 1       |
  @Realisation
  Scenario Outline: Qualipro-test Realiser reunion
    Given Ouvrir le site QualiProWeb
    When Connecter en tant declencheur que de reunion
    When cliquer sur ouvrir une session
    When saisir reunion filaile
    And consulter reunion
  #  When  consulter reunion
    When saisir numero reunion
    And cliquer sur rechercher reunion
    And Ouvrir fiche reunion
    #Then redirection vers fiche réunion
    When sélectionner Etat
    And saisir Date réalisation
    And saisir Durée réalisée
    And cliquer sur valider Réalisation
    And Rattacher action
    Then Taux de réalisation actions est correctement calculer
    When saisir Commentaires
    And cliquer sur valider Commentaires
    And cliquer sur Retour
    And cliquer sur Demande action
    #And cliquer sur Pièces jointes
    And cliquer sur Personnes à informer
    And cliquer sur Selectionner Employe
    #And rechercher avec Nom Prenom Employe
    And selectionner Employe
    And cliquer sur valider selectionner Employe
    When consulter reunion
    And saisir numero reunion
    And choisir Type reunion
    And selectionner etat
    And saisir Ordre de jour
    And cliquer sur rechercher reunion
    Then Liste des reunions contient la fiche reunion à recherche
    And Ouvrir fiche reunion
    When cliquer sur PV
    #When Exporter le rapport
    #When vérifier si tous les donneés existe
    #When consulter reporting
    #When cliquer sur liste des reunions
    #Then vérifier rapport
   #	When Vérifier l'exportation Excel  ( fichier excel généré par l'application est de mauvaise format)
    Examples:
      | exemple |
      | 1       |

