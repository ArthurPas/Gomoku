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
public class Match {
    static int tailleX;
    static int tailleY;
    
    /**
     * Constructeur du match
     * @param X le nombre de colonnes 
     * @param Y le nomnre de lignes 
     */
    public Match(int X, int Y, Joueur jUn, Joueur jDeux){
        tailleX = X;
        tailleY = Y;
    }
    /**
     * Retourne si la position p est bien dans le plateau
     * @param p la position a verifié
     * @return vrai si elle est comprise entre 0 et la taille maximale du plateau
     */
    public static boolean estDansPlateau(Position p){
        return (p.colonne >= 0 && p.ligne >=0 && p.colonne <= tailleX && 
                p.ligne <= tailleY);
    }
    
    /**
     * Methode qui permet de dire si il est possible de jouer (si un pion n'est 
     * pas présent sur la position)
     * @param p la position
     * @return true si aucun pion n'est présent
     */
    public static boolean jouer(Position p){
        return !p.pionPresent && estDansPlateau(p);
    }
}
