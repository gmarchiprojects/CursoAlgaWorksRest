package com.gmarchiprojects.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmarchiprojects.socialbooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long> {

}
