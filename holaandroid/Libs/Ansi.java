package com.antoniofrische.holaandroid.Libs;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Ansi {
    static Random r = new Random();
    static final Scanner reader = new Scanner(System.in);

    // global Formulation for ESC code
    static final String ESCAPE = "\u001B[";
    public static final String RESET = ESCAPE + "0m";//el reset para el final

    //enum de color y de Foreground and Background


    public enum ColorType {
        FOREGROUND, BACKGROUND
    }

    // limpiar la pantalla
    public static void cleanScreen() {
        System.out.print(ESCAPE + "H");
        System.out.print(ESCAPE + "0J");
        System.out.flush();
    }

    //imprimir a una position cualquiera de X y Y
    public static void PrintAT(char c, int fila, int columna) {
        System.out.print(ESCAPE + fila + ";" + columna + "f");
        System.out.print(c);
        System.out.flush();
    }

    /**
     * print a string to system.out(terminal)
     * @param string
     * @param bold
     * @param fg
     * @param bg
     */
    public static void println(String string, boolean bold, AnsiColor fg, AnsiColor bg) {
        println(System.out, string, bold, fg, bg);

    }

    /**
     * to print a string in a print stream.
     * @param out
     * @param string
     * @param bold
     * @param fg
     * @param bg
     */
    public static void println(PrintStream out, String string, boolean bold, AnsiColor fg, AnsiColor bg) {
        print(out, string, bold, fg, bg);
        out.println();
    }

    /**
     * print a Char in a String series with a printstream.
     * @param out
     * @param string
     * @param bold
     * @param fg
     * @param bg
     */
    public static void print(PrintStream out, String string, boolean bold, AnsiColor fg, AnsiColor bg) {
        for(char c : string.toCharArray()){
            print(out, c, bold, fg, bg);
        }
    }

    /**
     * normal print char with only 1 char.
     * @param out
     * @param character
     * @param bold
     * @param fg
     * @param bg
     */
    public static void print(PrintStream out, char character, boolean bold, AnsiColor fg, AnsiColor bg) {
        String fgColor = getColor(fg, ColorType.FOREGROUND);
        String bgColor = getColor(bg, ColorType.BACKGROUND);
        String negrita = bold ? "1;" : "0;";
        String color = "";
        if (!fgColor.isEmpty() || !bgColor.isEmpty()) {
            color = ESCAPE + negrita;
            color += (!fgColor.isEmpty()) ? ";" + fgColor : "";
            color += (!bgColor.isEmpty()) ? ";" + bgColor : "";
            color += "m";
        }
        System.out.print(color + character);
        System.out.print(RESET);
        System.out.flush();
    }

    //Print to Position X y Y con color
    public static void printTo(String string, int col, int row, boolean bold, AnsiColor fg, AnsiColor bg) {
        String fgColor = getColor(fg, ColorType.FOREGROUND);
        String bgColor = getColor(bg, ColorType.BACKGROUND);
        String negrita = bold ? "1;" : "0;";
        String color = "";
        if (!fgColor.isEmpty() || !bgColor.isEmpty()) {
            color = ESCAPE + negrita;
            color += (!fgColor.isEmpty()) ? ";" + fgColor : "";
            color += (!fgColor.isEmpty()) ? ";" + bgColor : "";
        }
        System.out.print(ESCAPE + row + ";" + col + "f");
        System.out.print(color + string);
        if (!color.isEmpty())
            System.out.print(RESET);
        System.out.flush();
    }

    //conseuir el color
    public static String getColor(AnsiColor c, ColorType ct) {
        String result = "";
        if (c != AnsiColor.NONE) {
            switch (ct) {
                case FOREGROUND:
                    result = "3" + c.ordinal();
                case BACKGROUND:
                    result = "4" + c.ordinal();
            }
        }
        return result;
    }

    //imprimir un cuadro de X por Y con el character que quieres
    public static void imprimirChar(int ancho, int alto, char x){
        for(int i=0; i <= alto;i++){
            for(int j=0; j<=ancho;j++){
                System.out.print(x);
            }
            System.out.println("");
        }
    }

}
