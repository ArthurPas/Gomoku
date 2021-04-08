package gomoku;

import Utilitaire.UtilsGomo;
import utilisateur.JoueurHumain;
import utilisateur.Joueur;
import utilisateur.Couleur;
import Grille.Plateau;
import Grille.Match;
import Grille.Partie;
import Exception.ExceptionHorsDuPlateau;
import Exception.ExceptionPasVoisin;
import Exception.ExceptionPositionDejaPose;
import java.util.HashSet;
import java.util.Scanner;
import utilisateur.JoueurRobot;

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
        boolean victoire = false;
        Match match = new Match(0,0);
        match.tailleX=UtilsGomo.SaisieLigne(match);
        match.tailleY=UtilsGomo.SaisieColonne(match);
        Plateau plateau = new Plateau(match);
        Partie partie = new Partie(couleurPremierJoueur, plateau);
        //Joueur joueurUn = new JoueurHumain(nomJUn, couleurPremierJoueur);
        //Joueur joueurDeux = new JoueurHumain(nomJDeux, couleurDeuxiemeJoueur);
        Joueur joueurUn = new JoueurRobot(couleurPremierJoueur);
        Joueur joueurDeux = new JoueurRobot(couleurDeuxiemeJoueur);
        String nomDernierJoueur = nomJUn;
        plateau.init(match);
        System.out.println(plateau.afficherPlateau(match));
        partie.effectuerPremierTour(nomJUn, joueurUn, couleurPremierJoueur, match);
        System.out.println(plateau.afficherPlateauActualise(match, partie.listeCoup.get(partie.listeCoup.size()-1)));
        
        while(!victoire){
            if(partie.victoire(match, plateau)){
                victoire = true;
            }
            else{
                partie.effectuerTour(nomJDeux, joueurDeux, couleurDeuxiemeJoueur, match);
                nomDernierJoueur = nomJDeux;
                
            }
            System.out.println(plateau.afficherPlateauActualise(match, partie.listeCoup.get(partie.listeCoup.size()-1)));
            if(partie.victoire(match, plateau)){
                victoire = true;
            }
            else{
                partie.effectuerTour(nomJUn, joueurUn, couleurPremierJoueur, match);
                nomDernierJoueur = nomJUn;
            }
           
            System.out.println(plateau.afficherPlateauActualise(match, partie.listeCoup.get(partie.listeCoup.size()-1)));
        }
        System.out.println("Bravo au joueur " + nomDernierJoueur + " qui a gagné cette partie !");
    }
}