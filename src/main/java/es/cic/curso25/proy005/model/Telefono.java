package es.cic.curso25.proy005.model;

public class Telefono { //clase de datos

    private long id; //lo cambiaremos cuando lleguemos a bases de datos
    
    private String titular;
    
    private String numero; //en el futuro veremos cómo hacer para que, siendo string, únicamente admita números
    
    private int tipoContrato;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(int tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    
}
