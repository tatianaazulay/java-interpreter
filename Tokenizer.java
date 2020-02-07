/*written by Tatiana Azulay*/
import java.util.ArrayList;
class Tokenizer{
	private String str;
	private Token lastToken;
	private boolean pushBack;
   private ArrayList <Token> tokenArray;
   
   public Tokenizer(String str){
	   this.str = str;
      tokenArray=new ArrayList<Token>();
      createTokens();
   }
   public ArrayList<Token> getTokenArray(){
    return tokenArray;
   }  
   public void createTokens(){  
   while (hasNextToken()) {
      Token x=nextToken();
      tokenArray.add(x); 
		}
    }
      public Token nextToken(){
      int index=0;
      ArrayList <Character> bufferArray= new ArrayList<Character>(); 
		str = str.trim();
		if (pushBack) {
			pushBack = false;
			return lastToken;
		}
		if (str.isEmpty()) {
			return (lastToken = new Token("", Token.TokenType.EMPTY,0));
		}
      for(int i=0; i<str.length(); i++){
       char ch=str.charAt(i);
         if (ch==';'){
         lastToken=new Token(";",Token.TokenType.SEMICOLON,0);
         index++;
         str=str.substring(i+1);
         str = str.trim();
        return lastToken;
      }else if(ch=='-'){
      lastToken=new Token(Character.toString(ch),Token.TokenType.MINUS,0);
      index++;
      str=str.substring(i+1);
      str = str.trim();
        return lastToken;
      }else if (ch=='+'){
      lastToken=new Token(Character.toString(ch),Token.TokenType.PLUS,0);
      index++;
      str=str.substring(i+1);
      str = str.trim();
        return lastToken;
      }else if (ch=='*'){
      lastToken=new Token(Character.toString(ch),Token.TokenType.MULT,0);
      index++;
      str=str.substring(i+1);
      str = str.trim();
        return lastToken;
      }else if (ch=='='){
      lastToken=new Token(Character.toString(ch),Token.TokenType.EQUALS,0);
      index++;
      str=str.substring(i+1);
      str = str.trim();
        return lastToken;
      }else if (ch=='('){
      lastToken=new Token(Character.toString(ch),Token.TokenType.L_PAREN,0);
      index++;
      str=str.substring(i+1);
      str = str.trim();
        return lastToken;
      }else if (ch==')'){
      lastToken=new Token(Character.toString(ch),Token.TokenType.R_PAREN,0);
      index++;
      str=str.substring(i+1);
      str = str.trim();
        return lastToken;
      }else if (ch=='0'){
      lastToken=new Token(Character.toString(ch),Token.TokenType.LITERAL,0);
      index++;
      str=str.substring(i+1);
      str = str.trim();
      return lastToken;
      }else if (Character.isDigit(ch) && ch!='0'){
      bufferArray.add(ch);
      int j;
      for(j=i+1; j<str.length(); j++)
      {
      ch=str.charAt(j);
      if ( Character.isDigit(ch))
      bufferArray.add(ch);
      else break;
      }
      String num="";
      for (char c: bufferArray)
      num=num+Character.toString(c);
      int val=Integer.parseInt(num);
      lastToken=new Token(num,Token.TokenType.LITERAL,val);
      index++;
      bufferArray.clear();
      str=str.substring(j);
      str = str.trim();
         return lastToken;
      }else if (Character.isLetter(ch) || ch=='_'){
      bufferArray.add(ch);
      int j;
      for(j=i+1; j<str.length(); j++){
      ch=str.charAt(j);
      if (Character.isLetter(ch)||ch=='_' || Character.isDigit(ch))
      bufferArray.add(ch);
      else break;
      }
      String id="";
      for (char c: bufferArray)
      id=id+Character.toString(c);
      lastToken=new Token(id,Token.TokenType.ID,0);
      index++;
      bufferArray.clear();
      str=str.substring(j);
      str = str.trim();
         return lastToken;
      }
        else    
         throw new IllegalStateException("LEXICAL ERROR: INVALID INPUT: " + str.charAt(i));
	   }//for loop ends
         return lastToken;
    }//nextToken ends
	public boolean hasNextToken(){
		return !str.isEmpty();
	}
	public void pushBack(){
		if (lastToken != null) {
			this.pushBack = true;
		}
	}   
   public void printTokenArray(){
      for (Token t: tokenArray)
      System.out.println(t.getLexeme()+" "+t.getTokenType());
      for (Token t: tokenArray)
      System.out.print(t.getTokenType()+" ");
      }
}//Tokenizer ends