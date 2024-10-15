package com.github.conversordemonedas.modelos;

import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionAlApi {
    //Variables
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String json;
    private String apiKey = "00dea81dc8ca02c616855b0c";
    private String nombreMonedaActual;
    private String nombreMonedaAConvertir;
    private double valorMonedaActual;
    private String direccion;

    //Metodos
    public ConexionAlApi(String nombreMonedaActual, String nombreMonedaAConvertir, double valorMonedaActual){
        this.nombreMonedaActual = nombreMonedaActual.toUpperCase();
        this.nombreMonedaAConvertir = nombreMonedaAConvertir.toUpperCase();
        this.valorMonedaActual = valorMonedaActual;
    }
    //Consultar la api y obtener la informacion correspondiente
    public void consultarAPI(){
        try{
            //Direccion del servidor API
            direccion = "https://v6.exchangerate-api.com/v6/" +apiKey+ "/pair/" +nombreMonedaActual+ "/" +nombreMonedaAConvertir+ "/" +valorMonedaActual+ "";
            //Cliente
            HttpClient client = HttpClient.newHttpClient();
            //Hace las peticiones al api
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            //Almacena la respuesta y manda la solicitud desde el cliente
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //Se guarda la informacion
            json = response.body();
//            System.out.println(json);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Guarda informacion especifica de la informacion obtenida de la api
    public GuardarDatosAPI guardarDatos(GuardarDatosAPI guardarDatos){
        //Se guardan los datos especificos del json en las variables de la clase GuardarDatosAPI
        return guardarDatos = gson.fromJson(json, GuardarDatosAPI.class);
//        System.out.println(guardarDatos);
    }
}
