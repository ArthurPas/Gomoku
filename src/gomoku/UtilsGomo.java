/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import static java.lang.Character.isUpperCase;
import static java.lang.System.in;
import java.util.Scanner;

/**
 *
 * @author apascal002
 */
public class UtilsGomo {

    final static int constanteAsciimMin = 97;
    static Scanner in = new Scanner(System.in);
    final static int constanteAsciiMaj = 65;

    /**
     * Methode qui permet de transformer une lettre en chiffre (0 pour a,1 pour
     * b etc ...)
     *
     * @param lettreminuscule la lettre
     * @return l'entier correspondant
     */
    public static int hexaVersInt(char lettre) {
        if (!isUpperCase(lettre)) {
            return (int) lettre - constanteAsciimMin;
        } else {
            return (int) lettre - constanteAsciiMaj;
        }
    }
    public static char intVersHexa(int chiffre){
             return (char) (chiffre + constanteAsciiMaj);
    }

    /**
     * Converti un String vers une Position
     *
     * @param stringPos le string à convertir
     * @return la position
     */
    public static Position stringVersPos(String stringPos) {
        Position pos = new Position(UtilsGomo.hexaVersInt(stringPos.toUpperCase().charAt(0)),
                Integer.parseInt(stringPos.substring(1)));
        return pos;
    }

    /**
     *
     * @return
     */
    public static String lireLigne() {
        return in.nextLine().trim();
    }

    public static String couleurVersString(Couleur col) {
        if (null == col) {
            return "test";
        } else {
            switch (col) {
                case BLANC:
                    return "BLANC";
                case NOIR:
                    return "NOIR";
                default:
                    return "RIEN";
            }
        }
    }

    public static int SaisieLigne(Match m) {

        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez sélectionner le nombre de lignes de votre tableau");
        if (clavier.hasNextInt()) {
            m.tailleX = clavier.nextInt();
            System.out.println("Nombre lu: " + m.tailleX);
        } else {
            System.out.println("Vous avez tapé autre chose qu’un entier.");
        }
        return m.tailleX;

    }

    public static int SaisieColonne(Match m) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez sélectionner le nombre de colonnes de votre tableau");
        if (clavier.hasNextInt()) {
            m.tailleY = clavier.nextInt();
            System.out.println("Nombre lu: " + m.tailleY);
        } else {
            System.out.println("Vous avez tapé autre chose qu’un entier.");
        }

        return m.tailleY;
    }
}
