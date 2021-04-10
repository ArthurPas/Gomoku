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
import Exception.ExceptionQuitter;
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
    public static void main(String[] args) throws ExceptionPositionDejaPose, ExceptionHorsDuPlateau, ExceptionPasVoisin, ExceptionQuitter {
        final Couleur couleurPremierJoueur = Couleur.BLANC;
        final Couleur couleurDeuxiemeJoueur = Couleur.NOIR;
        Match match = new Match(0, 0);
        match.tailleX = UtilsGomo.SaisieLigne(match);
        match.tailleY = UtilsGomo.SaisieColonne(match);
        Plateau plateau = new Plateau(match);
        Partie partie = new Partie(couleurPremierJoueur, plateau);
        System.out.println("Rentrer le nom du premier Joueur");
        String nomJUn = UtilsGomo.lireLigne();
        System.out.println("Merci et bienvenue " + nomJUn);
        System.out.println("Rentrer le nom du deuxieme Joueur");
        String nomJDeux = UtilsGomo.lireLigne();
        System.out.println("Merci et bienvenue " + nomJDeux);

        String nomDernierJoueur = nomJUn;
        System.out.println("Bienvenue dans GOMOKU ");
        System.out.println("Choisir parmi les possiblité : ");
        System.out.println("1- Humain VS Humain");
        System.out.println("2- Humain VS Robot");
        System.out.println("3- Robot VS Robot");
        System.out.println("4- Quitter");
        String choixDebut = UtilsGomo.lireLigne();
        System.out.println(choixDebut);
        switch (choixDebut) {
            case "1":
                Joueur joueurUn = new JoueurHumain(nomJUn, couleurPremierJoueur);
                Joueur joueurDeux = new JoueurHumain(nomJDeux, couleurDeuxiemeJoueur);
                UtilsGomo.deroulementPartie(couleurPremierJoueur, couleurDeuxiemeJoueur, joueurUn, joueurDeux, match, plateau, partie, nomJUn, nomJDeux);
                System.out.println("Bravo au joueur " + nomDernierJoueur + " qui a gagné cette partie !");
                break;
             case "2":
                Joueur j1 = new JoueurHumain(nomJUn, couleurPremierJoueur);
                Joueur j2 = new JoueurRobot(couleurDeuxiemeJoueur);
                UtilsGomo.deroulementPartie(couleurPremierJoueur, couleurDeuxiemeJoueur, j1, j2, match, plateau, partie, nomJUn, nomJDeux);
                System.out.println("Bravo au joueur " + nomDernierJoueur + " qui a gagné cette partie !");
                break;
            case "3":
                Joueur joueur = new JoueurRobot(couleurPremierJoueur);
                Joueur joueurbis = new JoueurRobot(couleurDeuxiemeJoueur);
                UtilsGomo.deroulementPartie(couleurPremierJoueur, couleurDeuxiemeJoueur, joueur, joueurbis, match, plateau, partie, nomJUn, nomJDeux);
                System.out.println("Bravo au joueur " + nomDernierJoueur + " qui a gagné cette partie !");
                break;
            case "4":
                break;
        }
        System.out.println(Partie.listeCoup);
    }
}
