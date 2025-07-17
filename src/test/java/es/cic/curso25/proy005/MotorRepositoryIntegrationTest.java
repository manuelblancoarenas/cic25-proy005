package es.cic.curso25.proy005;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.cic.curso25.proy005.model.Motor;
import es.cic.curso25.proy005.repository.MotorRepository;

@SpringBootTest
public class MotorRepositoryIntegrationTest {
    @Autowired
    private MotorRepository motorRepository; // le digo a Spring que me cree un MotorRepository; después generaré dos ids
                                             // diferentes para cada uno de los dos diferentes motores

    @Test
    public void testCreate() {
        Motor motor1 = new Motor();
        motor1.setMarca("Iveco");
        motor1.setPotencia(4.5);
        motor1.setEncendido(false);
        long idMotor1 = motorRepository.create(motor1);

        Motor motor2 = new Motor();
        motor2.setMarca("Iveco");
        motor2.setPotencia(4.5);
        motor2.setEncendido(false);
        long idMotor2 = motorRepository.create(motor2);

        assertTrue(idMotor1 < idMotor2); // la id que se crea primero debería ser menor
    }



}

