package br.ifpb.pweb1.beautyMarket.model;

public class MensagemDTO {

    private Long prestador;
    private Long usuario;
    private String conteudoMensagem;

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

    public String getConteudoMensagem() {
        return conteudoMensagem;
    }

    public void setConteudoMensagem(String conteudoMensagem) {
        this.conteudoMensagem = conteudoMensagem;
    }

    @Override
    public String toString() {
        return "MensagemDTO{" +
                ", idPrestador=" + prestador +
                ", idUsuario=" + usuario +
                ", conteudoMensagem='" + conteudoMensagem + '\'' +
                '}';
    }
}
