package gomoku;

import utilisateur.Couleur;
import Coordonnees.Position;
import Coordonnees.Directions;
import Grille.Plateau;
import Grille.Match;
import Exception.ExceptionHorsDuPlateau;
import Exception.ExceptionPasVoisin;
import Exception.ExceptionPositionDejaPose;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;


/**
 *
 * @author arthur
 */
public class PositionTest {
    
    public PositionTest() {
    }
    @Test
    public void testPositionVoisines() throws ExceptionHorsDuPlateau, ExceptionPositionDejaPose{
        
        List <Position> listePosVoisine= new ArrayList<>();
        Match m = new Match(40,40);
        Plateau pla = new Plateau(m);
        pla.init(m);
        
        Position aTeste = new Position(30,30);
        Position voisine = new Position(30,29);
        Position pasVoisine = new Position(0,9);
        pla.set(aTeste, Couleur.BLANC);
        pla.set(voisine, Couleur.BLANC);
        pla.set(pasVoisine, Couleur.BLANC);
        listePosVoisine = aTeste.posVoisParDistance(Directions.toutes(), 1, pla);
        assertTrue(listePosVoisine.contains(voisine));
        assertFalse(listePosVoisine.contains(pasVoisine));
        
    }
    
}
