/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author arthur
 */
public class ExceptionPasVoisin extends Exception {
    
    /**
     * Constructeur de l'exception qui gère le cas où il n'y a pas de voisins
     * @param msg le messahee à afficher
     */
    public ExceptionPasVoisin(String msg) {
        super(msg);
    }
}
