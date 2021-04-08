package Coordonnees;

import Coordonnees.Directions;
import Grille.Plateau;
import Grille.Match;
import Exception.ExceptionHorsDuPlateau;
import Exception.ExceptionPasVoisin;
import Exception.ExceptionPositionDejaPose;
import utilisateur.Couleur;
import Utilitaire.UtilsGomo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Arthur & Wijdan
 */
public class Position {

    public final int ligne;
    public final int colonne;
    public Couleur couleur;

    /**
     * Constructeur de la classe Positon
     *
     * @param laLigne correspond a la ligne concérnée
     * @param laColonne correspond a la colonne concérnée
     */
    public Position(int laLigne, int laColonne) {
        this.ligne = laLigne;
        this.colonne = laColonne;

    }

    public Position positionVide(Position p) {
        Position vide = new Position((char) p.ligne, p.colonne);
        vide.couleur = Couleur.RIEN;
        return vide;
    }

    /**
     * Methode qui verifie si la position est jouable
     *
     * @param p la positon
     * @return vrai si il n'y a aucune couleur sur cette case
     * @throws ExceptionPositionDejaPose
     */
    public boolean positionJouable() {//throws ExceptionPositionDejaPose{
        /*if(this.couleur == Couleur.RIEN){
            return true;
        }
        else{
            throw new ExceptionPositionDejaPose("Vous avez déja posé ici ");                
        }*/
        return this.couleur == Couleur.RIEN;
    }

    /**
     * Methode qui renvoie une liste de positions voisine a une position donné
     * et dans un tableau de direction donné ainsi qu'une distance a parcourir
     *
     * @param p la position donné
     * @param direc le tableau de directions
     * @param dist la distance a parcourir
     * @return la liste des positions voisines
     */
    public List<Position> posVoisParDirParDistance(Directions d, int dist, Plateau pla, Match m) throws ExceptionHorsDuPlateau {
        List<Position> posVoisine = new ArrayList<>();
        for (int i = 1; i <= dist; i++) {
            Position p = new Position(this.ligne + Directions.mvtVertic(d) * i, this.colonne + Directions.mvtHoriz(d) * i);
            if (p.estDansPlateau(pla)) {
                Position voisine = pla.listePositions[this.ligne + Directions.mvtVertic(d) * i][this.colonne + Directions.mvtHoriz(d) * i];
                posVoisine.add(voisine);
            }
        }
        return posVoisine;
    }

    /**
     *
     * @param d
     * @param pla
     * @param m
     * @param dist la distance a parcourir
     * @return la liste des positions voisines
     */
    public int compteurVoisineParDirParDistanceParCouleur(Directions d, int dist, Plateau pla, Match m) throws ExceptionHorsDuPlateau {
        int cpt = 0;
        boolean memeCouleur = true;
        int i = 1;
        while (i <= dist || memeCouleur) {
            Position p = new Position(this.ligne + Directions.mvtVertic(d) * i, this.colonne + Directions.mvtHoriz(d) * i);
            if (p.estDansPlateau(pla)) {
                Position voisine = pla.listePositions[this.ligne + Directions.mvtVertic(d) * i][this.colonne + Directions.mvtHoriz(d) * i];

                if (voisine.couleur == pla.listePositions[this.ligne][this.colonne].couleur
                        && voisine.couleur != Couleur.RIEN && voisine.couleur != null) {

                    cpt++;
                } else {

                    memeCouleur = false;
                }
            } else {
                memeCouleur = false;
            }
            i++;
        }
        return cpt;
    }

    /**
     * Methode qui renvoie une liste de positions voisine a une position donné
     * et dans un tableau de direction donné ainsi qu'une distance a parcourir
     *
     * @param p la position donné
     * @param direc le tableau de directions
     * @param dist la distance a parcourir
     * @return la liste des positions voisines
     */
    public List<Position> posVoisParDistance(Directions[] direc, int dist, Plateau pla) throws ExceptionHorsDuPlateau {
        List<Position> posVoisine = new ArrayList<>();
        for (Directions d : direc) {
            Position p = new Position(this.ligne + Directions.mvtVertic(d) * dist, this.colonne + Directions.mvtHoriz(d) * dist);
            if (p.estDansPlateau(pla)) {
                Position voisine = pla.listePositions[this.ligne + Directions.mvtVertic(d) * dist][this.colonne + Directions.mvtHoriz(d) * dist];
                posVoisine.add(voisine);
            }
        }
        return posVoisine;
    }

    /**
     * Boolén qui nous indique si une case a une voisine dans une liste de
     * positions
     *
     * @param distance
     * @param direc
     * @param listeDePositions la liste des positions
     * @return true si la liste de position contient p
     * @throws ExceptionPasVoisin
     */
    public boolean estVoisineParDistParDirec(int distance, Directions[] direc, List<Position> listeDePositions, Plateau pla, Match m) throws ExceptionPasVoisin, ExceptionHorsDuPlateau {

        boolean voisinePresente = false;
        for (int i = 0; i < listeDePositions.size(); i++) {
            if (this.posVoisParDistance(direc, distance, pla).contains(listeDePositions.get(i))) {
                voisinePresente = true;
            }

        }
        return voisinePresente;
    }

    /**
     * Retourne si la position p est bien dans le plateau
     *
     * @param p la position a verifié
     * @return vrai si elle est comprise entre 0 et la taille maximale du
     * plateau
     */
    public boolean estDansPlateau(Plateau pla) throws ExceptionHorsDuPlateau {
        return(this.colonne >= 0 && this.ligne >= 0 && this.colonne < pla.match.tailleX
                && this.ligne < pla.match.tailleY);
    }

    public static String posPossible(Plateau pla, Match m) throws ExceptionPositionDejaPose, ExceptionPasVoisin, ExceptionHorsDuPlateau {
        for (int lig = 0; lig < m.tailleX; lig++) {
            for (int col = 0; col < m.tailleY; col++) {
                Position p = pla.listePositions[lig][col];
                if (p.positionJouable() && m.jouable(p, pla)) {
                    return p.toString();
                }
            }

        }
        throw new ExceptionPositionDejaPose("toutes les cases sont utilisées");
    }

    public static String posPremierPossible(Plateau pla, Match m) throws ExceptionPositionDejaPose, ExceptionHorsDuPlateau {
        for (int lig = 0; lig < m.tailleX; lig++) {
            for (int col = 0; col < m.tailleY; col++) {
                Position p = pla.listePositions[lig][col];
                return p.toString();
            }
        }
        throw new ExceptionHorsDuPlateau("Case hors du plateau");
    }

    /**
     * Methode qui nous permet de comparer deux positions
     *
     * @param autre l'autre poisiton
     * @return true si les deux position sont égales
     */
    @Override
    public boolean equals(Object autre) {
        Position aCompare = (Position) autre;
        return this.ligne == aCompare.ligne && this.colonne == aCompare.colonne;
    }

    @Override
    public String toString() {
        return UtilsGomo.intVersHexa(this.ligne) + String.valueOf(this.colonne);
    }
}
