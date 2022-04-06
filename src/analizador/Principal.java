/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author JulioMulul
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        String rutaLex = "C:/Users/JulioMulul/Documents/NetBeansProjects/AnalizadorSintactico/src/analizador/Lexer.flex";
        String rutaCup = "C:/Users/JulioMulul/Documents/NetBeansProjects/AnalizadorSintactico/src/analizador/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C:/Users/JulioMulul/Documents/NetBeansProjects/AnalizadorSintactico/src/analizador/Sintax.cup"};
        generar(rutaLex, rutaCup, rutaS);
    }
    public static void generar(String rutaLex, String rutaCup, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(rutaLex);
        JFlex.Main.generate(archivo);
        archivo = new File(rutaCup);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("C:/Users/JulioMulul/Documents/NetBeansProjects/AnalizadorSintactico/src/analizador/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        
        Files.move(
                Paths.get("C:/Users/JulioMulul/Documents/NetBeansProjects/AnalizadorSintactico/sym.java"), 
                Paths.get("C:/Users/JulioMulul/Documents/NetBeansProjects/AnalizadorSintactico/src/analizador/sym.java")
        );
        
        Path rutaSin = Paths.get("C:/Users/JulioMulul/Documents/NetBeansProjects/AnalizadorSintactico/src/analizador/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        
        Files.move(
                Paths.get("C:/Users/JulioMulul/Documents/NetBeansProjects/AnalizadorSintactico/Sintax.java"), 
                Paths.get("C:/Users/JulioMulul/Documents/NetBeansProjects/AnalizadorSintactico/src/analizador/Sintax.java")
        );
    }
    
}



