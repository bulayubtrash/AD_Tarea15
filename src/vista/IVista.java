package vista;

import java.util.ArrayList;

import objetos.Alumno;
import objetos.Grupo;

public interface IVista {
    void mostrarAlumnos(ArrayList<Alumno> alumnos);

    void mostrarCursos(ArrayList<String> cursos);

    String pedirCurso();

    Alumno pedirDatosAlumno();

    Grupo pedirDatosGrupo();


}

