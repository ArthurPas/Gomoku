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
    Couleur prochainJoueur;
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
        this.listeCoup = new ArrayList<>();
    }
    
    /**
     * Methode qui actualise le plateau 
     * @param p la position dernierement jouée
     * @param couleurPion la couleur du joueur qui vient de jouable
     * @param match le match
     */
    public void actualiser(Position p, Couleur couleurPion, Match match){
        
        if(Match.jouable(p, match)){ 
            Plateau.set(p, couleurPion);
        }
        if( couleurPion == Couleur.NOIR ){
            this.prochainJoueur = Couleur.BLANC;
            
        }
        else if(couleurPion == Couleur.BLANC ){
            this.prochainJoueur = Couleur.NOIR;
        }
        else if(couleurPion == Couleur.RIEN){
            this.prochainJoueur = PremierJoueur;
        }
        else if(!Match.jouable(p, match)){
            System.out.println("Impossible");
        }
        //TODO Exception if jouable = false
    }
    public void ajouterTour(Position p){
        listeCoup.add(p.ligne + p.colonne );
    }
    public boolean partieFinie(){
        return false;
    }
}
