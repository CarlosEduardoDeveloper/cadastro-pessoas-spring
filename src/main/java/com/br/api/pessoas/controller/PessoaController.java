package com.br.api.pessoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.pessoas.PessoaService;
import com.br.api.pessoas.model.Pessoa;

@RestController
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;

	@GetMapping("/pessoa")
	public ResponseEntity<?> listar(){
		return pessoaService.listar();
	}
	
	@GetMapping("/pessoa/{id}")
	public Pessoa listarPorId(@PathVariable Long id) {
		return pessoaService.findByPessoaId(id);
	}
	
	@PostMapping("/pessoa")
	public Pessoa cadastrar(@RequestBody Pessoa pessoa) {
		return pessoaService.cadastrar(pessoa);
	}
	
	@PutMapping("/pessoa/{id}")
	public ResponseEntity<Pessoa> alterar(@PathVariable Long id, @RequestBody Pessoa pessoa){
		Pessoa pessoaAtualizada = pessoaService.alterar(id, pessoa);
		return ResponseEntity.ok().body(pessoaAtualizada);
	}
	
	@DeleteMapping("/pessoa/{id}")
	public ResponseEntity<Pessoa> deletar(@PathVariable Long id){
		return pessoaService.deletar(id);
	}
	

	
	
	
	
}
