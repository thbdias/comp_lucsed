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
     * @param nomeArq: nome do arquivo
     */
    public LexicalAnalyzer (String nomeArq){
        symbolTab = new SymbolTab();
        symbolTab.initialize();
        arq = new Arquivo (nomeArq); //carrega arquivo para memoria        
    }//end construtor
    
    
    /**
     * Metodo que le char a char do arquivo ate completar um lexema;
     * Depois, insere esse lexema na SymbolTab caso possível.
     * @return: Token
     */
    public Token getToken (){        
        token = new Token ();             
        byte idprox;  //proximo token a ser inserido na SymbolTab
        String lexema = obterLexema();
        
        //teste
        if (isId(lexema)){
            System.out.println ("id");
        }else
            System.out.println ("nao id");
        
        
        
        
        
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
    
    
    /***/
    private String obterLexema (){
        String lexema = "";               
        
        int byt = arq.readByte();    
        
        while ( (byt != 32) && (byt != 13) && (byt != 10) && (byt != 9) ){ //13 e 10 quebra de linha //32-vazio     
            lexema = lexema + (char)byt;           
            byt = arq.readByte();            
        }//end while                                        
        
        return lexema;
    }//end obterLexema  
    
    
    /**
      *Funcao que verifica se um caracter e numero
      *@param numero: string a ser testado
      *@return : true para sim ou false para nao
    */
    private boolean isNumber ( String num ){
        boolean resp = true;
        for (int i=0; i < num.length(); i++){
            if (!(num.charAt(i) >= '0' && num.charAt(i) <= '9'))
                resp = false;
        }//end for        
        return resp;    
    }//end isNumber
    
    
    /**
     * Funcao que verifica se um caracter e letra
     * @param id: string a ser testada
     * @return: true para sim ou false para nao
     */
    private boolean isId (String id){
        boolean resp = true;
        
        if ( (id.charAt(0) >= 'a' && id.charAt(0) <= 'z') ||
             (id.charAt(0) >= 'A' && id.charAt(0) <= 'Z') ){  //se comeca com letra
        
            for (int i = 1; i < id.length(); i++){
                if ( !((id.charAt(i) >= 'a' && id.charAt(i) <= 'z') ||
                       (id.charAt(i) >= 'A' && id.charAt(i) <= 'Z') ||
                       (id.charAt(i) >= '0' && id.charAt(i) <= '9')) )
                    resp = false;
            }//end for                       
        }
        else 
            resp = false;//end if
        
        return resp;
    }//end isId
    
}//end class LexicalAnalyzer

/**
 * esta lendo letra a letra
 */