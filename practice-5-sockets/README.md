# PRACTICA 5

## Objetivos de la práctica

1. Programación distribuida y concurrente
2. Socket y ServerSocket en Java

## PARTE 1 

Implementa un servidor de ficheros concurrente que espera la conexión de un cliente y cuando la recibe establece un Socket con él a través del cual recibe el nombre del fichero de texto que el cliente quiere obtener, y le envía su contenido a través del flujo de salida asociado al socket. Utiliza un nuevo proceso para llevar a cabo la comunicación descrita tras cada petición nueva de cliente.

## PARTE 2 

Implementa una aplicación capaz de gestionar y llevar a cabo el intercambio de ficheros entre máquinas remotas. Se trata de un híbrido entre arquitectura clienteservidor y peer-to-peer en la que el intercambio de ficheros se realiza directamente entre los propios clientes, y el servidor únicamente actúa proporcionando información acerca de qué ficheros hay disponibles en el sistema y quiénes son los propietarios.

### Cliente Funcionamiento básico del programa cliente:

* Al iniciar la aplicación se pregunta al usuario por su nombre de usuario. 
* Una vez iniciada la sesión, el cliente puede realizar dos tipos de consultas: conocer el nombre de todos los usuarios conectados o descargar ficheros.
* Una vez el usuario elija el fichero a descargar, comenzará el proceso de descarga (en realidad se descarga directamente de la máquina del usuario propietario) de tal forma que el programa cliente siga su curso natural, y en particular permitiendo que se realicen otras consultas e incluso otras descargas mientras continua la descarga del primer fichero.
* Al margen de la voluntad del usuario, el programa cliente puede actuar como emisor de cualquiera de sus archivos compartidos, como propietario de un fichero que otro cliente solicite. Esta acción será llevada a cabo en un segundo plano permitiendo al usuario continuar con el uso normal de la aplicación.
* Al terminar la aplicación se deberá comunicar el fin de sesión al servidor, y permitir así que éste actualice apropiadamente su base de datos.

### Servidor Acciones básicas de la aplicación servidor:

* Al iniciarse, leerá de un fichero “users.txt” la información de los usuarios registrados en el sistema y todos aquellos datos relativos a éstos que consideres oportunos.
* El servidor atiende de forma concurrente todas las peticiones que realizan los clientes conectados al sistema, en particular:
..* Solicitud de búsqueda de usuarios conectados: El servidor realiza una búsqueda en su base de datos y devuelve los resultados obtenidos.
..* Solicitud de descarga de un fichero: El servidor se comunica con los dos clientes en cuestión, gestionando el inicio de la comunicación p2p entre ellos. Una vez los clientes establecen conexión el servidor se desentiende de la comunicación p2p.
..* Fin de sesión: Se actualiza apropiadamente la bases de datos (en realidad son estructuras de datos).

### Detalles de implementación Implementa las siguientes clases:

* _Clase Cliente_: Clase principal de la aplicación cliente. Tendrá al menos los siguientes atributos: nombre de usuario, dirección ip de la máquina. Puedes tener también como atributos los objetos que proporcionan la comunicación con el servidor (socket y flujos). Es responsable de llevar a cabo todas las comunicaciones con el servidor, y cuando sea necesario ejecutar el envío o recepción de ficheros. Además ofrece el soporte para la interacción con el usuario del sistema.
* _Clase OyenteServidor_: Implementa el interfaz “Runnable” o hereda de la clase “Thread”, y será usada para llevar a cabo una escucha continua en el canal de comunicación con el servidor, en un hilo diferente.
* _Clase Usuario_: Guarda información para un usuario registrado en el sistema. Tendrá al menos los siguientes atributos: identificador de usuario, dirección ip y lista de ficheros compartidos. El servidor almacenará información sobre todos los usuarios registrados en el sistema (instancias de la clase Usuario).
* _Clase Mensaje (abstracta)_: Sirve como raíz de la jerarquía de mensajes que deberemos dise˜nar. Tiene como atributos al tipo, origen y destino del mensaje en cuestión; y declara al menos los siguientes métodos:

```java
public int getTipo();
public String getOrigen();
public String getDestino();
```

* _Clase Servidor_: Clase principal de la aplicación servidor. Tendrá como atributo una o varias estructuras de datos que contendrán la información de los usuarios. El servidor espera la llegada de peticiones de inicio de sesión, y asocia un hilo de ejecución con cada usuario.
* _Clase OyenteCliente_: Implementa el interfaz “Runnable” o hereda de la clase “Thread”, y es usada para proporcionar concurrencia respecto a las sesiones de cada usuario con el servidor. El método “run()” se limita a hacer lecturas del flujo de entrada correspondiente, realizar las acciones oportunas, y devolver los resultados en forma de mensajes que serán enviados al usuario o usuarios involucrados.

Será necesario implementar además varias clases adicionales. En particular: clases para cada tipo de mensaje, clases para la interfaz con el usuario, etc (GUI o de texto).
