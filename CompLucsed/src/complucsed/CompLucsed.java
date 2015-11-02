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
        LexicalAnalyzer lexical = new LexicalAnalyzer("D:\\compilador\\comp_lucsed\\arq_test\\test3.txt");
        Token token = new Token();
      
        token = lexical.getToken();
        
        String teste = token.getLexema();
        int teste1 = token.getIdToken();
        System.out.println ("lexema = " + teste);
        System.out.println ("id token = " + teste1);
    }//end main
    
}//end class CompLucsed
