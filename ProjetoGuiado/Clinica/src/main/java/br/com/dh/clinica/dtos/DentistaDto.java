package br.com.dh.clinica.dtos;

import br.com.dh.clinica.entities.Dentista;

import java.io.Serializable;

public class DentistaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String email;
    private String cro;
    private boolean atendeconvenio;

    public DentistaDto() {
    }

    public DentistaDto(Integer id, String nome, String email, String cro, boolean atendeconvenio) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cro = cro;
        this.atendeconvenio = atendeconvenio;
    }

    public DentistaDto(Dentista dentista) {
        this.id = dentista.getId();
        this.nome = dentista.getNome();
        this.email = dentista.getEmail();
        this.cro = dentista.getCro();
        this.atendeconvenio = dentista.isAtendeConvenio();
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

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public boolean isAtendeconvenio() {
        return atendeconvenio;
    }

    public void setAtendeconvenio(boolean atendeconvenio) {
        this.atendeconvenio = atendeconvenio;
    }
}
