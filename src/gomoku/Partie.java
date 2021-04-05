/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import Exception.ExceptionHorsDuPlateau;
import Exception.ExceptionPasVoisin;
import Exception.ExceptionPositionDejaPose;
import java.util.ArrayList;

/**
 *
 * @author Arthur & Wijdan 
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arthur & Wijdan 
 */
public class Partie {   
    Couleur prochainJoueur;
    final Plateau plateau;
    static ArrayList <Position> listeCoup;
    Couleur PremierJoueur;
    /**
    * Constructeur de la partie
    * @param prochainJoueur couleur du prochain joueur
    * @param plateau le plateau
    */
    public Partie(Couleur prochainJoueur, Plateau plateau) {
        this.prochainJoueur = prochainJoueur;
        this.plateau = plateau;
        this.listeCoup = new ArrayList<>();
    }
    
    /**
     * Methode qui actualise le plateau 
     * @param p la position dernierement jouée
     * @param couleurPion la couleur du joueur qui vient de jouable
     * @param match le match
     */
    public void actualiser(Position p, Couleur couleurPion, Match match, Plateau plateau) throws ExceptionPositionDejaPose, ExceptionHorsDuPlateau, ExceptionPasVoisin{
            if(p.estDansPlateau(plateau) && match.jouable(p)){
            plateau.set(p, couleurPion);
            if( null != couleurPion )switch (couleurPion) {
                case NOIR:
                    this.prochainJoueur = Couleur.BLANC;
                    break;
                case BLANC:
                    this.prochainJoueur = Couleur.NOIR;
                    break;
                case RIEN:
                    this.prochainJoueur = PremierJoueur;
                    break;
                default:
                    break;
            }
        }   
    }
    public boolean victoire(Match m, Plateau pla) throws ExceptionHorsDuPlateau {
        List <Position> listeVoisine = new ArrayList<>();
        int cpt = 0;
        boolean voisinDeMemCouleur = false;
        Position[][] listePositions = pla.listePositions;
        for(int col = 0; col < m.tailleY; col++){
            for(int lig= 0; lig < m.tailleX; lig++){
                Position p = listePositions[lig][col];
                for (Directions d: Directions.toutes()) {
                    boolean identiques = false;
                    listeVoisine = p.posVoisParDirParDistance(d, 5, pla, m);
                    for(Position pos : listeVoisine){
                        System.out.println(listeVoisine +" " + listePositions[lig][col].couleur +" " +pos.couleur );
                        identiques =(pos.couleur == p.couleur && pos.couleur != Couleur.RIEN) ;  
                    }
                    if(identiques){
                        return true;
                    }
                }
            }  
        }

        //System.out.println("false");
        return false;
    }
    public void effectuerTour(String nom, Joueur joueur, Couleur couleurJoueur, Match match) throws ExceptionPositionDejaPose, ExceptionHorsDuPlateau, ExceptionPasVoisin{
        System.out.println("Joueur " + nom + " Choisir votre coup : ");
        Position choixJoueur = joueur.choix(UtilsGomo.lireLigne());
            try{
                this.actualiser(choixJoueur, couleurJoueur,match, plateau);
                listeCoup.add(choixJoueur);
            }
            catch(ExceptionPositionDejaPose dejaPose){
                System.out.println("test" + dejaPose.getMessage());
                effectuerTour(nom, joueur, couleurJoueur, match);
            }
            catch(ExceptionHorsDuPlateau horsPlateau){
                System.out.println(horsPlateau.getMessage());
                effectuerTour(nom, joueur, couleurJoueur, match);
            }
            catch(ExceptionPasVoisin pasVoisin){
                System.out.println(pasVoisin.getMessage());
                effectuerTour(nom, joueur, couleurJoueur, match);
            }
    }
    public void effectuerPremierTour(String nom, Joueur joueur, Couleur couleurJoueur, Match match) throws ExceptionPositionDejaPose, ExceptionHorsDuPlateau{
        System.out.println("Joueur " + nom + " Choisir votre coup : ");
        Position choixJoueur = joueur.choix(UtilsGomo.lireLigne());
            try{
                this.premierTour(choixJoueur, couleurJoueur, match, plateau);
                listeCoup.add(choixJoueur);
            }
            catch(ExceptionPositionDejaPose dejaPose){
                System.out.println("test" + dejaPose.getMessage());
                effectuerPremierTour(nom, joueur, couleurJoueur, match);
            }
            catch(ExceptionHorsDuPlateau horsPlateau){
                System.out.println(horsPlateau.getMessage());
                effectuerPremierTour(nom, joueur, couleurJoueur, match);
            }
    }
    /**
     * Methode qui actualise le plateau 
     * @param p la position dernierement jouée
     * @param couleurPion la couleur du joueur qui vient de jouable
     * @param match le match
     */
    public void premierTour(Position p, Couleur couleurPion, Match match, Plateau plateau) throws ExceptionPositionDejaPose, ExceptionHorsDuPlateau{
            if(p.estDansPlateau(plateau)){
            plateau.set(p, couleurPion);
            if( null != couleurPion )switch (couleurPion) {
                case NOIR:
                    this.prochainJoueur = Couleur.BLANC;
                    break;
                case BLANC:
                    this.prochainJoueur = Couleur.NOIR;
                    break;
                case RIEN:
                    this.prochainJoueur = PremierJoueur;
                    break;
                default:
                    break;
            }
        }   
    }
}
