package br.com.dh.clinica.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private LocalDate dataCadastro;
    private LocalDate dataAtendimento;
    private Paciente paciente;
    private Dentista dentista;
    private Usuario usuario;

    public Consulta() {
    }

    public Consulta(Integer id, LocalDate dataCadastro, LocalDate dataAtendimento, Paciente paciente, Dentista dentista, Usuario usuario) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.dataAtendimento = dataAtendimento;
        this.paciente = paciente;
        this.dentista = dentista;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDate dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
