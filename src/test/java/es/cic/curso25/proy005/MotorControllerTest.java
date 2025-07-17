package es.cic.curso25.proy005;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.cic.curso25.proy005.controller.MotorController;
import es.cic.curso25.proy005.model.Motor;

@SpringBootTest
public class MotorControllerTest {
    @Autowired
    private MotorController motorController;

    @Test
    public void testCreate() {
        Motor motor = new Motor();
        motor.setMarca("Iveco");
        motor.setPotencia(4.5);
        motor.setEncendido(false);
        long resultadoId = motorController.create(motor);
        assertTrue(resultadoId > 0);
    }
}
