# PRACTICA 4

## Objetivos de la práctica:

1. Monitores
2. synchronized
3. Clases Lock y Condition

## Parte 1

La primera parte de la práctica consiste en re-implementar la práctica 2 (procesos incrementadores y decrementadores) y la práctica 3 (productores y consumidores) utilizando métodos _synchronized_.

## Parte 2

La segunda parte consiste en implementar un multibuffer: El MultiBuffer es una variación del problema del buffer compartido en el que productores y consumidores pueden insertar o extraer secuencias de elementos de longitud arbitraria, lo cual lo convierte en un ejemplo más realista. Implementa dos versiones del MultiBuffer:

1. Una primera versión usando métodos synchronized y el mecanismo wait()/notifyAll().
2. Una versión mejorada usando el mecanismo de cerrojos y colas de espera explícitas (locks & conditions).