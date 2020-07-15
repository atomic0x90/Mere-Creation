package test3;

// Parser.java
// Recursive descent parser for Expression Grammar

import java.io.*;


public class Parser {
	int checkFirst = 0;
	int checkLeftParan = 0;
    
    Token token;          // current token from the input stream
    Lexer lexer;
    String funcId = "";

    public Parser(Lexer ts) throws IOException { // Open the Clite source program
        lexer = ts;				// as a token stream, and
        token = lexer.next(); // retrieve its first Token
    }
  
	private void getToken() throws IOException {
		checkFirst++;
		token = lexer.next();
	}
	
	private void parse() throws IOException {
		command();
	}

	private void command() throws IOException {
		prgm();
		//expr();
		//System.out.println("Syntax OK");
	}
	
	private void prgm() throws IOException{
		stmt();
		getToken();
		if(token.type() == TokenType.Dot)
			System.out.println("Syntax OKK");
		else {
			System.out.println("Syntax Error . is required");
			System.exit(0);
		}
	}
	
	private void stmt() throws IOException{
		//getToken();
		
		if(token.type() == TokenType.Identifier) {
			getToken();
			if(token.type() ==  TokenType.RealEqual) {
				expr();
				if(token.type() == TokenType.Semicolon) {
					//System.out.println("Syntax Ok");
					//System.exit(0);
					//getToken();
				}
				else {
					System.out.println("Syntax Error (;is required)");
					System.exit(0);
				}
			}
			else {
				System.out.println("Syntax Error (= is required)");
				System.exit(0);
			}
		}
		else if(token.type() == TokenType.LeftBrace) {
			while(token.type() == TokenType.LeftBrace) {
				stmt();
			}
			
			if(token.type() != TokenType.RightBrace) {
				System.out.println("Syntax Error } is required");
				System.exit(0);
			}
		}
		else if(token.type() == TokenType.If) {
			getToken();
			
			if(token.type() == TokenType.LeftParen) {
				checkLeftParan = 1;
				expr();
				checkLeftParan = 0;
				
				if(token.type() == TokenType.RightParen || true) {
					getToken();
					
					if(token.type() == TokenType.Then) {
						getToken();
						stmt();
						getToken();
						if(token.type() == TokenType.Else) {
							getToken();
							stmt();
						}
					}
					else {
						System.out.println("Syntax Error 'then' is required");
						System.exit(0);
					}
				}
				else {
					System.out.println("Syntax Error ) is required");
					System.exit(0);
				}
			}
			else {
				System.out.println("Syntax Error ( is required");
				System.exit(0);
			}
		}
		else if(token.type() == TokenType.While) {
			getToken();
			
			if(token.type() == TokenType.LeftParen) {
				checkLeftParan = 1;
				expr();
				checkLeftParan = 0;
				
				if(token.type() == TokenType.RightParen || true) {
					getToken();
					stmt();
				}
				else {
					System.out.println("Syntax Error ) is required");
					System.exit(0);
				}
			}
			else {
				System.out.println("Syntax Error ( is required");
				System.exit(0);
			}
		}
		else if(token.type() == TokenType.Read) {
			getToken();
			
			if(token.type() == TokenType.Identifier) {
				getToken();
				
				if(token.type() == TokenType.Semicolon)
					System.out.println("");//Syntax Ok");
				else {
					System.out.println("Syntax Error (;is required)");
					System.exit(0);
				}
			}
			else {
				System.out.println("Syntax Error (identifier is required)");
				System.exit(0);
			}
		}
		else if(token.type() == TokenType.Print) {
			expr();
			
			if(token.type() != TokenType.Semicolon) {
				System.out.println("Syntax Error (;is required)");
				System.exit(0);
			}
/*			if(token.type() == TokenType.Semicolon)
				System.out.println("Syntax Ok");
			else {
				System.out.println("Syntax Error (;is required)");
				System.exit(0);
			}
		*/}
		else {
			System.out.println("Syntax Error 1");
			System.exit(0);
		}
	}
	
	private void expr() throws IOException {
		if(checkLeftParan == 1)
			getToken();
		bexp();
		
		if(token.type() == TokenType.Ampersand || token.type() == TokenType.Vertical_Bar) {
			while(token.type() == TokenType.Ampersand || token.type() == TokenType.Vertical_Bar) {
				getToken();
				bexp();
			}
		}
		else if(token.type() == TokenType.Exclamation_Point) {
			getToken();
			expr();
		}
		else if(token.type() == TokenType.True) {
			getToken();
			System.out.println("TokenType is true");
		}
		else if(token.type() == TokenType.False) {
			getToken();
			System.out.println("TokenType is false");
		}
		else if(token.type() == TokenType.NullString) {
			//System.out.println("TokenType is NullString");
		}
		else if(token.type() == TokenType.RightParen) {}
		else if(token.type() == TokenType.Semicolon || token.type() == TokenType.If || token.type() == TokenType.Then || token.type() == TokenType.Else || token.type() == TokenType.While || token.type() == TokenType.Read) {}
		else {
			System.out.println("Token Type Error");
			System.exit(0);
		}
		
	}
	
	private void bexp() throws IOException{
		aexp();
		
		if(token.type() == TokenType.Equal) {
			relop();
			aexp();
		}
		else if(token.type() == TokenType.Exclamation_Point) {//!
			relop();
			aexp();
		}
		else if(token.type() == TokenType.Less_than_sign) {	//<
			relop();
			aexp();
		}
		else if(token.type() == TokenType.Greater_than_sign) {//>
			relop();
			aexp();
		}
		else if(token.type() == TokenType.Not_Equal) {	//!=
			relop();
			aexp();
		}
		else if(token.type() == TokenType.Equal_Less_than_sign) {	//<=
			relop();
			aexp();
		}
		else if(token.type() == TokenType.Equal_Greater_than_sign) {	//>=
			relop();
			aexp();
		}
	}
	
	private void aexp() throws IOException{
		term();
		
		while(token.type() == TokenType.Plus || token.type() == TokenType.Minus) {
			getToken();
			term();
		}
	}
	
	private void relop() throws IOException{
		getToken();
	}
	
	private void term() throws IOException{
		factor();
		
		while(token.type() == TokenType.Multiply || token.type() == TokenType.Divide) {
			getToken();
			factor();
		}
	}
	
	private void factor() throws IOException{
		if(token.type() == TokenType.RealEqual)
			getToken();
		if(token.type() == TokenType.Minus)
			getToken();
		if(token.type() == TokenType.Print)
			getToken();
		
		if(token.type() == TokenType.LeftParen) {
			getToken();
			//if(checkLeftParan == 0)
			aexp();
			
			if(token.type() == TokenType.RightParen)// && checkLeftParan == 0)
				getToken();
			else {
				System.out.println(") is required");
				System.exit(0);
			}
		}
		/*
		else if(token.type() == TokenType.LeftParen && checkLeftParan == 1) {
			getToken();
		}*/
		else if(token.type() == TokenType.IntLiteral) {
			getToken();
		}
		else if(token.type() == TokenType.Identifier || token.type() == TokenType.True || token.type() == TokenType.False) {
			if(checkFirst == 0 && (token.type() == TokenType.True || token.type() == TokenType.False)) {
				System.out.println("First number most come (Syntax Error)");
				System.exit(0);
			}
			getToken();
		}
		else {
			System.out.println("( or num or id is required");
			System.exit(0);
		}
	}
	
    public static void main(String args[]) throws IOException {
		Parser parser;

		if (args.length == 0) {
            System.out.println("Begin parsing... ");
		    parser  = new Parser(new Lexer());
		    parser.parse();
		}
    	else {
			System.out.println("Begin parsing... " + args[0]);
			parser  = new Parser(new Lexer(args[0]));
		    parser.parse();
	    }
     } //main

} // Parser
