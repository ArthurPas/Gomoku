/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import java.util.HashSet;
import java.util.Scanner;

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
        final String nomJUn = "bob";
        final String nomJDeux = "anna";
        Scanner in = new Scanner(System.in);
        Plateau plateau = new Plateau();
        Partie partie = new Partie(premierJoueur,plateau);
        Match match = new Match(3,3);
        Joueur joueurUn = new JoueurHumain(nomJUn, premierJoueur);
        Joueur joueurDeux = new JoueurHumain(nomJDeux, premierJoueur);
        plateau.init(match);
        for(Position i : plateau.listePositions ){
            System.out.println(i +" " +i.pionPresent +" "+ i.couleur);
        }
        
        while(!partie.partieFinie()){
        
        System.out.println("Joueur " + nomJUn+ " Choisir votre coup : ");
        Position choixJoueurUn = joueurUn.choix(in.nextLine());
        partie.actualiser(choixJoueurUn,premierJoueur,match);
        for(Position i : plateau.listePositions ){
            System.out.println(i +" " +i.pionPresent+" "+ i.couleur);
        }
        partie.ajouterTour(choixJoueurUn);
        System.out.println("Joueur " + nomJDeux+ " Choisir votre coup : ");
        Position choixJoueurDeux= joueurDeux.choix(in.nextLine());
        partie.actualiser(choixJoueurDeux,deuxiemeJoueur,match);
        for(Position i : plateau.listePositions ){
            System.out.println(i +" " +i.pionPresent+" "+ i.couleur);
        }
        partie.ajouterTour(choixJoueurDeux);
        }

    }
    
    public static void plateau() {
        // TODO code application logic here
    }
     
 
     
     
}


//etape creer deux joueurs
// etape
//etape une plateau