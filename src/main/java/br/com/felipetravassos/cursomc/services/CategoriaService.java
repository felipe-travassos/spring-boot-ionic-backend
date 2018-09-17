package br.com.felipetravassos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipetravassos.cursomc.domain.Categoria;
import br.com.felipetravassos.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	//Metodo buscar o id da categoria no metodo GET
	public Categoria find(Integer id) {
		Optional <Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
