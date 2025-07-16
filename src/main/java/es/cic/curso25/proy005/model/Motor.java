package es.cic.curso25.proy005.model;

public class Motor {

    // Cuando tenga la clase de datos, además de los get y set, aparecerán anotaciones
    private Long id; // Puedo operar tanto con Long como con long; lo haremos habitualmente con objetos
                     // Este campo es único; ahora ya vendrían mis campos

    private double potencia; 

    private String marca;

    private boolean encendido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }


}
