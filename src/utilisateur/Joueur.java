package utilisateur;

import Coordonnees.Position;
import Exception.ExceptionMauvaiseEntree;
import Grille.Plateau;

/**
 *
 * @author apascal002
 */
public abstract interface Joueur {
    Position choix (String s, Plateau p)throws ExceptionMauvaiseEntree;
}
