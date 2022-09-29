package com.antoniofrische.holaandroid.Libs;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.Scanner;

public class Lib {
    static Random r = new Random();
    static final Scanner reader = new Scanner(System.in);


    //Introduction de un String
    public static String obtindreDNI(){
        //New Scanner, reader
        Scanner reader = new Scanner(System.in);

        //First print, and introduction for user
        System.out.print("Introduce tu DNI: ");
        String dni = reader.nextLine();
        reader.close();
        return dni;
    }

    /**
     * TO calculate the NIF from the DNI.
     * @param dni
     * @return
     */
    public static String calcularNIF(String dni){
        //variables
        String let = "";
        String letras = "TRBGTDFSGHJGTJFIKL"; //utilizando un CharAt para las letras de cada numero
        String nif = "";

        //calcul del DNI
        int calc = Integer.parseInt(dni) % 23;
        let = let + letras.charAt(calc);
        nif = dni+let;
        return nif;
    }


    //comparation de dos numros
    public static void comparacionDeDosFloat(){
        // new Scanner, lector
        Scanner lector = new Scanner(System.in);

        // Variables
        float primerNum, secondNum;

        // program start
        System.out.println("Introduce el primer Numero para comparar");
        primerNum = Float.parseFloat(lector.nextLine());

        System.out.println("Introduce el segundo numero para comparar");
        secondNum = Float.parseFloat(lector.nextLine());

        if (primerNum > secondNum) {
            System.out.println(primerNum + " es major que " + secondNum);
        } else if (primerNum < secondNum) {
            System.out.println(primerNum + " es menor que " + secondNum);
        } else {
            System.out.println(primerNum + " y " + secondNum + " son igual");
        }
        lector.close();
    }

    //imprimir un character o String x vezes
    public static void printCharacter(String string, int numVezes) {
        while (numVezes > 0) {
            System.out.println(string);
            numVezes--;
        }
    }

    //contar las letras de una palabra
    public static int cuentaLetras (String palabra){
        int cuenta = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (Character.isLetter(palabra.charAt(i)))
                cuenta++;
        }
        return cuenta;
    }


    //traducir a diferentes Idiomas como Castellano, ingles y valenciano
    public static void Translate(char idioma, String nombre){
        if(idioma == 'a'){
            System.out.println("Good morning, " + nombre);
        }
        else if (idioma == 'b'){
            System.out.println("Buenos dias, " + nombre);
        }
        else if(idioma == 'c') {
            System.out.println("Bon dia, " + nombre);
        }
    }

    /**
     * Show a Menu and define the max bounds to choose from, it prints the menu and valideds the introduction
     * @param menu StringBuilder
     * @param minBound int
     * @param maxBound int
     * @return int opcion
     */
    public static int mostraMenu(StringBuilder menu, int minBound, int maxBound){
        boolean validar = false;
        int result = 0;
        do{
            System.out.print(menu);
            System.out.println("Introduce un numero porfavor");
            result = Integer.parseInt(reader.nextLine());
            validar = validacionRango(result,minBound,maxBound);
        }while(!validar);
        reader.close();
        return result;
    }


    /**
     * Para generar random de tipo int, nesecita el Min y el Max
     * @param min int
     * @param max int
     * @return int
     */
    public static int randomInt (int min, int max)
    {
        return r.nextInt(max-min+1)+min;
    }

    /**
     * To generate Randoms of type double, need MIN and MAX
     * @param min int
     * @param max int
     * @return Double
     */
    public static double randomDouble(double min, double max){
        return r.nextDouble() * (max - min +1) +min;
    }

    /**
     * Te genera un menu con und String rellenado con el texto, los puntos/linias se separan con _
     * @param completeMenu String con el menu completo separados por _
     * @return devulve un StringBuilder.
     */
    public static StringBuilder generateMEnu(String completeMenu){
        StringBuilder finMenu = new StringBuilder();
        String[] menu = completeMenu.split("[|]");
        for (int i = 0; i < menu.length; i++){
            finMenu.append(menu[i]);
            finMenu.append("\n");
        }
        return finMenu;
    }


    /**
     * To valided a spesific range of options.
     * @param option int
     * @param rangoMinInclusive int
     * @param rangoMaxInclusive int
     * @return boolean
     */
    public static boolean validacionRango(int option, int rangoMinInclusive, int rangoMaxInclusive){
        return option >= rangoMinInclusive && option <= rangoMaxInclusive;
    }

    /**
     * To print a massag to the Terminal/User and then get back a INT. With exeptions
     * @param message String
     * @return Int
     */
    public static int readInt(String message){
        boolean itsValid = false;
        int data = 0;
        do{
            //intenta conseguir un Int
            try {
                System.out.println(message);
                data = Integer.parseInt(reader.nextLine());
                itsValid=true;
            } catch (NumberFormatException nfe){
                System.out.println("Solo numeros Son validos");
            }
        }while (!itsValid);
        return data;
    }

    /**
     * To print a Massage to the User and then get back a INT
     * @param massage String
     * @return Int
     */
    public static int askInteger(String massage) {
        boolean isValid = false;
        int integer = 0;
        do {
            try {
                System.out.println(massage);
                integer = Integer.parseInt(reader.nextLine());
                isValid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Solo introducir numeros");
            } //todo : enviar excepcion al metodo superior
        }while (!isValid);
        return integer;
    }

    /**
     * To print a massage and recieve a double back.
     * @param message String
     * @return Double
     */
    public static double askDouble(String message) {
        boolean isValid = false;
        double data = 0;
        do {
            System.out.println(message);
            data = Double.parseDouble(reader.nextLine());
            isValid = true;

        }while (!isValid);
        return data;
    }

    /**
     * TO print a massage and resieve a Long
     * @param message String
     * @return Long
     */
    public static long askLong(String message) {
        System.out.println(message);
        return Long.parseLong(reader.nextLine());
    }

    /**
     * To print a massage and resieve a Float
     * @param message String
     * @return Float
     */
    public static float askFloat(String message) {
        System.out.println(message);
        return Float.parseFloat(reader.nextLine());
    }

    /**
     * To print a massage to the user und recive a String that is longer than 2 chars
     * @param massage String
     * @return String
     */
    public static String askString(String massage) {
        boolean isValid = false;
        String data = "";
        do {
            System.out.println(massage);
            data = reader.nextLine();
            isValid = data.length()>2;
        }while (!isValid);
        return data;
    }

    /**
     * Waits for an Enter to continue.
     */
    public static void introPause(){
        boolean isValid = false;
        String data = "iuhh";
        do{
            System.out.print("Esperando a un intro... ");
            data = reader.nextLine();
            isValid = data.length()==0;
        }while (!isValid);
    }

    /**
     * Calculates the age with only the Birthday needet
     * @param fechaNac Birthday of the person
     * @return an Int.
     */
    public static int calcFechaNacimiento(LocalDate fechaNac){
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNac,fechaActual).getYears();
    }

    /**
     * To print a Array of Int type with any length
     * @param intArray int
     */
    public static void showArrayInt(int intArray[]){
        System.out.printf("[");
        for (int j : intArray) {
            System.out.printf(" %d", j);
        }
        System.out.printf(" ]\n");
    }

    /**
     * To print a Array of double Type, with any length
     * @param doubleArray double
     */
    public static void showArrayDouble(double doubleArray[]){
        System.out.printf("[");
        for (int i = 0; i < doubleArray.length; i++) {
            System.out.printf(" %.2f",doubleArray[i]);
        }
        System.out.printf(" ]\n");
    }

    /**
     * To print a Array of char Typ, with any length
     * @param charArray char
     */
    public static void showArrayChar(char charArray[]){
        System.out.printf("[");
        for (int i = 0; i < charArray.length; i++) {
            System.out.printf(" %c",charArray[i]);
        }
        System.out.printf(" ]\n");
    }

    /**
     * To print a Array of Type int, with Any length but only the even part of the array
     * @param intArrayForPar int
     */
    public static void showParArrayInt(int intArrayForPar[]) {
        for (int i = 0; i < intArrayForPar.length; i+=2) {
            if (intArrayForPar[i] % 2 == 0) {
                System.out.printf("Position array[%d] = %d \n",
                        i , intArrayForPar[i]);
            }
        }
    }



    //no relevantes!!

    //calcul de la area y el perimetro de un circulo
    public static double calcArea(double radio) {
        double area = radio * Configure.PI;
        return area;
    }

    public static double calcPerimetro(double radio) {
        double perimetro = 2 * Configure.PI * radio;
        return perimetro;
    }

}
