package es.cic.curso25.proy005.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.proy005.model.Motor;
import es.cic.curso25.proy005.service.MotorService;

@RestController // esta va a ser mi componente Api REST, la que administre las peticiones http
@RequestMapping("/motor") // en concreto, las que vayan con /motor
public class MotorController {

        @Autowired
        private MotorService motorService; // le digo a Spring que me inyecte automáticamente una instancia de MotorService en
                                           // la variable motorService

        @PostMapping
        public long create(@RequestBody Motor motor) { // desde el cuerpo de la petición http, Spring me inyecta los datos
                                                       // necesarios para crear el Motor. Dado que queremos que el id sea un dato
                                                       // intrínseco, en el body sólo deberían figurar los otros tres. Luego,
                                                       // cuando Spring haga la inyección, en tal caso por defecto pasará id="null" 

            if (motor.getId() != null) {
                throw new RuntimeException("Al crear no me puedes pasar id"); // aclaramos que id es un dato intrínseco
                                                                                      // y que el usuario no puede dar, y si se ha
                                                                                      // dado, se lanza una excepción. Lo
                                                                                      // comprobamos con getId porque todos los
                                                                                      // atributos son privados
            }
            return motorService.create(motor); // si se han dado correctamente los datos, es decir, todos menos id, llamamos
                                               // al método create que tiene motorService por pertenecer a MotorService pasándole
                                               // como parámetro un Motor, motor 
    }
}
