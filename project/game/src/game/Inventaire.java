package game;


import java.util.ArrayList;

public class Inventaire {
    private ArrayList<Objet> objets;

    public Inventaire() {
        this.objets = new ArrayList<>();
    }


    public void ajouterObjet(Objet objet) {
        this.objets.add(objet);
        System.out.println("Vous avez ajouté " + objet.getNom() + " à votre inventaire.");
    }


    public ArrayList<Objet> getObjets() {
        return this.objets;
    }


    public void utiliserObjet(int index, Personnage personnage) {
        if (index >= 0 && index < objets.size()) {
            Objet objet = objets.get(index);
            System.out.println("Vous utilisez " + objet.getNom() + ".");
            objet.utiliser(personnage);
            objets.remove(index);
        } else {
            System.out.println("Choix invalide. Aucun objet utilisé.");
        }
    }
}




