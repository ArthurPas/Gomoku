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
     * Methode qui renvoie une liste de positions voisine a une position donné et 
     * dans un tableau de direction donné ainsi qu'une distance a parcourir
     * @param p la position donné
     * @param direc le tableau de directions
     * @param dist la distance a parcourir
     * @return la liste des positions voisines
     */
    public List<Position> posVoisParDirParDistance(Directions d, int dist, Plateau pla, Match m) throws ExceptionHorsDuPlateau{
        List <Position> posVoisine = new ArrayList<>();
        System.out.println("direction :" + d);
        for (int i = 1; i <= dist; i++) {
            Position p = new Position(this.ligne + Directions.mvtVertic(d)*i,this.colonne + Directions.mvtHoriz(d)*i);
            if(p.estDansPlateau(pla)){
            Position voisine = pla.listePositions[this.ligne + Directions.mvtVertic(d)*i]
                    [this.colonne + Directions.mvtHoriz(d)*i];
            System.out.println(voisine);
            posVoisine.add(voisine);
            }
        }
        return posVoisine;
    }
    /**
     * Methode qui renvoie une liste de positions voisine a une position donné et 
     * dans un tableau de direction donné ainsi qu'une distance a parcourir
     * @param p la position donné
     * @param direc le tableau de directions
     * @param dist la distance a parcourir
     * @return la liste des positions voisines
     */
    public List<Position> posVoisParDistance(Directions [] direc, int dist){
        List <Position> posVoisine = new ArrayList<>();
        for (Directions d: direc) {
            Position voisine = new Position((this.ligne + Directions.mvtHoriz(d)*dist),
                    (this.colonne + Directions.mvtVertic(d)*dist));
                 posVoisine.add(voisine);
        }
        return posVoisine;
    }

    /**
     * Boolén qui nous indique si une case a une voisine dans une liste de positions
     * @param distance
     * @param direc
     * @param listeDePositions la liste des positions 
     * @return true si la liste de position contient p
     * @throws ExceptionPasVoisin
     */
    public boolean estVoisineParDistParDirec(int distance, Directions[] direc, List<Position> listeDePositions) /*throws ExceptionPasVoisin*/{
        
        boolean voisinePresente = false;
            for(int i=0; i<listeDePositions.size(); i++){
            if(this.posVoisParDistance(direc, distance).contains(listeDePositions.get(i))){
                    voisinePresente = true;
                }/*
                if(!voisinePresente){
                    throw new ExceptionPasVoisin("Pas de voisin");
                }*/
        
            }
        return voisinePresente;
    }

    
    /**
     * Retourne si la position p est bien dans le plateau
     *
     * @param p la position a verifié
     * @return vrai si elle est comprise entre 0 et la taille maximale du
     * plateau
     */
    public boolean estDansPlateau(Plateau pla) throws ExceptionHorsDuPlateau{
        if (this.colonne >= 0 && this.ligne >=0 && this.colonne < pla.match.tailleX && 
                this.ligne < pla.match.tailleY){
            return true;
        }
        else{
            return false;
            //throw new ExceptionHorsDuPlateau("case hors du plateau ");                
        }
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
    @Override
    public String toString(){
        return UtilsGomo.intVersHexa(this.ligne) +" "+this.colonne;
    }
}
