/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import Exception.ExceptionPositionDejaPose;

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
    public Position (char laLigne, int laColonne) {
    this.ligne = UtilsGomo.hexaVersInt(laLigne);
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
