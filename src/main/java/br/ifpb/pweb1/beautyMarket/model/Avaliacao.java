package br.ifpb.pweb1.beautyMarket.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Prestador prestador;
    private double avaliacao;
    private String mensagemAvaliacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @JsonBackReference(value = "usuario-avaliacao")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    @JsonBackReference(value = "prestador-avaliacao")
    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getMensagemAvaliacao() {
        return mensagemAvaliacao;
    }

    public void setMensagemAvaliacao(String mensagemAvaliacao) {
        this.mensagemAvaliacao = mensagemAvaliacao;
    }
}
