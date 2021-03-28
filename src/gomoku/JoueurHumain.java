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
    public Position choix(Plateau p, String choixJoueur){
        return UtilsGomo.stringVersPos(choixJoueur);

    }
}
