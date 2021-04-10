/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateur;

import Coordonnees.Position;
import Exception.ExceptionMauvaiseEntree;
import Grille.Match;
import Grille.Plateau;
import Utilitaire.UtilsGomo;

/**
 *
 * @author arthur
 */
public class JoueurRobot implements Joueur{
    Couleur couleur;
    
    public JoueurRobot(Couleur saCouleur){
        this.couleur = saCouleur;
    }
    @Override
    public Position choix(String choixJoueur, Plateau plateau) throws ExceptionMauvaiseEntree{
        return UtilsGomo.stringVersPos(choixJoueur, plateau);
    }
}
