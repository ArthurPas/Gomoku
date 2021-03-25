/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

/**
 *
 * @author Arthur & Wijdan 
 */
public class Plateau {
    
    /**
     * Méthode set qui permet d'associer une couleur a une position
     * @param p la position
     * @param c la couleur
     */
    public void set (Position p, Couleur c){
        p.couleur = c;       
    }
    /**
     * Méthode qui permet de recuperer la couleur d'une position
     * @param p la position
     * @return la couleur de la position
     */
    public Couleur get(Position p){
        return p.couleur;
    }
}
