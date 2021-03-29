/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import Exception.ExceptionHorsDuPlateau;
import Exception.ExceptionPositionDejaPose;
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
    public static void main(String[] args) throws ExceptionPositionDejaPose, ExceptionHorsDuPlateau {
        final Couleur couleurPremierJoueur = Couleur.BLANC;
        final Couleur couleurDeuxiemeJoueur = Couleur.NOIR;
        final String nomJUn = "bob";
        final String nomJDeux = "anna";
        Scanner in = new Scanner(System.in);
        Match match = new Match(3, 3);
        Plateau plateau = new Plateau(match);
        Partie partie = new Partie(couleurPremierJoueur, plateau);
        Joueur joueurUn = new JoueurHumain(nomJUn, couleurPremierJoueur);
        Joueur joueurDeux = new JoueurHumain(nomJDeux, couleurPremierJoueur);
        plateau.init(match);
        for (int i=0; i<match.tailleX; i++){
            for(int j = 0; j< match.tailleY; j++){
                System.out.println(plateau.listePositions[i][j] + " "
                + " " + plateau.listePositions[i][j].couleur );
            }
        }
        
        while(!partie.partieFinie()){
            partie.effectuerTour(nomJUn, joueurUn, couleurPremierJoueur, match);
            partie.effectuerTour(nomJDeux, joueurDeux, couleurDeuxiemeJoueur, match);
        }
    }
    
    public static void plateau() {
        // TODO code application logic here  
    }
}