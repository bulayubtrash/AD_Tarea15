package controlador;

import modelo.AlumnosBD;
import modelo.AlumnosDAO;
import vista.IVista;
import vista.VistaConsola;

public class Main {
    public static void main(String[] args) {
        AlumnosDAO modeloBD= new AlumnosBD();
        AlumnosDAO modeloFicheros = new AlumnosBD();
        AlumnosDAO modeloFicherosXML = new AlumnosBD();
        IVista vista = new VistaConsola();
        Controlador controladorBD = new Controlador(modeloBD, vista);
        Controlador controladorFicheros = new Controlador(modeloFicheros, vista);
        Controlador controladorFicherosXML = new Controlador(modeloFicherosXML, vista);


        Menu menu = new Menu(controladorBD,controladorFicheros,controladorFicherosXML);
        
        menu.mostrarMenu();
    }
}
