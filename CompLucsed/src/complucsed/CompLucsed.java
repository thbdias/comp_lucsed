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
      
        
        for (int i = 0; i < 14; i++){
            token = lexical.getToken();                        
            System.out.println ("lexema = " + token.getLexema());
            System.out.println ("id token = " + token.getIdToken() + "\n");
        }//end for
        
        
    }//end main
    
}//end class CompLucsed
