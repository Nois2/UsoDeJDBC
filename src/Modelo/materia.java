package Modelo;

public class materia {
    private int cod_materia = 0;
    private String nombre = "";
    private String descripcion = "";

    public materia(int cod_materia, String nombre, String descripcion) {
        this.cod_materia = cod_materia;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getCod_materia() {
        return cod_materia;
    }

    public void setCod_materia(int cod_materia) {
        this.cod_materia = cod_materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
