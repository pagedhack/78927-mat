# gRPC Streaming

Ejemplo desarrollado para probar los diferentes tipos de Streaming ofrecidos por gRPC.

-   **Unaria:**  el cliente envía una única solicitud y el servidor devuelve una única respuesta.
-   **Streaming del servidor:**  el cliente envía una única solicitud y el servidor puede retornar múltiples respuestas, es decir, un flujo de respuesta.
-   **Streaming del cliente:**  donde el cliente envía múltiples peticiones y el servidor devuelve una única respuesta.
-   **Streaming bidireccional:**  en la que tanto el cliente como el servidor envían mensajes entre sí de forma simultánea, es decir, sin esperar respuesta del otro lado.

# Repositorio

## Prerequisitos

- Java 1.8 
- Maven 3.8.x

## Ejecución

Para ejecutar el ejemplo y levantar el servidor en local simplemente es necesario lanzar el siguiente comando: 
```
mvn exec:java -Dexec.mainClass=com.paradigma.grpc.streaming.StoreServer
````