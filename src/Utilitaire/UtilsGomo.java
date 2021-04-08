package Utilitaire;

import utilisateur.Couleur;
import Coordonnees.Position;
import Exception.ExceptionHorsDuPlateau;
import Exception.ExceptionPasVoisin;
import Exception.ExceptionPositionDejaPose;
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

    public static char intVersHexa(int chiffre) {
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
     * Methode qui permet de lire la prochaine ligne saisi par l'utilisateur
     *
     * @return
     */
    public static String lireLigne() {
        return in.nextLine().trim();
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
    public static int SaisieLigne(Match m) {

        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez sélectionner le nombre de lignes de votre tableau");
        if (clavier.hasNextInt()) {
            m.tailleX = clavier.nextInt();
        } else {
            System.out.println("Vous avez tapé autre chose qu’un entier.");
            SaisieLigne(m);
        }
        return m.tailleX;

    }

    /**
     * Saisi des colonnes du match
     *
     * @param m le match
     * @return l'entier associé aux Y du match
     */
    public static int SaisieColonne(Match m) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez sélectionner le nombre de colonnes de votre tableau");
        if (clavier.hasNextInt()) {
            m.tailleY = clavier.nextInt();
        } else {
            System.out.println("Vous avez tapé autre chose qu’un entier.");
            SaisieColonne(m);
        }

        return m.tailleY;
    }

    public static void deroulementPartie(Couleur couleurPremierJoueur, Couleur couleurDeuxiemeJoueur,
            Joueur joueurUn, Joueur joueurDeux, Match match, Plateau plateau, Partie partie, String nomJUn, String nomJDeux)
            throws ExceptionHorsDuPlateau, ExceptionPositionDejaPose, ExceptionPasVoisin {

        boolean victoire = false;
        String nomDernierJoueur = nomJUn;
        plateau.init(match);
        System.out.println(plateau.afficherPlateau(match));
        partie.effectuerPremierTour(nomJUn, joueurUn, couleurPremierJoueur, match);
        System.out.println(plateau.afficherPlateauActualise(match, partie.listeCoup.get(partie.listeCoup.size() - 1)));

        while (!victoire) {
            if (partie.victoire(match, plateau)) {
                victoire = true;
            } else {
                partie.effectuerTour(nomJDeux, joueurDeux, couleurDeuxiemeJoueur, match);
                nomDernierJoueur = nomJDeux;

            }
            System.out.println(plateau.afficherPlateauActualise(match, partie.listeCoup.get(partie.listeCoup.size() - 1)));
            if (partie.victoire(match, plateau)) {
                victoire = true;
            } else {
                partie.effectuerTour(nomJUn, joueurUn, couleurPremierJoueur, match);
                nomDernierJoueur = nomJUn;
            }

            System.out.println(plateau.afficherPlateauActualise(match, partie.listeCoup.get(partie.listeCoup.size() - 1)));
        }
    }

}
