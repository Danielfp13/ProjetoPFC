package com.projeto.helpapet.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.helpapet.domain.Adotante;
import com.projeto.helpapet.dto.AdotanteNewDTO;
import com.projeto.helpapet.repositories.AdotanteRepository;
import com.projeto.helpapet.resources.execepton.FieldMessage;

public class AdotanteInsertValidator implements ConstraintValidator<AdotanteInsert, AdotanteNewDTO> {
	
	@Autowired
	private AdotanteRepository repo;
	
	@Override
	public void initialize(AdotanteInsert ann) {
	}

	@Override
	public boolean isValid(AdotanteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Adotante aux = repo.findByEmail(objDto.getEmail());
		if(aux != null) {
			list.add(new FieldMessage("Email","Email ja existente:"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFielName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
