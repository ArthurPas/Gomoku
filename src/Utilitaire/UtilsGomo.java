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

    /**
     * Execute le déroulement de la partie
     * @param couleurPremierJoueur la couleur du premier joueur
     * @param couleurDeuxiemeJoueur la couleur du deuxieme joueur
     * @param joueurUn le joueur numéro 1
     * @param joueurDeux le joueur numéro 2
     * @param plateau la plateau
     * @param partie la partie 
     * @param nomJUn le nom du premier joueur
     * @param nomJDeux le nom du deuxieme joueur
     * @throws ExceptionHorsDuPlateau
     * @throws ExceptionPositionDejaPose
     * @throws ExceptionPasVoisin
     * @throws ExceptionQuitter
     * @throws ExceptionMauvaiseEntree
     */
    public static void deroulementPartie(Couleur couleurPremierJoueur, Couleur couleurDeuxiemeJoueur,
            Joueur joueurUn, Joueur joueurDeux, Plateau plateau, Partie partie, String nomJUn, String nomJDeux)
            throws ExceptionHorsDuPlateau, ExceptionPositionDejaPose, ExceptionPasVoisin, ExceptionQuitter, ExceptionMauvaiseEntree {

        boolean victoire = false;
        boolean complet = false;
        String nomDernierJoueur = nomJUn;
        plateau.init();
        System.out.println(plateau.afficherPlateau());
        partie.effectuerPremierTour(nomJUn, joueurUn, couleurPremierJoueur);
        System.out.println(plateau.afficherPlateauActualise( ));

        while (!victoire && !complet) {
            if (partie.victoire(plateau)) {
                victoire = true;
            } else if (plateau.estComplet()) {
                complet = true;
            } else {
                try{
                partie.effectuerTour(nomJDeux, joueurDeux, couleurDeuxiemeJoueur);
                nomDernierJoueur = nomJDeux;
                }
                catch (ExceptionMauvaiseEntree e){
                    e.getMessage();
                    partie.effectuerTour(nomJDeux, joueurDeux, couleurDeuxiemeJoueur);
                }

            }

            System.out.println(plateau.afficherPlateauActualise());
            if (partie.victoire(plateau)) {
                victoire = true;
            } else if (plateau.estComplet()) {
                complet = true;
            } else {
                try{
                partie.effectuerTour(nomJUn, joueurUn, couleurPremierJoueur);
                nomDernierJoueur = nomJUn;
                }
                catch (ExceptionMauvaiseEntree e){
                    e.getMessage();
                    partie.effectuerTour(nomJDeux, joueurDeux, couleurDeuxiemeJoueur);
                }
            }

            System.out.println(plateau.afficherPlateauActualise());
        }
        if (plateau.estComplet()) {
            System.out.println("Partie nulle");
        }
    }

}
