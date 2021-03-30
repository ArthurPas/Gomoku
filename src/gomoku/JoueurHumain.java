/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        return UtilsGomo.stringVersPos(choixJoueur);

    }
}