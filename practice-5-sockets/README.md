# PRACTICA 5

## Objetivos de la pr�ctica

1. Programaci�n distribuida y concurrente
2. Socket y ServerSocket en Java

## PARTE 1 

Implementa un servidor de ficheros concurrente que espera la conexi�n de un cliente y cuando la recibe establece un Socket con �l a trav�s del cual recibe el nombre del fichero de texto que el cliente quiere obtener, y le env�a su contenido a trav�s del flujo de salida asociado al socket. Utiliza un nuevo proceso para llevar a cabo la comunicaci�n descrita tras cada petici�n nueva de cliente.

## PARTE 2 

Implementa una aplicaci�n capaz de gestionar y llevar a cabo el intercambio de ficheros entre m�quinas remotas. Se trata de un h�brido entre arquitectura clienteservidor y peer-to-peer en la que el intercambio de ficheros se realiza directamente entre los propios clientes, y el servidor �nicamente act�a proporcionando informaci�n acerca de qu� ficheros hay disponibles en el sistema y qui�nes son los propietarios.

### Cliente Funcionamiento b�sico del programa cliente:

* Al iniciar la aplicaci�n se pregunta al usuario por su nombre de usuario. 
* Una vez iniciada la sesi�n, el cliente puede realizar dos tipos de consultas: conocer el nombre de todos los usuarios conectados o descargar ficheros.
* Una vez el usuario elija el fichero a descargar, comenzar� el proceso de descarga (en realidad se descarga directamente de la m�quina del usuario propietario) de tal forma que el programa cliente siga su curso natural, y en particular permitiendo que se realicen otras consultas e incluso otras descargas mientras continua la descarga del primer fichero.
* Al margen de la voluntad del usuario, el programa cliente puede actuar como emisor de cualquiera de sus archivos compartidos, como propietario de un fichero que otro cliente solicite. Esta acci�n ser� llevada a cabo en un segundo plano permitiendo al usuario continuar con el uso normal de la aplicaci�n.
* Al terminar la aplicaci�n se deber� comunicar el fin de sesi�n al servidor, y permitir as� que �ste actualice apropiadamente su base de datos.

### Servidor Acciones b�sicas de la aplicaci�n servidor:

* Al iniciarse, leer� de un fichero �users.txt� la informaci�n de los usuarios registrados en el sistema y todos aquellos datos relativos a �stos que consideres oportunos.
* El servidor atiende de forma concurrente todas las peticiones que realizan los clientes conectados al sistema, en particular:
..* Solicitud de b�squeda de usuarios conectados: El servidor realiza una b�squeda en su base de datos y devuelve los resultados obtenidos.
..* Solicitud de descarga de un fichero: El servidor se comunica con los dos clientes en cuesti�n, gestionando el inicio de la comunicaci�n p2p entre ellos. Una vez los clientes establecen conexi�n el servidor se desentiende de la comunicaci�n p2p.
..* Fin de sesi�n: Se actualiza apropiadamente la bases de datos (en realidad son estructuras de datos).

### Detalles de implementaci�n Implementa las siguientes clases:

* _Clase Cliente_: Clase principal de la aplicaci�n cliente. Tendr� al menos los siguientes atributos: nombre de usuario, direcci�n ip de la m�quina. Puedes tener tambi�n como atributos los objetos que proporcionan la comunicaci�n con el servidor (socket y flujos). Es responsable de llevar a cabo todas las comunicaciones con el servidor, y cuando sea necesario ejecutar el env�o o recepci�n de ficheros. Adem�s ofrece el soporte para la interacci�n con el usuario del sistema.
* _Clase OyenteServidor_: Implementa el interfaz �Runnable� o hereda de la clase �Thread�, y ser� usada para llevar a cabo una escucha continua en el canal de comunicaci�n con el servidor, en un hilo diferente.
* _Clase Usuario_: Guarda informaci�n para un usuario registrado en el sistema. Tendr� al menos los siguientes atributos: identificador de usuario, direcci�n ip y lista de ficheros compartidos. El servidor almacenar� informaci�n sobre todos los usuarios registrados en el sistema (instancias de la clase Usuario).
* _Clase Mensaje (abstracta)_: Sirve como ra�z de la jerarqu�a de mensajes que deberemos dise�nar. Tiene como atributos al tipo, origen y destino del mensaje en cuesti�n; y declara al menos los siguientes m�todos:

```java
public int getTipo();
public String getOrigen();
public String getDestino();
```

* _Clase Servidor_: Clase principal de la aplicaci�n servidor. Tendr� como atributo una o varias estructuras de datos que contendr�n la informaci�n de los usuarios. El servidor espera la llegada de peticiones de inicio de sesi�n, y asocia un hilo de ejecuci�n con cada usuario.
* _Clase OyenteCliente_: Implementa el interfaz �Runnable� o hereda de la clase �Thread�, y es usada para proporcionar concurrencia respecto a las sesiones de cada usuario con el servidor. El m�todo �run()� se limita a hacer lecturas del flujo de entrada correspondiente, realizar las acciones oportunas, y devolver los resultados en forma de mensajes que ser�n enviados al usuario o usuarios involucrados.

Ser� necesario implementar adem�s varias clases adicionales. En particular: clases para cada tipo de mensaje, clases para la interfaz con el usuario, etc (GUI o de texto).
