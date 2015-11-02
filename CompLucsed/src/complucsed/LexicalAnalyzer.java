/**
 * @author thiago
 */

package complucsed;

public class LexicalAnalyzer {
    
    private static SymbolTab symbolTab;
    private static Token token;
    public static Arquivo arq;
    
    /**
     * construtor
     */
    public LexicalAnalyzer (String nomeArq){
        symbolTab = new SymbolTab();
        symbolTab.initialize();
        arq = new Arquivo (nomeArq); //carrega arquivo para memoria
    }//end construtor
    
    
    /****/
    public Token getToken (){        
        token = new Token ();             
        
        String lexema = "";
        byte idprox = 0;  //proximo simbolo a ser inserido na SymbolTab
        int byt = arq.readByte();    
        
        while (byt != ' '){       
            lexema = lexema + (char)byt;           
            byt = arq.readByte();            
        }//end while          
        
        if ( !(symbolTab.contains(lexema)) ){   //se tabela nao cotem o lexema, insere-o        
            idprox = symbolTab.getIdProx();
            token.setLexema(lexema);
            token.setIdToken(idprox);
            symbolTab.insertSimb(lexema, idprox);            
        }
        else { //se tabela ja contem o lexema, nada insere na tabela
            token.setLexema(lexema);
            token.setIdToken(symbolTab.getToken(lexema));
        }//end if
        
        return token;
    }//end getToken
    
}//end class LexicalAnalyzer

/**
 * esta lendo letra a letra
 */