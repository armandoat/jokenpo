package br.com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.dto.EntradaDTO;
import br.com.dto.JogadorDTO;
import br.com.service.EntradaService;

@Service
public class EntradaServiceImpl implements EntradaService {

	@Override
	public JogadorDTO processarJogo(List<EntradaDTO> entradas) {
		JogadorDTO vencedor = new JogadorDTO();

		// TODO Aqui seria implementar as regras do jogo e como resultado sairia um vencedor, apesar de conhecer, não houve tempo de implementar.
		
		return vencedor;
	}

}
