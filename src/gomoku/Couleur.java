/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

/**
 *
 * @author Arthur & Wijdan  
 */
public enum Couleur {
    BLANC,
    NOIR,
    RIEN;
    
    @Override
    public String toString(){
        if(this==this.BLANC){
            return "B";   
        }
        if(this==this.NOIR){
            return "N"; 
        }
        return " ";
    }
}
