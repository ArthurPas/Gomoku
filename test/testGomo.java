/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gomoku.UtilsGomo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arthur
 */
public class testGomo {
    // Tests de la classe utils
     @Test
     public void TestHexaVersInt(){
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
}

