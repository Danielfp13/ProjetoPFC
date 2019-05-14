package com.projeto.helpapet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.helpapet.domain.Animal;

public interface AnimalRepository extends JpaRepository<Animal,Integer>{
	@Transactional(readOnly=true)
	Animal findByIdMicrochip(String idMicrochip);
}
