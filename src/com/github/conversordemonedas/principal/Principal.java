package com.github.conversordemonedas.principal;

import com.github.conversordemonedas.archivos.ArchivoJson;
import com.github.conversordemonedas.modelos.ConexionAlApi;
import com.github.conversordemonedas.modelos.DatosDeConversion;
import com.github.conversordemonedas.modelos.GuardarDatosAPI;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        GuardarDatosAPI guardarDatos = null;
        ArchivoJson archivoJson = new ArchivoJson();
        String nombreMonedaActual;
        String nombreMonedaAconvertir;
        int opcionMenu;
        double valorAConvertir;
        Scanner teclado = new Scanner(System.in);

        while (true){
            System.out.println(
                    """
                    ________________________________________________________
                    |   ¡Bienvenido al mejor conversor de monedas!         |
                    |                                                      |
                    |   1.- Dólar =>> Peso Argentino                       |
                    |   2.- Peso Argentino =>> Dólar                       |
                    |   3.- Dólar =>> Real Brasileño                       |
                    |   4.- Real Brasileño =>> Dólar                       |
                    |   5.- Dólar =>> Peso Colombiano                      |
                    |   6.- Peso Colombiano =>> Dólar                      |
                    |   7.- Dólar =>> Peso Mexicano                        |
                    |   8.- Peso Argentino =>> Peso Mexicano               |
                    |   9.- Lira Turca =>> Peso Mexicano                   |
                    |   10.- Naira =>> Peso Mexicano                       |
                    |   11.- Salir                                         |
                    |                                                      |
                    |   Elige una opción:                                  |
                    |______________________________________________________|
                    """);
            //Obtiene lo que escribio el usuario en el teclado
            opcionMenu = teclado.nextInt();
            /*
             Dolar = USD. Peso Argentino = ARS. Real Brasileno = BRL. Peso Colombiano = COP
             Peso Mexicano = MXN. Lira Turca = TRY. Naira = NGN
            */
            if(opcionMenu == 11){
                break;
            } else if (opcionMenu == 1) {
                nombreMonedaActual = "USD";
                nombreMonedaAconvertir = "ARS";
            } else if (opcionMenu == 2) {
                nombreMonedaActual = "ARS";
                nombreMonedaAconvertir = "USD";
            } else if (opcionMenu == 3) {
                nombreMonedaActual = "USD";
                nombreMonedaAconvertir = "BRL";
            } else if (opcionMenu == 4) {
                nombreMonedaActual = "BRL";
                nombreMonedaAconvertir = "USD";
            } else if (opcionMenu == 5) {
                nombreMonedaActual = "USD";
                nombreMonedaAconvertir = "COP";
            } else if (opcionMenu == 6) {
                nombreMonedaActual = "COP";
                nombreMonedaAconvertir = "USD";
            } else if (opcionMenu == 7) {
                nombreMonedaActual = "USD";
                nombreMonedaAconvertir = "MXN";
            } else if (opcionMenu == 8) {
                nombreMonedaActual = "ARS";
                nombreMonedaAconvertir = "MXN";
            } else if (opcionMenu == 9) {
                nombreMonedaActual = "TRY";
                nombreMonedaAconvertir = "MXN";
            } else if (opcionMenu == 10) {
                nombreMonedaActual = "NGN";
                nombreMonedaAconvertir = "MXN";
            } else {
                System.out.println("Escribe una opción válida. Intentalo de nuevo\n");
                continue;
            }

            System.out.println("Ingresa el valor que deseas convertir: ");
            valorAConvertir = teclado.nextDouble();
            ConexionAlApi conexion = new ConexionAlApi(nombreMonedaActual, nombreMonedaAconvertir, valorAConvertir);
            conexion.consultarAPI();
            guardarDatos = conexion.guardarDatos(guardarDatos);
            DatosDeConversion datosConvertidos = new DatosDeConversion(guardarDatos, valorAConvertir);
            System.out.println(datosConvertidos);
            archivoJson.actualizarHistorial(datosConvertidos);
        }
        archivoJson.crearJson();
        System.out.println("Se creo de manera exitosa el historial de tus conversaciones en formato json");
    }
}
