package Controlador;

import java.sql.*;

public class ConexionToDB {
    Connection cn;


    public ConexionToDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/escuela", "noel", "1234");
            System.out.println("Conexión exitosa!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Ocurrió este error: " + e.getMessage());
        }
    }

    public void cerrarConexion() {
        try {
            if(cn != null) {
                cn.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public ResultSet EjecutarConsultas(String consulta) {
        ResultSet rs;
        try {
            Statement EditorDeQuery = cn.createStatement();
            rs = EditorDeQuery.executeQuery(consulta);
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return null;
    }
    public int ejecutarEliminacionActualizacionInsercion(String consulta) {
        try {
            Statement editorDeQuery = cn.createStatement();
            int filasAfectadas = editorDeQuery.executeUpdate(consulta);
            return filasAfectadas;
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la eliminación: " + e.getMessage());
            return -1; // Otra manera de manejar el error
        }
    }



}
