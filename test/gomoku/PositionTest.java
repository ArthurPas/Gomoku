/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import Exception.ExceptionHorsDuPlateau;
import java.util.Arrays;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import Gomoku.Position;

/**
 *
 * @author arthur
 */
public class PositionTest {
    
    public PositionTest() {
    }
    @Test
    public void testPositionVoisines() throws ExceptionHorsDuPlateau{
        Position aTeste = new Position(30,30);
        Position voisine = new Position (30,29);
        Match match = new Match(100,100);
        Position [] test = aTeste.positionVoisines(aTeste, match);
        List <Position> listePosVoisine = Arrays.asList(test);
        assertEquals(listePosVoisine.contains(voisine), true);
        
    }
    @Test
    public void testEstVoisine() throws ExceptionHorsDuPlateau{
        Position aTesteVrai = new Position(30,30);
        Position aTesteFaux = new Position(20,20);
        Position voisine = new Position (30,29);
        Match match = new Match(100,100);
        assertTrue(aTesteVrai.estVoisine(voisine, match));
        assertFalse(aTesteFaux.estVoisine(voisine,, match));
        
    }
    
}
