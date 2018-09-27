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

import br.com.felipetravassos.cursomc.domain.Pedido;
import br.com.felipetravassos.cursomc.services.PedidoService;

@RestController // Diretiva Controlador REST que vai responder pelo End Point abaixo.
@RequestMapping(value = "/pedidos") // End point REST
public class PedidoResource {

	@Autowired
	private PedidoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		// ResponseEntity Tipo especial no spring que armazena as
		// respostas de um serviço REST no HTTP

		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
