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

    public static char intVersHexa(int chiffre) {
        return (char) (chiffre + CONSTANTEASCCIMAJ);
    }

    /**
     * Converti une entrée (String) vers une Position et vérifie qu'il correspond à une 
     * position du plateau
     *
     * @param stringPos le string à convertir
     * @return la position
     */
    public static Position stringVersPos(String stringPos, Plateau pla) throws ExceptionMauvaiseEntree{
        char charLigne = stringPos.charAt(0);
        int intLigne = lettreVersInt(charLigne);
        if(intLigne >= pla.match.tailleY){
            throw new ExceptionMauvaiseEntree("mauvaise entrée de ligne");
        }
        String stringCol = stringPos.substring(1);
        try{
            int intCol = Integer.parseInt(stringCol);
            if(intCol>= pla.match.tailleX){
                throw new ExceptionMauvaiseEntree("mauvaise entrée de colonne (hors du plateau)");
            }
            Position pos = new Position(intLigne, intCol);
            return pos;
        } catch (NumberFormatException e) {
            throw new ExceptionMauvaiseEntree("mauvaise entrée de colonne (pas un nombre valide)");
        }
        
        
        /*
        Position pos = new Position(UtilsGomo.lettreVersInt(stringPos.toUpperCase().charAt(0)),
                Integer.parseInt(stringPos.substring(1)));
       */
        
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
            throws ExceptionHorsDuPlateau, ExceptionPositionDejaPose, ExceptionPasVoisin, ExceptionQuitter, ExceptionMauvaiseEntree {

        boolean victoire = false;
        boolean complet = false;
        String nomDernierJoueur = nomJUn;
        plateau.init(match);
        System.out.println(plateau.afficherPlateau(match));
        partie.effectuerPremierTour(nomJUn, joueurUn, couleurPremierJoueur, match);
        System.out.println(plateau.afficherPlateauActualise(match, partie.listeCoup.get(partie.listeCoup.size() - 1)));

        while (!victoire && !complet) {
            if (partie.victoire(match, plateau)) {
                victoire = true;
            } else if (plateau.estComplet(match)) {
                complet = true;
            } else {
                try{
                partie.effectuerTour(nomJDeux, joueurDeux, couleurDeuxiemeJoueur, match);
                nomDernierJoueur = nomJDeux;
                }
                catch (ExceptionMauvaiseEntree e){
                    e.getMessage();
                    partie.effectuerTour(nomJDeux, joueurDeux, couleurDeuxiemeJoueur, match);
                }

            }

            System.out.println(plateau.afficherPlateauActualise(match, partie.listeCoup.get(partie.listeCoup.size() - 1)));
            if (partie.victoire(match, plateau)) {
                victoire = true;
            } else if (plateau.estComplet(match)) {
                complet = true;
            } else {
                try{
                partie.effectuerTour(nomJUn, joueurUn, couleurPremierJoueur, match);
                nomDernierJoueur = nomJUn;
                }
                catch (ExceptionMauvaiseEntree e){
                    e.getMessage();
                    partie.effectuerTour(nomJDeux, joueurDeux, couleurDeuxiemeJoueur, match);
                }
            }

            System.out.println(plateau.afficherPlateauActualise(match, partie.listeCoup.get(partie.listeCoup.size() - 1)));
        }
        if (plateau.estComplet(match)) {
            System.out.println("Partie nulle");
        }
    }

}
