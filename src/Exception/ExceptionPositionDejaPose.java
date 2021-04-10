/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author apascal002
 */
public class ExceptionPositionDejaPose extends Exception {

    /**
     * Constructeur de l'exception qui gére le cas ou la position est deja prise
     * @param msg le message a afficher
     */
    public ExceptionPositionDejaPose(String msg) {
        super(msg);
    }
}
