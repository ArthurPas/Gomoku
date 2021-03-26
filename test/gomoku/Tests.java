/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gomoku.Position;
import gomoku.UtilsGomo;
import gomoku.Position;
import gomoku.UtilsGomo;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author arthur
 */
public class Tests {
    // Tests de la classe utils
    
     @Test
     public void testHexaVersInt(){
        char a = 'a';
        char b = 'b';
        char A = 'A';
        char B = 'B';
        int i = UtilsGomo.hexaVersInt(a);
        int j = UtilsGomo.hexaVersInt(b);
        int I = UtilsGomo.hexaVersInt(A);
        int J = UtilsGomo.hexaVersInt(B);
        assertEquals(0, i);
        assertEquals(1,j);    
        assertEquals(0, I);  
        assertEquals(1, J);  
     }
     @Test
     public void testStringversPos(){
         String coorda="a0";
         String coordb = "B1";
         assertEquals(new Position('A',0),UtilsGomo.stringVersPos(coorda));
         assertEquals(new Position('B',1),UtilsGomo.stringVersPos(coordb));
     }
}


