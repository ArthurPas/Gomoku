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
    final Plateau plateau;
    ArrayList listeCoup;

    public Partie(Couleur prochainJoueur, Plateau plateau) {
        this.prochainJoueur = prochainJoueur;
        this.plateau = plateau;
    }
    
    public boolean jouer(Position p){
        //TODO
        return false;
    }
    
}
