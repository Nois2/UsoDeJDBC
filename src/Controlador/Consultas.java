package Controlador;
import Modelo.*;

import java.sql.*;
import java.util.ArrayList;

public class Consultas {
    public alumno get1AlumnoID(String ID) {
        try {
            // Crear una nueva instancia de la clase ConexionToDB para establecer la conexión a la base de datos
            ConexionToDB conexion = new ConexionToDB();

            // Ejecutar la consulta SQL para obtener el alumno con el ID proporcionado
            ResultSet rs = conexion.EjecutarConsultas("SELECT * FROM alumno WHERE cod_alumno='" + ID + "'");

            // Verificar si hay al menos una fila en el resultado
            if (rs.next()) {
                // Si hay una fila, crear un nuevo objeto Alumno con los datos de la fila actual
                alumno al = new alumno(rs.getInt("cod_alumno"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getString("direccion"));

                // Cerrar la conexión a la base de datos
                conexion.cerrarConexion();

                // Devolver el objeto Alumno creado
                return al;
            } else {
                // Si no se encuentra ningún alumno con el ID proporcionado, devolver null
                conexion.cerrarConexion();
                return null;
            }
        } catch (SQLException e) {
            // Si ocurre alguna excepción SQLException, imprimir el mensaje de error y devolver null
            System.out.println("Error al obtener el alumno con ID " + ID + ": " + e.getMessage());
            return null;
        }
    }
    public ArrayList<materia> obtenerListaDeMaterias() {
        ArrayList<materia> listaMaterias = new ArrayList<>();
        try {
            // Crear una instancia de la clase ConexionToDB para establecer la conexión a la base de datos
            ConexionToDB conexion = new ConexionToDB();

            // Ejecutar la consulta para obtener la lista de materias
            ResultSet rsMaterias = conexion.EjecutarConsultas("SELECT * FROM materia");

            // Recorrer el conjunto de resultados y agregar cada materia a la lista
            while (rsMaterias.next()) {
                materia materia2 = new materia(
                        rsMaterias.getInt("id_materia"),
                        rsMaterias.getString("nombre"),
                        rsMaterias.getString("descripcion")
                );
                listaMaterias.add(materia2);
            }

            // Cerrar la conexión
            conexion.cerrarConexion();

        } catch (SQLException e) {
            // Si ocurre una excepción SQLException al establecer la conexión o ejecutar la consulta,
            // imprimir el mensaje de error
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return listaMaterias;
    }
    public alumno[] obtenerTodosLosAlumnos() {
        try {
            // Crear una nueva instancia de la clase ConexionToDB para establecer la conexión a la base de datos
            ConexionToDB conexion = new ConexionToDB();

            // Obtener el recuento de alumnos
            ResultSet rsLista = conexion.EjecutarConsultas("SELECT count(*) as total FROM alumno");
            rsLista.next(); // Mover el cursor al primer resultado
            int totalAlumnos = rsLista.getInt("total");
            conexion.cerrarConexion();

            // Crear un array para almacenar los objetos Alumno
            alumno[] alumnos = new alumno[totalAlumnos];

            // Crear una nueva conexión para obtener todos los alumnos
            ConexionToDB conexion2 = new ConexionToDB();
            ResultSet rsTodos = conexion2.EjecutarConsultas("SELECT * FROM alumno");

            int contador = 0; // Inicializar el contador en 0
            while (rsTodos.next()) {
                // Crear un objeto Alumno con los datos obtenidos de la base de datos
                alumno al = new alumno(rsTodos.getInt("cod_alumno"),
                        rsTodos.getString("nombre"),
                        rsTodos.getString("apellido"),
                        rsTodos.getInt("edad"),
                        rsTodos.getString("direccion"));
                // Almacenar el objeto Alumno en el array
                alumnos[contador] = al;
                contador++;
            }

            // Cerrar la conexión
            conexion2.cerrarConexion();

            // Devolver el array de alumnos
            return alumnos;

        } catch (SQLException e) {
            // Si ocurre una excepción SQLException al establecer la conexión o ejecutar la consulta,
            // imprimir el mensaje de error y devolver un array vacío
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
            e.printStackTrace();
            return new alumno[0]; // Devolver un array vacío en caso de error
        }
    }
    public int eliminarAlumno(int id){

            ConexionToDB iWatchTheMoon = new ConexionToDB();
            int resultado = iWatchTheMoon.ejecutarEliminacionActualizacionInsercion("DELETE FROM alumno where cod_alumno='"+ id + "'");

            System.out.println(resultado);
            return resultado;

    }
    public int InsertarAlumno(alumno al){
        ConexionToDB cn = new ConexionToDB();
        String consulta = "INSERT INTO alumno(nombre, apellido, edad, direccion) " +
                "VALUES('" + al.getNombre() + "','" + al.getApellido() + "'," +
                al.getEdad() + ",'" + al.getDireccion() + "')";

        return cn.ejecutarEliminacionActualizacionInsercion(consulta);
    }
    public int ActualizarDatosAlumno(alumno al){
        ConexionToDB cn = new ConexionToDB();
        String consulta = "UPDATE alumno " +
                "SET nombre = '" + al.getNombre() + "', " +
                "apellido = '" + al.getApellido() + "', " +
                "edad = " + al.getEdad() + ", " +
                "direccion = '" + al.getDireccion() + "' " +
                "WHERE cod_alumno = " + al.getCod_alumno();
        int resultant = cn.ejecutarEliminacionActualizacionInsercion(consulta);
        if (resultant == 1){
            return resultant;
        }
        else return -1;

    }



}





