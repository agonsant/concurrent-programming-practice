# PRACTICA 3

## Objetivos de la práctica:

1. Uso de semáforos
2. Clase Semaphore en Java

## Evitar condición de carrera práctica 2 utilizando semáforos. 

Este ejercicio consiste en evitar una condición de carrera usando semáforos. En esta ocasión tenemos el mismo número de procesos incrementadores que decrementadores que incrementan y decrementan, respectivamente, en un mismo número de pasos una variable compartida. El objetivo es asegurar la exclusión mutua en la ejecución de los incrementos y decrementos de la variable y el objetivo es hacerlo utilizando exclusivamente un semáforo de la clase Semaphore.

## Productor-consumidor con semáforos. 

Existen procesos de dos tipos diferentes:

* _Productores_, su hilo de ejecución consiste, repetidamente, en crear un producto y hacerlo llegar a uno de los consumidores. 
* _Consumidores_: su hilo de ejecución consiste en, repetidamente, recoger productos producidos por los productores y consumirlos. 

La comunicación entre productores y consumidores se realizará través de un “almacén” compartido por todos los procesos. La interfaz de Almacen es:

```java

public interface Almacen {
/**
* Almacena (como ultimo) un producto en el almacén. Si no hay
* hueco el proceso que ejecute el método bloqueará hasta que lo
* haya.
*/
public void almacenar(Producto producto);
/**
* Extrae el primer producto disponible. Si no hay productos el
* proceso que ejecute el método bloqueará hasta que se almacene un
* dato.
*/
public Producto extraer();
}

```
En este apartado el tama˜no del almacén es uno, es decir puede haber almacenado como máximo un producto. Si un proceso quiere almacenar debe esperar hasta que el almacén esté libre y si un proceso quiere extraer espera hasta que haya un producto.
Para valorar si el problema está bien resuelto, el objetivo es asegurar:

* que todos los productos producidos acaban por ser consumidos,
* que no se consume un producto dos veces y
* que no se consume ningún producto no válido

**Recomendación**: jugar con los valores de número de productores y número de consumidores y observar con atención las trazas del programa.

**Extensión a almacén con N productos**. En esta apartado, el almacén a implementar tiene una capacidad de hasta N productos, lo que permite a los productores seguir trabajando aunque los consumidores se vuelvan, momentáneamente, lentos.