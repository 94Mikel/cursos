package alumnos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import alumnos.dao.AlumnoDAO;
import alumnos.vo.Alumnos;

@Repository
public class HibernateAlumnoDAO implements AlumnoDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional(readOnly=true)
	public List<Alumnos> getAlumnos() {
		
		Query q = sessionFactory.getCurrentSession().createQuery("from Alumnos");
		
		return q.getResultList();
	}

	@Transactional(readOnly=false)
	public void addAlumno(Alumnos alumno) {
		sessionFactory.getCurrentSession().save(alumno);
	}

}
