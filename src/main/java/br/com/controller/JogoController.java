package br.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.constantes.API;
import br.com.dto.EntradaDTO;
import br.com.dto.JogadorDTO;
import br.com.service.EntradaService;

@RestController
@RequestMapping(value = br.com.constantes.API.VERSAO + API.JOGADOR_API, produces = MediaType.APPLICATION_JSON_VALUE)
public class JogoController {

	@Autowired
	private EntradaService service;
	
    @PostMapping
    public ResponseEntity<Object> entrada(@RequestBody List<EntradaDTO> dto){

      	JogadorDTO jogadorDTO = service.processarJogo(dto);

        return new ResponseEntity<>(jogadorDTO, HttpStatus.ACCEPTED);
    }
}
