package br.com.service;

import java.util.List;

import br.com.dto.JogadorDTO;

public interface JogadorService {
	
	JogadorDTO buscarPorId(Long id);
	List<JogadorDTO> buscarTodos();
	JogadorDTO gravar(JogadorDTO jogador);
	void atualizar(JogadorDTO jogador);
}
