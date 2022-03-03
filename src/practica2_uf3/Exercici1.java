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
    static Scanner scan  = new Scanner (System.in);
    static final int TAMANY_MAX_CODI = 5, TAMANY_MAX_NOM = 19, TAMANY_MAX_COGNOM = 29, TAMANY_MAX_NAIXAMENT = 7, TAMANY_MAX_ADRECA = 39, TAMANY_MAX_EMAIL = 29;
    static final String ubicacio_borrador = "./clients_borrador.txt", ubicacio = "./clients.txt";
    
    public static void main(String[] args) throws IOException { 
        Utils.Mostrar_contenido_fichero(ubicacio);
        String client1 = "", client2 = "", client3 = "";
        String codi = "1", nom_client = "Xavi", cognom_client = "Cabezas", naixament = "23062003", adreca = "Carrer de Cent", email = "xavicabezas@gmail.com";
        String codi2 = "2", nom_client2 = "Arnau", cognom_client2 = "Sole", naixament2 = "15042002", adreca2 = "Avinguda Europa", email2 = "arnausole@gmail.com";
        client1 = FraseFinal(codi, nom_client, cognom_client, naixament, adreca, email);
        client2 = FraseFinal(codi2, nom_client2, cognom_client2, naixament2, adreca2, email2);
        client3 = FraseFinal(codi2, nom_client2, cognom_client2, naixament2, adreca2, email2);
        /*Utils.Escribir_fichero(client1, ubicacio);
        Utils.Escribir_fichero(client2, ubicacio);*/
        int contador_clients = Utils.Contador_lineas_ficher(ubicacio);
        boolean existeix = ExisteixClient(ubicacio, client3, contador_clients);
        if (existeix){
            System.out.println("Es repeteix el client.");
        }
        else{
            Utils.Escribir_fichero(client3, ubicacio);
        }
        Utils.Mostrar_contenido_fichero(ubicacio);
        /*ConsultaPosicio(ubicacio);
        ConsultaCodi(ubicacio);
        ModificarClient(ubicacio);*/
        EsborrarClient(ubicacio);
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
        String frase_result = "";

        codi = AfegirEspais(TAMANY_MAX_CODI, codi);
        nom_client = AfegirEspais(TAMANY_MAX_NOM, nom_client);
        cognom_client = AfegirEspais(TAMANY_MAX_COGNOM, cognom_client);
        naixament = AfegirEspais(TAMANY_MAX_NAIXAMENT, naixament);
        adreca = AfegirEspais(TAMANY_MAX_ADRECA, adreca);
        email = AfegirEspais(TAMANY_MAX_EMAIL, email);
        frase_result = codi + nom_client + cognom_client + naixament + adreca + email;
        
        return frase_result;
    }
    
    public static Boolean ExisteixClient (String ubicacio, String client, int contador_clients) throws IOException{
        boolean existeix = false;
        String client_per_comparar = "";
        for (int i = 0; i < contador_clients; i++){
            client_per_comparar = Utils.Returnar_linea_demanada(ubicacio, i);
            if (client_per_comparar.equals(client)){
                existeix = true;
            }
        }
        return existeix;
    }
    
    public static void ConsultaPosicio(String ubicacio) throws IOException {
        int consulta_client = Utils.LlegirInt("Hi han "+Utils.Contador_lineas_ficher(ubicacio)+" clients, quin vols consultar? ");
        Utils.Mostrar_linea_demanada(ubicacio, consulta_client);
    }
    
    public static void ConsultaCodi (String ubicacio) throws IOException{
        int client_per_mostrar = 0;
        Boolean existeix = false;
        System.out.print("Quin codi vols consultar? ");
        String codi_consulta = scan.nextLine();
        codi_consulta = AfegirEspais(TAMANY_MAX_CODI, codi_consulta);
        for (int i = 0; i < Utils.Contador_lineas_ficher(ubicacio); i++){
            String client = Utils.Returnar_linea_demanada(ubicacio, i);
            String codi_comparar = client.substring(0, 6);
            if (codi_comparar.equals(codi_consulta)){
                existeix = true;
                client_per_mostrar = i+1;
            }
        }
        if (existeix){
            Utils.Mostrar_linea_demanada(ubicacio, client_per_mostrar);
        }
        else{
            System.out.println("No existeix cap client amb el codi demanat.");
        }
    }
    public static String DadesClient(){
        String client = "";
        System.out.print("Introdueix el codi del client: ");
        String codi = scan.nextLine();
        System.out.print("Introdueix el nom del client: ");
        String nom = scan.nextLine();
        System.out.print("Introdueix el cognom del client: ");
        String cognom = scan.nextLine();
        System.out.print("Introdueix la data de naixament del client (DDMMYYYY): ");
        String data_naixament = scan.nextLine();
        System.out.print("Introdueix l'adreça del client: ");
        String adreca = scan.nextLine();
        System.out.print("Introdueix el email del client: ");
        String email = scan.nextLine();
        client = FraseFinal(codi, nom, cognom, data_naixament, adreca, email);
        return client;
    }
    
    public static void ModificarClient (String ubicacio) throws IOException{
        int client_per_modificar = 0;
        String client_modificar = "";
        Boolean existeix = false;
        System.out.print("Introdueix el codi del client que vols modificar: ");
        String codi_consulta = scan.nextLine();
        codi_consulta = AfegirEspais(TAMANY_MAX_CODI, codi_consulta);
        for (int i = 0; i < Utils.Contador_lineas_ficher(ubicacio); i++){
            String client = Utils.Returnar_linea_demanada(ubicacio, i);
            String codi_comparar = client.substring(0, 6);
            if (codi_comparar.equals(codi_consulta)){
                existeix = true;
                client_per_modificar = i;
            }
        }
        if (existeix){
            client_modificar = Utils.Returnar_linea_demanada(ubicacio, client_per_modificar);
            System.out.println("Introdueix les noves dades del client: ");
            String nou_client = DadesClient();
            Utils.ModificarFicher(ubicacio, ubicacio_borrador, client_modificar, nou_client);
        }
        else{
            System.out.println("No existeix cap client amb el codi demanat.");
        }
    }
    
    public static void EsborrarClient (String ubicacio) throws IOException{
        int client_per_modificar = 0;
        String client_esborrar = "";
        Boolean existeix = false;
        System.out.print("Introdueix el codi del client que vols esborrar: ");
        String codi_consulta = scan.nextLine();
        codi_consulta = AfegirEspais(TAMANY_MAX_CODI, codi_consulta);
        for (int i = 0; i < Utils.Contador_lineas_ficher(ubicacio); i++){
            String client = Utils.Returnar_linea_demanada(ubicacio, i);
            String codi_comparar = client.substring(0, 6);
            if (codi_comparar.equals(codi_consulta)){
                existeix = true;
                client_per_modificar = i;
            }
        }
        if (existeix){
            client_esborrar = Utils.Returnar_linea_demanada(ubicacio, client_per_modificar);
            Utils.EsborrarLinea(ubicacio, ubicacio_borrador, client_esborrar);
            System.out.println("S'ha esborrar el client correctament.");
        }
        else{
            System.out.println("No existeix cap client amb el codi demanat.");
        }
    }
}
