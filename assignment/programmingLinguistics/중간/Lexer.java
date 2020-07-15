package middleExam;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import middleExam.Lexer;
import middleExam.Token;

public class Lexer {

    private char ch = ' '; 
    private BufferedReader input;
    private String line = "";
    private int col = 1;
    private final String letters = "abcdefghijklmnopqrstuvwxyz"
        + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String digits = "0123456789";
    private final char eolnCh = '\n';

    public Lexer (String fileName) { // source filename
        try {
            input = new BufferedReader (new FileReader(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            System.exit(1);
        }
    }

	public Lexer ( ) { // from standard input 
            input = new BufferedReader (new InputStreamReader(System.in));
			System.out.print(">");
	}

    private char nextChar() { // Return next char
        col++;
        if (col >= line.length()) {
            try {
				System.out.print("    ");
				line = input.readLine( );
            } catch (IOException e) {
                System.err.println(e);
                System.exit(1);
            } // try
            col = 0;
        } // if col
        if(line.length() == 0)
        	return '#';
        else
        	return line.charAt(col);
    }
            

    public Token next( ) { // Return next token
        do {
            if (isLetter(ch)) { // ident 
                String spelling = concat(letters + digits);
                if(spelling.equals("true"))
                	return Token.mkTrueTok(spelling);
                else if(spelling.equals("false"))
                	return Token.mkFalseTok(spelling);
                else if(spelling.equals("if"))
                	return Token.mkIfTok(spelling);
                else if(spelling.equals("then"))
                	return Token.mkThenTok(spelling);
                else if(spelling.equals("else"))
                	return Token.mkElseTok(spelling);
                else if(spelling.equals("while"))
                	return Token.mkWhileTok(spelling);
                else if(spelling.equals("read"))
                	return Token.mkReadTok(spelling);
                else if(spelling.equals("print"))
                	return Token.mkPrintTok(spelling);
                else if(spelling.equals("let"))
                	return Token.mkLetTok(spelling);
                else if(spelling.equals("in"))
            		return Token.mkInTok(spelling);
                else if(spelling.equals("end"))
                	return Token.mkEndTok(spelling);
                else if(spelling.equals("int"))
                	return Token.mkIntTok(spelling);
                else if(spelling.equals("bool"))
                	return Token.mkBoolTok(spelling);
                else
                	return Token.mkIdentTok(spelling);
            } else if (isDigit(ch)) { // int 
                String number = concat(digits);
                return Token.mkIntLiteral(number);
            } else 
			switch (ch) {
            case ' ': case '\t': case '\r': case eolnCh:
                ch = nextChar();
                break;
            
            case '/':  // divide 
                ch = nextChar();
                return Token.divideTok;
            
            case '+': ch = nextChar();
                return Token.plusTok;
            case '-': ch = nextChar();
                return Token.minusTok;
            case '*': ch = nextChar();
                return Token.multiplyTok;
            case '(': ch = nextChar();
                return Token.leftParenTok;
            case ')': ch = nextChar();
                return Token.rightParenTok;
            case ';': ch = nextChar();
                return Token.semicolonTok;
            case '{': ch = nextChar();
            	return Token.leftBrace;
            case '}': ch = nextChar();
            	return Token.rightBrace;
            case '!': ch = nextChar();
            	if(isDigit(ch))
            		return Token.exclamation_PointTok;
            	else if(isEqual(ch)) {
            		ch = nextChar();
            		if(isDigit(ch) || ch == ' ')
            			return Token.not_equalTok;
            		else {
            			System.out.println("Syntax error !=");
            			System.exit(0);
            		}
            	}
            	else {
            		System.out.println("Syntax error '!'");
            		System.exit(0);
            	}
            case '=': ch = nextChar();
            	if(isEqual(ch)) {
            		ch = nextChar();
            		if(isDigit(ch) || ch == ' ')
            			return Token.equalTok;
            		else {
            			System.out.println("Syntax error '=='");
            			System.exit(0);
            		}
            	}
            	else if(ch == ' ' || isDigit(ch) || isLetter(ch)) {
            		if(ch == ' ')
            			ch = nextChar();
            		return Token.realEqual;
            	}
            	else {
            		System.out.println("Syntax error '='");
            		System.exit(0);
            	}
            case '<': ch = nextChar();
            	if(isDigit(ch) || ch == ' ')
            		return Token.less_than_signTok;
            	else if(isEqual(ch)) {
            		ch = nextChar();
            		if(isDigit(ch) || ch == ' ')
            			return Token.equal_less_than_signTok;
            		else {
            			System.out.println("Syntax error '<='");
            			System.exit(0);
            		}
            	}
            	else {
            		System.out.println("Syntax error '<");
            		System.exit(0);
            	}
            case '>': ch = nextChar();
            	if(isDigit(ch) || ch == ' ')
            		return Token.greator_than_signTok;
            	else if(isEqual(ch)) {
            		ch = nextChar();
            		if(isDigit(ch) || ch == ' ')
            			return Token.equal_Greater_than_signTok;
            		else {
            			System.out.println("Syntax error '>='");
            			System.exit(0);
            		}
            	}
            	else {
            		System.out.println("Syntax error '>'");
            		System.exit(0);
            	}
            case '|': ch = nextChar();
            	return Token.vertical_BarTok;
            case '&': ch = nextChar();
            	return Token.ampersandTok;
            case '#':
            	return Token.nullStringTok;
            case '.':
            	return Token.dot;
            } // switch
        } while (true);
    } // next


    private boolean isLetter(char c) {
        return (c>='a' && c<='z' || c>='A' && c<='Z' && ( c != '(' && c != ')' && c != '!' && c != '<' && c != '.' && c != '>' && c != '|' && c != '&' ) );
    }
  
    private boolean isDigit(char c) {
        return (c>='0' && c<='9'); 
    }
    
    private boolean isEqual(char c) {
    	return c == '=';
    }

    
    private String concat(String set) {
        String r = "";
        do {
            r += ch;
            ch = nextChar();
            if(ch == '(' || ch == ')' || ch == '!' || ch == '|' || ch == '&' || ch == '>' || ch == '<')
            	break;
        } while (set.indexOf(ch) >= 0);
        return r;
    }

    public void error (String msg) {
        System.err.print(line);
        System.err.println("Error: column " + col + " " + msg);
        System.exit(1);
    }

    static public void main ( String[] args ) {
        Lexer lexer;
		if (args.length == 0)
            lexer = new Lexer( );
		else
            lexer = new Lexer(args[0]);

        Token tok = lexer.next( );
        while (tok != Token.semicolonTok) {
            System.out.println(tok);
             tok = lexer.next( );
        } 
    } // main
}