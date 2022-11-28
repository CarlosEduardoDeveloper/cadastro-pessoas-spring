package com.br.api.pessoas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.api.pessoas.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository <Pessoa, Long> {

	@Query(value = "SELECT * FROM pessoas p WHERE p.id = :id", nativeQuery = true)
	Optional<Pessoa> findByPessoaId(@Param("id") Long id);

}
