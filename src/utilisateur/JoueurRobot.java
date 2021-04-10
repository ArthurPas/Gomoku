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
    
    /**
     * COnstructeur du joueur robot
     * @param saCouleur
     */
    public JoueurRobot(Couleur saCouleur){
        this.couleur = saCouleur;
    }

    /**
     * Methode qui retourne la position jouée par le robot
     * @param choixPosition la chaine de caractére entrée par le robot
     * @param plateau le plateau
     * @return la position jouée par le robot
     * @throws ExceptionMauvaiseEntree
     */
    @Override
    public Position choix(String choixPosition, Plateau plateau) throws ExceptionMauvaiseEntree{
        return UtilsGomo.stringVersPos(choixPosition, plateau);
    }
}
