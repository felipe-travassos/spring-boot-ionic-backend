package br.com.felipetravassos.cursomc.resources;
//Resources é um nome padrão que grava as controladoras REST.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.felipetravassos.cursomc.domain.Cliente;
import br.com.felipetravassos.cursomc.services.ClienteService;

//Representational State Transfer, abreviado como REST, 
//não é uma tecnologia, uma biblioteca, e nem tampouco 
//uma arquitetura, mas sim um modelo a ser utilizado para 
//se projetar arquiteturas de software distribuído, baseadas 
//em comunicação via rede.

@RestController // Diretiva Controlador REST que vai responder pelo End Point abaixo.
@RequestMapping(value = "/clientes") // End point REST
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		// ResponseEntity Tipo especial no spring que armazena as
		// respostas de um serviço REST no HTTP

		Cliente obj = service.find(id);
		return ResponseEntity.ok().body(obj);

//		Cliente cat1 = new Cliente(1, "Informática");
//		Cliente cat2 = new Cliente(2, "Escritorio");
//
//		List<Cliente> lista = new ArrayList<>();// List é uma interface e
//													// não pode ser importado
//													// ArrayList implementa uma lista.
//		lista.add(cat1);
//		lista.add(cat2);
//
//		return lista;
	}

}
