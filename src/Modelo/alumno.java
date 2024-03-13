package Modelo;

public class alumno {
    private int cod_alumno = 0;
    private String nombre = "";
    private String apellido = "";
    private int edad = 0;
    private String direccion = "";

    public alumno() {
    }

    public alumno(int cod_alumno, String nombre, String apellido, int edad, String direccion) {
        this.cod_alumno = cod_alumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
    }

    public int getCod_alumno() {
        return cod_alumno;
    }

    public void setCod_alumno(int cod_alumno) {
        this.cod_alumno = cod_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
