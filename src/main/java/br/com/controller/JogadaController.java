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
import br.com.dto.JogadaDTO;
import br.com.service.JogadaService;

@RestController
@RequestMapping(value = br.com.constantes.API.VERSAO + API.JOGADA_API, produces = MediaType.APPLICATION_JSON_VALUE)
public class JogadaController {

	@Autowired
	private JogadaService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscaUsuario(@PathVariable Long id) {

		JogadaDTO jogadaDTO = service.buscarPorId(id);

		return ResponseEntity.ok().body(jogadaDTO);
	}

    @GetMapping
    public ResponseEntity<Object> buscaTodos() {
 
    	List<JogadaDTO> jogadas = service.buscarTodos();

        return ResponseEntity.ok(jogadas);
    }
	
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Object> novo(@RequestBody JogadaDTO dto){

      	JogadaDTO jogadaDTO = service.gravar(dto);

        return new ResponseEntity<>(jogadaDTO, HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Object> atualiza(@RequestBody JogadaDTO dto) {

        service.atualizar(dto);

        return ResponseEntity.noContent().build();
    }    
}
