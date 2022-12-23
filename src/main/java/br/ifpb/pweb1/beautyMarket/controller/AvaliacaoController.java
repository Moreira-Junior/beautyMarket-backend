package br.ifpb.pweb1.beautyMarket.controller;

import br.ifpb.pweb1.beautyMarket.model.Avaliacao;
import br.ifpb.pweb1.beautyMarket.model.AvaliacaoDTO;
import br.ifpb.pweb1.beautyMarket.service.AvaliacaoService;
import br.ifpb.pweb1.beautyMarket.service.PrestadorService;
import br.ifpb.pweb1.beautyMarket.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/{id}")
    public List<Avaliacao> listarAvaliacaoPorPrestador(@Param("id")Long id){
        return this.avaliacaoService.avaliacoesPorPrestador(id);
    }

    @PostMapping()
    public Avaliacao criarAvaliacao(@RequestBody AvaliacaoDTO avaliacao){
        return this.avaliacaoService.criarAvaliacao(avaliacao);
    }


}
