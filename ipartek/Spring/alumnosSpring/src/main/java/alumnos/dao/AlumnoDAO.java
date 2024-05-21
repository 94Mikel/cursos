package alumnos.dao;

import java.util.List;

import alumnos.vo.Alumnos;

public interface AlumnoDAO {
	
	public List<Alumnos> getAlumnos();

	public void addAlumno(Alumnos alumno);

}
