Feature: Qualipro- Test demande de création document
  En tant que utilisateur je souhaite de création un document

  @ParemtrageTypeDocument
  Scenario Outline: Creation type document et parmetrage de circuit de validation
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que superviseur
    When cliquer sur ouvrir une session
    And saisir filaile documentation
    And consulter type  document
    And Saisir  paremetrage  <exemple>
    And cliquer sur ajouter type document
    And  Avec codification automatique des documents <codification>
    And saisir  type  document
    And saisir nature document
    And  saisir périodicité de revue de document
    And saisir docuemnt  pdf <vaPdf>  au  Document sécurisé <valSécurise>
    And saisir Avec possibilité d'envoi par mail <envoyer mail>
    And  Document visible par tout le monde <visible a tous>
    Then  cliquer  sur  valider document
    And ajouter  superviseur
    And ajouter des personnes ayant le droit d'imprimer
    And ajouter des rédacteurs
    And ajouter  des vérificateurs
    And ajouter des approbateurs
    And responsables de la gestion diffusion papier
  #  And Liste de diffusion par défaut avec accusé de réception
    Then verfier le type document
    Examples:
      | exemple | valSécurise | vaPdf | envoyer mail | codification | visible a tous |
      | 1       | 0           | 1     | 0            | 1            | 1              |


  @BoîteDialogueRédacteurSuperviseur
  Scenario Outline: Qualipro- Test de boite dailogue Rédacteur vers Superviseur et création un document a travers boite de dailoue
    Given Ouvrir le site QualiProWeb
   # When Connecter en tant que superviseur
    When Connecter en tant que redacteur
    When cliquer sur ouvrir une session
    And saisir filaile documentation
    When Consulter boite de dialogue
    And cliquer sur Rédacteur au superviseur
    And Saisir <Type document>
    And Saisir Objet
    And rattacher fichier lien
    And Saisir message
    And cliquer sur Envoyer au superviseur
    When Change compte rédacteur
    And saisir filaile documentation
    Then verifier ajout dans la boite d envoi et vérifier message a été envoyé
    And verifier l incrémentation du compteur
    When cliquer sur notification agenda boite de dialogue
    And cliquer sur le fichier joint pour stocker le document au niveau de l infrastructure
    And cliquer sur Créer document
    And saisir Mot clé spécifique
    And choisir site lab
    And choisir processus lab
    And choisir activite lab
    And choisir direction lab
    And choisir service lab
    And cliquer sur valider Creation Document
    And cliquer sur valider en bas de page
    And cliquer sur Rédacteur en bas de page
    When Consulter boite de dialogue
    When consulter  le message de   Boîte de réception
    Then vérifier le message  lu et  traite
    Examples:
      | Type document | responsable | exemple | module          | Filaile |
      | 1             | 6           | 1       | "Documentation" | "MONO"  |

  @DocumentaionRedecteur
  Scenario Outline: Qualipro- Test validation  de rédacteur
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que redacteur
    When cliquer sur ouvrir une session
    And saisir filaile documentation
    And Saisir ligne <exemple>
    And consulter agenda documentation documents à valider par le rédacteur
    And insérer code documents
    And cliquer sur le document en question
    And cliquer sur visualiser le document et vérifier son téléchargement et stockage sur plateforme
    And cliquer sur vérificateur bleu
    Examples:
      | responsable | exemple | module          | Filaile |
      | 6           | 1       | "Documentation" | "MONO"  |

  @DocumentaionVerificateur
  Scenario Outline: Qualipro- Test validation  de vérificateur
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que verficateur
    When cliquer sur ouvrir une session
    And saisir filaile documentation
    And Saisir ligne <exemple>
    And consulter agenda documentation documents à valider par le vérificateur
    And insérer code documents
    And cliquer sur le document en question
    And cliquer sur visualiser le document et vérifier son téléchargement et stockage sur plateforme
    And cliquer sur approbateur bleu
    Examples:
      | responsable | exemple | module          | Filaile |
      | 7           | 1       | "Documentation" | "MONO"  |

  @DocumentaionApprobateur
  Scenario Outline: Qualipro- Test validation approbateur
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que approbateur
    When cliquer sur ouvrir une session
    And saisir filaile documentation
    And Saisir ligne <exemple>
    And consulter agenda documentation documents à valider par l approbateur
    And insérer code documents
    And cliquer sur le document en question
    And cliquer sur visualiser le document et vérifier son téléchargement et stockage sur plateforme
    And cliquer sur Envoi diffusion bleu
    Examples:
      | responsable | exemple | module          | Filaile |
      | 8           | 1       | "Documentation" | "MONO"  |

  @DocumentaionDiffusion
  Scenario Outline: Qualipro- Test diffusion  de document
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que superviseur
    When cliquer sur ouvrir une session
    And saisir filaile documentation
    And Saisir ligne <exemple>
    And consulter agenda documentation documents en attente de diffusion
    And insérer code documents
    And cliquer sur le document en question
    And cliquer sur visualiser le document à diffuser et vérifier son téléchargement et stockage sur plateforme
    And cliquer sur Mise en vigueur bleu
    Examples:
      | responsable | exemple | module          | Filaile |
      | 5           | 1       | "Documentation" | "MONO"  |


  @DocumentaionConsulter
  Scenario Outline: Qualipro- Test de consultation de document et  le commentaire  de  document
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que superviseur
    When cliquer sur ouvrir une session
    And saisir filaile documentation
    And Saisir ligne <exemple>
    And consulter agenda documentation documents à consulter
    And insérer code documents à consulter
    And cliquer sur le document à consulter
    And cliquer sur Visualiser  document en bleu vérifier son téléchargement et stockage sur plateforme
    And cliquer sur J ai consulté ce document
    And cliquer sur raccourci consulter doc interne
    And rechercher code documents niveau filtre
    And cliquer sur le document interne en question
   # And Vérifier nombre et taux de consultation
    And cliquer sur commentaire
    And cliquer sur Ajouter
    And cliquer saisir message au superviseur
    And Envoyer au superviseur
    #Then vérifier le commantaire reçu
    And Supprimer les fichiers temporaires de l infrastructure
    Examples:
      | responsable | exemple | module          | Filaile |
      | 19          | 1       | "Documentation" | "MONO"  |


  @DocumentaionAvecReporting
  Scenario Outline: Qualipro- Test demande de création document
    Given Ouvrir le site QualiProWeb
    When Connecter en tant que superviseur
    When cliquer sur ouvrir une session
    And saisir filaile documentation
    And Saisir ligne <exemple>
    When Consulter boite de dialogue
    And cliquer sur Rédacteur au superviseur
    And Saisir <Type document>
    And Saisir Objet
    And rattacher fichier lien
    And Saisir message
    And cliquer sur Envoyer au superviseur
    Then verifier ajout dans la boite d envoi et vérifier message a été envoyé
    And verifier l incrémentation du compteur
    When cliquer sur notification agenda boite de dialogue
    And cliquer sur le fichier joint pour stocker le document au niveau de l infrastructure
    And cliquer sur Créer document
    #And saisir  code document
    And saisir Mot clé spécifique
    And cliquer sur valider Creation Document
    And cliquer sur Rédacteur en bas de page
    And consulter agenda documentation documents à valider par le rédacteur
    And insérer code documents
    And cliquer sur le document en question
    And cliquer sur visualiser le document et vérifier son téléchargement et stockage sur plateforme
    And cliquer sur vérificateur bleu
    And vérifier que les données existent au niveau des reportings document en cours
    And consulter agenda documentation documents à valider par le vérificateur
    And insérer code documents
    And cliquer sur le document en question
    And cliquer sur visualiser le document et vérifier son téléchargement et stockage sur plateforme
    And cliquer sur approbateur bleu
    And vérifier que les données existent au niveau des reportings document en cours
    And consulter agenda documentation documents à valider par l approbateur
    And insérer code documents
    And cliquer sur le document en question
    And cliquer sur visualiser le document et vérifier son téléchargement et stockage sur plateforme
    And cliquer sur Envoi diffusion bleu
    And consulter agenda documentation documents en attente de diffusion
    And insérer code documents
    And cliquer sur le document en question
    And cliquer sur visualiser le document à diffuser et vérifier son téléchargement et stockage sur plateforme
    And cliquer sur Mise en vigueur bleu
    And consulter agenda documentation documents à consulter
    And insérer code documents à consulter
    And cliquer sur le document à consulter
    And cliquer sur Visualiser  document en bleu vérifier son téléchargement et stockage sur plateforme
    And cliquer sur J ai consulté ce document
    And cliquer sur raccourci consulter doc interne
    And rechercher code documents niveau filtre
    And cliquer sur le document interne en question
    And cliquer sur commentaire
    And cliquer sur Ajouter
    And cliquer saisir message au superviseur
    And Envoyer au superviseur
    And Supprimer les fichiers temporaires de l infrastructure
    Examples:
      | responsable | exemple | module          | Filaile |
      | 5           | 1       | "Documentation" | "MONO"  |


