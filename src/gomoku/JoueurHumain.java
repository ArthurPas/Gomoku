/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

/**
 *
 * @author arthur
 */
public class JoueurHumain implements Joueur{
    final String nom;

    public JoueurHumain(String nomJoueur) {
        this.nom = nomJoueur;
    }
    public Position choix(Plateau p){
        Position pos = new Position('B',10,false,Couleur.BLANC);
        return pos;
    }
}
