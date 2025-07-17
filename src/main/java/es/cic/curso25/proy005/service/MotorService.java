package es.cic.curso25.proy005.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso25.proy005.model.Motor;
import es.cic.curso25.proy005.repository.MotorRepository;

@Service // esta va a ser mi componente Servicio, donde implementaremos la lógica de negocio
public class MotorService {
    @Autowired
    private MotorRepository motorRepository; // le digo a Spring que me inyecte automáticamente una instancia de la clase
                                             // MotorRepository en motorRepository
    
    public long create(Motor motor) { // creo un motor siguiendo lógica de negocio (por implementar)
        // los días festivos y fines de semana en esta empresa no se crean motores: aquí implementaríamos esta lógica de negocio
        // una vez hecho eso, con las condiciones convenientes, llamo al método create de MotorRepository utilizando como
        // argumento el motor en cuestión. El resultado, por lo que se hace en MotorRepository, será un long
        return motorRepository.create(motor);
    }
}
