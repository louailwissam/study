package game;

public class Objet {
    private String nom;
    private String description;
    private int effet;


    public Objet(String nom, String description, int effet) {
        this.nom = nom;
        this.description = description;
        this.effet = effet;
    }


    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public int getEffet() {
        return effet;
    }


    public void utiliser(Personnage personnage) {
        System.out.println(personnage.getNom() + " utilise " + nom + ".");
        if (effet > 0) {
            personnage.recevoirDegats(-effet);
            System.out.println(personnage.getNom() + " récupère " + effet + " points de vie !");
        } else {
            personnage.recevoirDegats(effet);
            System.out.println(personnage.getNom() + " subit " + Math.abs(effet) + " points de dégâts !");
        }
    }
}


