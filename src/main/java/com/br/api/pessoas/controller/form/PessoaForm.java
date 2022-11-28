package com.br.api.pessoas.controller.form;

import javax.validation.constraints.NotBlank;

import com.br.api.pessoas.model.Pessoa;

public class PessoaForm {
	
	private String email;
	
	@NotBlank
	private String cpf;
	
	private String telefone;

	public static PessoaForm toForm(Pessoa pessoa) {
		PessoaForm form = new PessoaForm();
		form.email = pessoa.getEmail();
		form.cpf = pessoa.getCpf();
		form.telefone = pessoa.getTelefone();
		return form;
	}
	
}
