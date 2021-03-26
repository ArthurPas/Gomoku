/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import java.util.ArrayList;

/**
 *
 * @author Arthur & Wijdan 
 */
public class Partie {
    final Couleur prochainJoueur;
    Plateau plateau;
    ArrayList listeCoup;
    Couleur PremierJoueur;
    /**
    * Constructeur de la partie
    * @param prochainJoueur couleur du prochain joueur
    * @param plateau le plateau
    */
    public Partie(Couleur prochainJoueur, Plateau plateau) {
        this.prochainJoueur = prochainJoueur;
        this.plateau = plateau;
    }
    
    /**
     * Methode qui actualise le plateau 
     * @param p la position dernierement jouée
     * @param joueurPrecedent la couleur du joueur qui vient de jouer 
     * @param plateau la plateau
     * @param joueurSuivant la couleur du joueur qui s'appréte a jouer
     */
    public void Actualiser(Position p, Couleur joueurPrecedent, Plateau plateau,
            Couleur joueurSuivant, Joueur joueur){
        if(Match.jouer(p) && joueurPrecedent == Couleur.NOIR ){
            joueurSuivant = Couleur.BLANC;
            Plateau.set(joueur.choix(plateau), joueurPrecedent);
        }
        else if(Match.jouer(p) && joueurPrecedent == Couleur.BLANC ){
            joueurSuivant = Couleur.NOIR;
            Plateau.set(joueur.choix(plateau), joueurPrecedent);
        }
        else if(Match.jouer(p) && joueurPrecedent == Couleur.RIEN){
            joueurSuivant = PremierJoueur;
            Plateau.set(joueur.choix(plateau), PremierJoueur);
        }
        //TODO Exception if jouer = false
    }
    public void AjouterTour(ArrayList listeCoup, Position p){
        listeCoup.add("col = " + p.colonne + " lig = " + p.ligne + "couleur = " +
                p.couleur);
    }
    
}
