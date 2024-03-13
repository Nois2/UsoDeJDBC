package Vista;
import Controlador.Consultas;
import Modelo.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class VisualizacionPrueba {
    public VisualizacionPrueba() {
    }

    Consultas consultas = new Consultas();
    public void VerDatosDePersonaPorID(){
        // Solicitar al usuario que ingrese el ID del alumno
        String input = JOptionPane.showInputDialog(null, "Ingrese el ID del alumno para ver su información:");

        // Obtener los datos del alumno con el ID proporcionado
        alumno al = consultas.get1AlumnoID(input);

        // Verificar si se encontraron datos para el alumno
        if (al == null) {
            JOptionPane.showMessageDialog(null, "No se encontraron datos para el ID proporcionado.");
        } else {
            // Mostrar la información del alumno
            JOptionPane.showMessageDialog(null, "Información del alumno:\n" +
                    "Cod_Alumno: " + al.getCod_alumno() + "\n" +
                    "Nombre: " + al.getNombre() + "\n" +
                    "Apellido: " + al.getApellido() + "\n" +
                    "Edad: " + al.getEdad() + "\n" +
                    "Dirección: " + al.getDireccion());
        }
    }
    public void VerEliminacionDePersonaPorID(){
        int resultadoDeEliminacion = consultas.eliminarAlumno(Integer.parseInt(JOptionPane.showInputDialog(null,"Por favor ingrese" +
                "El cod_alumno del alumno que quiere borrar")));
        if (resultadoDeEliminacion == 1){
            JOptionPane.showMessageDialog(null, "Acaba de eliminar la informacion del alumno exitosamente");
        }else{
            JOptionPane.showMessageDialog(null,"Ocurrio un error en la eliminacion");
        }
    }
    public void VisualizacionTodosLosAlumnos() {
        alumno[] al = consultas.obtenerTodosLosAlumnos();
        int contador = 0;
        while (contador <  al.length){
            JOptionPane.showMessageDialog(null, "Información del alumno:\n" +
                    "Cod_Alumno: " + al[contador].getCod_alumno() + "\n" +
                    "Nombre: " + al[contador].getNombre() + "\n" +
                    "Apellido: " + al[contador].getApellido() + "\n" +
                    "Edad: " + al[contador].getEdad() + "\n" +
                    "Dirección: " + al[contador].getDireccion());
            contador++;
        }


        }
    // Función para mostrar un cuadro de diálogo con varios campos de entrada y obtener los valores ingresados
    public void InsertarAlumnoVista() {
        // Creamos un JPanel para contener los campos de entrada
        JPanel panel = new JPanel();

        // Creamos los campos de texto para los valores que queremos ingresar
        JTextField textField1 = new JTextField(10);
        JTextField textField2 = new JTextField(10);
        JTextField textField3 = new JTextField(10);
        JTextField textField4 = new JTextField(10);

        // Configuramos el layout del panel con un GridLayout de 5 filas y 2 columnas
        panel.setLayout(new GridLayout(4, 2));

        // Agregamos etiquetas y campos de texto al panel
        panel.add(new JLabel("Ingrese el nombre:"));
        panel.add(textField1);
        panel.add(new JLabel("Ingrese el apellido:"));
        panel.add(textField2);
        panel.add(new JLabel("Ingrese la edad:"));
        panel.add(textField3);
        panel.add(new JLabel("Ingrese la  direccion"));
        panel.add(textField4);


        // Mostramos el panel en un JOptionPane con botones de aceptar (OK) y cancelar (CANCEL)
        int result = JOptionPane.showConfirmDialog(null, panel, "Ingrese valores", JOptionPane.OK_CANCEL_OPTION);

        // Verificamos si el usuario hizo clic en el botón de aceptar
        if (result == JOptionPane.OK_OPTION) {
            // Obtenemos los valores ingresados desde los campos de texto
            alumno datosActualizados = new alumno();
            String valor1 = textField1.getText();
            String valor2 = textField2.getText();
            int valor3 = Integer.parseInt(textField3.getText());
            String valor4 = textField4.getText();
            datosActualizados.setNombre(valor1);
            datosActualizados.setApellido(valor2);
            datosActualizados.setEdad(valor3);
            datosActualizados.setDireccion(valor4);
            if (consultas.InsertarAlumno(datosActualizados) == 1){
                JOptionPane.showMessageDialog(null,"Se Insertaron los datos correctamente");
            }
            else{
                JOptionPane.showMessageDialog(null,"Ocurrio un error en la Insercion de datos");
            }
            // Imprimimos los valores ingresados (aquí puedes hacer lo que necesites con ellos)
            System.out.println("Valor 1: " + valor1);
            System.out.println("Valor 2: " + valor2);
            System.out.println("Valor 3: " + valor3);
            System.out.println("Valor 4: " + valor4);
        }
    }
    public void ActualizarAlumnoVista() {
        // Creamos un JPanel para contener los campos de entrada
        JPanel panel = new JPanel();

        // Creamos los campos de texto para los valores que queremos ingresar
        JTextField textField1 = new JTextField(10);
        JTextField textField2 = new JTextField(10);
        JTextField textField3 = new JTextField(10);
        JTextField textField4 = new JTextField(10);
        JTextField textField5 = new JTextField(10);


        // Configuramos el layout del panel con un GridLayout de 5 filas y 2 columnas
        panel.setLayout(new GridLayout(5, 2));

        // Agregamos etiquetas y campos de texto al panel
        panel.add(new JLabel("Ingrese el cod_alumno:"));
        panel.add(textField1);
        panel.add(new JLabel("Ingrese el nombre:"));
        panel.add(textField2);
        panel.add(new JLabel("Ingrese el apellido:"));
        panel.add(textField3);
        panel.add(new JLabel("Ingrese la  edad"));
        panel.add(textField4);
        panel.add(new JLabel("Ingrese la  direccion"));
        panel.add(textField5);


        // Mostramos el panel en un JOptionPane con botones de aceptar (OK) y cancelar (CANCEL)
        int result = JOptionPane.showConfirmDialog(null, panel, "Ingrese valores", JOptionPane.OK_CANCEL_OPTION);

        // Verificamos si el usuario hizo clic en el botón de aceptar
        if (result == JOptionPane.OK_OPTION) {
            // Obtenemos los valores ingresados desde los campos de texto
            alumno datosActualizados = new alumno();
            datosActualizados.setCod_alumno(Integer.parseInt(textField1.getText()));
            datosActualizados.setNombre(textField2.getText());
            datosActualizados.setApellido(textField3.getText());
            datosActualizados.setEdad(Integer.parseInt(textField4.getText()));
            datosActualizados.setDireccion(textField5.getText());
            if (consultas.ActualizarDatosAlumno(datosActualizados) == 1){
                JOptionPane.showMessageDialog(null,"Se Insertaron los datos correctamente");
            }
            else{
                JOptionPane.showMessageDialog(null,"Ocurrio un error en la Insercion de datos");
            }
            // Imprimimos los valores ingresados (aquí puedes hacer lo que necesites con ellos)

        }
    }


}

