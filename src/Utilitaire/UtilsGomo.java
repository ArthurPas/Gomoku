package Utilitaire;

import utilisateur.Couleur;
import Coordonnees.Position;
import Exception.ExceptionHorsDuPlateau;
import Exception.ExceptionMauvaiseEntree;
import Exception.ExceptionPasVoisin;
import Exception.ExceptionPositionDejaPose;
import Exception.ExceptionQuitter;
import Grille.Match;
import Grille.Partie;
import Grille.Plateau;
import static java.lang.Character.isUpperCase;
import static java.lang.System.in;
import java.util.Scanner;
import utilisateur.Joueur;

/**
 *
 * @author apascal002
 */
public class UtilsGomo {

    final static int CONSTANTEASCCIMIN = 97;
    static Scanner in = new Scanner(System.in);
    final static int CONSTANTEASCCIMAJ = 65;

    /**
     * Methode qui permet de transformer une lettre en chiffre (0 pour a,1 pour
     * b etc ...)
     *
     * @param lettre la lettre
     * @return l'entier correspondant
     */
    public static int lettreVersInt(char lettre) {
        if (!isUpperCase(lettre)) {
            return (int) lettre - CONSTANTEASCCIMIN;
        } else {
            return (int) lettre - CONSTANTEASCCIMAJ;
        }
    }

    public static char intVersChar(int chiffre) {
        return (char) (chiffre + CONSTANTEASCCIMAJ);
    }


    /**
     * Methode qui permet de lire la prochaine ligne saisi par l'utilisateur
     *
     * @return la ligne lu
     * @throws Exception.ExceptionQuitter
     */
    public static String lireLigne() throws ExceptionQuitter {
        String ligne = in.nextLine().trim();
        if ("/quit".equals(ligne)) {
            throw new ExceptionQuitter("Au revoir");
        }
        return ligne;
    }

    /**
     * Renvoie le string associé à une couleur
     *
     * @param col la couleur
     * @return le string associé à une couleur
     */
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

    /**
     * Saisi des lignes du match
     *
     * @param m le match
     * @return l'entier associé aux X du match
     */
    public static int SaisieLigne() {
        int tailleX = 0;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez sélectionner le nombre de lignes de votre tableau");
        if (clavier.hasNextInt()) {
            tailleX = clavier.nextInt();
        } else {
            System.out.println("Vous avez tapé autre chose qu’un entier.");
            SaisieLigne();
        }
        return tailleX;

    }

    /**
     * Saisi des colonnes du match
     *
     * @param m le match
     * @return l'entier associé aux Y du match
     */
    public static int SaisieColonne() {
        Scanner clavier = new Scanner(System.in);
        int tailleY= 0;
        System.out.println("Veuillez sélectionner le nombre de colonnes de votre tableau");
        if (clavier.hasNextInt()) {
            tailleY = clavier.nextInt();
        } else {
            System.out.println("Vous avez tapé autre chose qu’un entier.");
            SaisieColonne();
        }

        return tailleY;
    }
}