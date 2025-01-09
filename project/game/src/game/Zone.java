package game;

import java.util.Random;

public class Zone {
    private String nom;
    private String description;

    public Zone(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    // evenement speciale dans la zone
    public void evenementSpecial(Personnage joueur, Personnage[] adversaires) {
        Random rand = new Random();
        int chance = rand.nextInt(100);

        // 20% de chance pour un evenement speciale
        if (chance < 20) {
            System.out.println("Un événement spécial se produit dans la zone " + this.nom + " !");
            //un Example pour un evenment de Buff ou  debuff pour le joueur et laddversaire
            int bonus = rand.nextInt(10) + 1;  // Random bonus for the player
            joueur.degats += bonus;
            System.out.println(joueur.getNom() + " reçoit un boost de " + bonus + " dégâts !");
        }

        // un autre evenment aleatoires pour les adversaires
        if (chance < 20) {
            Personnage adversaire = adversaires[rand.nextInt(adversaires.length)];
            if (adversaire.estVivant()) {
                int malus = rand.nextInt(5) + 1;  // un debuff aleatoire pour adversaire
                adversaire.degats -= malus;
                System.out.println(adversaire.getNom() + " subit une malédiction et perd " + malus + " dégâts !");
            }
        }
    }
}
