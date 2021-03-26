/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import static java.lang.Character.isUpperCase;

/**
 *
 * @author apascal002
 */
public class UtilsGomo {
    final static int constanteAsciimMin = 97;
    final static int constanteAsciiMaj = 65;
    /**
     * Methode qui permet de transformer une lettre en chiffre (0 pour a,1 pour b
     * etc ...)
     * @param lettre la lettre
     * @return l'entier correspondant
     */
    
    public static int hexaVersInt(char lettre){
        if(!isUpperCase(lettre)){
        return (int)lettre - constanteAsciimMin;
        }
        else{
             return (int)lettre - constanteAsciiMaj;
        }
    }

    /**
     * Converti un String vers une Position
     * @param stringPos le string à convertir
     * @return la position 
     */
    public static Position stringVersPos(String stringPos){
        Position pos = new Position (stringPos.toUpperCase().charAt(0), 
                Integer.parseInt(stringPos.substring(1)));
        return pos;
    }
    
    public static String couleurVersString(Couleur col){
        if (col == Couleur.BLANC){
            return "BLANC";
        }
        else if (col == Couleur.NOIR){
            return "NOIR";
        }
        else{
            return "RIEN";
        }
    }
}
