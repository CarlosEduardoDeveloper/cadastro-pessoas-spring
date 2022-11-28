package com.br.api.pessoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.api.pessoas.model.Pessoa;
import com.br.api.pessoas.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;

	public ResponseEntity<?> listar(){
		return new ResponseEntity<>(pessoaRepository.findAll(), HttpStatus.OK);
	}

	public Pessoa findByPessoaId(Long id) {
		return pessoaRepository.findByPessoaId(id).get();
	}

	public Pessoa cadastrar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public ResponseEntity<Pessoa> deletar(Long id) {
		pessoaRepository.deleteById(id);
		return new ResponseEntity<Pessoa>(HttpStatus.OK);
	}

	public Pessoa alterar(Long id, Pessoa pessoa) {
		Pessoa pessoaAtualizada = findByPessoaId(id);
		pessoaAtualizada.setCpf(pessoa.getCpf());
		pessoaAtualizada.setEmail(pessoa.getEmail());
		pessoaAtualizada.setTelefone(pessoa.getTelefone());
		return pessoaRepository.save(pessoaAtualizada);
	}

}
