package es.cic.curso25.proy005.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.proy005.model.Motor;
import es.cic.curso25.proy005.service.MotorService;

@RestController
@RequestMapping("/motor")
public class MotorController {

        @Autowired
        private MotorService motorService;

        @PostMapping
        public long create(Motor motor) {
            if (motor.getId() != null) {
                throw new RuntimeException("Al crear no me puedes pasar id");
            }
            return motorService.create(motor);
    }
}
