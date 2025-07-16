package es.cic.curso25.proy005.repository;

import es.cic.curso25.proy005.model.Motor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

@Repository
public class MotorRepository {

    private Map<Long, Motor> motores = new HashMap<>();

    public long create(Motor motor) {
        long mayor = getSiguienteId();
        motor.setId(mayor);
        motores.put(motor.getId(), motor);
        return motor.getId();
    }

    private long getSiguienteIdConStreams() {
        long mayor =
            motores
                .keySet() // de un conjunto
                .stream() // me lo tratas como stream (flujo de elementos que he de procesar uno tras otro)
                .max( // me das el mayor con una operación rara
                    (primero, segundo) -> (int) (segundo.longValue() - primero.longValue())
                ).get() + 1; // y me lo devuelves
        return mayor + 1;
    }
    private long getSiguienteId() {
        long mayor = 0;
        
        Set<Long> ids = motores.keySet();

        Iterator<Long> iteratorId = ids.iterator(); //los sets son iterables, luego tienen iterator (me puede devolver un iterador)
    
        while (iteratorId.hasNext()) {
            Long siguiente = iteratorId.next();
            if (siguiente.longValue() > mayor) { //no me haría falta la conversión objeto-primitiva pero la hago de todos modos
                mayor = siguiente;
            }
        }
        mayor++;
        return mayor;
    }

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
