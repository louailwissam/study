package game;

import java.util.Scanner;

public class Play {
    public void Play() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Personnage guerrier = new Guerrier("Thor");
        Personnage mage = new Mage("Gandalf");
        Personnage voleur = new Voleur("Loki");

        while (((Personnage) guerrier).estVivant() && ((Personnage) mage).estVivant() && ((Personnage) voleur).estVivant()) {
            System.out.println("\n--- Tour de combat ---");
            ((Personnage) guerrier).attaquer(mage);
            ((Personnage) mage).gagnerExperience(10);
            if (!((Personnage) mage).estVivant()) {
                System.out.println(((Personnage) mage).getNom() + " est vaincu !");
                break;
            }

            ((Personnage) mage).attaquer(guerrier);
            ((Personnage) guerrier).gagnerExperience(10);
            if (!((Personnage) guerrier).estVivant()) {
                System.out.println(((Personnage) guerrier).getNom() + " est vaincu !");
                break;
            }

            ((Personnage) voleur).attaquer(mage);
            ((Personnage) voleur).gagnerExperience(10);
            if (!((Personnage) mage).estVivant()) {
                System.out.println(((Personnage) mage).getNom() + " est vaincu !");
                break;
            }

            ((Personnage) voleur).utiliserCompetence(guerrier);
            if (!((Personnage) guerrier).estVivant()) {
                System.out.println(((Personnage) guerrier).getNom() + " est vaincu !");
                break;
            }
        }
    }

}