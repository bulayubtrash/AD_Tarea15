package modelo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import objetos.Alumno;
import objetos.Grupo;

public class AlumnosFicheroXML implements AlumnosDAO {

	@Override
	public void insertarAlumno(Alumno a1) {
		// TODO Auto-generated method stub
		ArrayList<Alumno> aLista = new ArrayList<>();
		aLista.add(a1);
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document documento = builder.newDocument();

			Element rootElement = documento.createElement("alumnos");
			documento.appendChild(rootElement);

			for (Alumno alumno : aLista) {

				Element alumnoElement = documento.createElement("alumno");
				alumnoElement.setAttribute("nia", String.valueOf(alumno.getNia()));
				alumnoElement.setAttribute("nombre", alumno.getNombre());
				alumnoElement.setAttribute("apellidos", alumno.getApellidos());
				alumnoElement.setAttribute("genero", String.valueOf(alumno.getGenero()));
				SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
				String txt = formato.format(a1.getFechaNac());
				alumnoElement.setAttribute("fechaNacimiento", txt);
				alumnoElement.setAttribute("ciclo", alumno.getCiclo());
				alumnoElement.setAttribute("curso", alumno.getCurso());
				alumnoElement.setAttribute("grupo", alumno.getGrupo());

				rootElement.appendChild(alumnoElement);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			// Configuración para formato legible
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			DOMSource source = new DOMSource(documento);
			StreamResult result = new StreamResult(new File("/Users/datos/Desktop/ficheros/alumnos2.xml"));
			transformer.transform(source, result);
			System.out.println("XML generado");

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void insertarGrupo(Grupo grupo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Alumno> obtenerAlumnos() {
		// TODO Auto-generated method stub
		ArrayList<Alumno> aLista = new ArrayList<>();
		Alumno a1;

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document documento = builder.parse(new File("/Users/datos/Desktop/ficheros/alumnos2.xml"));

			NodeList listaAlumnos = documento.getElementsByTagName("alumno");

			for (int i = 0; i < listaAlumnos.getLength(); i++) {
				Node nodo = listaAlumnos.item(i);

				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element alumnoElement = (Element) nodo;

					// Crear un nuevo objeto Alumno
					a1 = new Alumno();

					// Usar setters para asignar los valores desde los atributos del elemento XML
					a1.setNia(Integer.parseInt(alumnoElement.getAttribute("nia")));
					a1.setNombre(alumnoElement.getAttribute("nombre"));
					a1.setApellidos(alumnoElement.getAttribute("apellidos"));
					a1.setGenero(alumnoElement.getAttribute("genero").charAt(0));

					String fechaNacimientoStr = alumnoElement.getAttribute("fechaNacimiento");
					if (!fechaNacimientoStr.isEmpty()) {
//	                    SimpleDateFormat formato = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", java.util.Locale.ENGLISH);
						SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");

						a1.setFechaNac(formato.parse(fechaNacimientoStr));
					} else {
						a1.setFechaNac(null);
					}

					a1.setCiclo(alumnoElement.getAttribute("ciclo"));
					a1.setCurso(alumnoElement.getAttribute("curso"));
					a1.setGrupo(alumnoElement.getAttribute("grupo"));

					aLista.add(a1);

					System.out.println(a1 + " Inserado");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
