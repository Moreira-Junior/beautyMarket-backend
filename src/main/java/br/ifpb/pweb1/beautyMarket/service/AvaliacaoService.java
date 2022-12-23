package br.ifpb.pweb1.beautyMarket.service;

import br.ifpb.pweb1.beautyMarket.model.Avaliacao;
import br.ifpb.pweb1.beautyMarket.model.AvaliacaoDTO;
import br.ifpb.pweb1.beautyMarket.model.Prestador;
import br.ifpb.pweb1.beautyMarket.model.Usuario;
import br.ifpb.pweb1.beautyMarket.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    @Autowired
    private PrestadorService prestadorService;
    @Autowired
    private UsuarioService usuarioService;

    public List<Avaliacao> avaliacoesPorPrestador(Long idPrestador){
        return this.avaliacaoRepository.listarAvaliacaoPorEmpresa(idPrestador);
    }

    public Avaliacao criarAvaliacao(AvaliacaoDTO avaliacaoDTO){
        Usuario usuario = this.usuarioService.listarUsuario(avaliacaoDTO.getUsuario());
        Prestador prestador = this.prestadorService.listarPrestador(avaliacaoDTO.getPrestador());
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setAvaliacao(avaliacaoDTO.getAvaliacao());
        avaliacao.setMensagemAvaliacao(avaliacaoDTO.getMensagemAvaliacao());
        avaliacao.setPrestador(prestador);
        avaliacao.setUsuario(usuario);
        return this.avaliacaoRepository.save(avaliacao);
    }
}
