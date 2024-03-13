package Modelo;


public class alumno_materia {

    private int id_alumno_materia = 0;
    private int fk_cod_alumno = 0;
    private int fk_cod_materia=0;

    public alumno_materia(int id_alumno_materia, int fk_cod_alumno, int fk_cod_materia) {
        this.id_alumno_materia = id_alumno_materia;
        this.fk_cod_alumno = fk_cod_alumno;
        this.fk_cod_materia = fk_cod_materia;
    }

    public int getId_alumno_materia() {
        return id_alumno_materia;
    }

    public void setId_alumno_materia(int id_alumno_materia) {
        this.id_alumno_materia = id_alumno_materia;
    }

    public int getFk_cod_alumno() {
        return fk_cod_alumno;
    }

    public void setFk_cod_alumno(int fk_cod_alumno) {
        this.fk_cod_alumno = fk_cod_alumno;
    }

    public int getFk_cod_materia() {
        return fk_cod_materia;
    }

    public void setFk_cod_materia(int fk_cod_materia) {
        this.fk_cod_materia = fk_cod_materia;
    }
}
