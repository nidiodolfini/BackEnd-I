package br.com.dh.clinica.services;

import br.com.dh.clinica.dtos.UsuarioDto;
import br.com.dh.clinica.entities.Usuario;
import br.com.dh.clinica.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Transactional(readOnly = true)
    public List<UsuarioDto> buscarTodos() {
        List<Usuario> list = repository.findAll();
        return list.stream().map(x -> new UsuarioDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioDto buscarPorId(Integer id) {
        Optional<Usuario> objeto = repository.findById(id);
        Usuario usuario = objeto.get();
        return new UsuarioDto(usuario);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }

    @Transactional
    public UsuarioDto inserir(UsuarioDto dto) {
        Usuario entidade = new Usuario();
        entidade.setNome(dto.getNome());
        entidade.setEmail(dto.getEmail());
        entidade.setSenha(dto.getSenha());
        entidade.setNivelAcesso(dto.getNivelAcesso());
        entidade = repository.save(entidade);                // Retorna o objeto com ID
        return new UsuarioDto(entidade);
    }

    @Transactional
    public UsuarioDto atualizar(Integer id, UsuarioDto dto) {
        Usuario entidade = repository.getReferenceById(id);
        entidade.setNome(dto.getNome());
        entidade.setEmail(dto.getEmail());
        entidade.setSenha(dto.getSenha());
        entidade.setNivelAcesso(dto.getNivelAcesso());
        entidade = repository.save(entidade);
        return new UsuarioDto(entidade);
    }

}