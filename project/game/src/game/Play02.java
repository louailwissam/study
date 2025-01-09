package game;

import java.util.Scanner;



import java.util.Scanner;

public class Play02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Introduction pour ajouter un mode "histoire"
        afficherHistoireIntroduction();

        // Création des personnages
        Personnage guerrier = new Guerrier("Thor");
        Personnage mage = new Mage("Floki");
        Personnage voleur = new Voleur("Loki");

        // Choix du personnage
        Personnage joueur = choisirPersonnage(scanner, guerrier, mage, voleur);

        //  présentation du  choix
        afficherDialogueIntro(joueur);

        // Création des zones
        Zone zone1 = new Zone("SOMBRAFATAL", "Une forêt sombre et pleine de maledictions!!.");
        Zone zone2 = new Zone("TERRAGIETA", "Un terrain ravagé par la guerre.");
        Zone zone3 = new Zone("NEVACUMBRE", "Des montagnes glacées où la neige ne fond jamais.");

           // le joueur choisi la zone qui sera ensuite afficher
        Zone zoneChoisie = choisirZone(scanner, zone1, zone2, zone3);
        System.out.println("Vous avez choisi la zone : " + zoneChoisie.getNom());
        System.out.println(zoneChoisie.getDescription());
        System.out.println("=========================================");

        // creer un inventaire
        Inventaire inventaire = new Inventaire();

        // Ajouter les  objets  à la zone
        ajouterObjetsParZone(zoneChoisie, inventaire);

        // Choix des adversaires
        Personnage[] adversaires = choisirAdversaires(joueur, guerrier, mage, voleur);









        while (joueur.estVivant() && (adversaires[0].estVivant() || adversaires[1].estVivant())) {
            System.out.println("\n--- Tour de combat ---");

            // Effet spécial de la zone
            zoneChoisie.evenementSpecial(joueur, adversaires);

            System.out.println("Choisissez une action :");
            System.out.println("1. Attaquer un adversaire");
            System.out.println("2. Utiliser compétence spéciale");
            System.out.println("3. Passer son tour");
            System.out.println("4. Utiliser un objet");

            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    Personnage cibleAttaque = choisirAdversaire(scanner, adversaires);
                    if (cibleAttaque != null) {
                        joueur.attaquer(cibleAttaque);
                        if (!cibleAttaque.estVivant()) {
                            System.out.println(cibleAttaque.getNom() + " a été vaincu !");
                            joueur.gagnerExperience(50);
                        }
                    }
                    break;
                case 2:
                    if (joueur.peutUtiliserCompetence()) {
                        Personnage cibleCompetence = choisirAdversaire(scanner, adversaires);
                        if (cibleCompetence != null) {
                            joueur.utiliserCompetence(cibleCompetence);
                            if (!cibleCompetence.estVivant()) {
                                System.out.println(cibleCompetence.getNom() + " a été vaincu !");
                                joueur.gagnerExperience(50);
                            }
                        }
                        // Réinitialiser le compteur de tours après utilisation
                        joueur.reinitialiserCompetence();
                    } else {
                        System.out.println("La compétence spéciale n'est pas prête. Attendez " + joueur.toursAvantCompetence + " tour(s) supplémentaires.");
                    }
                    break;
                case 3:
                    System.out.println(joueur.getNom() + " passe son tour.");
                    break;
                case 4:
                    utiliserObjet(scanner, inventaire, joueur);
                    break;
                default:
                    System.out.println("Action invalide.");
            }

            // Réduction du compteur de tours pour la compétence
            joueur.decrementerToursAvantCompetence();

            // Réaction des adversaires
            for (Personnage adversaire : adversaires) {
                if (adversaire.estVivant()) {
                    adversaire.attaquer(joueur);
                    if (!joueur.estVivant()) {
                        System.out.println(joueur.getNom() + " est vaincu !");
                        break;
                    }
                }
            }
        }



        afficherFinDeJeu(joueur);

        scanner.close();
    }
     // les methodes
    private static void ajouterObjetsParZone(Zone zone, Inventaire inventaire) {
        if (zone.getNom().equals("SOMBRAFATAL")) {
            inventaire.ajouterObjet(new Objet("Potion de Soin", "Une potion qui restaure 50 points de vie.", 50));
        } else if (zone.getNom().equals("TERRAGIETA")) {
            inventaire.ajouterObjet(new Objet("Élixir de Force", "Augmente les dégâts de 15 pour un tour.", -15));
        } else if (zone.getNom().equals("NEVACUMBRE")) {
            inventaire.ajouterObjet(new Objet("Cristal Gelé", "Inflige 10 dégâts à un adversaire.", -10));
        }
    }

    private static void utiliserObjet(Scanner scanner, Inventaire inventaire, Personnage joueur) {
        System.out.println("Inventaire :");
        for (int i = 0; i < inventaire.getObjets().size(); i++) {
            Objet objet = inventaire.getObjets().get(i);
            System.out.println((i + 1) + ". " + objet.getNom() + " - " + objet.getDescription());
        }
        System.out.println("Choisissez un objet à utiliser :");
        int choixObjet = scanner.nextInt() - 1;
        inventaire.utiliserObjet(choixObjet, joueur);
    }

    private static void afficherHistoireIntroduction() {
        System.out.println("BIENVENUE !! dans le royaume ERYNDOR. Un mal ancien est revenu, menaçant la paix.");
        System.out.println("Trois héros doivent se dresser contre cette menace : Thor, le Guerrier; Floki, le Mage; et Loki, le Voleur. Un combat entre ces derniers déterminera qui est le plus apte à vaincre le mal.");
        System.out.println("Choisissez votre personnage et préparez-vous à la bataille !");
        System.out.println("=========================================");
    }

    private static Personnage choisirPersonnage(Scanner scanner, Personnage guerrier, Personnage mage, Personnage voleur) {
        System.out.println("Choisissez votre personnage :");
        System.out.println("1. Guerrier");
        System.out.println("2. Mage");
        System.out.println("3. Voleur");

        int choix = scanner.nextInt();
        Personnage joueur;

        switch (choix) {
            case 1:
                joueur = guerrier;
                break;
            case 2:
                joueur = mage;
                break;
            case 3:
                joueur = voleur;
                break;
            default:
                System.out.println("Choix invalide. Le Guerrier est sélectionné par défaut.");
                joueur = guerrier;
        }

        return joueur;
    }

    private static void afficherDialogueIntro(Personnage joueur) {
        if (joueur instanceof Guerrier) {
            System.out.println(joueur.getNom() + " : \"Je suis Thor, fils d'Odin. Je protégerai ce royaume à tout prix !\"");
        } else if (joueur instanceof Mage) {
            System.out.println(joueur.getNom() + " : \"Je suis Floki, le mage. La magie est ma seule arme, et je la maîtrise parfaitement.\"");
        } else if (joueur instanceof Voleur) {
            System.out.println(joueur.getNom() + " : \"Je suis Loki, et je préfère les ombres. Mais je ne reculerai pas face à ce danger !\"");
        }
        System.out.println("=========================================");
    }

    private static Personnage[] choisirAdversaires(Personnage joueur, Personnage guerrier, Personnage mage, Personnage voleur) {
        Personnage[] adversaires;

        if (joueur instanceof Guerrier) {
            adversaires = new Personnage[]{mage, voleur};
        } else if (joueur instanceof Mage) {
            adversaires = new Personnage[]{guerrier, voleur};
        } else {
            adversaires = new Personnage[]{guerrier, mage};
        }

        System.out.println("Vos adversaires sont : ");
        for (Personnage adversaire : adversaires) {
            System.out.println(adversaire.getNom());
        }
        System.out.println("=========================================");
        return adversaires;
    }

    //  choisir la zone de combat
    private static Zone choisirZone(Scanner scanner, Zone zone1, Zone zone2, Zone zone3) {
        System.out.println("Choisissez une zone de combat :");
        System.out.println("1. " + zone1.getNom());
        System.out.println("2. " + zone2.getNom());
        System.out.println("3. " + zone3.getNom());

        int choix = scanner.nextInt();
        Zone zoneChoisie;

        switch (choix) {
            case 1:
                zoneChoisie = zone1;
                break;
            case 2:
                zoneChoisie = zone2;
                break;
            case 3:
                zoneChoisie = zone3;
                break;
            default:
                System.out.println("Choix invalide. La zone 'SOMBRAFATAL' est sélectionnée par défaut.");

                zoneChoisie = zone1;
        }

        return zoneChoisie;
    }

    // Méthode qui affiche la fin du jeu
    private static void afficherFinDeJeu(Personnage joueur) {
        System.out.println("Le combat est terminé !");
        if (joueur.estVivant()) {
            System.out.println(joueur.getNom() + " a remporté la victoire !");
        } else {
            System.out.println("Vous avez perdu ! L'ennemi a triomphé.");
        }
        System.out.println("Merci d'avoir joué !");
    }

    // Méthode pour choisir un adversaire
    private static Personnage choisirAdversaire(Scanner scanner, Personnage[] adversaires) {
        System.out.println("Choisissez un adversaire :");
        for (int i = 0; i < adversaires.length; i++) {
            if (adversaires[i].estVivant()) {
                System.out.println((i + 1) + ". " + adversaires[i].getNom());
            }
        }

        int choix = scanner.nextInt() - 1;
        if (choix >= 0 && choix < adversaires.length && adversaires[choix].estVivant()) {
            return adversaires[choix];
        } else {
            System.out.println("Cible invalide.");
            return null;
        }
    }


}
