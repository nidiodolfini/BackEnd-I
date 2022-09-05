package br.com.dh.clinica.dtos;

import br.com.dh.clinica.entities.Usuario;

import java.io.Serializable;

public class UsuarioDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private Integer nivelacesso;

    public UsuarioDto() {
    }

    public UsuarioDto(Integer id, String nome, String email, String senha, Integer nivelacesso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivelacesso = nivelacesso;
    }

    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.nivelacesso = usuario.getNivelAcesso();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivelAcesso() {
        return nivelacesso;
    }

    public void setNivelAcesso(Integer nivelacesso) {
        this.nivelacesso = nivelacesso;
    }
}
