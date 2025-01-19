package controlador;

import java.util.Scanner;

public class Menu {
    private Controlador controladorBD; 
    private Controlador controladorFicheros; 
    private Controlador controladorFicherosXML; 
    Scanner scanner;

    public Menu(Controlador controladorBD, Controlador controladorFicheros, Controlador controladorFicherosXML) {
		super();
		this.controladorBD = controladorBD;
		this.controladorFicheros = controladorFicheros;
		this.controladorFicherosXML = controladorFicherosXML;
	}

    
    public void mostrarMenu() {
        while (true) {
        	System.out.println(
        		    "Menu\n" +
        		    "1. Insertar alumno\n" +
        		    "2. Insertar grupo\n" +
        		    "3. Mostrar todos los alumnos\n" +
        		    "4. Modificar nombre de alumno\n" +
        		    "5. Eliminar alumno\n" +
        		    "6. Eliminar alumnos por curso\n" +
        		    "7. Guardar alumnos en fichero\n" +
        		    "8. Leer alumnos de fichero\n" +
        		    "9. Guardar grupos en fichero XML/JSON\n" +
        		    "10. Leer grupos de fichero XML/JSON\n" +
        		    "0. Salir\n" +
        		    "Elige una opción: "
        		);


            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    controladorBD.insertarAlumno();
                    break;
                case 2:
                    controladorBD.insertarGrupo();
                    break;
                case 3:
                    controladorBD.mostrarAlumnos();
                    break;
                case 4:
                    controladorBD.modificarNombreAlumno();
                    break;
                case 5:
                    controladorBD.eliminarAlumno();
                    break;
                case 6:
                    controladorBD.eliminarAlumnosPorCurso();
                    break;
                case 7:
                    controladorFicheros.insertarAlumno();
                    break;
                case 8:
                    controladorFicheros.mostrarAlumnos();
                    break;
                case 9:
                    controladorFicherosXML.insertarAlumno();
                    break;
                case 10:
                    controladorFicherosXML.mostrarAlumnos();
                    break;
                case 0:
                    
                    return;  
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
}
