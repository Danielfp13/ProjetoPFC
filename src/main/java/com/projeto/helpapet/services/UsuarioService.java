package com.projeto.helpapet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.helpapet.domain.Usuario;
import com.projeto.helpapet.dto.UsuarioDTO;
import com.projeto.helpapet.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	public UsuarioRepository repo;

	public Usuario insert(Usuario obj) {
		obj.setIdUsuario(null);
		return repo.save(obj);
	}
	
	public Usuario fromDTO(UsuarioDTO objDto) {

		String tipo = "Adotante";
		 Usuario usuario  = new Usuario(objDto.getIdUsuario(), objDto.getNome(), objDto.getEmail(), objDto.getDataAtualizacao(),
				objDto.getDataCadastro(), objDto.getSituacao(), objDto.getSenha(), objDto.getMunicipio(),
				objDto.getCep(), objDto.getUf(), objDto.getBairro(), objDto.getRua(), objDto.getNumero(),
				objDto.getFoto(), objDto.getTipo(), objDto.getCpf(), objDto.getRg(), objDto.getDataNascimento(),
				objDto.getCnpj(), objDto.getSituacaoDeAprovacao(),objDto.getDescricaoInstituicao());
		if(objDto.getTipo().equals(tipo)) {
			usuario.setCnpj(null);
			usuario.setSituacaoDeAprovacao(null);
			usuario.setDescricaoInstituicao(null);
		}else {
			usuario.setCpf(null);
			usuario.setRg(null);
			usuario.setDataNascimento(null);
		}
		return usuario;
	}
}
