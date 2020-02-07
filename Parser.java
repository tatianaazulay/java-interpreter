/*written by Tatiana Azulay*/
import java.util.*;
public class Parser {
    private ArrayList<Token> tokenArray;
    private int index=0;
    public SymbolTable myTable = new SymbolTable();  // To stores values of variables

    public Parser(ArrayList<Token> tokenArray){
        this.tokenArray = tokenArray;
        assignment();
    }
    private void assignment(){
    if(index < tokenArray.size() && tokenArray.get(index).getTokenType()==Token.TokenType.ID)
         {String varName = tokenArray.get(index++).getLexeme();
             if(index < tokenArray.size() && tokenArray.get(index++).getTokenType()==Token.TokenType.EQUALS)
              { Node node = E();
                myTable.addVar(varName, node.getValue());// Adds variable-value pairs to the table
                if (index < tokenArray.size() && tokenArray.get(index).getTokenType()==Token.TokenType.SEMICOLON)//check if expression ends with semicolon
                  index++;//move index
                  else throw new IllegalStateException ("Syntax error: semicolon expected after "+tokenArray.get(index-1).getLexeme());//if semicolon is missing
                if (index<tokenArray.size())//chech if there are more assignments
                assignment();
               }
          }else throw new IllegalStateException("ERROR");
    }//assignment ends
    
    private Node E() { 
    Node eNode=T();
    return E_TAIL(eNode); }

    private Node E_TAIL(Node eNode){
        if (index < tokenArray.size()) {
            if (tokenArray.get(index).getTokenType() == Token.TokenType.PLUS) {
                Node newNode=new sumNode(tokenArray.get(index++).getValue(), eNode, T());
                E_TAIL(newNode);
                  return newNode;
            } else if (tokenArray.get(index).getTokenType() == Token.TokenType.MINUS) {
                Node newNode=new subNode(tokenArray.get(index++).getValue(), eNode, T()); 
                E_TAIL(newNode);
                   return newNode;
            } 
           }
        return eNode;
    }
    private Node T(){
    Node tNode=factor();
    return T_TAIL(tNode);
    }
    private Node T_TAIL(Node tNode){
        if (index < tokenArray.size()) {
            if (tokenArray.get(index).getTokenType() == Token.TokenType.MULT) {
                return T_TAIL(new MulNode(tokenArray.get(index++).getValue(), tNode, factor()));
            }  
        }
        return tNode;
    }
    private Node factor(){
        if (index < tokenArray.size()) {
            if (tokenArray.get(index).getTokenType() == Token.TokenType.LITERAL) {
                return new intNode(tokenArray.get(index++).getValue());
            }else if (tokenArray.get(index).getTokenType() == Token.TokenType.ID) {
                  if (myTable.hasVar(tokenArray.get(index).getLexeme())) {
                     Node newNode=new intNode(myTable.findVar(tokenArray.get(index).getLexeme()));
                     index++;
                     return newNode;
                  }else
                   throw new IllegalStateException("ERROR: uninitialized variable: "+tokenArray.get(index).getLexeme());
             }else if (tokenArray.get(index).getTokenType() == Token.TokenType.L_PAREN) {
                  index++;   
                  pNode paren = new pNode(E());
                  index++;    
                  return paren;
             }else if (tokenArray.get(index).getTokenType() == Token.TokenType.MINUS) {
                  index++; // Skip the token
                   return new intNode(-factor().getValue());
             }else throw new IllegalStateException("ERROR");
             
        } else throw new IllegalStateException("ERROR");
    }//factor ends
    public void printSymbolTable(){myTable.printSymbolTable();}
    
    public class SymbolTable {
    private  Map<String, Integer> varValues = new LinkedHashMap<>();

    public void addVar(String var, int val) {
        varValues.put(var, val);
    }
    public boolean hasVar(String var) {
        return varValues.containsKey(var);
    }
    public int findVar(String var) {
        return varValues.get(var);
    }
      public void printSymbolTable() {
      for (Map.Entry<String, Integer> entry : varValues.entrySet()) 
      System.out.println(entry.getKey()+" = "+entry.getValue());
      }   
    }//symbolTable ends
}//Parser ends