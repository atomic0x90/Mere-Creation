package middleExam;

import middleExam.Token;
import middleExam.TokenType;


enum TokenType {
     Eof, Semicolon, 
     LeftParen, RightParen, 
     Plus, Minus, Multiply,
     Divide, Identifier, IntLiteral,
     Ampersand,		//&
     Vertical_Bar,	//| 
     Equal, 		//==
     Exclamation_Point,	//!
     Not_Equal,	//!=
     Less_than_sign,	//<
     Greater_than_sign,	//>
     Equal_Less_than_sign,	//<=
     Equal_Greater_than_sign,	//>=
     True, False,
     NullString,	//' '
     If, Then, Else, While, Read, Print, RealEqual, 
     LeftBrace, 	// {
     RightBrace,	// }
     Dot,
     Let,In,End,
     Int,Bool,
}

public class Token {

    public static final Token eofTok = new Token(TokenType.Eof, "<<EOF>>");
    public static final Token leftParenTok = new Token(TokenType.LeftParen, "(");
    public static final Token rightParenTok = new Token(TokenType.RightParen, ")");
	public static final Token semicolonTok = new Token(TokenType.Semicolon, ";");
    public static final Token plusTok = new Token(TokenType.Plus, "+");
    public static final Token minusTok = new Token(TokenType.Minus, "-");
    public static final Token multiplyTok = new Token(TokenType.Multiply, "*");
    public static final Token divideTok = new Token(TokenType.Divide, "/");
    
    public static final Token ampersandTok = new Token(TokenType.Ampersand, "&");
    public static final Token vertical_BarTok = new Token(TokenType.Vertical_Bar, "|");
    public static final Token equalTok = new Token(TokenType.Equal, "==");
    public static final Token exclamation_PointTok = new Token(TokenType.Exclamation_Point, "!");
    public static final Token not_equalTok = new Token(TokenType.Not_Equal, "!=");
    public static final Token less_than_signTok = new Token(TokenType.Less_than_sign, "<");
    public static final Token greator_than_signTok = new Token(TokenType.Greater_than_sign, ">");
    public static final Token equal_less_than_signTok = new Token(TokenType.Equal_Less_than_sign, "<=");
    public static final Token equal_Greater_than_signTok = new Token(TokenType.Equal_Greater_than_sign, ">=");
    public static final Token nullStringTok = new Token(TokenType.NullString, "");
    
    public static final Token realEqual = new Token(TokenType.RealEqual, "=");
    public static final Token leftBrace = new Token(TokenType.LeftBrace, "{");
    public static final Token rightBrace = new Token(TokenType.RightBrace, "}");
    public static final Token dot = new Token(TokenType.Dot, ".");
   // public static final Token let = new Token(TokenType.Let,"")

    private TokenType type;
    private String value = "";

    private Token (TokenType t, String v) {
        type = t;
        value = v;
    }

    public TokenType type( ) { return type; }

    public String value( ) { return value; }
    
    public static Token mkLetTok (String name) {
    	return new Token(TokenType.Let, name);
    }
    
    public static Token mkInTok (String name) {
    	return new Token(TokenType.In, name);
    }
    
    public static Token mkEndTok (String name) {
    	return new Token(TokenType.End, name);
    }
    
    public static Token mkIntTok (String name) {
    	return new Token(TokenType.Int, name);
    }
    
    public static Token mkBoolTok(String name) {
    	return new Token(TokenType.Bool, name);
    }

    public static Token mkIdentTok (String name) {
        return new Token(TokenType.Identifier, name);
    }

    public static Token mkIntLiteral (String name) {
        return new Token(TokenType.IntLiteral, name);
    }
    
    public static Token mkTrueTok (String name) {
    	return new Token(TokenType.True, name);
    }

    public static Token mkFalseTok (String name) {
    	return new Token(TokenType.False, name);
    }
    
    public static Token mkIfTok (String name) {
    	return new Token(TokenType.If, name);
    }
    
    public static Token mkThenTok (String name) {
    	return new Token(TokenType.Then, name);
    }
    
    public static Token mkElseTok (String name) {
    	return new Token(TokenType.Else, name);
    }
    
    public static Token mkWhileTok (String name) {
    	return new Token(TokenType.While, name);
    }
    
    public static Token mkReadTok (String name) {
    	return new Token(TokenType.Read, name);
    }
    
    public static Token mkPrintTok (String name) {
    	return new Token(TokenType.Print, name);
    }
    
    public String toString ( ) {
        return value;
    } // toString

    public static void main (String[] args) {
        System.out.println(eofTok);
        System.out.println(divideTok);
        System.out.println(multiplyTok);
        System.out.println(rightParenTok);
    }
} // Token