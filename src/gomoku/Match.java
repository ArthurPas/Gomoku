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
    int tailleX;
    int tailleY;
    
    /**
     * Constructeur du match
     * @param X le nombre de colonnes 
     * @param Y le nomnre de lignes 
     */
    public Match(int X, int Y){
        this.tailleX = X;
        this.tailleY = Y;
    }
    /**
     * Retourne si la position p est bien dans le plateau
     * @param p la position a verifié
     * @return vrai si elle est comprise entre 0 et la taille maximale du plateau
     */
    public boolean estDansPlateau(Position p){
        return (p.colonne >= 0 && p.ligne >=0 && p.colonne < tailleX && 
                p.ligne < tailleY);
    }
    
    /**
     * Methode qui permet de dire si il est possible de jouer (si un pion n'est 
     * pas présent sur la position et que la positon est dans le plateau)
     * @param p la position
     * @param match le match
     * @return true si aucun pion n'est présent et que le la position est dans 
     * le plateau
     */
    public static boolean jouable(Position p, Match match){
        return !(p.couleur == Couleur.RIEN) && match.estDansPlateau(p);
    }
}
