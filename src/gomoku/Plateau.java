/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import java.util.Scanner;

/**
 *
 * @author Arthur & Wijdan 
 */
public class Plateau {
   
    public void set (Position p, Couleur c){
        //TODO
    }
    public Couleur get(Position p){
        return null;
        //TODO
    }
    
     public static void plateau() {
        choix();
        tab();
        
    }
     
     public static void choix(){
        String choix;        
        Scanner clavier = new Scanner(System.in);
        System.out.println("*--------------------------------*");
        System.out.println("  Veuillez choisir votre plateau");
        System.out.println("*--------------------------------*");
        System.out.println("|          a) 10x5               |");
        System.out.println("|          b) 15x10              |");
        System.out.println("|          c) 20x20              |");
        System.out.println("*--------------------------------*");
        choix = clavier.nextLine();
      
        
        if (choix.equals("a") || choix.equals("A")){
            System.out.println("Vous avez sélectionné le plateau A [10x5]"); 
            tableauA();
        }
        if (choix.equals("b")|| choix.equals("B")){
            System.out.println("Vous avez sélectionné le plateau B [15x10]");
            tableauB();
        }
        if (choix.equals("c")|| choix.equals("C")){
            System.out.println("Vous avez sélectionné le plateau C [20x20]");
            tableauC();
        }
     }
        
        public static void tableauA(){
            
        }
        
        public static void tableauB(){
            
        }
  
        
        public static void tableauC(){
        
        }
        
         
 

 

     public static void tab() {
         String a = new String ("[ ]") ;
         int cases[][] = new int[3][3];
         
         for (int i = 0; i < 10; i++) {
             for (int j = 0; j < 1; j++ ) {
//               
                 System.out.println(a); 
                 System.out.println("[ ][ ][ ][ ][ ]"); 
                 System.out.println("[ ][ ][ ][ ][ ]"); 
                 
             }
         }
         
     }

}