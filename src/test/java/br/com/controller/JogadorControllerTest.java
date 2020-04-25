package br.com.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.JokenpoApplication;
import br.com.constantes.API;
import br.com.dto.JogadorDTO;
import br.com.service.JogadorService;

//@SpringBootTest(classes = JokenpoApplication.class)
//@AutoConfigureMockMvc
public class JogadorControllerTest {

	@Autowired
	protected MockMvc mockMvc;

	@InjectMocks
	private JogadorService jogadorService;

	private static final String JOGADOR_URI = br.com.constantes.API.VERSAO + API.JOGADOR_API;

	@Test
	public void testBuscarTodos() throws Exception {

		JogadorDTO jogadorDTO = new JogadorDTO();
		List<JogadorDTO> jogadores = new ArrayList<JogadorDTO>();
		jogadores.add(jogadorDTO);

		when(jogadorService.buscarTodos()).thenReturn(jogadores);

		this.mockMvc
				.perform(get(JOGADOR_URI)
						.contentType(MediaType.MULTIPART_FORM_DATA)
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content[0]").exists());
	}

	@Test
	void testConsultarUmJogador() throws Exception {
		
		JogadorDTO jogadorDTO = new JogadorDTO();
		jogadorDTO.setId(1L);

		when(jogadorService.buscarPorId(1L)).thenReturn(jogadorDTO);

		this.mockMvc.perform(get(JOGADOR_URI + "/{id}", 1L)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value(1L));
	}
}
