package game;
class Guerrier extends Personnage {
    public Guerrier(String nom) {
        super(nom, 100, 10);
    }

    public void attaquer(Personnage cible) {
        String var10001 = this.nom;
        System.out.println(var10001 + " attaque " + cible.getNom() + " !");
        cible.recevoirDegats(this.degats);
    }

    public void utiliserCompetence(Personnage cible) {
        System.out.println(this.nom + " utilise sa compétence spéciale : Coup de rage !");
        cible.recevoirDegats(this.degats * 2);
    }
}


