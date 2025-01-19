package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import objetos.Alumno;
import objetos.Grupo;
import pool.DBCPDataSource;

public class AlumnosBD implements AlumnosDAO {

	@Override
	public void insertarAlumno(Alumno a1) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO alumnos (nia, nombre, apellido, genero, fechaNac, ciclo, curso, id_grupo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = DBCPDataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, a1.getNia());
			ps.setString(2, a1.getNombre());
			ps.setString(3, a1.getApellidos());
			ps.setString(4, String.valueOf(a1.getGenero()));

			java.sql.Date fechaSql = new java.sql.Date(a1.getFechaNac().getTime());
			ps.setDate(5, fechaSql);
			
			ps.setString(6, a1.getCiclo());
			ps.setString(7, a1.getCurso());
			ps.setString(8, a1.getGrupo());
			
			int filas = ps.executeUpdate();
			if (filas > 0 ) {
				System.out.println("Alumno insertado");
			} else {
				System.out.println("No se ha podido insertar");
			}
		} catch (Exception e) {

		}
	}

	@Override
	public void insertarGrupo(Grupo g1) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO grupos (id_grupo, nombre) VALUES (?, ?)";

		try (Connection conn = DBCPDataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, g1.getId());
			ps.setString(2, g1.getGrupo());

			int filas = ps.executeUpdate();
			if (filas > 0) {
				System.out.println("Grupo insertado");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public ArrayList<Alumno> obtenerAlumnos() {
		// TODO Auto-generated method stub
		Alumno a1;
		ArrayList <Alumno> aLista = new ArrayList<>();
		String sql = "SELECT nia, nombre, apellido, genero, ciclo, curso, grupo  FROM alumnos";

		try (Connection conn = DBCPDataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				a1 = new Alumno();

		        a1.setNia(rs.getInt("nia"));
		        a1.setNombre(rs.getString("nombre"));
		        a1.setApellidos(rs.getString("apellido"));
		        a1.setGenero(rs.getString("genero").charAt(0));
		        a1.setCiclo(rs.getString("ciclo"));
		        a1.setCurso(rs.getString("curso"));
		        a1.setGrupo(rs.getString("grupo")); 
		        
		        aLista.add(a1);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return aLista;
	}

	@Override
	public void modificarNombreAlumno(int nia, String nombre) {
		// TODO Auto-generated method stub
		String sql="UPDATE alumnos SET nombre = ? WHERE nia = ?";
		try(Connection conn=DBCPDataSource.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);) {

			ps.setString(1, nombre);
			ps.setInt(2, nia);

			int filas=ps.executeUpdate();
			if(filas>0) {
				System.out.println("Alumno modificado");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void eliminarAlumno(int nia) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM alumnos WHERE nia = ?";
		try (Connection conn=DBCPDataSource.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);){
			ps.setInt(1, nia);

			int filas=ps.executeUpdate();
			if(filas>0) {
				System.out.println("Alumno eliminado");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public ArrayList<String> obtenerCursos() {
		// TODO Auto-generated method stub
		ArrayList<String>cursos= new ArrayList<>();
		String sql1="SELECT curso FROM alumnos";
		try(Connection conn=DBCPDataSource.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql1);
				ResultSet rs=ps.executeQuery();) {

			while (rs.next()) {
				String curso=rs.getString("curso");
				cursos.add(curso);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cursos;
	}

	@Override
	public void eliminarAlumnosPorCurso(String curso) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM alumnos WHERE curso LIKE ?";
		try (Connection conn=DBCPDataSource.getConnection();
				PreparedStatement ps= conn.prepareStatement(sql);) {
			ps.setString(1, curso);

			int filas=ps.executeUpdate();
			if(filas>0) {
				System.out.println("Alumno eliminado");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public ArrayList<Grupo> obtenerGrupos() {
		// TODO Auto-generated method stub
		Grupo g1;
		ArrayList<Grupo>gLista=new ArrayList<>();

		String sql = "SELECT id_grupo, nombre FROM grupos";

		try (Connection conn = DBCPDataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				g1 = new Grupo();

				g1.setId(rs.getInt("id_grupo"));
				g1.setGrupo(rs.getString("nombre"));
				gLista.add(g1);
			}
			for (Grupo grupo : gLista) {
				System.out.println(grupo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return gLista;
	}

	
}
