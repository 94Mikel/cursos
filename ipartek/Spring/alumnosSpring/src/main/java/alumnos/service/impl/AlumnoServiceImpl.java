package alumnos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alumnos.dao.AlumnoDAO;
import alumnos.service.AlumnoService;
import alumnos.vo.Alumnos;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	AlumnoDAO alumnoDao;
	
	public List<Alumnos> getAlumnos() {
		return alumnoDao.getAlumnos();
	}


	public void addAlumno(Alumnos alumno) {
		alumnoDao.addAlumno(alumno);
		
	}

	

}
