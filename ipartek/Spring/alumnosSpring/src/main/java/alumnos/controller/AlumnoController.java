package alumnos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import alumnos.service.AlumnoService;
import alumnos.vo.Alumnos;

@Controller
@RequestMapping("/alumnos")
//@SessionAttributes(names={"cds"})
public class AlumnoController {
	
	@Autowired
	AlumnoService alumnosService;
	
	@GetMapping
	public String home(ModelMap model) {
		List<Alumnos> alumnos = alumnosService.getAlumnos();
		
		model.addAttribute("alumnos", alumnos);
		model.addAttribute("alumno", new Alumnos());
		
		return "index";
	}
	
	@PostMapping
	public String addAlumno(ModelMap model, Alumnos alumno) {
		alumnosService.addAlumno(alumno);
		
		List<Alumnos> alumnos = alumnosService.getAlumnos();
		
		model.addAttribute("alumnos", alumnos);
		model.addAttribute("alumno", new Alumnos());
		
		return "index";
	}

}
