package com.ipartek.videoclub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.videoclub.domain.Cliente;
import com.ipartek.videoclub.service.ClienteService;
import com.mysql.fabric.xmlrpc.base.Member;

//@CrossOrigin(origins = {"http://localhost"})
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@GetMapping(produces="application/json")
	public List<Cliente> getClientes(){
		return (List<Cliente>) clienteService.getClientes();
	}
	
	@GetMapping(path="/{nombre}", produces="application/json")
	public Cliente getClineteByNombre(@PathVariable String nombre) {
		return clienteService.GetClienteByNombre(nombre);
	}
	
	@PostMapping("/login")
    public String holaPost() {
         System.out.println("post");
        return "has hecho una peticion post";
         
    }
	
}
