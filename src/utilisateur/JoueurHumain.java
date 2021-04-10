package utilisateur;
import utilisateur.Joueur;
import utilisateur.Couleur;
import Coordonnees.Position;
import Exception.ExceptionMauvaiseEntree;
import Grille.Plateau;
import java.util.Scanner;
import Utilitaire.UtilsGomo;
import Utilitaire.UtilsGomo;
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
     * @param choixPosition la chaine de caractére
     * @return la position choisi par le joueur
     * @throws Exception.ExceptionMauvaiseEntree
     */
    @Override
    public Position choix(String choixPosition, Plateau plateau) throws ExceptionMauvaiseEntree{
        return UtilsGomo.stringVersPos(choixPosition.toUpperCase(), plateau);

    }
}
