package com.github.conversordemonedas.archivos;

import com.github.conversordemonedas.modelos.DatosDeConversion;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ArchivoJson {
    //Se crea la variable gson para poder interactuar con archivos json
    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    //Se crea un archivo json
    private FileWriter escritura = new FileWriter("HistorialDeConversiones.json");
    //Se crea la lista para almacenar las conversiones
    private List<DatosDeConversion> listaDeConversiones = new ArrayList<>();
    //Constructor para agregar la IOException
    public ArchivoJson() throws IOException {
    }

    //Metodos
    //Se anaden las conversiones a la lista de conversiones
    public void actualizarHistorial(DatosDeConversion datosDeConversion) {
        listaDeConversiones.add(datosDeConversion);
    }
    public void crearJson() throws IOException {
        escritura.write(gson.toJson(listaDeConversiones));
        escritura.close();
    }
}
