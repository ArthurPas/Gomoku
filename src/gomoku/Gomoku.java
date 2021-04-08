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
        boolean victoire = false;
        Match match = new Match(0,0);
        match.tailleX=UtilsGomo.SaisieLigne(match);
        match.tailleY=UtilsGomo.SaisieColonne(match);
        Plateau plateau = new Plateau(match);
        Partie partie = new Partie(couleurPremierJoueur, plateau);
        Joueur joueurUn = new JoueurHumain(nomJUn, couleurPremierJoueur);
        Joueur joueurDeux = new JoueurHumain(nomJDeux, couleurPremierJoueur);
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
                
            }
            System.out.println(plateau.afficherPlateauActualise(match, partie.listeCoup.get(partie.listeCoup.size()-1)));
            if(partie.victoire(match, plateau)){
                victoire = true;
            }
            else{
                 partie.effectuerTour(nomJUn, joueurUn, couleurPremierJoueur, match);
                
            }
           
            System.out.println(plateau.afficherPlateauActualise(match, partie.listeCoup.get(partie.listeCoup.size()-1)));
        }
    }
}