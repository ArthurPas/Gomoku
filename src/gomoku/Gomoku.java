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
        Match match = new Match(3, 3);
        Plateau plateau = new Plateau(match);
        Partie partie = new Partie(premierJoueur, plateau);
        Joueur joueurUn = new JoueurHumain(nomJUn, premierJoueur);
        Joueur joueurDeux = new JoueurHumain(nomJDeux, premierJoueur);
        plateau.init(match);
        for (int i=0; i<match.tailleX; i++){
            for(int j = 0; j< match.tailleY; j++){
                System.out.println(plateau.listePositions[i][j] + " "+ plateau.listePositions[i][j].pionPresent);
            }
        }
        
        while(!partie.partieFinie()){
        
        System.out.println("Joueur " + nomJUn+ " Choisir votre coup : ");
        Position choixJoueurUn = joueurUn.choix(UtilsGomo.lireLigne());
        partie.actualiser(choixJoueurUn, premierJoueur, match, plateau);
        for (int i=0; i<match.tailleX; i++){
            for(int j = 0; j< match.tailleY; j++){
                System.out.println(plateau.listePositions[i][j] + " "+ plateau.listePositions[i][j].pionPresent);
            }
        }
        partie.ajouterTour(choixJoueurUn);
        System.out.println("Joueur " + nomJDeux+ " Choisir votre coup : ");
        Position choixJoueurDeux= joueurDeux.choix(UtilsGomo.lireLigne());
        partie.actualiser(choixJoueurDeux, deuxiemeJoueur, match, plateau);
        for (int i=0; i<match.tailleX; i++){
            for(int j = 0; j< match.tailleY; j++){
                System.out.println(plateau.listePositions[i][j] + " "+ plateau.listePositions[i][j].pionPresent);
            }
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