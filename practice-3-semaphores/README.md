# PRACTICA 3

## Objetivos de la pr�ctica:

1. Uso de sem�foros
2. Clase Semaphore en Java

## Evitar condici�n de carrera pr�ctica 2 utilizando sem�foros. 

Este ejercicio consiste en evitar una condici�n de carrera usando sem�foros. En esta ocasi�n tenemos el mismo n�mero de procesos incrementadores que decrementadores que incrementan y decrementan, respectivamente, en un mismo n�mero de pasos una variable compartida. El objetivo es asegurar la exclusi�n mutua en la ejecuci�n de los incrementos y decrementos de la variable y el objetivo es hacerlo utilizando exclusivamente un sem�foro de la clase Semaphore.

## Productor-consumidor con sem�foros. 

Existen procesos de dos tipos diferentes:

* _Productores_, su hilo de ejecuci�n consiste, repetidamente, en crear un producto y hacerlo llegar a uno de los consumidores. 
* _Consumidores_: su hilo de ejecuci�n consiste en, repetidamente, recoger productos producidos por los productores y consumirlos. 

La comunicaci�n entre productores y consumidores se realizar� trav�s de un �almac�n� compartido por todos los procesos. La interfaz de Almacen es:

```java

public interface Almacen {
/**
* Almacena (como ultimo) un producto en el almac�n. Si no hay
* hueco el proceso que ejecute el m�todo bloquear� hasta que lo
* haya.
*/
public void almacenar(Producto producto);
/**
* Extrae el primer producto disponible. Si no hay productos el
* proceso que ejecute el m�todo bloquear� hasta que se almacene un
* dato.
*/
public Producto extraer();
}

```
En este apartado el tama�no del almac�n es uno, es decir puede haber almacenado como m�ximo un producto. Si un proceso quiere almacenar debe esperar hasta que el almac�n est� libre y si un proceso quiere extraer espera hasta que haya un producto.
Para valorar si el problema est� bien resuelto, el objetivo es asegurar:

* que todos los productos producidos acaban por ser consumidos,
* que no se consume un producto dos veces y
* que no se consume ning�n producto no v�lido

**Recomendaci�n**: jugar con los valores de n�mero de productores y n�mero de consumidores y observar con atenci�n las trazas del programa.

**Extensi�n a almac�n con N productos**. En esta apartado, el almac�n a implementar tiene una capacidad de hasta N productos, lo que permite a los productores seguir trabajando aunque los consumidores se vuelvan, moment�neamente, lentos.