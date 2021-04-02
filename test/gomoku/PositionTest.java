/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import Exception.ExceptionHorsDuPlateau;
import Exception.ExceptionPasVoisin;
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
    public void testPositionVoisines() throws ExceptionHorsDuPlateau{
        Position aTeste = new Position(30,30);
        Position voisine = new Position (30,29);
        List listePosVoisine = Position.positionVoisinesParDirection(aTeste);
        assertEquals(listePosVoisine.contains(voisine), true);
        
    }
    @Test
    public void testEstVoisine() throws ExceptionHorsDuPlateau, ExceptionPasVoisin{
        Position posFaux= new Position(10,10);
        Position posVrai= new Position(30,30);
        List<Position> aTesteFaux = new ArrayList<>();
        aTesteFaux.add(posFaux);
        List<Position> aTesteVrai= new ArrayList<>();
        aTesteVrai.add(posVrai);
        Position voisine = new Position (30,29);
        System.out.println(aTesteVrai);
        assertTrue(Position.estVoisine(voisine,aTesteVrai));
        assertFalse(Position.estVoisine(voisine,aTesteFaux));        
    }
    
}
