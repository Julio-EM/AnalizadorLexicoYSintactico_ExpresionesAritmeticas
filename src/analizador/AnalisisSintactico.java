/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizador;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author JulioMulul
 */
public class AnalisisSintactico {
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        Reader lector = new BufferedReader(new FileReader("C:/Users/JulioMulul/Documents/NetBeansProjects/AnalizadorSintactico/src/analizador/archivo.txt"));
        Lexer lexer = new Lexer(lector);
        String resultado = "";
            
        
        while (true) {
            
            Tokens tokens = lexer.yylex();
            if (tokens == null) {

                resultado += "\nFIN";
                System.out.println(resultado);
                return;
            }
            switch (tokens) {
                case ERROR:
                    resultado += "  -Simbolo no definido-       " + lexer.lexeme + "\n";
                    break;
                case Variable:
                    resultado += "  -Variable-      " + lexer.lexeme + "\n";
                    break;
                case Igual:
                    resultado += "  -Simbolo de Igual-      " + lexer.lexeme + "\n";
                    break;
                case Suma:
                    resultado += "  -Operador de Suma-      " + lexer.lexeme + "\n";
                    break;
                    
                case Resta:
                    resultado += "  -Operador de Resta-     " + lexer.lexeme + "\n";
                    break;
                    
                case Multiplicacion:
                    resultado += "  -Operador de Multiplicacion-        " + lexer.lexeme + "\n";
                    break;
                    
                case Division:
                    resultado += "  -Operador de Division-      " + lexer.lexeme + "\n";
                    break;
                    
                case Entero: case Decimal:
                    resultado += "  -Numero Real-       " + lexer.lexeme + "\n";
                    break;
                                    
                default:
                    resultado += lexer.lexeme + ": " + tokens  + "\n";
                    break;
            }
        }
    }
}