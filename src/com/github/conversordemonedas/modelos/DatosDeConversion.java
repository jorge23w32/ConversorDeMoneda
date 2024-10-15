package com.github.conversordemonedas.modelos;

public class DatosDeConversion {
    //Variables
    private String nombreMonedaActual;
    private String nombreMonedaAConvertir;
    private double valorConvertido;
    private double valorActual;
    //Constructor el cual almacena los valores de GuardarDatosAPI
    public DatosDeConversion(GuardarDatosAPI guardarDatos, double valorActual) {
        this.nombreMonedaActual = guardarDatos.base_code();
        this.nombreMonedaAConvertir = guardarDatos.target_code();
        this.valorConvertido = guardarDatos.conversion_result();
        this.valorActual = valorActual;
    }

    //Se modifica el metodo toString()
    @Override
    public String toString() {
        return "El valor " +valorActual+ " [" +nombreMonedaActual+ "] corresponde al valor final de =>>> " +valorConvertido+ " [" +nombreMonedaAConvertir+ "]";
    }
}
