package controlador;

import java.util.ArrayList;

import modelo.AlumnosDAO;
import objetos.Alumno;
import objetos.Grupo;
import vista.IVista;

public class Controlador {
    private AlumnosDAO modelo; 
    private IVista vista;     

    public Controlador(AlumnosDAO modelo, IVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

   
    public void insertarAlumno() {
        Alumno alumno = vista.pedirDatosAlumno();
        
        modelo.insertarAlumno(alumno);

    }

    public void insertarGrupo() {
        Grupo grupo = vista.pedirDatosGrupo();
        
        modelo.insertarGrupo(grupo);

    }

    public void mostrarAlumnos() {
    	ArrayList<Alumno> alumnos = modelo.obtenerAlumnos();
        
        vista.mostrarAlumnos(alumnos);
    }

    public void modificarNombreAlumno() {
        int id=vista.pedirInt();
        String nuevoNombre=vista.pedirString();
        

        modelo.modificarNombreAlumno(id, nuevoNombre);
        
    }

    public void eliminarAlumno() {
        int id=vista.pedirInt();        
        modelo.eliminarAlumno(id);

    }

    public void eliminarAlumnosPorCurso() {
        ArrayList<String> cursos = modelo.obtenerCursos();
        vista.mostrarCursos(cursos);
        
        String curso = vista.pedirCurso();
        modelo.eliminarAlumnosPorCurso(curso);

    }

}
