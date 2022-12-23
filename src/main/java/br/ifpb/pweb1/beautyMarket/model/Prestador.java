package br.ifpb.pweb1.beautyMarket.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
public class Prestador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeFantasia;
    private String especialidade;
    private String avatar;
    private String foto;
    private String servicos;
    private String bairro;
    private String cidade;
    @OneToMany(mappedBy = "prestador", orphanRemoval = true)
    private List<Mensagem> mensagens;
    @OneToMany(mappedBy = "prestador", orphanRemoval = true)
    private List<Avaliacao> avaliacoes;
    @Transient
    private double avaliacaoMedia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getServicos() {
        return servicos;
    }

    public void setServicos(String servicos) {
        this.servicos = servicos;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    @JsonManagedReference(value = "prestador-mensagem")
    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    @JsonManagedReference(value = "prestador-avaliacao")
    public List<Avaliacao> getAvaliacoes() {
        if(this.avaliacoes != null){
            double sum = 0;
            for(Avaliacao avaliacao: this.avaliacoes){
                sum += avaliacao.getAvaliacao();
            }
            if(avaliacoes.size() > 0){
                this.avaliacaoMedia = Math.round(sum/avaliacoes.size()*10.00)/10.00;
            }
        }
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public double getAvaliacaoMedia() {
        return avaliacaoMedia;
    }

    public void setAvaliacaoMedia(double avaliacaoMedia) {
        this.avaliacaoMedia = avaliacaoMedia;
    }

    @Override
    public String toString() {
        return "Prestador{" +
                "nomeFantasia='" + nomeFantasia + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }
}
