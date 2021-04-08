package gomoku;
import java.util.Scanner;
import gomoku.UtilsGomo;
/**
 *
 * @author arthur
 */
public class JoueurHumain implements Joueur{
    final String nom;
    final Couleur couleur;
    
    /**
     * Constructeur de JoueurHumain
     * @param nomJoueur le nom du joueur
     * @param saCouleur la couleur du joueur
     */
    public JoueurHumain(String nomJoueur, Couleur saCouleur) {
        this.nom = nomJoueur;
        this.couleur = saCouleur;
    }

    /**
     * Renvoie a partir d'une chaine de caractére la position
     * @param choixJoueur la chaine de caractére
     * @return la position choisi par le joueur
     */
    @Override
    public Position choix(String choixJoueur){
        return UtilsGomo.stringVersPos(choixJoueur.toUpperCase());

    }
}
