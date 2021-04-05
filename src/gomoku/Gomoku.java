/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import Exception.ExceptionHorsDuPlateau;
import Exception.ExceptionPasVoisin;
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
    public static void main(String[] args) throws ExceptionPositionDejaPose, ExceptionHorsDuPlateau, ExceptionPasVoisin {
        final Couleur couleurPremierJoueur = Couleur.BLANC;
        final Couleur couleurDeuxiemeJoueur = Couleur.NOIR;
        final String nomJUn = "Blanc";
        final String nomJDeux = "Noir";
        Scanner in = new Scanner(System.in);
        
        Match match = new Match(0,0);
        match.tailleX= 3;//UtilsGomo.SaisieLigne(match);
        match.tailleY=3;//UtilsGomo.SaisieColonne(match);
        Plateau plateau = new Plateau(match);
        Partie partie = new Partie(couleurPremierJoueur, plateau);
        Joueur joueurUn = new JoueurHumain(nomJUn, couleurPremierJoueur);
        Joueur joueurDeux = new JoueurHumain(nomJDeux, couleurPremierJoueur);
        plateau.init(match);
        //affiche le tableau visuellement
        System.out.println(plateau.affichageGame(match));
      
     //debug
        for (int i=0; i<match.tailleX; i++){
            for(int j = 0; j< match.tailleY; j++){
                System.out.println(plateau.listePositions[i][j] + " "
                + " " + plateau.listePositions[i][j].couleur );
            }
        }
        
        partie.effectuerPremierTour(nomJUn, joueurUn, couleurPremierJoueur, match);
        while(!partie.victoire(match, plateau)){
            partie.effectuerTour(nomJDeux, joueurDeux, couleurDeuxiemeJoueur, match);
            /*
            
                for (int i=0; i<match.tailleX; i++){
                    for(int j = 0; j< match.tailleY; j++){
                        System.out.println(plateau.listePositions[i][j] + " "
                        + " " + plateau.listePositions[i][j].couleur );
                    }
        }
*/
        partie.effectuerTour(nomJUn, joueurUn, couleurPremierJoueur, match);
         System.out.println(plateau.actualiserGame(match, partie.listeCoup.get(partie.listeCoup.size()-1)));
        /*
        for (int i=0; i<match.tailleX; i++){
            for(int j = 0; j< match.tailleY; j++){
                System.out.println(plateau.listePositions[i][j]+ " " + plateau.listePositions[i][j].couleur);
            }
        }*/
            System.out.println(Partie.listeCoup);
        }
    }
}