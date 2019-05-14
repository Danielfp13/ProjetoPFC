package com.projeto.helpapet.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.helpapet.domain.Animal;
import com.projeto.helpapet.dto.AnimalDTO;
import com.projeto.helpapet.dto.AnimalNewDTO;
import com.projeto.helpapet.services.AnimalService;

@RestController
@RequestMapping(value = "instituicoes/animais")
public class AnimalResource {

	@Autowired
	private AnimalService service;

	// cadastro
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AnimalNewDTO objNewDto) {
		Animal obj = service.fromDTO(objNewDto);
		obj = service.insert(obj);
		// pega a URI do novo recurso que foi inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// busca por id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Animal> find(@PathVariable Integer id) {
		Animal obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	// alterar
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AnimalNewDTO objDto, @PathVariable Integer id) {
		Animal obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	// excluir
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

//lista todos os animais
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AnimalDTO>> buscarTodosAnimais() {
		List<Animal> lista = service.buscarTodosAnimais();
		List<AnimalDTO> listaDto = lista.stream().map(obj -> new AnimalDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}

	// paginação
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<AnimalDTO>> buscarPaginas(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Animal> lista = service.findPage(page, linesPerPage, orderBy, direction);
		Page<AnimalDTO> listaDto = lista.map(obj -> new AnimalDTO(obj));
		return ResponseEntity.ok().body(listaDto);

	}
}
