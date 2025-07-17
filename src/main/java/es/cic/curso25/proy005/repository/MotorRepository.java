package es.cic.curso25.proy005.repository;

import es.cic.curso25.proy005.model.Motor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

@Repository // este va a ser mi componente Repositorio
public class MotorRepository {

    private Map<Long, Motor> motores = new HashMap<>(); // mi objetivo es identificar una id Long con cada objeto Motor.
                                                        // Es de tipo Long y no long porque cada Motor empieza con id="null", que
                                                        // no es long (el long base sería 0, pero lo hacemos con null)

    // ATENCIÓN: este método usa getSiguienteId(), luego leer primero ese
    // Al principio, cuando no tengo ningún motor guardado y quiero asignar por vez primera un id a un objeto Motor, el bucle
    // while no se ejecuta, luego se retorna un id igual a 1, que es resultado de sumar 1 a mayor. Ya a partir de ahí, create
    // lo añadiría al mapa, y además sustituiría el valor por defecto "null" por 1.
    public long create(Motor motor) {
        long mayor = getSiguienteId(); // es decir, aplico el método getSiguienteId para hallar cuál es un id que está disponible
                                       // y es mayor a todos los demás
        motor.setId(mayor); // le asigno a mi variable motor dicha id
        motores.put(motor.getId(), motor); // y la indico en mi mapa
        return motor.getId(); // devuelvo la id que corresponde a mi motor
    }

    private long getSiguienteId() {
        long mayor = 0; // inicializo la variable mayor, que contendrá el id más alto al que se haya llegado
        
        Set<Long> ids = motores.keySet(); // en nuestro mapa, identificamos, para cada Motor, su key (su id como Long) con su
                                          // value (el objeto Motor que determina unívocamente). Utilizo el método keySet() de los
                                          // mapas (key-value) para encontrar todas las keys (ids, Longs) que haya en el mapa. No
                                          // están ordenadas por formarse aquí un conjunto que llamaremos ids.

        Iterator<Long> iteratorId = ids.iterator(); // los sets son iterables, luego tienen iterator (me puede devolver un iterador)
                                                    // Aquí estoy preparando un iterador, es decir, algo con lo que, cuando invoque
                                                    // al método next de los iteradores, voy a coger un elemento random del set que
                                                    // voy a poder comparar con el anterior mientras lo guarde en una variable. No
                                                    // tiene un valor concreto ("null", 0...) al crear la variable, simplemente
                                                    // dice: "voy a coger elementos de este set"
    
        while (iteratorId.hasNext()) { // mientras haya elementos que sacar de set
            Long siguiente = iteratorId.next(); // asigno a la variable "siguiente" el elemento que saco
            if (siguiente.longValue() > mayor) { // no me haría falta la conversión objeto-primitiva pero la hago de todos modos.
                                                 // Si "siguiente" es mayor que el mayor de todos ("mayor"),
                mayor = siguiente; //  entonces actualizo mayor para que el que guarde sea éste
            }
        }
        mayor++; // para generar un id nuevo, lo hago de modo que sea superior a todos los anteriores (no tendrían por qué ser 1,
                 // 3, 2,... completando todos hasta cierto número, podrían ser 1, 49, 25, 222334, ..., pero el modo de
                 // asegurarme que no cojo ninguno que esté en uso es este).
        return mayor; // retorno un id que sé que está disponible, y es mayor que todos los demás guardados
    }



    // private long getSiguienteIdConStreams() {
        // long mayor =
            // motores
                // .keySet() // de un conjunto
                // .stream() // me lo tratas como stream (flujo de elementos que he de procesar uno tras otro)
                // .max( // me das el mayor con una operación rara
                    // (primero, segundo) -> (int) (segundo.longValue() - primero.longValue())
                // ).get() + 1; // y me lo devuelves
        // return mayor + 1;
    // }

    // obtengo el mayor de los que tengo hasta ahora
        // long mayor = 0;
        
        // Set<Long> ids = motores.keySet();

        // Iterator<Long> iteratorId = ids.iterator(); //los sets son iterables, luego tienen iterator (me puede devolver un iterador)
    
        // while (iteratorId.hasNext()) {
            // Long siguiente = iteratorId.next();
            // if (siguiente.longValue() > mayor) { //no me haría falta la conversión objeto-primitiva pero la hago de todos modos
                // mayor = siguiente;
            // }
        // }
        // motor.setId(++mayor);
        // motores.put(motor.getId(), motor);
}
