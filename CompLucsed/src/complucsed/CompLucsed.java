/**
 *
 * @author thiago
 */

package complucsed;

public class CompLucsed {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //tudo aqui e teste ainda
        //alguem chama o analisador lexico e este retorna o proximo token
        LexicalAnalyzer lexical = new LexicalAnalyzer("D:\\compilador\\comp_lucsed\\arq_test\\test4.txt");
        Token token = new Token();
      
        token = lexical.getToken();                        
        System.out.println ("lexema = " + token.getLexema());
        System.out.println ("id token = " + token.getIdToken());                
        /**
        token = lexical.getToken();        
        System.out.println ("\nlexema = " + token.getLexema());
        System.out.println ("id token = " + token.getIdToken());        
        */        
        /**
        token = lexical.getToken();                
        System.out.println ("\nlexema = " + token.getLexema());
        System.out.println ("id token = " + token.getIdToken());                
        */
    }//end main
    
}//end class CompLucsed
