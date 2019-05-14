package com.projeto.helpapet.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.helpapet.domain.Instituicao;
import com.projeto.helpapet.dto.InstituicaoNewDTO;
import com.projeto.helpapet.repositories.InstituicaoRepository;
import com.projeto.helpapet.resources.execepton.FieldMessage;

public class InstituicaoInsertValidator implements ConstraintValidator<InstituicaoInsert, InstituicaoNewDTO> {
	
	@Autowired
	private InstituicaoRepository repo;
	
	@Override
	public void initialize(InstituicaoInsert ann) {
	}

	@Override
	public boolean isValid(InstituicaoNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Instituicao aux = repo.findByEmail(objDto.getEmail());
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
