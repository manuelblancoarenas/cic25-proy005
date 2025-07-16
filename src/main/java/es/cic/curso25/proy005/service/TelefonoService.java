package es.cic.curso25.proy005.service;

import org.springframework.stereotype.Service;

import es.cic.curso25.proy005.model.Telefono;

@Service
public class TelefonoService {
    private long contador = 0;

    public long create(Telefono telefono) {
        return ++contador;
    }
}
