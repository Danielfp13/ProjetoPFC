package com.projeto.helpapet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.helpapet.domain.Telefone;
import com.projeto.helpapet.domain.Usuario;
import com.projeto.helpapet.dto.UsuarioDTO;
import com.projeto.helpapet.dto.UsuarioNewDTO;
import com.projeto.helpapet.repositories.TelefoneRepository;
import com.projeto.helpapet.repositories.UsuarioRepository;
import com.projeto.hepapet.services.exception.DataIntegrityException;
import com.projeto.hepapet.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	public UsuarioRepository repo;

	@Autowired
	public TelefoneRepository telefoneRepository;
//inserir

	@Transactional
	public Usuario insert(Usuario obj) {
		obj = repo.save(obj);
		telefoneRepository.saveAll(obj.getListTelefones());
		return obj;
	}

	// transformar objeto
	public Usuario fromDTO(UsuarioDTO objDto) {
		Usuario usuario = new Usuario(objDto.getIdUsuario(), objDto.getNome(), objDto.getEmail(), null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

		return usuario;
	}

	public Usuario fromDTO(UsuarioNewDTO objDto) {
		String tipo = "Adotante";
		Usuario usuario = new Usuario(objDto.getIdUsuario(), objDto.getNome(), objDto.getEmail(),
				objDto.getDataAtualizacao(), objDto.getDataCadastro(), objDto.getSituacao(), objDto.getSenha(),
				objDto.getMunicipio(), objDto.getCep(), objDto.getUf(), objDto.getBairro(), objDto.getRua(),
				objDto.getNumero(), objDto.getFoto(), objDto.getTipo(), objDto.getCpf(), objDto.getRg(),
				objDto.getDataNascimento(), objDto.getCnpj(), objDto.getSituacaoDeAprovacao(),
				objDto.getDescricaoInstituicao());
		if (objDto.getTipo().equals(tipo)) {
			usuario.setCnpj(null);
			usuario.setSituacaoDeAprovacao(null);
			usuario.setDescricaoInstituicao(null);
		} else {
			usuario.setCpf(null);
			usuario.setRg(null);
			usuario.setDataNascimento(null);
		}

		Telefone telefone1 = new Telefone(null, objDto.getTelefone1(), usuario);
		usuario.getListTelefones().add(telefone1);
		if (objDto.getTelefone2() != null) {
			Telefone telefone2 = new Telefone(null, objDto.getTelefone2(), usuario);
			usuario.getListTelefones().add(telefone2);
		}
		if (objDto.getTelefone3() != null) {
			Telefone telefone3 = new Telefone(null, objDto.getTelefone3(), usuario);
			usuario.getListTelefones().add(telefone3);
		}
		return usuario;
	}

	// buscar por id
	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

//altera
	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getIdUsuario());
		updateDate(newObj, obj);
		return repo.save(newObj);
	}

	private void updateDate(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
	}

//excluir
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
		}
	}

//busca todos usuario
	public List<Usuario> buscarTodosUsuarios() {
		return repo.findAll();
	}

//paginação
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
