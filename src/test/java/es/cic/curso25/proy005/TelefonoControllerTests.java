package es.cic.curso25.proy005;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TelefonoControllerTests {
    @Autowired //si no la pusiera, me daría nullPointerException, puesto que en testCreate utilizaría null y no lo creado por Spring
    private TelefonoController telefonoController; //no creo new, porque lo crea Spring

    @Test
    public void testCreate() {
        long resultadoId = telefonoController.create(null); //el null es excepcional, para ver si entra
        assertTrue(resultadoId > 0);
    }
}
