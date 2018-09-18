package br.com.felipetravassos.cursomc.resources;
//Resources é um nome padrão que grava as controladoras REST.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

//Representational State Transfer, abreviado como REST, 
//não é uma tecnologia, uma biblioteca, e nem tampouco 
//uma arquitetura, mas sim um modelo a ser utilizado para 
//se projetar arquiteturas de software distribuído, baseadas 
//em comunicação via rede.

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.felipetravassos.cursomc.domain.Categoria;
import br.com.felipetravassos.cursomc.services.CategoriaService;

@RestController // Diretiva Controlador REST que vai responder pelo End Point abaixo.
@RequestMapping(value = "/categorias") // End point REST
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		// ResponseEntity Tipo especial no spring que armazena as
		// respostas de um serviço REST no HTTP

		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);

//		Categoria cat1 = new Categoria(1, "Informática");
//		Categoria cat2 = new Categoria(2, "Escritorio");
//
//		List<Categoria> lista = new ArrayList<>();// List é uma interface e
//													// não pode ser importado
//													// ArrayList implementa uma lista.
//		lista.add(cat1);
//		lista.add(cat2);
//
//		return lista;
	}

}
