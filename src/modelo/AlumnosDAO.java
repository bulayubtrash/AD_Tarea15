package modelo;

import java.util.ArrayList;

import objetos.Alumno;
import objetos.Grupo;

public interface AlumnosDAO {
	void insertarAlumno(Alumno alumno);

	void insertarGrupo(Grupo grupo);

	ArrayList<Alumno> obtenerAlumnos();

	void modificarNombreAlumno(int id, String nuevoNombre);

	void eliminarAlumno(int id);

	ArrayList<String> obtenerCursos();

	void eliminarAlumnosPorCurso(String curso);

	ArrayList<Grupo> obtenerGrupos();
}
