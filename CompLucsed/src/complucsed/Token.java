/**
 * @author thiago 
 */

package complucsed;

public class Token {
    
    private String lexema;
    private byte token;
        
    /** construtor */
    public Token (){
        lexema = "";
        token = -1;
    }//end construtor
    
    
    /**
     * metodo que 
     */
    public void setLexema (String lexema){
        this.lexema = lexema;
    }//end setLexema
    
    
    /**
     * metodo que retorna o lexema do Token
     */
    public String getLexema(){
        return lexema;
    }//end getLexema
    
}//end class Token
