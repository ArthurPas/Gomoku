/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import Coordonnees.Position;
import Exception.ExceptionMauvaiseEntree;
import Grille.Match;
import Grille.Plateau;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author arthur
 */
public class PlateauTest {
    
    @Test
     public void testStringversPos() throws ExceptionMauvaiseEntree{
        Match match = new Match(10,10);
        Plateau plateau = new Plateau(match);
        String coorda="a0";
        String coordb = "B1";
        assertEquals(new Position(0,0),plateau.stringVersPos(coorda));
        assertEquals(new Position(1,1),plateau.stringVersPos(coordb));
     }
}
