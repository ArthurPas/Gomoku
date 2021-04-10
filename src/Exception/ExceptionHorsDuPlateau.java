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
public class ExceptionHorsDuPlateau extends Exception {

    /**
     * Constructeur de l'exception qui gére le cas ou la position est hors du plateau
     * @param msg le message à afficher
     */
    public ExceptionHorsDuPlateau(String msg) {
        super(msg);
    }
}
