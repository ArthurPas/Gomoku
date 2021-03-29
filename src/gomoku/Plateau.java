/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

<<<<<<< HEAD
import java.util.Scanner;
=======
import java.util.ArrayList;
>>>>>>> Arthur

/**
 *
 * @author Arthur & Wijdan 
 */
public class Plateau {
<<<<<<< HEAD
    
=======
    Position [][] listePositions;
    
    
    public Plateau(Match m){
        this.listePositions = new Position [m.tailleX][m.tailleY];
    }
    
    public void init(Match m){
        for(int col =0; col<m.tailleY; col++){
            for(int lig=0; lig<m.tailleX; lig++){
                Position p = new Position((char)lig,col);
                p.pionPresent = false;
                p.couleur = Couleur.RIEN;
                this.listePositions[lig][col] = p;
            }
        }
    }
>>>>>>> Arthur
    /**
     * Méthode set qui permet d'associer une couleur a une position
     * @param p la position
     * @param c la couleur
     */
    public void set (Position p, Couleur c){
<<<<<<< HEAD
        p.couleur = c;       
=======
        this.listePositions[p.ligne][p.colonne].pionPresent = true;
        this.listePositions[p.ligne][p.colonne].couleur = c;
>>>>>>> Arthur
    }
    /**
     * Méthode qui permet de recuperer la couleur d'une position
     * @param p la position
     * @return la couleur de la position
     */
<<<<<<< HEAD
    public Couleur get(Position p){
=======
    public static Couleur get(Position p){
>>>>>>> Arthur
        return p.couleur;
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