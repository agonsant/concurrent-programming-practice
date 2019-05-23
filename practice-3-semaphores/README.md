# PRACTICA 4

## Objetivos de la pr�ctica:

1. Monitores
2. synchronized
3. Clases Lock y Condition

## Parte 1

La primera parte de la pr�ctica consiste en re-implementar la pr�ctica 2 (procesos incrementadores y decrementadores) y la pr�ctica 3 (productores y consumidores) utilizando m�todos _synchronized_.

## Parte 2

La segunda parte consiste en implementar un multibuffer: El MultiBuffer es una variaci�n del problema del buffer compartido en el que productores y consumidores pueden insertar o extraer secuencias de elementos de longitud arbitraria, lo cual lo convierte en un ejemplo m�s realista. Implementa dos versiones del MultiBuffer:

1. Una primera versi�n usando m�todos synchronized y el mecanismo wait()/notifyAll().
2. Una versi�n mejorada usando el mecanismo de cerrojos y colas de espera expl�citas (locks & conditions).