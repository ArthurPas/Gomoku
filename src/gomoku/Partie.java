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
import java.util.ArrayList;

/**
 *
 * @author Arthur & Wijdan 
 */
public class Partie {
    final Couleur prochainJoueur;
    final Plateau plateau;
    final int tailleX;
    final int tailleY;
    ArrayList listeCoup;
    Couleur PremierJoueur;
    /**
    * Constructeur de la partie
    * @param prochainJoueur couleur du prochain joueur
    * @param plateau le plateau
    * @param X le nombre de cases sur les abscisees 
    * @param Y le nombre de cases sur les ordonnées 
    */
    public Partie(Couleur prochainJoueur, Plateau plateau, int X, int Y) {
        this.prochainJoueur = prochainJoueur;
        this.plateau = plateau;
        this.tailleX = X;
        this.tailleY = Y;
    }
    
    /**
     * Methode qui permet de dire si il est possible de jouer (si un pion n'est 
     * pas présent sur la position)
     * @param p la position
     * @return true si aucun pion n'est présent
     */
    public boolean jouer(Position p){
        return !p.pionPresent;
    }
    /**
     * Methode qui actualise le plateau 
     * @param p la position dernierement jouée
     * @param joueurPrecedent la couleur du joueur qui vient de jouer 
     * @param plateau la plateau
     * @param joueurSuivant la couleur du joueur qui s'appréte a jouer
     */
    public void actualiser(Position p, Couleur joueurPrecedent, Plateau plateau,
            Couleur joueurSuivant){
        if(this.jouer(p) && joueurPrecedent == Couleur.NOIR ){
            joueurSuivant = Couleur.BLANC;
        }
        else if(this.jouer(p) && joueurPrecedent == Couleur.BLANC ){
            joueurSuivant = Couleur.NOIR;
        }
        else if(this.jouer(p) && joueurPrecedent == Couleur.RIEN){
            joueurSuivant = PremierJoueur;
        }
        //TODO Exception if jouer = false
    }
    
}
