package br.com.felipetravassos.cursomc.resources;
//Resources é um nome padrão que grava as controladoras REST.

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.felipetravassos.cursomc.domain.Categoria;
import br.com.felipetravassos.cursomc.dto.CategoriaDTO;
import br.com.felipetravassos.cursomc.services.CategoriaService;

//Representational State Transfer, abreviado como REST, 
//não é uma tecnologia, uma biblioteca, e nem tampouco 
//uma arquitetura, mas sim um modelo a ser utilizado para 
//se projetar arquiteturas de software distribuído, baseadas 
//em comunicação via rede.

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

	}

	// Resposta com corpo vazio ResponseEntity<Void>
	// Insert vai recaber um objeto do tipo Categoria.
	// Metodo de inserção de dados

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDto) {
		Categoria obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		// ResponseEntity Tipo especial no spring que armazena as
		// respostas de um serviço REST no HTTP
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = service.findAll();
		// Pecorrer a lista pelo Stream() COllectors serve para converter uma lista para
		// outra.
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}

	// EndPoint de paginação de busca ao BD
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(listDto);

	}
}
