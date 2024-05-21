package alumnos.service;

import java.util.List;

import alumnos.vo.Alumnos;

public interface AlumnoService {

	public List<Alumnos> getAlumnos();
	
	public void addAlumno(Alumnos alumno);
	
}
