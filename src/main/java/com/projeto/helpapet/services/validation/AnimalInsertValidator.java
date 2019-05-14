package com.projeto.helpapet.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.helpapet.domain.Animal;
import com.projeto.helpapet.dto.AnimalNewDTO;
import com.projeto.helpapet.repositories.AnimalRepository;
import com.projeto.helpapet.resources.execepton.FieldMessage;

public class AnimalInsertValidator implements ConstraintValidator<AnimalInsert, AnimalNewDTO> {

	@Autowired
	private AnimalRepository repo;

	@Override
	public void initialize(AnimalInsert ann) {
	}

	@Override
	public boolean isValid(AnimalNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		Animal aux = repo.findByIdMicrochip(objDto.getIdMicrochip());
		if (aux != null) {
			list.add(new FieldMessage("IdMicrochip", "IdMicrochip ja existente:"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFielName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}