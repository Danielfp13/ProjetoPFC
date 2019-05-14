package com.projeto.helpapet.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.projeto.helpapet.domain.Instituicao;
import com.projeto.helpapet.dto.InstituicaoDTO;
import com.projeto.helpapet.repositories.InstituicaoRepository;
import com.projeto.helpapet.resources.execepton.FieldMessage;

public class InstituicaoUpdateValidator implements ConstraintValidator<InstituicaoUpdate, InstituicaoDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private InstituicaoRepository repo;
	
	@Override
	public void initialize(InstituicaoUpdate ann) {
	}

	@Override
	public boolean isValid(InstituicaoDTO objDto, ConstraintValidatorContext context) {
//pega o id da uri
		@SuppressWarnings("unchecked")
		Map<String,String> map = (Map<String,String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId =Integer.parseInt(map.get("id"));
		List<FieldMessage> list = new ArrayList<>();
		
		Instituicao aux = repo.findByEmail(objDto.getEmail());
		
		if(aux != null && !aux.getIdUsuario().equals(uriId)) {
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
