package middleExam;

import java.io.IOException;
import java.util.ArrayList;




public class Parser {
    
    Token token;          // current token from the input stream
    Lexer lexer;
    String funcId = "";
    Lexer tmpLexer;
    
    int checkL = 0;
    
    int checkNEEDsemi = 0;
    int printsemi = 0;

    public Parser(Lexer ts) throws IOException { // Open the Clite source program
        lexer = ts;				// as a token stream, and
        token = lexer.next(); // retrieve its first Token
        tmpLexer = ts;
    }
  
	private void getToken() throws IOException {
		token = lexer.next();
	}
	
	private void parse() throws IOException {
		command();
	}
	
	public void error(String s) {
		System.out.println(s+" "+"error");
		System.exit(0);
	}
	
	public Program program() throws IOException{
		Statement s = statement();
		System.out.println("end");
		return new Program(s);
	}
	Statement statement() throws IOException{
		//checkL++;
		Statement s = null;
		if(token.type().equals(TokenType.Identifier))
			s = assignment();
		else if (token.type().equals(TokenType.If)) // IfStatement 
			s = ifStatement(); 
		else if (token.type().equals(TokenType.While)) // WhileStatement 
			s = whileStatement(); 
		else if (token.type().equals(TokenType.LeftBrace)) { // Block
			token = lexer.next(); 
			s = block(); 
			match(TokenType.RightBrace); 
			} 
		else if (token.type().equals(TokenType.Let)) // Let 
			s = letStatement(); 
		else if (token.type().equals(TokenType.Read)) // Read 
			s = readStatement(); 
		else if (token.type().equals(TokenType.Print)) // Print 
			s = printStatement(); 
		/*else {
			System.out.println("Error");
			System.exit(0);//error("Illegal statement"); 
		}*/
		else error("Illegal statement");
		//checkL--;
		return s;
	}
	
	
	Statement assignment() throws IOException{
		Identifier target = new Identifier(match(TokenType.Identifier));
		//match(TokenType.Identifier); 
		//if(token.type() == TokenType.Identifier)
		match(TokenType.RealEqual);
		Expression e = expression(); 
		if(token.type() != TokenType.Semicolon)
			getToken();
		match(TokenType.Semicolon); 
		//System.out.println("AA");
		return new Assignment(target, e);
	}
	While whileStatement() throws IOException{
		match(TokenType.While); 
		match(TokenType.LeftParen); 
		Expression test = expression(); 
		if(token.type() != TokenType.RightParen)getToken();
		match(TokenType.RightParen);
		Statement body = statement(); 
		return new While(test, body);

	}
	Let letStatement () throws IOException{ // LetStatement --> let Decls in { Statement } end 
		match(TokenType.Let);
		Expression ds = declarations();
		if(token.type() == TokenType.Semicolon)
			getToken();
		match(TokenType.In);
		Statement body = block();
		match(TokenType.End);
		return new Let(ds, body);
	}
	Conditional ifStatement() throws IOException{
		match(TokenType.If);
		match(TokenType.LeftParen);
		Expression test = expression();
		if(token.type() != TokenType.RightParen)getToken();
		match(TokenType.RightParen);
		match(TokenType.Then);
		Statement s1 = statement();
		if(token.type() == TokenType.Else)//match(TokenType.Else).equals(TokenType.Else))
		{
			getToken();
			Statement s2 = statement();
			return new Conditional(test,s1,s2);
		}
		return new Conditional(test,s1);
	}
	Read readStatement() throws IOException{
		match(TokenType.Read);
		Identifier test = new Identifier(match(TokenType.Identifier));
		//Expression test = expression();
		match(TokenType.Semicolon);
		return new Read(test);
	}
	Print printStatement() throws IOException{
		match(TokenType.Print);
		Expression test = expression();
		match(TokenType.Semicolon);
		return new Print(test);
	}

	
	private void command() throws IOException {
		prgm();
	}
	private void prgm() throws IOException{
		Program p = program();
		p.display();	//출력
		/*
		stmt();
		getToken();
		System.out.println("end");
		if(token.type() == TokenType.Dot) {
			//트리 출력
		}
		else {
			//. 이 없음 오류?
		}
		*/
	}
	Statement block() throws IOException{
		Statement test = null;
		Statement tmp = null;
		while(true) {
			if(token.type() == TokenType.End) {break;}
			else if(token.type() == TokenType.RightBrace) {break;}
			else if(token.type() != TokenType.NullString) {
				test = statement();
				
				if(tmp == null)
					tmp = test;
				else {
					tmp = new Assignment(tmp,test);
				}
				//getToken();
			}
			else {break;}
		}
		return tmp;
	}
	Expression declarations() throws IOException{
		//checkL++;
		Expression e = null;
		Expression tmp;
		Identifier test;
		while(true) {
			if(token.type() == TokenType.Semicolon)
				getToken();
			if(token.type() == TokenType.In)
				break;
			tmp = type();
			if(token.type() == TokenType.Identifier) {
				test = new Identifier(match(TokenType.Identifier));
				e = new Binary(tmp,test);
			}
			else {
				System.out.println("ERROR");
				System.exit(0);
				break;
			}
		}
		//e.display(0);
		//checkL--;
		return e;
	}
	Expression type() throws IOException{
		//checkL++;
		Operator op = null;
		Expression e;
		if(token.type() == TokenType.Int) {
			op = new Operator(match(token.type()));
		}
		else if(token.type() == TokenType.Bool) {
			op = new Operator(match(token.type()));
		}
		else{
			System.out.println("ERRor "+token.value()+" "+token.type());
			System.exit(0);
		}
		e = new Binary(op);
		
		//e.display(0);
		//checkL--;
		return e;
	}
	Expression expression() throws IOException{
		//checkL++;
		Expression e;
		Assignment tmp;
		Operator op;
		e = bexp();
		//getToken();
		while(true) {
			if(token.type() == TokenType.Ampersand) {
				op = new Operator(match(token.type()));
				Expression e2 = bexp();
				e = new Binary(op,e,e2);
			}
			else if(token.type() == TokenType.Vertical_Bar) {
				op = new Operator(match(token.type()));
				Expression e2 = bexp();
				e = new Binary(op,e,e2);
			}
			else break;
		}
		if(token.type() == TokenType.Exclamation_Point) {
			op = new Operator(match(token.type()));
			Expression e2 = expression();
			e = new Binary(op,e,e2);
		}
		else if(token.type() == TokenType.True) {
			op = new Operator(match(token.type()));
			e = new Binary(op,e);
		}
		else if(token.type() == TokenType.False) {
			op = new Operator(match(token.type()));
			e = new Binary(op,e);
		}
		else if(token.type() == TokenType.Semicolon) {}
		else if(token.type() == TokenType.IntLiteral) {}
		else {
			System.out.println("error "+token.type() +" "+token.value());
			System.exit(0);
		}
		//e.display(0);
		//checkL--;
		return e;
	}
	Expression bexp() throws IOException{
		//checkL++;
		Expression e;
		Operator op;
		e = aexp();
		
		if(token.type() == TokenType.Equal) {
			op = new Operator(match(token.type()));
			Expression e2 = aexp();
			e = new Binary(op,e,e2);
		}
		else if(token.type() == TokenType.Not_Equal) {
			op = new Operator(match(token.type()));
			Expression e2 = aexp();
			e = new Binary(op,e,e2);
		}
		else if(token.type() == TokenType.Less_than_sign) {
			op = new Operator(match(token.type()));
			Expression e2 = aexp();
			e = new Binary(op,e,e2);
		}
		else if(token.type() == TokenType.Greater_than_sign) {
			op = new Operator(match(token.type()));
			Expression e2 = aexp();
			e = new Binary(op,e,e2);
		}
		else if(token.type() == TokenType.Equal_Less_than_sign) {
			op = new Operator(match(token.type()));
			Expression e2 = aexp();
			e = new Binary(op,e,e2);
		}
		else if(token.type() == TokenType.Equal_Greater_than_sign) {
			op = new Operator(match(token.type()));
			Expression e2 = aexp();
			e = new Binary(op,e,e2);
		}
		else if(token.type() == TokenType.IntLiteral || token.type() == TokenType.Identifier){
			//System.out.println(token.type()+" "+token.value());
			getToken();

			//System.out.println("get "+token.type()+" "+token.value());
		}
		//e.display(0);
		//checkL--;
		return e;
	}
	Expression aexp() throws IOException{
		//checkL++;
		Expression e;
		Operator op;
		e = term();
		while(true) {
			if(token.type() == TokenType.Plus) {
				op = new Operator(match(token.type()));
				Expression e2 = term();
				e = new Binary(op,e,e2);
			}
			else if(token.type() == TokenType.Minus) {
				op = new Operator(match(token.type()));
				Expression e2 = term();
				e = new Binary(op,e,e2);
			}
			else {
				break;
			}
		}
		//e.display(0);
		//checkL--;
		return e;
	}

	Expression term() throws IOException{
		//checkL++;
		Expression e;
		Operator op;
		e = factor();
		while(true) {
			//getToken();
			if(token.type() == TokenType.Multiply) {
				op = new Operator(match(token.type()));
				Expression e2 = factor();
				e = new Binary(op,e,e2);
			}
			else if(token.type() == TokenType.Divide) {
				op = new Operator(match(token.type()));
				Expression e2 = factor();
				e = new Binary(op,e,e2);
			}
			else {
				break;
			}
		}
		//e.display(0);
		//checkL--;
		return e;
	}

	Expression factor() throws IOException{
		//getToken();
		if(token.type() == TokenType.Minus) {
			//getToken();
			Operator op = new Operator(match(token.type()));
			Expression e1 = primary();
			return new Unary(op,e1);
		}
		else {
			return primary();
		}
	}
	/*
	private void type() throws IOException{	//let int a; bool tmp; in end.
		if(token.type() == TokenType.Int) {}
		else if(token.type() == TokenType.Bool) {}
		else {
			//오류
			//System.out.println("type-> error "+token.type());
			//System.exit(0);
		}
	}*/
	
	private Expression primary() throws IOException{
		Expression e = null;
		if(token.type().equals(TokenType.Identifier)) {
			Identifier v = new Identifier(match(TokenType.Identifier));
			e = v;
		}
		else if(token.type().equals(TokenType.LeftParen)) {
			token = lexer.next();
			e = aexp();
			match(TokenType.RightParen);
		}
		else if(!token.type().equals(TokenType.NullString)) {	//isLiteral()
			e = literal();
		}
		else error(token.type());
		return e;
	}
	
	private Value literal() {
		String s = null;
		switch (token.type()) {
		case IntLiteral:
			//s = match(TokenType.IntLiteral);
			s = token.value();
			return new IntValue(Integer.parseInt(s));
		case Bool:
			s = match(TokenType.Bool);
			return new BoolValue();	//	////////////
		}
		throw new IllegalArgumentException( "should not reach here");
	}
    
	private String match(TokenType t) {
		String value = token.value();
		if(token.type().equals(t))
			token = lexer.next();
		else error(t);
		return value;
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
   
    
    
    private void error(TokenType tok) {
    	System.err.println("Syntax error: expecting: "+ 
    			tok + 
    			"; saw: "+
    			token);
    }
    
    
    
    
   

    

} // Parser


class Type{
	final static Type INT = new Type("int");
	final static Type BOOL = new Type("bool");
	final static Type CHAR = new Type("char");
	final static Type FLOAT = new Type("float");
	
	protected String id;
	protected Type (String t) {id = t;}
	public String getId() {return id;}
}
class Expression{
	
	public void display(int level) {
		Indenter indent = new Indenter(level);
		indent.display(getClass().toString().substring(6)+": ");//getClass().toString().substring(6)+
	}
	
}

class Variable extends Expression{
	private String id;
	Variable (String s){id = s;}
	public String id() {return id;}
	public String toString() {return id;}
	public boolean equals (Object obj) {
		String s = ((Variable) obj).id;
		return id.equals(s); 
	}
	
	public void display(int level) {
		super.display(level);
		System.out.print(id);
	}
}

class Indenter {  
	public int level;  
	public Indenter(int nextlevel) { level = nextlevel; }  
  
	public void display(String message) {  
       // displays a message on the next line at the current level  
	String tab = "";  
	System.out.println();  
	for (int i=0; i<level; i++)  
		tab = tab + "  ";  
      	System.out.print(tab + message);// + " "+level);  
	}  
}

abstract class Statement {
	public void display(int level) {
		Indenter indent = new Indenter(level);
		indent.display(getClass().toString().substring(6)+": ");
	}
}
class Skip extends Statement{
	public void display(int level) {
		super.display(level);
		//System.out.print("Skip");
	}
}
class Block extends Statement{
	public ArrayList<Statement> members = new ArrayList<Statement>();
	
	public void display(int level) {
		super.display(level);
		for(Statement s :members)
			s.display(level+1);
	}
	
}
class Assignment extends Statement{
	Variable target = null;
	Expression source = null;
	Identifier tmp = null;
	Operator op = null;
	Statement t1 = null,t2 = null;
	Assignment(Statement s1,Statement s2){
		t1 = s1;
		t2 = s2;
	}
	Assignment(Operator o,Expression e){
		op = o;
		source = e;
	}
	Assignment(Variable t,Expression e){
		target = t;
		source = e;
	}
	Assignment(Identifier i,Expression e){
		tmp = i;
		source = e;
	}
	
	public void display(int level) {
		super.display(level);

		//Indenter indent = new Indenter(level);
		//indent.display(getClass().toString().substring(6)+": "
		//		+target+" "+source+" "+tmp+" "+op+" "+t1+" "+t2);
		if(target != null)
		target.display(level+1);
		if(source != null)
		source.display(level+1);
		if(tmp != null)
		tmp.display(level+1);
		if(op != null)
		op.display(level+1);
		if(t1 != null)
			t1.display(level+1);
		if(t2 != null)
			t2.display(level+1);
		//System.out.print("Assignment ");
	}
}
class Conditional extends Statement{
	Expression test = null;
	Statement thenbranch = null, elsebranch = null;
	
	Conditional(Expression t,Statement tp){
		test = t; thenbranch = tp; elsebranch = new Skip();
	}
	
	Conditional(Expression t, Statement tp,Statement ep){
		test = t; thenbranch = tp; elsebranch = ep;
	}
	
	public void display(int level) {
		super.display(level);
		if(test != null)
			test.display(level+1);
		if(thenbranch != null)
			thenbranch.display(level+1);
		if(elsebranch != null)
			elsebranch.display(level+1);
		//System.out.print("Conditional ");
		Indenter indent = new Indenter(level);
		indent.display(getClass().toString().substring(6)+": ");
	}
}
class While extends Statement{
	Expression test = null;
	Block body = null;
	Statement tmp = null;
	Assignment t1 = null;
	While(Expression t, Block b){
		test = t;
		body = b;
	}
	
	While(Expression t,Statement s){
		test = t;
		tmp = s;
	}
	
	public void display(int level) {
		super.display(level);
		if(test != null)
		test.display(level+1);
		if(body != null)
		body.display(level+1);
		if(t1 != null)
		t1.display(level+1);
		//System.out.print("While ");
	}
}

class Let extends Statement {
	Expression e = null;
	Statement s = null;
	Declarations decpart = null;
	Block body = null;
	Let(Declarations d,Block b){
		decpart = d;
		body = b;
	}
	
	Let(Expression t1, Statement t2){
		e = t1;
		s = t2;
	}
	public void display(int level) {
		super.display(level);
		if(decpart != null)
		decpart.display(level+1);
		if(body != null)
		body.display(level+1);
		if(e != null)
		e.display(level+1);
		if(s != null)
		s.display(level+1);
		//System.out.print("Let ");
	}
}

class If extends Statement{
	
}

class Read extends Statement{
	Identifier test = null;
	Read(Identifier i){
		test = i;
	}
	public void display(int level) {
		super.display(level);
		if(test != null)
		test.display(level+1);
		//System.out.print("Read ");
	}
}

class Print extends Statement{
	Expression test = null;
	Print(Expression t){
		test = t;
	}
	public void display(int level) {
		super.display(level);
		if(test != null)
		test.display(level+1);
		//System.out.print("Print ");
	}
}

class Program{
	Declarations decpart = null;
	Block body = null;
	Statement test = null;
	
	Program(Statement s){
		test = s;
	}
	Program(Declarations d,Block b){
		decpart = d;
		body = b;
	}
    public void display () {  
        int level = 0;  
        Indenter indent = new Indenter(level);  
        indent.display("Program (abstract syntax): ");
        if(test != null)
        	test.display(level+1);
        if(decpart != null)
        	decpart.display(level+1);
        if(body != null)
        	body.display(level+1);
        //System.out.println("program");  
    }  
}

class Declarations extends ArrayList<Declaration>{
	public void display(int level) {
		Indenter indent = new Indenter(level);
		indent.display(getClass().toString().substring(6)+": ");
		indent.display("Declarations = {");
		String sep = "";
		for(Declaration dc1: this) {
			System.out.print(sep);
			dc1.display();
			sep = ",";
		}
		System.out.print("}");
	}
}

class Declaration{
	Variable v;
	Type t;
	
	Declaration() {}
	Declaration(String id, Type type){
		v = new Variable(id);
		t = type;
	}
	
	public void display() {
		System.out.print("<" + v+ "," +t.getId()+">");
	}
}

class Binary extends Expression {
	//Binary = Operator op,Expression term1,term2
	Operator op = null;
	Expression term1 = null, term2 = null;
	Binary (Operator o,Expression I, Expression r){
		op = o;
		term1 = I;
		term2 = r;
	}//binary
	
	Binary(Operator o,Expression e){
		op = o;
		term1 = e;
	}
	
	Binary(Operator o){
		op = o;
	}
	
	Binary(Expression e1, Expression e2){
		term1 = e1;
		term2 = e2;
	}
	
	public void display(int level) {
		super.display(level);
		//System.out.print("binary "+ op +" "+term1+" "+term2);
		if(term1 != null)
			term1.display(level+1);
		if(op != null)
			op.display(level+1);
		if(term2 != null)
		term2.display(level+1);
		
	}
}

class Unary extends Expression {
	Operator op = null;
	Expression term = null;
	
	Unary (Operator o,Expression e){
		op = o.val.equals("-") ? new Operator("neg"): o;
		term = e;
	}
	
	public void display(int level) {
		super.display(level);
		if(op != null)
		op.display(level+1);
		if(term != null)
		term.display(level+1);
	}
}

class Operator extends Expression {
	final static String PLUS = "+";
	final static String MINUS = "-";
	final static String TIMES = "*";
	final static String DIV = "/";
	
	final static String NEG = "neg";
	
	final static String If = "if";
	final static String Then = "then";
	final static String Else = "else";
	final static String While = "while";
	final static String Read = "read";
	final static String Print = "print";
	final static String Let = "let";
	final static String In = "in";
	final static String End = "end";
	final static String Int = "int";
	final static String Bool = "bool";
	
	final static String Ampersand = "&";
	final static String Vertical_Bar = "|";
	final static String True = "true";
	final static String False = "false";
	final static String Equal = "==";
	final static String Exclamation_Point = "!";
    final static String Not_Equal = "!=";
    final static String Less_than_sign = "<";	//<
    final static String Greater_than_sign = ">";	//>
    final static String Equal_Less_than_sign = "<=";	//<=
    final static String Equal_Greater_than_sign = ">=";	//>=
    final static String RealEqual = "=";
    final static String RightParen = ")";
    final static String LeftParaen = "(";
	String val;
	
	Operator (String s){
		val = s;
	}
	
	public String toString() {
		return val;
	}
	public boolean equals(Object obj) {
		return val.equals(obj);
	}
	boolean NegateOp() {return val.equals(NEG);}
	public void display(int level) {
		Indenter ident = new Indenter(level);
		ident.display("Operator: "+val);
	}
}
class Identifier extends Expression {
	//Identifier = String id
	private String id;
	Identifier (String s){id = s;}
	public String id() {return id;}
	public String toString() {return id;}
	public boolean equals (Object obj) {
		String s = ((Identifier) obj).id;
		return id.equals(s);// case-sensitive identifiers
	}
	
	public void display(int level) {
		Indenter indent = new Indenter(level);
		indent.display(getClass().toString().substring(6)+": "+id);
	}
}

abstract class Value extends Expression {
	protected Type type;
	protected boolean undef = true;
	
	boolean isUndef() {return undef;}
	Type type() {return type;}
}
class IntValue extends Value {
	private int value = 0;
	
	IntValue() {type = Type.INT;}
	IntValue(int v){
		this();
		value = v;
		undef = false;
	}
	
	public String toString() {
		if(undef) return "undef";
		return ""+value;
	}
	
	public void display(int level) {
		Indenter indent = new Indenter(level);
		indent.display(getClass().toString().substring(6)+": "+value);
	}
}
class CharValue extends Value {}
class FloatValue extends Value {}
class BoolValue extends Value {
	private boolean value = false;
	
	BoolValue() {type = Type.BOOL;}
	BoolValue(boolean v) {
		this();
		value = v;
		undef = false;
	}
	
	public String toString() {
		if(undef) return "undef";
		return ""+value;
	}
	
	public void display(int level) {
		Indenter indent = new Indenter(level);
		indent.display(getClass().toString().substring(6)+": "+value);
	}
}
