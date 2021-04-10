package gomoku;

import Utilitaire.UtilsGomo;
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
public class UtilsGomoTest {
    
    public UtilsGomoTest() {
    }
    
     @Test
     public void testHexaVersInt(){
        char a = 'a';
        char b = 'b';
        char A = 'A';
        char B = 'B';
        int i = UtilsGomo.lettreVersInt(a);
        int j = UtilsGomo.lettreVersInt(b);
        int I = UtilsGomo.lettreVersInt(A);
        int J = UtilsGomo.lettreVersInt(B);
        assertEquals(0, i);
        assertEquals(1,j);    
        assertEquals(0, I);  
        assertEquals(1, J);  
     }
     @Test
     public void testStringversPos() throws ExceptionMauvaiseEntree{
        Match match = new Match(10,10);
        Plateau plateau = new Plateau(match);
        String coorda="a0";
        String coordb = "B1";
        assertEquals(new Position(0,0),UtilsGomo.stringVersPos(coorda, plateau));
        assertEquals(new Position(1,1),UtilsGomo.stringVersPos(coordb, plateau));
     }
    /**
     * Test of intVersHexa method, of class UtilsGomo.
     */
    @Test
    public void testIntVersHexa() {
        System.out.println("intVersHexa");
        int chiffre = 0;
        char expResult = 'A';
        char result = UtilsGomo.intVersHexa(chiffre);
        assertEquals(expResult, result);
    }
}
