package Grille;

import Exception.ExceptionHorsDuPlateau;
import Exception.ExceptionPasVoisin;
import Exception.ExceptionPositionDejaPose;
import utilisateur.Couleur;
import Coordonnees.Directions;
import utilisateur.Joueur;
import Coordonnees.Position;
import Exception.ExceptionMauvaiseEntree;
import Exception.ExceptionQuitter;
import Utilitaire.UtilsGomo;
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
    public static ArrayList<Position> listeCoup;
    Couleur PremierJoueur;

    /**
     * Constructeur de la partie
     *
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
     *
     * @param p la position dernierement jouée
     * @param couleurPion la couleur du joueur qui vient de jouable
     * @param match le match
     */
    public void actualiser(Position p, Couleur couleurPion, Match match, Plateau plateau)
            throws ExceptionPositionDejaPose, ExceptionHorsDuPlateau, ExceptionPasVoisin {
        if (p.estDansPlateau(plateau) && match.jouable(p, this.plateau)) {
            plateau.set(p, couleurPion);
            if (null != couleurPion) {
                switch (couleurPion) {
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

    /**
     * Booléen qui indique si 5 case alignées sont de même couleur
     *
     * @param m le match
     * @param pla le plateau
     * @return true si la derniere position jouée compléte un alignement de 5
     * pions de la même couleur
     * @throws ExceptionHorsDuPlateau
     */
    public boolean victoire(Match m, Plateau pla) throws ExceptionHorsDuPlateau {
        int nbAAligner = 5;
        int cptDeVoisine = 0;
        int cptDeVoisineOp = 0;
        Position p = this.listeCoup.get(this.listeCoup.size() - 1);
        for (Directions d : Directions.toutes()) {
            cptDeVoisine = p.compteurVoisineParDirParDistanceParCouleur(d, nbAAligner, pla, m);
            cptDeVoisineOp = p.compteurVoisineParDirParDistanceParCouleur(d.oppose(), nbAAligner, pla, m);
            if (cptDeVoisine + cptDeVoisineOp >= nbAAligner - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Methode qui permet d'effectuer un tour
     * @param nom le nom du joueur
     * @param joueur le joueur
     * @param couleurJoueur la couleur du joueur
     * @param match le match 
     * @throws ExceptionPositionDejaPose
     * @throws ExceptionHorsDuPlateau
     * @throws ExceptionPasVoisin
     */
    public void effectuerTour(String nom, Joueur joueur, Couleur couleurJoueur,
            Match match) throws ExceptionPositionDejaPose, ExceptionHorsDuPlateau, ExceptionPasVoisin, ExceptionQuitter, ExceptionMauvaiseEntree {
        System.out.println("Joueur " + nom + " Choisir votre coup : ");
        if (joueur.getClass() == utilisateur.JoueurHumain.class) {
            try {
                Position choixJoueur = joueur.choix(UtilsGomo.lireLigne(), plateau);
                try {
                    this.actualiser(choixJoueur, couleurJoueur, match, plateau);
                    listeCoup.add(choixJoueur);
                } catch (ExceptionPositionDejaPose dejaPose) {
                    System.out.println(dejaPose.getMessage());
                    effectuerTour(nom, joueur, couleurJoueur, match);
                } catch (ExceptionHorsDuPlateau horsPlateau) {
                    System.out.println(horsPlateau.getMessage());
                    effectuerTour(nom, joueur, couleurJoueur, match);
                } catch (ExceptionPasVoisin pasVoisin) {
                    System.out.println(pasVoisin.getMessage());
                    effectuerTour(nom, joueur, couleurJoueur, match);
                }
            } catch (ExceptionMauvaiseEntree e) {
                System.out.println(e.getMessage());
                effectuerTour(nom, joueur, couleurJoueur, match);
            }
        } else {
            Position choixJoueur = UtilsGomo.stringVersPos(Position.posPossibleParRobot(plateau, match), plateau);
            try {
                this.actualiser(choixJoueur, couleurJoueur, match, plateau);
                listeCoup.add(choixJoueur);
            } catch (ExceptionPositionDejaPose dejaPose) {
                System.out.println(dejaPose.getMessage());
                effectuerTour(nom, joueur, couleurJoueur, match);
            } catch (ExceptionHorsDuPlateau horsPlateau) {
                System.out.println(horsPlateau.getMessage());
                effectuerTour(nom, joueur, couleurJoueur, match);
            } catch (ExceptionPasVoisin pasVoisin) {
                System.out.println(pasVoisin.getMessage());
                effectuerTour(nom, joueur, couleurJoueur, match);
            }
        }
    }

    /**
     * Methode qui effectue un tour particulier car c'est le premier
     *
     * @param nom le nom du joueur qui va jouer
     * @param joueur le joueur qui va jouer
     * @param couleurJoueur la couleur du joueur
     * @param match le match dans lequel le tour est joué
     * @throws ExceptionPositionDejaPose
     * @throws ExceptionHorsDuPlateau
     */
    public void effectuerPremierTour(String nom, Joueur joueur, Couleur couleurJoueur,
            Match match) throws ExceptionPositionDejaPose, ExceptionHorsDuPlateau, ExceptionQuitter, ExceptionMauvaiseEntree, ExceptionPasVoisin {
        System.out.println("Joueur " + nom + " Choisir votre coup : ");
        if (joueur.getClass() == utilisateur.JoueurHumain.class) {
            try {
                Position choixJoueur = joueur.choix(UtilsGomo.lireLigne(), plateau);
                try {
                    this.changementDeCouleur(choixJoueur, couleurJoueur, match, plateau);
                    listeCoup.add(choixJoueur);
                } catch (ExceptionPositionDejaPose dejaPose) {
                    System.out.println(dejaPose.getMessage());
                    effectuerPremierTour(nom, joueur, couleurJoueur, match);
                } catch (ExceptionHorsDuPlateau horsPlateau) {
                    System.out.println(horsPlateau.getMessage());
                    effectuerPremierTour(nom, joueur, couleurJoueur, match);
                }
            } catch (ExceptionMauvaiseEntree e) {
                System.out.println(e.getMessage());
                effectuerTour(nom, joueur, couleurJoueur, match);
                
            }

        } else {
            Position choixJoueur = UtilsGomo.stringVersPos(Position.posPremierPossibleParRobot(plateau, match), plateau);
            try {
                this.changementDeCouleur(choixJoueur, couleurJoueur, match, plateau);
                listeCoup.add(choixJoueur);
            } catch (ExceptionPositionDejaPose dejaPose) {
                System.out.println(dejaPose.getMessage());
                effectuerPremierTour(nom, joueur, couleurJoueur, match);
            } catch (ExceptionHorsDuPlateau horsPlateau) {
                System.out.println(horsPlateau.getMessage());
                effectuerPremierTour(nom, joueur, couleurJoueur, match);
            }
        }
    }

    /**
     * Methode qui change la couleur du joueur et ajoute la position au plateau
     *
     * @param p la position dernierement jouée
     * @param couleurJoueur la couleur du joueur
     * @param match le match
     * @param plateau le plateau dans lequel on se situe
     * @throws Exception.ExceptionPositionDejaPose
     * @throws Exception.ExceptionHorsDuPlateau
     */
    public void changementDeCouleur(Position p, Couleur couleurJoueur, Match match,
            Plateau plateau) throws ExceptionPositionDejaPose, ExceptionHorsDuPlateau {
        if (p.estDansPlateau(plateau)) {
            plateau.set(p, couleurJoueur);
            if (null != couleurJoueur) {
                switch (couleurJoueur) {
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
}
