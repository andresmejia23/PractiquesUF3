/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Llibreria d'utilitats
 *
 * @author author
 * @version version
 *
 */
public class Utils {
// <editor-fold defaultstate="collapsed" desc="Implementació de LlegirInt() i de LlegirDouble()">

    private static Scanner scan=null;
       
    public static int LlegirInt() {
        int result;

        if (scan == null)
            scan = new Scanner(System.in);
        result = LlegirInt(scan);

        return result;
    }

    public static int LlegirInt(String missatge) {
        int result;

        if (scan == null)
            scan = new Scanner(System.in);
        result = LlegirInt(scan, missatge);
        
        return result;
    }

    public static int LlegirInt(Scanner scan) {
        return LlegirInt(scan, null);
    }
    
    public static int LlegirInt(Scanner scan, String missatge, int valorMin, int valorMax)
    {
        int result =0;
        do {
            result = LlegirInt(scan, missatge);
        } while (result < valorMin || result > valorMax);
        
        return result;
    }

    public static int LlegirInt(Scanner scan, String missatge) {
        boolean dadesCorrectes;
        int result = 0;
        do {
            if (missatge != null) {
                System.out.print(missatge);
            }
            dadesCorrectes = scan.hasNextInt();
            if (dadesCorrectes) {
                result = scan.nextInt();
            } else if (scan.hasNext()) {
                scan.nextLine();
            }
        } while (!dadesCorrectes);

        return result;
    }
    
    public static double LlegirDouble() {
        double result;

        if (scan == null)
            scan = new Scanner(System.in);
        result = LlegirDouble(scan);

        return result;
    }

    public static double LlegirDouble(String missatge) {
        double result;

        if (scan == null)
            scan = new Scanner(System.in);
        result = LlegirDouble(scan, missatge);
        
        return result;
    }

    public static double LlegirDouble(Scanner scan) {
        return LlegirDouble(scan, null);
    }
    
    public static double LlegirDouble(Scanner scan, String missatge, double valorMin, double valorMax)
    {
        double result = 0;
        do {
            result = LlegirDouble(scan, missatge);
        } while (result < valorMin || result > valorMax);
        
        return result;
    }

    public static double LlegirDouble(Scanner scan, String missatge) {
        boolean dadesCorrectes;
        double result = 0;
        do {
            if (missatge != null) {
                System.out.print(missatge);
            }
            dadesCorrectes = scan.hasNextDouble();
            if (dadesCorrectes) {
                result = scan.nextDouble();
            } else if (scan.hasNext()) {
                scan.nextLine();
            }
        } while (!dadesCorrectes);

        return result;
    }

// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="Implementació de Numeros aleatoris">
    public static int Numero_aleatori(int max, int min) {

        int numero_aleatori = (int) (Math.random() * (max - min + 1) + min);
        return numero_aleatori;
    }

    public static void Cadena_sense_repeticio(int vector[], int max, int min) {

        for (int i = 0; i < vector.length; i++) {
            boolean encontrat = false;
            int aleatori = Numero_aleatori(max, min);
            for (int j = 0; j < i; j++) {
                if (vector[j] == aleatori) {
                    encontrat = true;
                }
            }
            if (!encontrat) {
                vector[i] = aleatori;
            } else {
                i--;
            }
        }
    }public static void Cadena_sense_repeticio_amb_numero_prohibit(int vector[], int max, int min, int num_prohibit) {

        for (int i = 0; i < vector.length; i++) {
            boolean encontrat = false;
            boolean prohibit = false;
            int aleatori = 0;
            do {
                aleatori = Numero_aleatori(max, min);
                if (aleatori == num_prohibit) {
                    prohibit = false;
                }
                else{
                    prohibit = true;
                }
            } while (!prohibit);
            for (int j = 0; j < i; j++) {
                if (vector[j] == aleatori) {
                    encontrat = true;
                }
            }
            if (!encontrat) {
                vector[i] = aleatori;
            } else {
                i--;
            }
        }
    }
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="Implementació de Ficheros">
    public static void Mostrar_contenido_fichero (String ubicacion){
        try {
            FileReader entrada = new FileReader(ubicacion);
            BufferedReader mibuffer = new BufferedReader(entrada);
            String linea ="";
            while (linea!=null){
                linea = mibuffer.readLine();
                if (linea!=null){
                System.out.println(linea);
                }   
            }
            entrada.close();
        } catch (IOException ex) {
            System.out.println("No se ha podido encontrar el archivo");
        }
    }
    
    public static void Escribir_fichero (String frase, String ubicacion){
        try {
            FileWriter escritura = new FileWriter(ubicacion, true);
            escritura.write(10);//Fa un salt de linea.
            escritura.write(frase);
            escritura.close();
        } catch (IOException ex) {
            System.out.println("No se ha podido encontrar el archivo");
        }
    }
    
    public static String Escribir_lugar_especifico (int lugar, String frase_general, String frase){
        String frase_final = "";
        frase_final = frase_general.substring(0, lugar-1) + frase;
        return frase_final;
    }
    
    public static void Mostrar_linea_demanada (String ubicacio, int linea) throws IOException{
        linea--;
        String linea_demanada = Files.readAllLines(Paths.get(ubicacio)).get(linea);
        System.out.println(linea_demanada);
    }
    
    public static String Returnar_linea_demanada (String ubicacio, int linea) throws IOException{
        String linea_demanada = Files.readAllLines(Paths.get(ubicacio)).get(linea);
        return linea_demanada;
    }
    
    public static int Contador_lineas_ficher (String ubicacio) throws FileNotFoundException, IOException{
        String frase = "";
        int contador = 0;
        FileReader fr = new FileReader(ubicacio);
        BufferedReader br = new BufferedReader(fr);
        while ((frase = br.readLine())!= null){
            contador++;
        }
        fr.close();
        br.close();
        return contador;
    }
// </editor-fold>
}
