package es.cic.curso25.proy005.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.proy005.model.Telefono;
import es.cic.curso25.proy005.service.TelefonoService;

@RestController
@RequestMapping("/telefono")
public class TelefonoController { //expone urls
    @Autowired //porque quiero el que cree Spring; si no, sería private TelefonoService telefonoService = new TelefonoService()
    private TelefonoService telefonoService;
    //OJO: Esto es un arreglo momentáneo. Crear una variable aquí está prohibido.
    private int contador = 0;
    // C R U D

    // create(long id, String titular, ... <-- esto es viable, pero lo hacemos de otro modo)
    // public long create(Telefono telefono); 1er criterio (sólo le devuelvo el id)
    // public Telefono create(Telefono telefono); 2o criterio (le devuelvo un Telefono)

    // C
    @PostMapping
    public long create(@RequestBody Telefono telefono) { //Spring me crea el Telefono.
        long id = telefonoService.create(telefono);

        return id;
        
        //return ++contador; //ojo, recorar que no es lo mismo que contador++ (éste último cogería contador, lo retornaría y ya
                           //después sumaría uno.
    }

    // R
    @GetMapping
    // public Telefono[] mensaje() { //devuelvo un array de Telefono... incomodidad: tamaño del array inalienable
    public List<Telefono> get() { //devuelvo un array de Telefono
        // contador++;
        List<Telefono> resultado = new ArrayList<>();
        Telefono telefono1 = new Telefono();
        telefono1.setId(1);
        telefono1.setNumero("55555555");
        telefono1.setTipoContrato(3);
        telefono1.setTitular("Manuel");
        resultado.add(telefono1);
        
        Telefono telefono2 = new Telefono();
        telefono2.setId(2);
        telefono2.setNumero("55555556");
        telefono2.setTipoContrato(1);
        telefono2.setTitular("Juan");
        resultado.add(telefono2);

        return resultado;
    }
    
    @GetMapping("/{id}")
    public Telefono get(@PathVariable long id) {
        Telefono telefono1 = new Telefono();
        telefono1.setId(id);
        telefono1.setNumero("55555555");
        telefono1.setTipoContrato(3);
        telefono1.setTitular("Manuel");

        return telefono1;
    }

    // U
    @PutMapping
    public void update(@RequestBody Telefono telefono) { //no necesito dar más que un void porque tan sólo necesito verificar si se ha
                                                         //actualizado o no (es decir, me hará un 200)
        //Falta de escribir todo
    }

    // D
    @DeleteMapping("/{id}") //al tener misma URL que GetMapping, si le invocan con Delete entrará aquí y si lo hacen con Get
                            //en el otro
    public void delete(@PathVariable long id) { //para borrar un Telefono, tan solo necesito borrar su id. Y, lo mismo, me hará un 200.

    }
}
