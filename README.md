# Conversor de Moneda en Java

¡Bienvenido al Conversor de Moneda en Java! Este es un programa diseñado para facilitar la conversión entre diferentes tipos de moneda. Utilizando la API de [ExchangeRate-API](https://www.exchangerate-api.com/) y la biblioteca [Gson](https://github.com/google/gson), este proyecto está implementado siguiendo principios de programación orientada a objetos.

## Características

- **Conversión de 10 tipos de monedas**: Este conversor admite las siguientes conversiones:
  - Dólar =>> Peso Argentino
  - Peso Argentino =>> Dólar                       
  - Dólar =>> Real Brasileño                       
  - Real Brasileño =>> Dólar                       
  - Dólar =>> Peso Colombiano                      
  - Peso Colombiano =>> Dólar                      
  - Dólar =>> Peso Mexicano                        
  - Peso Argentino =>> Peso Mexicano               
  - Lira Turca =>> Peso Mexicano                   
  - Naira =>> Peso Mexicano 

- **Interfaz de Usuario Simple**: El programa cuenta con una interfaz de línea de comandos que permite a los usuarios realizar conversiones de manera rápida y sencilla.

- **Uso de API**: El programa se conecta a la API de ExchangeRate-API para obtener tasas de cambio en tiempo real, lo que garantiza que las conversiones sean precisas y actualizadas.
- Al finalizar se crea un archivo .json con el historial de las conversiones que hiciste
## Requisitos

- **JDK 8 o superior**
- **ExchangeRate-API**: Regístrate y obtén una clave de API gratuita en [ExchangeRate-API](https://www.exchangerate-api.com/). Necesitarás esta clave para realizar las solicitudes a la API.
- **Dependencias**:
  - Gson: Para el manejo de JSON.
  - Biblioteca para realizar llamadas a APIs.
