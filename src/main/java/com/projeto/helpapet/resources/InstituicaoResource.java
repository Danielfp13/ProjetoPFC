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

import com.projeto.helpapet.domain.Instituicao;
import com.projeto.helpapet.dto.InstituicaoDTO;
import com.projeto.helpapet.dto.InstituicaoNewDTO;
import com.projeto.helpapet.services.InstituicaoService;

@RestController
@RequestMapping(value = "/instituicoes")
public class InstituicaoResource {

	@Autowired
	private InstituicaoService service;

	// cadastro
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody InstituicaoNewDTO objDto) {
		Instituicao obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		// pega a URI do novo recurso que foi inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUsuario())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	// busca por id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Instituicao> find(@PathVariable Integer id) {
		Instituicao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	// alterar
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody InstituicaoNewDTO objDto, @PathVariable Integer id) {
		Instituicao obj = service.fromDTO(objDto);
		obj.setIdUsuario(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	// excluir
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

//lista todos os usuarios
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<InstituicaoDTO>> buscarTodasUsuarios() {
		List<Instituicao> lista = service.buscarTodosUsuarios();
		List<InstituicaoDTO> listaDto = lista.stream().map(obj -> new InstituicaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}

	// paginação
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<InstituicaoDTO>> buscarPaginas(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Instituicao> lista = service.findPage(page, linesPerPage, orderBy, direction);
		Page<InstituicaoDTO> listaDto = lista.map(obj -> new InstituicaoDTO(obj));
		return ResponseEntity.ok().body(listaDto);
	}
}
