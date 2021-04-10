package Grille;
import Grille.Partie;
import Exception.ExceptionHorsDuPlateau;
import Exception.ExceptionPasVoisin;
import Exception.ExceptionPositionDejaPose;
import Coordonnees.Directions;
import Coordonnees.Position;
import java.util.Scanner;

/**
 *
 * @author Arthur & Wijdan
 */
public class Match {

    public int tailleX;
    public int tailleY;

    /**
     * Constructeur du match
     *
     * @param X le nombre de colonnes
     * @param Y le nomnre de lignes
     */
    public Match(int X, int Y) {
        this.tailleX = X;
        this.tailleY = Y;
    }

    
    /**
     * Methode qui permet de dire si il est possible de jouer (si le coup est 
     * bien dans le plateau et que l'on pose a cote d'une case déja jouée)
     *
     * @param p la position
     * @return true si aucun pion n'est présent et que le la position est dans
     * le plateau
     * @throws Exception.ExceptionPasVoisin
     */
    public boolean jouable(Position p, Plateau pla) throws ExceptionPasVoisin, ExceptionHorsDuPlateau{
        if(p.estVoisineParDistParDirec(1,Directions.toutes(),Partie.listeCoup, pla)){
            return true;
        }
        else{
            throw new ExceptionPasVoisin("Pas de voisin");
        }
    }


}
