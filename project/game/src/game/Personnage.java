



package game;
abstract class Personnage implements Attaquable {
    protected String nom;
    protected int pointsDeVie;
    protected int degats;
    protected int niveau;
    protected int experience;
    protected int toursAvantCompetence = 3;  // Compteur de tours avant d'utiliser la compétence spéciale

    public Personnage(String nom, int pointsDeVie, int degats) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.degats = degats;
        this.niveau = 1;
        this.experience = 0;
    }

    public void recevoirDegats(int degats) {
        this.pointsDeVie -= degats;
        System.out.println(this.nom + " a reçu " + degats + " points de dégâts. Points de vie restants : " + this.pointsDeVie);
    }

    public boolean estVivant() {
        return this.pointsDeVie > 0;
    }

    public String getNom() {
        return this.nom;
    }

    public void gagnerExperience(int xp) {
        this.experience += xp;
        System.out.println(this.nom + " a gagné " + xp + " points d'expérience. Total : " + this.experience);

        // Vérification si le joueur passe au niveau suivant
        while (this.experience >= 100) {
            this.experience -= 100; // Réduire l'expérience excédentaire
            this.niveau++; // Monter d'un niveau
            this.pointsDeVie += 20; // Bonus de points de vie
            this.degats += 5; // Bonus de dégâts

            System.out.println(this.nom + " est monté au niveau " + this.niveau + " !");
            System.out.println("Points de vie augmentés à " + this.pointsDeVie + ". Dégâts augmentés à " + this.degats + ".");
        }
    }

    // Vérifie si la compétence est prête à être utilisée (après 3 tours)
    public boolean peutUtiliserCompetence() {
        return toursAvantCompetence <= 0;
    }

    // Réinitialise le compteur de tours et permet d'utiliser la compétence
    public void reinitialiserCompetence() {
        this.toursAvantCompetence = 3;  // Réinitialisation à 3 tours avant de pouvoir utiliser la compétence à nouveau
    }

    // Compte les tours écoulés
    public void decrementerToursAvantCompetence() {
        if (toursAvantCompetence > 0) {
            toursAvantCompetence--;
        }
    }
}


