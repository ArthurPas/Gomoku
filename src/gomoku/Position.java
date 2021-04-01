/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import Exception.ExceptionHorsDuPlateau;
import Exception.ExceptionPositionDejaPose;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Arthur & Wijdan
 */
public class Position {
    final int ligne;
    final int colonne;
    Couleur couleur;
    
    /**
     * Constructeur de la classe Positon
     * @param laLigne correspond a la ligne concérnée 
     * @param laColonne correspond a la colonne concérnée 
    */
    public Position (int laLigne, int laColonne) {
    this.ligne = laLigne;
    this.colonne = laColonne;
    
    }  
    public Position positionVide(Position p ){
        Position vide = new Position((char) p.ligne, p.colonne);
        vide.couleur = Couleur.RIEN;
        return vide;
    }

    /**
     * Methode qui verifie si la position est jouable 
     * @param p la positon
     * @return vrai si il n'y a aucune couleur sur cette case
     * @throws ExceptionPositionDejaPose
     */
    public boolean positionJouable(Position p) throws ExceptionPositionDejaPose{
        if(p.couleur == Couleur.RIEN){
            return true;
        }
        else{
            throw new ExceptionPositionDejaPose("Vous avez déja posé ici ");                
        }
    }
    public Position[] positionVoisines(Position p, Match m) throws ExceptionHorsDuPlateau{
        Position[] posVoisine = new Position[8];
        int nbVoisines = 0;
        for (Directions d: Directions.toutes()) {
            Position voisine = new Position((p.ligne + Directions.mvtHoriz(d)), p.colonne + Directions.mvtVertic(d));
            if(m.estDansPlateau(voisine)) {
                 posVoisine[nbVoisines]=voisine;
                 nbVoisines++;
            }
        }
        return posVoisine;
    }
    public boolean estVoisine(Position p, Match m) throws ExceptionHorsDuPlateau{
        List <Position> listePosVoisine = Arrays.asList(this.positionVoisines(p, m));
        return listePosVoisine.contains(p);
    }
    /**
     * Methode qui nous permet de comparer deux position 
     * @param autre l'autre poisiton
     * @return true si les deux position sont égales
     */
    @Override
    public boolean equals(Object autre){
        Position aCompare = (Position) autre;
        return this.ligne == aCompare.ligne && this.colonne == aCompare.colonne;
    }
}
