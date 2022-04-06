package analizador;
import static analizador.Tokens.*;
%%
%class Lexer
%type Tokens

L=[a-zA-Z]
D=[0-9]+
espacio=[ ,\t,\r]+

%{
    public String lexeme;
%}
%%

{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}

"\n" {lexeme=yytext(); return Linea;}

"=" {lexeme=yytext(); return Igual;}
"+" {lexeme=yytext(); return Suma;}
"-" {lexeme=yytext(); return Resta;}
"*" {lexeme=yytext(); return Multiplicacion;}
"/" {lexeme=yytext(); return Division;}

{D} {lexeme=yytext(); return Entero;}
{D}[.|,]{D} {lexeme=yytext(); return Decimal;}
{L} {lexeme=yytext(); return Variable;}
 . {lexeme=yytext(); return ERROR;}

