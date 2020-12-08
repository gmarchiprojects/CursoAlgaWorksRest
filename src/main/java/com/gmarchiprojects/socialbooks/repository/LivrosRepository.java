package com.gmarchiprojects.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmarchiprojects.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{

}
