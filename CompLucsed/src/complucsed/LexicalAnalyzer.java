/**
 * @author thiago
 */

package complucsed;

public class LexicalAnalyzer {
    
    private static SymbolTab symbolTab;
    //private static Token token;
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
        Token token = new Token ();                     
        String lexema = obterLexema(); 
        String buffer = "";
                                                        
        if (isId(lexema)){                  //is identificador?
            token = addOnTable(lexema); 
        }//
        else if (isNumber(lexema)){         //is number?
                token = addOnTable (lexema); 
             }
        else if (isQuoteMark(lexema.charAt(0))){ //se primeiro char é aspas
                token = addOnTable (lexema);
                //if (isQuoteMark(lexema.charAt(lexema.length()-1))){ //se ultimo char é aspas                             
                  //  String lex = ""; 
                    //copiando string que esta dentro das aspas para lex
                    //    for (int i = 1; i < (lexema.length()-1); i++){
                      //      lex = lex + lexema.charAt(i);
                       // }//end for
                    
                  //  if (isId(lex))
                    //    token = addOnTable(lex);                                        
               // }//end if
             }//  
        //else if (isLparenthese(lexema.charAt(0))){ //se primeiro char é abre parenteses
                //buffer = buffer + "(";
                //String lex = "";
                //retirando '(' e ',' do lexema
                  //  for (int i = 1; i < (lexema.length()-1); i++){
                    //    lex = lex + lexema.charAt(i);
                    //}//end for
                //if (isId(lex)){    //se identificador
                  //  token = addOnTable(lex);  //adiciona id na tabela de simbolos
                   // if (isComma(lexema.charAt(lexema.length()-1))){  //se virgula
                    //    token = addOnTable (",");  //adiciona virgula na tabela de simbolo
                    //}//end if
               // }//end if
             //}
             //else //"deve haver um tratamento de erro aki"
               // System.out.println("deve haver um tratamento de erro aqui");
        
        return token;
    }// end getToken
    
    
    /**
     * Metodo que ler proximo lexema 
     * @return: retorna o lexema
     */
    private String obterLexema (){
        String lexema = "";               
        int controle = 0;
        int byt = arq.readByte(); 
        
        while ( (byt != 32) && (byt != 13) && (byt != 10) && (controle != 1) ){
            lexema = lexema + (char)byt;
            
            if ((lexema.charAt(0) == '\"') || (lexema.charAt(0) == '\''))
                controle = 1; //sair do while
            else
                byt = arq.readByte();            
        }//end while                                        
        
        controle = 0;   
        return lexema;
    }//end obterLexema 
    
    
    /**
     * metodo que insere "Token" na tabela de simbolos
     * @param lexema: lexema a ser inserido na tabela de simbolos
     * @return: retorna o Token que foi inserido na tabela de simbolos
     */
    private Token addOnTable (String lexema){
        Token tok = new Token ();             
        byte idprox;  //proximo token a ser inserido na SymbolTab
        
        if ( !(symbolTab.contains(lexema)) ){   //se tabela nao cotem o lexema, insere-o                    
            idprox = symbolTab.getIdProx();
            tok.setLexema(lexema);
            tok.setIdToken(idprox);
            symbolTab.insertSimb(lexema, idprox);            
        }
        else { //se tabela ja contem o lexema, nada insere na tabela
            tok.setLexema(lexema);
            tok.setIdToken(symbolTab.getToken(lexema));
        }//end if
        
        return tok;
    }//end addOnTable
    
    
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
    
    
    /**
     * Funcao que verifica se um caracter e aspas
     */
    private boolean isQuoteMark (char c){               
        return ( (c == '\'') || (c == '\"') );
    }//end isQuoteMark
    
    
    /**
     * Funcao que verifica se um caracter e abre parenteses
     */
    private boolean isLparenthese (char c){
        return (c == '(');
    }//end isLbroket
    
    
    /**
     * Funcao que verifica se um caracter e fecha parenteses
     */
    private boolean isRparenthese (char c){
        return (c == ')');
    }//end isRparenthese
    
    
    /**
     * Funcao que verifica se um caracter e virgula
     */
    private boolean isComma (char c){
        return (c == ',');
    }//end isComma
    
}//end class LexicalAnalyzer

/**
 * esta lendo letra a letra
 */