/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2_uf3;

import java.io.File;
import java.io.IOException;
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
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int contador_clients = 0;
        String ubicacio = "./clients.txt";
        Utils.Mostrar_contenido_fichero(ubicacio);
        String client1 = "", client2 = "", client3 = "";
        String codi = "1", nom_client = "Xavi", cognom_client = "Cabezas", naixament = "23062003", adreca = "Carrer de Cent", email = "xavicabezas@gmail.com";
        String codi2 = "2", nom_client2 = "Arnau", cognom_client2 = "Sole", naixament2 = "15042002", adreca2 = "Avinguda Europa", email2 = "arnausole@gmail.com";
        client1 = FraseFinal(codi, nom_client, cognom_client, naixament, adreca, email);
        client2 = FraseFinal(codi2, nom_client2, cognom_client2, naixament2, adreca2, email2);
        client3 = FraseFinal(codi2, nom_client2, cognom_client2, naixament2, adreca2, email2);
        /*Utils.Escribir_fichero(client1, ubicacio);
        Utils.Escribir_fichero(client2, ubicacio);*/
        contador_clients = 2;
        boolean existeix = ExisteixClient(ubicacio, client3, contador_clients);
        if (existeix){
            System.out.println("Es repeteix el client.");
        }
        else{
            Utils.Escribir_fichero(client3, ubicacio);
        }
        Utils.Mostrar_contenido_fichero(ubicacio);
    }
    
    public static String AfegirEspais(int tamanoMax, String missatge) {
        boolean tamano = true;
        String result = missatge;
        int tamanoMissatge = missatge.length();
        if (tamanoMissatge > tamanoMax) {
            tamano = false;
        } else {         
            for (int i = tamanoMissatge; i < (tamanoMax + 1); i++) {
                result = result + " ";
            }
        }
        return result;
    }
    
    public static String FraseFinal(String codi, String nom_client, String cognom_client, String naixament, String adreca, String email) {
        final int TAMANY_MAX_CODI = 5, TAMANY_MAX_NOM = 19, TAMANY_MAX_COGNOM = 29, TAMANY_MAX_NAIXAMENT = 7, TAMANY_MAX_ADRECA = 39, TAMANY_MAX_EMAIL = 29;
        String frase_result = "";

        codi = AfegirEspais(TAMANY_MAX_CODI, codi);
        nom_client = AfegirEspais(TAMANY_MAX_NOM, nom_client);
        cognom_client = AfegirEspais(TAMANY_MAX_COGNOM, cognom_client);
        naixament = AfegirEspais(TAMANY_MAX_NAIXAMENT, naixament);
        adreca = AfegirEspais(TAMANY_MAX_ADRECA, adreca);
        email = AfegirEspais(TAMANY_MAX_EMAIL, email);
        frase_result = codi + nom_client + cognom_client + naixament + adreca + email;
        System.out.println(codi.length());
        System.out.println(nom_client.length());
        System.out.println(cognom_client.length());
        System.out.println(naixament.length());
        System.out.println(adreca.length());
        System.out.println(email.length());
        
        return frase_result;
    }
    
    public static Boolean ExisteixClient (String ubicacio, String client, int contador_clients) throws IOException{
        System.out.println();
        System.out.println(client.length());
        System.out.println();
        boolean existeix = false;
        String client_per_comparar = "";
        for (int i = 0; i < contador_clients; i++){
            client_per_comparar = Utils.Returnar_linea_demanada(ubicacio, i);
            System.out.println(client_per_comparar.length());
            if (client_per_comparar.equals(client)){
                existeix = true;
            }
        }
        return existeix;
    }
    
    public static void ConsultaPosicio (int posicio, String ubicacio, int contador_clients){
        
    }
    
}
