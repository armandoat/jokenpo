package br.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.dto.JogadorDTO;
import br.com.model.Jogador;
import br.com.service.JogadorService;

@Service
public class JogadorServiceImpl implements JogadorService {

	@Override
	public JogadorDTO buscarPorId(Long id) {
		JogadorDTO jogadorDTO = new JogadorDTO();
		jogadorDTO.setId(1L);
		return jogadorDTO;
	}

	@Override
	public List<JogadorDTO> buscarTodos() {
		List<JogadorDTO> jogadores = new ArrayList<JogadorDTO>();
		JogadorDTO jogadorDTO = new JogadorDTO();
		jogadorDTO.setId(1L);
		jogadores.add(jogadorDTO);
		return jogadores;
	}

	@Override
	public JogadorDTO gravar(JogadorDTO jogadorDTO) {
    	Jogador jogador = new Jogador();
    	BeanUtils.copyProperties(jogadorDTO, jogador);
    	
		// TODO: Implementar persistencia...
    
    	BeanUtils.copyProperties(jogador, jogadorDTO);
    	return jogadorDTO;
	}

	@Override
	public void atualizar(JogadorDTO jogadorDTO) {
    	Jogador jogador = new Jogador();
    	BeanUtils.copyProperties(jogadorDTO, jogador);

    	// TODO: Implementar persistencia...
 	}
}
