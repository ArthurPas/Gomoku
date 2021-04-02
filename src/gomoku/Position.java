/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import Exception.ExceptionHorsDuPlateau;
import Exception.ExceptionPasVoisin;
import Exception.ExceptionPositionDejaPose;
import java.util.ArrayList;
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

    /**
     * Methode qui renvoie une liste de positions voisine a une position donné
     * @param p la position donné
     * @return la liste des positions voisines
     */
    public static List<Position> posVoisParDirParDistance(Position p, Directions [] direc, int dist){
        List <Position> posVoisine = new ArrayList<>();
        for (Directions d: direc) {
            Position voisine = new Position((p.ligne + Directions.mvtHoriz(d)*dist), p.colonne + Directions.mvtVertic(d)*dist);
                 posVoisine.add(voisine);
        }
        return posVoisine;
    }

    /**
     * Boolén qui nous indique si une case a une voisine dans une liste de positions
     * @param p la position
     * @param listeDePositions la liste des positions 
     * @return true si la liste de position contient p
     * @throws ExceptionPasVoisin
     */
    public static boolean estVoisine(Position p,List<Position> listeDePositions) throws ExceptionPasVoisin{
        
        boolean voisinePresente = false;
        for(int i=0; i<listeDePositions.size(); i++){
            if(posVoisParDirParDistance(p, Directions.toutes(),1).contains(listeDePositions.get(i))){
                voisinePresente = true;
            }
        }
        if(!voisinePresente){
            throw new ExceptionPasVoisin("Pas de voisin");
        }
        return voisinePresente;
        }
    public static boolean cinqVoisinsDansDirec(Position p, Directions []direc,List<Position> listeDePositions){
        boolean victoire = true;
        List <Position> posVoisine = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
           posVoisine = posVoisParDirParDistance(p, direc, i);
           if(!posVoisine.contains(listeDePositions.get(i))){
               victoire = false;
           }
        }
        return victoire;
    }
    /**
     * Methode qui nous permet de comparer deux positions
     * @param autre l'autre poisiton
     * @return true si les deux position sont égales
     */
    @Override
    public boolean equals(Object autre){
        Position aCompare = (Position) autre;
        return this.ligne == aCompare.ligne && this.colonne == aCompare.colonne;
    }
}
