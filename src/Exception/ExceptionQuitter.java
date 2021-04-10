package Exception;

/**
 *
 * @author arthur
 */
public class ExceptionQuitter extends Exception {

    /**
     * Constructeur de l'exception qui gére le cas ou le joueur rentre "/quit"
     * @param msg le message a afficher
     */
    public ExceptionQuitter(String msg) {
        super(msg);
    }
}
