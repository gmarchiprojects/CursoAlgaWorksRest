package com.gmarchiprojects.socialbooks.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gmarchiprojects.socialbooks.domain.Comentario;
import com.gmarchiprojects.socialbooks.domain.Livro;
import com.gmarchiprojects.socialbooks.repository.ComentariosRepository;
import com.gmarchiprojects.socialbooks.repository.LivrosRepository;
import com.gmarchiprojects.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository;
	
	@Autowired
	private ComentariosRepository comentariosRepository;
	
	public List<Livro> listar(){
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		
			Optional<Livro> livro = livrosRepository.findById(id);
			
			if(livro.isEmpty()) {
				throw new LivroNaoEncontradoException("O livro não pode ser encontrado");
			}
			return livro.get();
		}

	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);
	}
	
	public void deletar(Long id) {
		try {
			livrosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O Livro não pode ser encontrado", e);
		}	
	}
		
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livrosRepository.save(livro);
	}
	
	public void verificarExistencia(Livro livro) {
		buscar(livro.getId());
	}
	
	public Comentario salvarComentario(Long livroId, Comentario comentario) {
		Livro livro = buscar(livroId);
		
		comentario.setLivro(livro);
		comentario.setData(new Date());
		
		return comentariosRepository.save(comentario);
	}
	
	public List<Comentario> listarComentario(Long livroId){
		Livro livro = buscar(livroId);
		
		return livro.getComentarios();
	}
}
	
