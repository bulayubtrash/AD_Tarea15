package controlador;

import java.util.List;

import modelo.AlumnosDAO;
import vista.IVista;

public class Controlador {
    private AlumnosDAO modelo;  // Dependencia del modelo
    private IVista vista;      // Dependencia de la vista

    public Controlador(AlumnosDAO modelo, IVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // Método para insertar un alumno
    public void insertarAlumno() {
        // Pedir los datos del alumno a través de la vista
        Alumno alumno = vista.pedirDatosAlumno();
        
        // Insertar el alumno en el modelo (base de datos, fichero, XML, etc.)
        modelo.insertarAlumno(alumno);
        
        // Mostrar un mensaje de éxito
        vista.mostrarMensaje("Alumno insertado correctamente.");
    }

    // Método para insertar un grupo
    public void insertarGrupo() {
        // Pedir los datos del grupo a través de la vista
        Grupo grupo = vista.pedirDatosGrupo();
        
        // Insertar el grupo en el modelo
        modelo.insertarGrupo(grupo);
        
        // Mostrar un mensaje de éxito
        vista.mostrarMensaje("Grupo insertado correctamente.");
    }

    // Método para mostrar todos los alumnos
    public void mostrarAlumnos() {
        // Obtener la lista de alumnos desde el modelo
        List<Alumno> alumnos = modelo.obtenerAlumnos();
        
        // Mostrar los alumnos en la vista
        vista.mostrarAlumnos(alumnos);
    }

    // Método para modificar el nombre de un alumno por su ID
    public void modificarNombreAlumno() {
        // Pedir el ID del alumno y el nuevo nombre a través de la vista
        int id = vista.pedirIdAlumno();
        String nuevoNombre = vista.pedirNuevoNombreAlumno();
        
        // Modificar el nombre del alumno en el modelo
        modelo.modificarNombreAlumno(id, nuevoNombre);
        
        // Mostrar un mensaje de éxito
        vista.mostrarMensaje("Nombre del alumno modificado correctamente.");
    }

    // Método para eliminar un alumno por su ID
    public void eliminarAlumno() {
        // Pedir el ID del alumno a eliminar
        int id = vista.pedirIdAlumno();
        
        // Eliminar el alumno en el modelo
        modelo.eliminarAlumno(id);
        
        // Mostrar un mensaje de éxito
        vista.mostrarMensaje("Alumno eliminado correctamente.");
    }

    // Método para eliminar alumnos por curso
    public void eliminarAlumnosPorCurso() {
        // Mostrar los cursos disponibles
        List<String> cursos = modelo.obtenerCursos();
        vista.mostrarCursos(cursos);
        
        // Pedir al usuario el curso del cual eliminar alumnos
        String curso = vista.pedirCurso();
        
        // Eliminar alumnos del curso indicado
        modelo.eliminarAlumnosPorCurso(curso);
        
        // Mostrar un mensaje de éxito
        vista.mostrarMensaje("Alumnos del curso " + curso + " eliminados correctamente.");
    }

    // Método para guardar todos los alumnos en un fichero
    public void guardarAlumnosEnFichero() {
        // Guardar los alumnos en el modelo (por ejemplo, en un fichero CSV)
        modelo.guardarAlumnosEnFichero();
        
        // Mostrar un mensaje de éxito
        vista.mostrarMensaje("Alumnos guardados en el fichero correctamente.");
    }

    // Método para leer alumnos desde un fichero y guardarlos en la base de datos
    public void leerAlumnosDeFichero() {
        // Leer los alumnos desde el fichero y guardarlos en la base de datos
        modelo.leerAlumnosDeFicheroYGuardarBD();
        
        // Mostrar un mensaje de éxito
        vista.mostrarMensaje("Alumnos leídos del fichero y guardados en la base de datos correctamente.");
    }

    // Método para guardar todos los grupos en un fichero XML o JSON
    public void guardarGruposEnFicheroXML() {
        // Guardar todos los grupos en un fichero XML o JSON
        modelo.guardarGruposEnFicheroXML();
        
        // Mostrar un mensaje de éxito
        vista.mostrarMensaje("Grupos guardados en el fichero correctamente.");
    }

    // Método para leer un fichero XML o JSON de grupos y guardarlos en la base de datos
    public void leerGruposDeFicheroYGuardarBD() {
        // Leer los grupos desde un fichero XML o JSON y guardarlos en la base de datos
        modelo.leerGruposDeFicheroYGuardarBD();
        
        // Mostrar un mensaje de éxito
        vista.mostrarMensaje("Grupos leídos del fichero y guardados en la base de datos correctamente.");
    }
}
