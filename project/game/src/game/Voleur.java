package game;
class Voleur extends Personnage {
    public Voleur(String nom) {
        super(nom, 70, 12);
    }

    public void attaquer(Personnage cible) {
        String var10001 = this.nom;
        System.out.println(var10001 + " attaque furtivement " + cible.getNom() + " !");
        cible.recevoirDegats(this.degats);
        if (Math.random() < 0.2) {
            System.out.println(this.nom + " inflige un coup critique !");
            cible.recevoirDegats(this.degats);
        }

    }

    public void utiliserCompetence(Personnage cible) {
        System.out.println(this.nom + " utilise sa compétence spéciale : Attaque rapide !");
        cible.recevoirDegats(this.degats * 3);
    }
}


