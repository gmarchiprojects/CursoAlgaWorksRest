package com.gmarchiprojects.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmarchiprojects.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

}
