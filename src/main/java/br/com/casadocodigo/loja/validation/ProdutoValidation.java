package br.com.casadocodigo.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.models.Produto;

public class ProdutoValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "titulo", "fild.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "fild.required");
		
		Produto produto = (Produto) target;
		
		if(produto.getPaginas()<= 0){
			ValidationUtils.rejectIfEmpty(errors, "paginas", "fild.required");
		}
		
	}

}
