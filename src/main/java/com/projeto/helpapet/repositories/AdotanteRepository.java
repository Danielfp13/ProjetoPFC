package com.projeto.helpapet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.helpapet.domain.Adotante;

public interface AdotanteRepository extends JpaRepository<Adotante,Integer>{
	@Transactional(readOnly=true)
	Adotante findByEmail(String email);
@Query("select id,nome,email from adotante")
	List<Adotante> findIdNomeEmail();
	
	
}
