package com.projeto.helpapet.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.projeto.helpapet.domain.Animal;
import com.projeto.helpapet.dto.AnimalNewDTO;
import com.projeto.helpapet.repositories.AnimalRepository;
import com.projeto.helpapet.resources.execepton.FieldMessage;

public class AnimalUpdateValidator implements ConstraintValidator<AnimalUpdate, AnimalNewDTO> {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private AnimalRepository repo;

	@Override
	public void initialize(AnimalUpdate ann) {
	}

	@Override
	public boolean isValid(AnimalNewDTO objDto, ConstraintValidatorContext context) {
//pega o id da uri
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		List<FieldMessage> list = new ArrayList<>();

		Animal aux = repo.findByIdMicrochip(objDto.getIdMicrochip());

		if (aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("idMicrochip", "Microchip ja existente:"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFielName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
