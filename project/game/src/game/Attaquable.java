package game;

import java.util.Scanner;

public interface Attaquable {
    void attaquer(Personnage var1);

    void utiliserCompetence(Personnage var1);
}
/*public class Play02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        afficherHistoireIntroduction();
        private static void afficherHistoireIntroduction(){
            System.out.println("Bienvenue dans le royaume des héros. Un mal ancien est revenu, menaçant la paix.");
            System.out.println("Trois héros doivent se dresser contre cette menace : Thor, le Guerrier; Floki, le Mage; et Loki, le Voleur.");
            System.out.println("Choisissez votre personnage et préparez-vous à la bataille !");
            System.out.println("=========================================");
        }

        // Création des personnages
        Personnage guerrier = new Guerrier("Thor");
        Personnage mage = new Mage("Floki");
        Personnage voleur = new Voleur("Loki");

        // Sélection du personnage du joueur
        System.out.println("Choisissez votre personnage :");
        System.out.println("1. Guerrier");
        System.out.println("2. Mage");
        System.out.println("3. Voleur");

        int choix = scanner.nextInt();
        Personnage joueur;
        Personnage[] adversaires;

// Définir le joueur et les adversaires en fonction du choix
        switch (choix) {
            case 1:
                joueur = guerrier;
                adversaires = new Personnage[]{mage, voleur};
                break;
            case 2:
                joueur = mage;
                adversaires = new Personnage[]{guerrier, voleur};
                break;
            case 3:
                joueur = voleur;
                adversaires = new Personnage[]{guerrier, mage};
                break;
            default:
                System.out.println("Choix invalide. Le guerrier est sélectionné par défaut.");
                joueur = guerrier;
                adversaires = new Personnage[]{mage, voleur};
        }



        // Adversaires


        // Boucle principale du jeu
        while (joueur.estVivant() && (adversaires[0].estVivant() || adversaires[1].estVivant())) {
            System.out.println("\n--- Tour de combat ---");
            System.out.println("Choisissez une action :");
            System.out.println("1. Attaquer un adversaire");
            System.out.println("2. Utiliser compétence spéciale");
            System.out.println("3. Passer son tour");

            int action = scanner.nextInt();
            switch (action) {
                case 1: // Attaque
                    Personnage cibleAttaque = choisirAdversaire(scanner, adversaires);
                    if (cibleAttaque != null) {
                        joueur.attaquer(cibleAttaque);
                    }
                    break;
                case 2: // Compétence spéciale
                    Personnage cibleCompetence = choisirAdversaire(scanner, adversaires);
                    if (cibleCompetence != null) {
                        joueur.utiliserCompetence(cibleCompetence);
                    }
                    break;
                case 3: // Passer son tour
                    System.out.println(joueur.getNom() + " passe son tour.");
                    break;
                default:
                    System.out.println("Action invalide.");
            }

            // Les adversaires réagissent
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

        // Fin du jeu
        System.out.println("Le combat est terminé !");
        if (joueur.estVivant()) {
            System.out.println(joueur.getNom() + " a remporté la victoire !");
        } else {
            System.out.println("Vous avez perdu !");
        }

        scanner.close();
    }

    /**
     * Méthode pour choisir un adversaire.
     */
/*private static Personnage choisirAdversaire(Scanner scanner, Personnage[] adversaires) {
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
}*/
