package br.com.service;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import br.com.JokenpoApplication;
import br.com.dto.JogadorDTO;
import br.com.service.impl.JogadorServiceImpl;


@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {JokenpoApplication.class})
public class JogadorServiceTest {

	@InjectMocks
	private JogadorServiceImpl jogadorService;
	
	@Test
	public void testBuscarPorId() {
		
		JogadorDTO jogadorRetornado = jogadorService.buscarPorId(1L);
		
		assertTrue(jogadorRetornado.getId().equals(1L));
	}
	
	@Test
	public void testBuscarPorTodos() {
		
		List<JogadorDTO> jogadoresRetornados = jogadorService.buscarTodos();
		
		assertTrue(jogadoresRetornados.size() > 0);
	}
	
	@Test
	public void testGravar() {
		
		JogadorDTO mockJogadorDTO = Mockito.mock(JogadorDTO.class);
		
		JogadorDTO resultado = jogadorService.gravar(mockJogadorDTO);
	
		assertTrue(Objects.nonNull(resultado));
	}
	
	@Test
	public void testAlterar() {
		
		JogadorDTO mockJogadorDTO = Mockito.mock(JogadorDTO.class);
		
		jogadorService.atualizar(mockJogadorDTO);
		
		JogadorDTO jogadorRetornado = jogadorService.buscarPorId(1L);
		
		assertTrue(jogadorRetornado.getId().equals(1L));
	}
}
