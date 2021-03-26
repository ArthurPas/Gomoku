/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

/**
 *
 * @author Arthur & Wijdan 
 */
public class Gomoku {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Couleur premierJoueur = Couleur.BLANC;
        final Couleur deuxiemeJoueur = Couleur.NOIR;
        final String nom = "bob";
        Plateau plateau = new Plateau();
        Partie partie = new Partie(premierJoueur,plateau);
        Match match = new Match(20,20);
        
        Joueur joueurUn = new JoueurHumain(nom, premierJoueur);
        System.out.println("Choisir votre coup : ");
        Position choixJoueur = joueurUn.choix(plateau);
        partie.Actualiser(choixJoueur,premierJoueur,plateau,deuxiemeJoueur, joueurUn, match);
        Couleur a = Plateau.get(choixJoueur);
        String test = UtilsGomo.couleurVersString(a);
        System.out.println(test);
    }
    
    public static void plateau() {
        // TODO code application logic here
    }
     
 
     
     
}


//etape creer deux joueurs
// etape
//etape une plateau