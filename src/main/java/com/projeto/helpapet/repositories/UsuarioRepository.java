package com.projeto.helpapet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.helpapet.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

}
