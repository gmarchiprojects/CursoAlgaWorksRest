package com.gmarchiprojects.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmarchiprojects.socialbooks.domain.Autor;
import com.gmarchiprojects.socialbooks.repository.AutoresRepository;
import com.gmarchiprojects.socialbooks.services.exceptions.AutorEncontradoException;
import com.gmarchiprojects.socialbooks.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresServices {

	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor> listar(){
		return autoresRepository.findAll();
	}
	
	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
			Optional<Autor> a = autoresRepository.findById(autor.getId());
			
			if(a != null) {
				throw new AutorEncontradoException("O autor já existe");
			}
		}
		
		return autoresRepository.save(autor);
	}
	
	public Autor buscar(Long id) {
		Optional<Autor> autor = autoresRepository.findById(id);
		
		if(autor.isEmpty()) {
			throw new AutorNaoEncontradoException("Autor Não Encontrado");
		}
		
		return autor.get();
	}
	
}
