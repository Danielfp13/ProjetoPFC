package com.projeto.helpapet.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.projeto.helpapet.domain.Adotante;
import com.projeto.helpapet.dto.AdotanteDTO;
import com.projeto.helpapet.dto.AdotanteNewDTO;
import com.projeto.helpapet.repositories.AdotanteRepository;
import com.projeto.helpapet.services.exception.DataIntegrityException;
import com.projeto.helpapet.services.exception.ObjectNotFoundException;

@Service
public class AdotanteService {

	@Autowired
	public AdotanteRepository repo;

//inserir

	@Transactional
	public Adotante insert(Adotante obj) {
		obj = repo.save(obj);
		return obj;
	}

	// transformar objeto
	public Adotante fromDTO(AdotanteDTO objDto) {
		Adotante adotante = new Adotante(objDto.getIdUsuario(), objDto.getNome(), objDto.getEmail(), null, null, null,
				null, null, null, null, null, null, null, null, null,null, null, null);

		return adotante;
	}

	public Adotante fromDTO(AdotanteNewDTO objDto) {

		Adotante adotante = new Adotante(objDto.getIdUsuario(), objDto.getNome(), objDto.getEmail(), new Date(),
				new Date(), "Ativo", objDto.getSenha(), objDto.getMunicipio(), objDto.getCep(), objDto.getUf(),
				objDto.getBairro(), objDto.getRua(), objDto.getNumero(), objDto.getFoto(), objDto.getCpf(),
				objDto.getRg(), objDto.getDataNascimento(), objDto.getTermo());

		adotante.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			adotante.getTelefones().add(objDto.getTelefone2());
		}
		return adotante;
	}

	// buscar por id
	public Adotante find(Integer id) {
		Optional<Adotante> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Adotante.class.getName()));
	}

//altera
	public Adotante update(Adotante obj) {
		Adotante newObj = find(obj.getIdUsuario());
		updateDate(newObj, obj);
		newObj = repo.save(newObj);
		return newObj;
	}

	private void updateDate(Adotante newObj, Adotante obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setBairro(obj.getBairro());
		newObj.setCep(obj.getCep());
		newObj.setDataAtualizacao(obj.getDataAtualizacao());
		newObj.setFoto(obj.getFoto());
		newObj.setMunicipio(obj.getMunicipio());
		newObj.setNumero(obj.getNumero());
		newObj.setRua(obj.getNumero());
		newObj.setUf(obj.getUf());
		newObj.setSituacao(obj.getSituacao());
		newObj.setSenha(obj.getSenha());
		newObj.setTelefones(obj.getTelefones());
	}

//excluir
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir");
		}
	}

//busca todos adotante
	public List<Adotante> buscarTodosUsuarios() {
		return repo.findAll();
	}

//paginação
	public Page<Adotante> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
