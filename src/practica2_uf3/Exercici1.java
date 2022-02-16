/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2_uf3;

import java.util.Scanner;
import utils.Utils;

/**
 *
 * @author ausias
 */
public class Exercici1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String ubiacion = "./clients.txt";
        Utils.Mostrar_contenido_fichero(ubiacion);
        String frase = scan.nextLine();
        Utils.Escribir_fichero(frase, ubiacion);
        Utils.Escribir_lugar_especifico(7, ubiacion, frase);
        String client = "";
        String nom_client = "Arnabo";
        client = Utils.Escribir_lugar_especifico(7, client, nom_client);
        Utils.Escribir_fichero(client, ubiacion);
    }
    
}
