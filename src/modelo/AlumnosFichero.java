package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import objetos.Alumno;
import objetos.Grupo;

public class AlumnosFichero implements AlumnosDAO{

	@Override
	public void insertarAlumno(Alumno a1) {
		// TODO Auto-generated method stub
		//Esto no se deberia hacer asi:
		Scanner sc = new Scanner(System.in);
		ArrayList<Alumno>aLista= new ArrayList<>();
		aLista.add(a1);
		System.out.println(" Introducir ruta del archivo");
		String ruta = sc.nextLine();

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
			for (Alumno alumno : aLista) {
				oos.writeObject(alumno);
				System.out.println("insertando "+alumno);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sc.close();
		}
		
	}

	@Override
	public void insertarGrupo(Grupo grupo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Alumno> obtenerAlumnos() {
		// TODO Auto-generated method stub
		//Esto no se deberia hacer asi:
		Scanner sc = new Scanner(System.in);
		ArrayList<Alumno>aLista= new ArrayList<>();
		Alumno a1;
		System.out.println("Introducir ruta del archivo");
		String ruta = sc.nextLine();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {

			while(true) {
				try {
					a1= new Alumno();
					a1=(Alumno) ois.readObject();
					aLista.add(a1);
				} catch (Exception e) {
					break;
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
		}finally {
			sc.close();
		}
		return aLista;
	}


	@Override
	public void modificarNombreAlumno(int id, String nuevoNombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarAlumno(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<String> obtenerCursos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarAlumnosPorCurso(String curso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Grupo> obtenerGrupos() {
		// TODO Auto-generated method stub
		return null;
	}

}
