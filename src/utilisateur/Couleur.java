package utilisateur;

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
