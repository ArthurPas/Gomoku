/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import java.util.HashSet;

/**
 *
 * @author Arthur & Wijdan 
 */
public class Plateau {
    HashSet <Position> listePositions;
    
    
    public Plateau(){
        this.listePositions = new HashSet<Position>();
    }
    
    public void init(Match m){
        for(int col =0; col<m.tailleY; col++){
            for(int lig=0; lig<m.tailleX; lig++){
                Position p = new Position((char)lig,col);
                p.pionPresent =false;
                p.couleur=Couleur.RIEN;
                listePositions.add(p);
            }
        }
    }
    /**
     * Méthode set qui permet d'associer une couleur a une position
     * @param p la position
     * @param c la couleur
     */
    public static void set (Position p, Couleur c){
        p.pionPresent = true;
        p.couleur = c;
    }
    /**
     * Méthode qui permet de recuperer la couleur d'une position
     * @param p la position
     * @return la couleur de la position
     */
    public static Couleur get(Position p){
        return p.couleur;
    }
}
