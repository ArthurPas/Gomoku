/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

/**
 *
 * @author apascal002
 */
public class UtilsGomo {
    final static int constanteAsciimMin = 97;
    /**
     * Methode qui permet de transformer une lettre en chiffre (0 pour a,1 pour b
     * etc ...)
     * @param lettreminuscule la lettre
     * @return l'entier correspondant
     */
    
    public static int hexaVersInt(char lettreminuscule){
        return (int)lettreminuscule - constanteAsciimMin;
    }
}
