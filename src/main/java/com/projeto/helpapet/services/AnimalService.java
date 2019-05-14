package com.projeto.helpapet.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.projeto.helpapet.domain.Animal;
import com.projeto.helpapet.domain.Instituicao;
import com.projeto.helpapet.dto.AnimalDTO;
import com.projeto.helpapet.dto.AnimalNewDTO;
import com.projeto.helpapet.repositories.AnimalRepository;
import com.projeto.helpapet.repositories.InstituicaoRepository;
import com.projeto.helpapet.services.exception.DataIntegrityException;
import com.projeto.helpapet.services.exception.ObjectNotFoundException;

@Service
public class AnimalService {

	@Autowired
	public AnimalRepository repo;
	@Autowired
	public InstituicaoRepository repoInstituicao;

//inserir
	@Transactional
	public Animal insert(Animal obj) {
		obj = repo.save(obj);
		return obj;
	}

	// transformar objeto
	public Animal fromDTO(AnimalDTO objDto) {
		Animal animal = new Animal(objDto.getId(), null, null, objDto.getNome(), null, null, null, null, null, null,
				objDto.getEspecie(), null, null, null, null);

		return animal;
	}

	public Animal fromDTO(AnimalNewDTO objNewDto) {
		Instituicao instituicao = repoInstituicao.getOne(objNewDto.getIdInstituicaoFk().getIdUsuario());
		Animal animal = new Animal(null, instituicao, objNewDto.getIdMicrochip(), objNewDto.getNome(),
				objNewDto.getPorte(), objNewDto.getGenero(), objNewDto.getVacinado(), objNewDto.getAnoNascimento(),
				objNewDto.getRaca(), objNewDto.getVermifugado(), objNewDto.getEspecie(),
				objNewDto.getDataRecolhimento(), objNewDto.getEsterelizado(), objNewDto.getCor(),
				objNewDto.getDescricao());

		return animal;
	}

	// buscar por id
	public Animal find(Integer id) {
		Optional<Animal> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Animal.class.getName()));
	}

//altera
	public Animal update(Animal obj) {
		Animal newObj = find(obj.getId());
		updateDate(newObj, obj);
		newObj = repo.save(newObj);
		return newObj;
	}

	private void updateDate(Animal newObj, Animal obj) {
		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
		newObj.setEsterelizado(obj.getEsterelizado());
		newObj.setPorte(obj.getPorte());
		newObj.setVermifugado(obj.getVermifugado());
		newObj.setVacinado(obj.getVacinado());
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

//busca todos animal
	public List<Animal> buscarTodosAnimais() {
		return repo.findAll();
	}

//paginação
	public Page<Animal> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
