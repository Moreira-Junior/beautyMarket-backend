package br.ifpb.pweb1.beautyMarket.service;

import br.ifpb.pweb1.beautyMarket.model.*;
import br.ifpb.pweb1.beautyMarket.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PrestadorService prestadorService;

    public Mensagem criarMensagem(MensagemDTO mensagemDTO) {
        Usuario usuario = this.usuarioService.listarUsuario(mensagemDTO.getUsuario());
        Prestador prestador = this.prestadorService.listarPrestador(mensagemDTO.getPrestador());
        Mensagem mensagem = new Mensagem();
        mensagem.setConteudoMensagem(mensagemDTO.getConteudoMensagem());
        mensagem.setEnviadoPor(EnviadoPorEnum.USUARIO);
        mensagem.setUsuario(usuario);
        mensagem.setPrestador(prestador);
        mensagem.setDateStamp(LocalDateTime.now());
        return this.mensagemRepository.save(mensagem);
//        System.out.println(mensagemDTO);
//        return new Mensagem();
    }

    public List<Mensagem> listarMensagens(Long usuarioId, Long prestadorId){
        return this.mensagemRepository.listarMensagens(usuarioId, prestadorId);
    }

    public Mensagem atualizarMensagem(Mensagem mensagem) {
        return this.mensagemRepository.save(mensagem);
    }

    public void deletarMensagem(Long id) {
        this.mensagemRepository.deleteById(id);
    }

    public Mensagem buscarMensagemPorId(Long id) {
        return this.mensagemRepository.findById(id).orElse(null);
    }
}
