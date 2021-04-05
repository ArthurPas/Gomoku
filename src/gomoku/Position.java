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
    public List<Position> posVoisParDirParDistance(Directions [] direc, int dist){
        List <Position> posVoisine = new ArrayList<>();
        for (Directions d: direc) {
            Position voisine = new Position((this.ligne + Directions.mvtHoriz(d)*dist), (this.colonne + Directions.mvtVertic(d)*dist));
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
    public boolean estVoisineParDistParDirec(int distance,Directions[] direc, List<Position> listeDePositions) /*throws ExceptionPasVoisin*/{
        
        boolean voisinePresente = false;
        for(int i=0; i<listeDePositions.size(); i++){
            if(this.posVoisParDirParDistance(direc,distance).contains(listeDePositions.get(i))){
                voisinePresente = true;
        }/*
        if(!voisinePresente){
            throw new ExceptionPasVoisin("Pas de voisin");
        }*/
        
        }
        return voisinePresente;
    }

    /**
     * Compte le nombre de position voisine dans une liste
     * @param listeDePositions la liste des voisines
     * @return
     */
    public int nombreDeVoisines(List<Position> listeDePositions){
        return listeDePositions.size();
    }
    /**
     *
     * @param p
     * @param direc
     * @param listeDePositions
     * @return
     */
    public boolean quatreVoisinsDansDirec(Directions[] direc, List<Position> listeDePositions) {
        int cptVoisines=0;
        for(Directions d: direc){
            for (int i = 1; i < 5; i++){
                if(this.estVoisineParDistParDirec(i,direc,listeDePositions)){
                        cptVoisines++;
                    }
            }
        }
        System.out.println(cptVoisines);
        return cptVoisines>=4;
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
