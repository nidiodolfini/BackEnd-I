package br.com.dh.clinica.controllers;

import br.com.dh.clinica.dtos.EnderecoDto;
import br.com.dh.clinica.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

    @Autowired
    EnderecoService service;

    @GetMapping
    public ResponseEntity<List<EnderecoDto>> buscaTodosEnderecos() {
        List<EnderecoDto> list = service.buscarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EnderecoDto> buscarEnderecoPorId(@PathVariable Integer id){
        EnderecoDto enderecoDto = service.buscarPorId(id);
        return ResponseEntity.ok().body(enderecoDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EnderecoDto> excluirEndereco(@PathVariable Integer id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<EnderecoDto> inserirEnderecos(@RequestBody EnderecoDto dto){
        dto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EnderecoDto> atualizarEndereco(@PathVariable Integer id, @RequestBody EnderecoDto dto){
        dto = service.atualizar(id, dto);
        return ResponseEntity.ok().body(dto);
    }

}
