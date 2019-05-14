package com.projeto.helpapet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.helpapet.domain.Instituicao;

public interface InstituicaoRepository extends JpaRepository<Instituicao,Integer>{
	@Transactional(readOnly=true)
	Instituicao findByEmail(String email);
}
