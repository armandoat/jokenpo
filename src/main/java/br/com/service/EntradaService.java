package br.com.service;

import java.util.List;

import br.com.dto.EntradaDTO;
import br.com.dto.JogadorDTO;

public interface EntradaService {
	
	JogadorDTO processarJogo(List<EntradaDTO> entradas);

}
