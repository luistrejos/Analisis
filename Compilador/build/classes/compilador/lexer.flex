

/* --------------------------Usercode Section------------------------ */
package compilador;
import java_cup.runtime.*;
      
%%
   
/* -----------------Options and Declarations Section----------------- */

%class Lexer

%line
%column
%cup

%{   
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}
   
   
/* A line terminator is a \r (carriage return), \n (line feed), or
   \r\n. */
LineTerminator = \r|\n|\r\n
   
/* White space is a line terminator, space, tab, or line feed. */
WhiteSpace     = {LineTerminator} | [ \t\f]

NUM = {DIG}+ ({DIG}|{CERO})*
DIG = [1-9]
CERO = 0
DECIMAL = {NUM} "." {NUM}
LETER = [A-Za-z]
ID = {LETER}({LETER}|{NUM})*
MENSAJE = "'" .*? "'"
COMENTARIO = "//" .*?
   
%%
/* ------------------------Lexical Rules Section---------------------- */
   
/*
   This section contains regular expressions and actions, i.e. Java
   code, that will be executed when the scanner matches the associated
   regular expression. */
   
   /* YYINITIAL is the state at which the lexer begins scanning.  So
   these regular expressions will only be matched if the scanner is in
   the start state YYINITIAL. */
   
<YYINITIAL> {

    "{"                { System.out.print(" { "); return symbol(sym.CORCHIZQ, yytext());}
    "}"                { System.out.print(" } "); return symbol(sym.CORCHDER, yytext());}
    ";"                { return symbol(sym.SEMI, yytext()); }
    ","                { System.out.print(" , "); return symbol(sym.COMA, yytext()); }
    ":"                { System.out.print(" : "); return symbol(sym.DOSP, yytext()); }
    "+"                { System.out.print(" + "); return symbol(sym.SUMA, yytext()); }
    "-"                { System.out.print(" - "); return symbol(sym.RESTA, yytext()); }
    "*"                { System.out.print(" * "); return symbol(sym.MULTI, yytext()); }
    "/"                { System.out.print(" / "); return symbol(sym.DIVIDE, yytext()); }
    "("                { System.out.print(" ( "); return symbol(sym.PARENIZQ, yytext()); }
    ")"                { System.out.print(" ) "); return symbol(sym.PARENDER, yytext()); }
    "<-"               { System.out.print(" <- "); return symbol(sym.ASSIGN, yytext()); }
    "<"                { System.out.print(" < "); return symbol(sym.MENOR, yytext()); }
    ">"                { System.out.print(" > "); return symbol(sym.MAYOR, yytext()); }
    "<>"               { System.out.print(" <> "); return symbol(sym.DIFERENTE, yytext()); }
    "="                { System.out.print(" = "); return symbol(sym.IGUAL, yytext()); } 
    "<="               { System.out.print(" <= "); return symbol(sym.MENORIGUAL, yytext()); } 
    ">="               { System.out.print(" >= "); return symbol(sym.MAYORIGUAL, yytext()); }   
    "["                { System.out.print(" [ "); return symbol(sym.LLAVEIZQ, yytext()); }
    "]"                { System.out.print(" ] "); return symbol(sym.LLAVEDER, yytext()); }
    "main"             { System.out.print(" main "); return symbol(sym.MAIN, yytext()); }
    "function"         { System.out.print(" function "); return symbol(sym.FUNCTION, yytext()); }
    "procedure"        { System.out.print(" procedure "); return symbol(sym.PROCEDURE, yytext()); }
    "return"           { System.out.print(" return "); return symbol(sym.RETURN, yytext()); }
    "for"              { System.out.print(" for "); return symbol(sym.FOR, yytext()); }
    "endfor"           { System.out.print(" endfor "); return symbol(sym.ENDFOR, yytext()); }
    "while"            { System.out.print(" while "); return symbol(sym.WHILE, yytext()); }
    "endwhile"         { System.out.print(" endwhile "); return symbol(sym.ENDWHILE, yytext()); }
    "if"               { System.out.print(" if "); return symbol(sym.IF, yytext()); }
    "else"             { System.out.print(" else "); return symbol(sym.ELSE, yytext()); }
    "endif"            { System.out.print(" endif "); return symbol(sym.ENDIF, yytext()); }
    "repeat"           { System.out.print(" repeat "); return symbol(sym.REPEAT, yytext()); }
    "int"              { System.out.print(" int "); return symbol(sym.INT, yytext()); }
    "float"            { System.out.print(" float "); return symbol(sym.FLOAT, yytext()); }
    "boolean"          { System.out.print(" boolean "); return symbol(sym.BOOL, yytext()); }
    "String"           { System.out.print(" String "); return symbol(sym.STRING, yytext()); }
    "in"               { System.out.print(" in "); return symbol(sym.IN, yytext()); }
    "out"              { System.out.print(" out "); return symbol(sym.OUT, yytext()); }
    "inout"            { System.out.print(" inout "); return symbol(sym.INOUT, yytext()); }
    "escriba"          { System.out.print(" escriba "); return symbol(sym.ESCRIBA, yytext()); }
    "llame"            { System.out.print(" llame "); return symbol(sym.LLAME, yytext()); }
    "to"               { System.out.print(" to "); return symbol(sym.TO, yytext()); }
    "and"              { System.out.print(" and "); return symbol(sym.AND, yytext()); }
    "or"               { System.out.print(" or "); return symbol(sym.OR, yytext()); }
    "true"             { System.out.print(" true "); return symbol(sym.TRUE, yytext()); }
    "false"            { System.out.print(" false "); return symbol(sym.FALSE, yytext()); }

    {NUM}              { System.out.print(yytext()); return symbol(sym.NUM, new Integer(yytext())); }
    {DECIMAL}          { System.out.print(yytext()); return symbol(sym.DECIMAL, new Float(yytext())); }
    {ID}               { System.out.print(" "+yytext()); return symbol(sym.ID, yytext());}
    {MENSAJE}          { System.out.print(yytext()); return symbol(sym.MENSAJE, yytext());}
   
    /* Don't do anything if whitespace is found */
    {WhiteSpace}       { /* just skip what was found, do nothing */ }  
    {COMENTARIO}       { /* just skip what was found, do nothing */ } 
}


/* No token was found for the input so through an error.  Print out an
   Illegal character message with the illegal character that was found. */
[^]                    { throw new Error("Illegal character <"+yytext()+">"); }
