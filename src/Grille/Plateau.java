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

    public void init(Match m) {
        for (int col = 0; col < m.tailleY; col++) {
            for (int lig = 0; lig < m.tailleX; lig++) {
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
        }
        else{
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
     *
     * @param m
     * @return
     */
    public String afficherPlateau(Match m) {
        StringBuilder builder = new StringBuilder("").append(System.lineSeparator());
        for (int lig=-1; lig< m.tailleX ;lig++){

            if(lig!=-1 && lig<10){
                builder.append(UtilsGomo.intVersHexa(lig));
            }
            else if(lig>-1){
                builder.append(UtilsGomo.intVersHexa(lig));
            }
            if(lig>-1){
                builder.append("|");
            }
            for (int col=0; col< m.tailleY ;col++){
                if(lig==-1 && col<10){
                    builder.append("  ");
                    builder.append("0"+col);
                }
                else if(lig==-1){
                    builder.append("  ");
                    builder.append(col);
                }
                if(lig>-1){
                    builder.append(" ").append(" | ");
                }
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    /**
     *
     * @param m
     * @param p
     * @return
     */
    public String afficherPlateauActualise(Match m, Position p) {
        StringBuilder builder = new StringBuilder("").append(System.lineSeparator());

        //boucle avec le nombre de ligne
        for (int lig = -1; lig < m.tailleX; lig++) {

            if (lig != -1 && lig < 10) {
                builder.append(UtilsGomo.intVersHexa(lig));
            } else if (lig > -1) {
                builder.append(UtilsGomo.intVersHexa(lig));
            }
            if (lig > -1) {
                builder.append("|");
            }
            for (int col = 0; col < m.tailleY; col++) {
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
}
