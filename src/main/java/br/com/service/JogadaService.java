package br.com.service;

import java.util.List;

import br.com.dto.JogadaDTO;

public interface JogadaService {

	JogadaDTO buscarPorId(Long id);
	List<JogadaDTO> buscarTodos();
	JogadaDTO gravar(JogadaDTO jogador);
	void atualizar(JogadaDTO jogador);
}
