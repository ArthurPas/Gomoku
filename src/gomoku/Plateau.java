/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import Exception.ExceptionPositionDejaPose;
import java.util.Scanner;
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
        for(int col = 0; col < m.tailleY; col++){
            for(int lig= 0; lig < m.tailleX; lig++){
                Position p = new Position((char)lig,col);
                p = p.positionVide(p);
                this.listePositions[lig][col] = p;
                
            }
        }
    }
    /**
     * Méthode set qui permet d'associer une couleur a une position
     * @param p la position
     * @param c la couleur
     * @throws Exception.ExceptionPositionDejaPose
     */
    public void set (Position p, Couleur c) throws ExceptionPositionDejaPose {
        if(p.positionJouable(this.listePositions[p.ligne][p.colonne])){
            this.listePositions[p.ligne][p.colonne].couleur = c;
        }
    }
    /**
     * Méthode qui permet de recuperer la couleur d'une position
     * @param p la position
     * @return la couleur de la position
     */
    public static Couleur get(Position p){
        return p.couleur;
    }
      public String affichageGame(Match m) {
        StringBuilder builder = new StringBuilder("*-----------*").append(System.lineSeparator());

        //boucle avec le nombre de ligne
        for (int lig=0; lig< m.tailleX ;lig++){
        builder.append("| ");
                for (int col=0; col< m.tailleX ;col++){
                builder.append( "N & B").append(" | ");
                //
        builder.append("-----------").append(System.lineSeparator());
        }
        builder.append("*-----------*").append(System.lineSeparator());

        return builder.toString();
    }
}