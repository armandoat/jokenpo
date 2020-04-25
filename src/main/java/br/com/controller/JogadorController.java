package br.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.constantes.API;
import br.com.dto.JogadorDTO;
import br.com.service.JogadorService;

@RestController
@RequestMapping(value = br.com.constantes.API.VERSAO + API.JOGADOR_API, produces = MediaType.APPLICATION_JSON_VALUE)
public class JogadorController {

	@Autowired
	private JogadorService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscaUsuario(@PathVariable Long id) {

		JogadorDTO jogadorDTO = service.buscarPorId(id);

		return ResponseEntity.ok().body(jogadorDTO);
	}

    @GetMapping
    public ResponseEntity<Object> buscatodos() {
 
    	List<JogadorDTO> jogadores = service.buscarTodos();

        return ResponseEntity.ok(jogadores);
    }
	
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Object> novo(@RequestBody JogadorDTO dto){

      	JogadorDTO jogadorDTO = service.gravar(dto);

        return new ResponseEntity<>(jogadorDTO, HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Object> atualiza(@RequestBody JogadorDTO dto) {

        service.atualizar(dto);

        return ResponseEntity.noContent().build();
    }    
}
