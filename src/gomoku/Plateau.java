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
public class Plateau {
    Position [][] listePositions;
    
    
    public Plateau(Match m){
        this.listePositions = new Position [m.tailleX][m.tailleY];
    }
    
    public void init(Match m){
        for(int col =0; col<m.tailleY; col++){
            for(int lig=0; lig<m.tailleX; lig++){
                Position p = new Position((char)lig,col);
                p.pionPresent = false;
                p.couleur = Couleur.RIEN;
                this.listePositions[lig][col] = p;
            }
        }
    }
    /**
     * Méthode set qui permet d'associer une couleur a une position
     * @param p la position
     * @param c la couleur
     */
    public void set (Position p, Couleur c){
        this.listePositions[p.ligne][p.colonne].pionPresent = true;
        this.listePositions[p.ligne][p.colonne].couleur = c;
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
