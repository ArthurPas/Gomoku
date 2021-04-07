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
     * Methode qui permet de dire si il est possible de jouer (si le coup est 
     * bien dans le plateau et que l'on pose a cote d'une case déja jouée)
     *
     * @param p la position
     * @return true si aucun pion n'est présent et que le la position est dans
     * le plateau
     * @throws Exception.ExceptionPasVoisin
     */
    public boolean jouable(Position p) throws ExceptionPasVoisin {
       
    return p.estVoisineParDistParDirec(1,Directions.toutes(),Partie.listeCoup);
    }


}
