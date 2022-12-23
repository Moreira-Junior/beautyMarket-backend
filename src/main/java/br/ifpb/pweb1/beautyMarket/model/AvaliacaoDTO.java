package br.ifpb.pweb1.beautyMarket.model;

public class AvaliacaoDTO {

    private Long prestador;
    private Long usuario;
    private String mensagemAvaliacao;
    private double avaliacao;

    public Long getPrestador() {
        return prestador;
    }

    public void setPrestador(Long prestador) {
        this.prestador = prestador;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public String getMensagemAvaliacao() {
        return mensagemAvaliacao;
    }

    public void setMensagemAvaliacao(String mensagemAvaliacao) {
        this.mensagemAvaliacao = mensagemAvaliacao;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }
}
