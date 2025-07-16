package es.cic.curso25.proy005;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.cic.curso25.proy005.model.Motor;
import es.cic.curso25.proy005.service.MotorService;

@SpringBootTest
public class MotorServiceIntegrationTest {
    @Autowired
    private MotorService motorService;

    @Test
    public void testCreate() {
        Motor motorACrear = new Motor();
        motorACrear.setEncendido(true);
        motorACrear.setMarca("Iveco");
        motorACrear.setPotencia(2.1);

        long idAsignado = motorService.create(motorACrear);

        assertTrue(idAsignado > 0, "El id no debe ser no positivo");
    }
}
