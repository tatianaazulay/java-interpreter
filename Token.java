/*written by Tatiana Azulay*/
public class Token {
   private int val;
   private String name;
   private TokenType tokType; 
	public enum TokenType{EMPTY,LITERAL, ID, PLUS, MINUS, MULT, EQUALS, L_PAREN, R_PAREN,SEMICOLON}; 
  
	public Token(String name, TokenType t, int val) {
		this.name = name;
		this.tokType = t;
      this.val=val;
	}
	public String getLexeme() {
		return name;
	}
	public int getValue() {
		return val;
	}
	public TokenType getTokenType() {
		return tokType;
	}
   public String toString()
   {return getLexeme()+" "+getTokenType();
   }
}
