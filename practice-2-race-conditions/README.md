# Pr�ctica 2

## Objetivos de la pr�ctica:

1. Condici�n de carrera
2. Exclusi�n mutua
3. Uso de volatile en Java
4. Uso de volatile con arrays

## Parte 1

*Evitar condici�n de carrera con espera activa.*
 
La primera parte consiste en evitar la condici�n de carrera que se produjo en la pr�ctica anterior. Para ello supondremos la existencia de s�lo dos procesos, que simult�neamente ejecutan sendos bucles de N pasos incrementando y decrementando, respectivamente, en cada paso una variable compartida (la operaci�n de incremento y la de decremento sobre esa misma variable compartida son secciones cr�ticas). El objetivo es evitar que mientras un proceso modifica la variable el otro haga lo mismo (propiedad que se denomina exclusi�n mutua: no puede haber dos procesos modificando simult�neamente esa variable) y el objetivo es hacerlo utilizando �espera activa� (en otras palabras, est� prohibido utilizar m�todos synchronized, sem�foros o cualquier otro mecanismo de concurrencia).

## Parte 2
 
*Generalizar la parte 1 para que funcione con 2M procesos (M incremetandores y M decrementadores).*
 
Crea tres clases LockRompeEmpate, LockTicket y LockBakery que implementen los tres algoritmos vistos en clase (cada una de ellas con un m�todo takeLock y un m�todo releaseLock), y util�zalas para garantizar la exclusi�n mutua en el ejemplo de incrementadores y decrementadores.
