package Coordonnees;

/**
 *
 * @author arthur
 */
public enum Directions {
    NORD,
    SUD,
    EST,
    OUEST,
    NORD_EST,
    NORD_OUEST,
    SUD_EST,
    SUD_OUEST;
    
    /**
     * Renvoie toutes les directions dans un tableau.
     *
     * @return tableau contenant toutes les directions.
     */
    public static Directions[] toutes() {
        Directions[] directions
                = {NORD, SUD, EST, OUEST, NORD_EST, NORD_OUEST, SUD_EST, SUD_OUEST};
        return directions;
    }
    /**
     * Direction opposé 
     * @return la direction opposé 
     */
    public Directions oppose(){
        Directions oppose = NORD;
        switch (this) {
            case NORD:
            oppose = SUD;
            break;
            case SUD:
            oppose = NORD;
            break;
            case EST:
            oppose = OUEST;
            break;
            case NORD_EST:
            oppose = SUD_OUEST;
            break;
            case SUD_EST:
            oppose = NORD_OUEST;
            break;
            case OUEST:
            oppose = EST;
            break;
            case NORD_OUEST:
            oppose = SUD_EST;
            break;
            case SUD_OUEST:
            oppose = NORD_EST;
                break;
        }
        return oppose;
    }

    /**
     * Renvoie le nombre de cases parcourues horizontalement lorsqu'on suit
     * cette direction (0 pour Nord et Sud, -1 pour Ouest, 1 pour Est).
     *
     * @return nombre de cases horizontales de cette direction
     */
    static int mvtHoriz(Directions d) {
        int dh = -2;
        switch (d) {
            case NORD:
            case SUD:
                dh = 0;
                break;
            case EST:
            case NORD_EST:
            case SUD_EST:
                dh = 1;
                break;
            case OUEST:
            case NORD_OUEST:
            case SUD_OUEST:
                dh = -1;
                break;
        }
        return dh;
    }

    /**
     * Renvoie le nombre de cases parcourues verticalement lorsqu'on suit cette
     * direction (0 pour Est et Ouest, -1 pour Nord, 1 pour Sud).
     *
     * @return nombre de cases verticales de cette direction
     */
    static int mvtVertic(Directions d) {
        int dv = -2;
        switch (d) {
            case EST:
            case OUEST:
                dv = 0;
                break;
            case NORD:
            case NORD_EST:
            case NORD_OUEST:
                dv = -1;
                break;
            case SUD:
            case SUD_EST:
            case SUD_OUEST:
                dv = 1;
                break;
        }
        return dv;
    }
}
