package br.com.dh.clinica.controllers;

import br.com.dh.clinica.dtos.UsuarioDto;
import br.com.dh.clinica.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> buscarTodosUsuarios() {
        List<UsuarioDto> list = service.buscarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDto> buscarUsuarioPorId(@PathVariable Integer id) {
        UsuarioDto usuarioDto = service.buscarPorId(id);
        return ResponseEntity.ok().body(usuarioDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Integer id) {
        service.excluir(id);
        return ResponseEntity.noContent().build(); // Retorna um código 204
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> inserirUsuario(@RequestBody UsuarioDto dto) {
        dto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDto> atualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioDto dto) {
        dto = service.atualizar(id, dto);
        return ResponseEntity.ok().body(dto);
    }

}
