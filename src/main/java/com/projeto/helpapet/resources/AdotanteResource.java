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

import com.projeto.helpapet.domain.Adotante;
import com.projeto.helpapet.dto.AdotanteDTO;
import com.projeto.helpapet.dto.AdotanteNewDTO;
import com.projeto.helpapet.services.AdotanteService;

@RestController
@RequestMapping(value = "/adotantes")
public class AdotanteResource {

	@Autowired
	private AdotanteService service;

	// cadastro
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AdotanteNewDTO objDto) {
		Adotante obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		// pega a URI do novo recurso que foi inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUsuario())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	// busca por id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Adotante> find(@PathVariable Integer id) {
		Adotante obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	// alterar
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AdotanteNewDTO objDto, @PathVariable Integer id) {
		Adotante obj = service.fromDTO(objDto);
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
	public ResponseEntity<List<AdotanteDTO>> buscarTodasUsuarios() {
		List<Adotante> lista = service.buscarTodosUsuarios();
		List<AdotanteDTO> listaDto = lista.stream().map(obj -> new AdotanteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}

	// paginação
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<AdotanteDTO>> buscarPaginas(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Adotante> lista = service.findPage(page, linesPerPage, orderBy, direction);
		Page<AdotanteDTO> listaDto = lista.map(obj -> new AdotanteDTO(obj));
		return ResponseEntity.ok().body(listaDto);

	} 
}
