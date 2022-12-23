package br.ifpb.pweb1.beautyMarket.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne()
    private Prestador prestador;
    private LocalDateTime dateStamp;
    private String conteudoMensagem;
    @Enumerated(EnumType.STRING)
    private EnviadoPorEnum enviadoPor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonBackReference(value = "usuario-mensagem")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    @JsonBackReference(value = "prestador-mensagem")
    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public LocalDateTime getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(LocalDateTime dateStamp) {
        this.dateStamp = dateStamp;
    }

    public String getConteudoMensagem() {
        return conteudoMensagem;
    }

    public void setConteudoMensagem(String conteudoMensagem) {
        this.conteudoMensagem = conteudoMensagem;
    }

    public EnviadoPorEnum getEnviadoPor() {
        return enviadoPor;
    }

    public void setEnviadoPor(EnviadoPorEnum enviadoPor) {
        this.enviadoPor = enviadoPor;
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", prestador=" + prestador +
                ", dateStamp=" + dateStamp +
                ", conteudoMensagem='" + conteudoMensagem + '\'' +
                ", enviadoPor=" + enviadoPor +
                '}';
    }
}
