package br.com.felipetravassos.cursomc.resources;
//Resources é um nome padrão que grava as controladoras REST.

import java.util.ArrayList;
import java.util.List;

//Representational State Transfer, abreviado como REST, 
//não é uma tecnologia, uma biblioteca, e nem tampouco 
//uma arquitetura, mas sim um modelo a ser utilizado para 
//se projetar arquiteturas de software distribuído, baseadas 
//em comunicação via rede.

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.felipetravassos.cursomc.domain.Categoria;

@RestController // Diretiva Controlador REST que vai responder pelo End Point abaixo.
@RequestMapping(value = "/categorias") // End point REST
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {

		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritorio");

		List<Categoria> lista = new ArrayList<>();// List é uma interface e
													// não pode ser importado
													// ArrayList implementa uma lista.
		lista.add(cat1);
		lista.add(cat2);

		return lista;
	}

}
