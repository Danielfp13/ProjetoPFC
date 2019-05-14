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

import com.projeto.helpapet.domain.Instituicao;
import com.projeto.helpapet.dto.InstituicaoDTO;
import com.projeto.helpapet.dto.InstituicaoNewDTO;
import com.projeto.helpapet.repositories.InstituicaoRepository;
import com.projeto.helpapet.services.exception.DataIntegrityException;
import com.projeto.helpapet.services.exception.ObjectNotFoundException;

@Service
public class InstituicaoService {

	@Autowired
	public InstituicaoRepository repo;

//inserir

	@Transactional
	public Instituicao insert(Instituicao obj) {
		obj = repo.save(obj);
		return obj;
	}

	// transformar objeto
	public Instituicao fromDTO(InstituicaoDTO objDto) {
		Instituicao instituicao = new Instituicao(objDto.getIdUsuario(), objDto.getNome(), objDto.getEmail(), null,
				null, null, null, null, null, null, null, null, null,null, null, null, null, null);

		return instituicao;
	}

	public Instituicao fromDTO(InstituicaoNewDTO objDto) {

		Instituicao instituicao = new Instituicao(objDto.getIdUsuario(), objDto.getNome(), objDto.getEmail(),
				new Date(), new Date(), "Ativo", objDto.getSenha(), objDto.getMunicipio(), objDto.getCep(),
				objDto.getUf(), objDto.getBairro(), objDto.getRua(), objDto.getNumero(), objDto.getFoto(),
				objDto.getCnpj(), "Pendente", objDto.getDescricaoInstituicao(),objDto.getTermo());

		instituicao.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			instituicao.getTelefones().add(objDto.getTelefone2());
		}

		return instituicao;
	}

	// buscar por id
	public Instituicao find(Integer id) {
		Optional<Instituicao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Instituicao.class.getName()));
	}

//altera
	public Instituicao update(Instituicao obj) {
		Instituicao newObj = find(obj.getIdUsuario());
		updateDate(newObj, obj);
		newObj = repo.save(newObj);
		return newObj;
	}

	private void updateDate(Instituicao newObj, Instituicao obj) {
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

//busca todos instituicao
	public List<Instituicao> buscarTodosUsuarios() {
		return repo.findAll();
	}

//paginação
	public Page<Instituicao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
