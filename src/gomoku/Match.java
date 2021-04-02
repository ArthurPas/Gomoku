/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;
import Exception.ExceptionHorsDuPlateau;
import Exception.ExceptionPasVoisin;
import Exception.ExceptionPositionDejaPose;
import java.util.Scanner;

/**
 *
 * @author Arthur & Wijdan
 */
public class Match {

    int tailleX;
    int tailleY;

    /**
     * Constructeur du match
     *
     * @param X le nombre de colonnes
     * @param Y le nomnre de lignes
     */
    public Match(int X, int Y) {
        this.tailleX = X;
        this.tailleY = Y;
    }

    /**
     * Retourne si la position p est bien dans le plateau
     *
     * @param p la position a verifié
     * @return vrai si elle est comprise entre 0 et la taille maximale du
     * plateau
     */
    public boolean estDansPlateau(Position p) throws ExceptionHorsDuPlateau{
        if (p.colonne >= 0 && p.ligne >=0 && p.colonne < tailleX && 
                p.ligne < tailleY){
            return true;
        }
        else{
            throw new ExceptionHorsDuPlateau("case hors du plateau ");                
        }
    }
    /**
     * Methode qui permet de dire si il est possible de jouer (si le coup est 
     * bien dans le plateau et que l'on pose a cote d'une case déja jouée)
     *
     * @param p la position
     * @param match le match
     * @return true si aucun pion n'est présent et que le la position est dans
     * le plateau
     * @throws Exception.ExceptionHorsDuPlateau
     */
    public boolean jouable(Position p) throws ExceptionPasVoisin {
       
    return Position.estVoisine(p,Partie.listeCoup);
    }


}
