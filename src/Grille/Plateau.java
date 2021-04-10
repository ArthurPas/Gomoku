package Grille;

import Grille.Match;
import Exception.ExceptionHorsDuPlateau;
import Exception.ExceptionPositionDejaPose;
import utilisateur.Couleur;
import utilisateur.Couleur;
import Coordonnees.Position;
import Coordonnees.Position;
import Utilitaire.UtilsGomo;
import Utilitaire.UtilsGomo;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Arthur & Wijdan
 */
public class Plateau {

    public Match match;
    public Position[][] listePositions;

    public Plateau(Match m) {
        this.listePositions = new Position[m.tailleX][m.tailleY];
        this.match = m;
    }

    public void init() {
        for (int col = 0; col < this.match.tailleY; col++) {
            for (int lig = 0; lig < this.match.tailleX; lig++) {
                Position p = new Position(lig, col);
                p = p.positionVide(p);
                this.listePositions[lig][col] = p;

            }
        }
    }

    /**
     * Méthode set qui permet d'associer une couleur a une position
     *
     * @param p la position
     * @param c la couleur
     * @throws Exception.ExceptionPositionDejaPose
     */
    public void set(Position p, Couleur c) throws ExceptionPositionDejaPose {
        if (this.listePositions[p.ligne][p.colonne].positionJouable()) {
            this.listePositions[p.ligne][p.colonne].couleur = c;
        } else {
            throw new ExceptionPositionDejaPose("Vous avez déja posé ici ");
        }
    }

    /**
     * Méthode qui permet de recuperer la couleur d'une position
     *
     * @param p la position
     * @return la couleur de la position
     */
    public static Couleur get(Position p) {
        return p.couleur;
    }

    /**
     * Methode qui affiche le plateau à l'écran
     * @return la chaine de caractére qui lui correspond
     */
    public String afficherPlateau() {
        StringBuilder builder = new StringBuilder("").append(System.lineSeparator());
        for (int lig = -1; lig < this.match.tailleX; lig++) {

            if (lig != -1 && lig < 10) {
                builder.append(UtilsGomo.intVersHexa(lig));
            } else if (lig > -1) {
                builder.append(UtilsGomo.intVersHexa(lig));
            }
            if (lig > -1) {
                builder.append("|");
            }
            for (int col = 0; col < this.match.tailleY; col++) {
                if (lig == -1 && col < 10) {
                    builder.append("  ");
                    builder.append("0" + col);
                } else if (lig == -1) {
                    builder.append("  ");
                    builder.append(col);
                }
                if (lig > -1) {
                    builder.append(" ").append(" | ");
                }
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    /**
     * Methode qui affiche un plateau actualisé à l'écran
     * @return
     */
    public String afficherPlateauActualise() {
        StringBuilder builder = new StringBuilder("").append(System.lineSeparator());

        //boucle avec le nombre de ligne
        for (int lig = -1; lig < this.match.tailleX; lig++) {

            if (lig != -1 && lig < 10) {
                builder.append(UtilsGomo.intVersHexa(lig));
            } else if (lig > -1) {
                builder.append(UtilsGomo.intVersHexa(lig));
            }
            if (lig > -1) {
                builder.append("|");
            }
            for (int col = 0; col < this.match.tailleY; col++) {
                if (lig == -1) {
                    builder.append("  ");
                    builder.append("0" + col);
                } else if (lig >= 0 && listePositions[lig][col].couleur != Couleur.RIEN) {
                    builder.append(listePositions[lig][col].couleur).append(" | ");
                } else {
                    builder.append(" ").append(" | ");
                }
            }
            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }

    public boolean estComplet(){
        boolean complet = true;
        for (int col = 0; col < this.match.tailleY; col++) {
            for (int lig = 0; lig < this.match.tailleX; lig++) {
                if(this.listePositions[lig][col].couleur == Couleur.RIEN){
                    System.out.println(complet);
                    complet = false;
                }
            }
        }
        return complet;
    }
}
