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
public class Position {
<<<<<<< HEAD
    final char ligne;
    final int colonne;
    boolean pionPresent;
=======
    final int ligne;
    final int colonne;
    boolean pionPresent = false;
>>>>>>> Arthur
    Couleur couleur;
    
    /**
     * Constructeur de la classe Positon
     * @param laLigne correspond a la ligne concérnée 
     * @param laColonne correspond a la colonne concérnée 
<<<<<<< HEAD
     * @param pion nous indique si un pion est présent sur la position
     * @param laCouleur couleur de la positon
     */
    
    public Position (char laLigne, int laColonne, boolean pion, Couleur laCouleur) {
    this.ligne = laLigne;
    this.colonne = laColonne;
    this.pionPresent = pion;
    this.couleur = laCouleur;
    }  
=======
     */
    
    public Position (char laLigne, int laColonne) {
    this.ligne = UtilsGomo.hexaVersInt(laLigne);
    this.colonne = laColonne;
    
    }  
    /*
    public String posVersString(){
        return "ligne = " + this.ligne + " colonne =" + this.colonne;
    }
    */
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
>>>>>>> Arthur
}
