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
public class ExceptionMauvaiseEntree extends Exception {

    /**
     * Constructeur de l'exception qui gére le cas où l'entree n'est pas une position
     * @param msg le message à afficher
     */
    public ExceptionMauvaiseEntree(String msg) {
        super(msg);
    }
}
