package br.ifpb.pweb1.beautyMarket.controller;

import br.ifpb.pweb1.beautyMarket.model.Mensagem;
import br.ifpb.pweb1.beautyMarket.model.MensagemDTO;
import br.ifpb.pweb1.beautyMarket.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    @Autowired
    private MensagemService mensagemService;

    @PostMapping
    public Mensagem criarPrestador(@RequestBody MensagemDTO mensagem){
        return this.mensagemService.criarMensagem(mensagem);
    }

    @GetMapping("{id}")
    public Mensagem buscarMensagemPorId(@PathVariable("id")Long id){
        return this.mensagemService.buscarMensagemPorId(id);
    }

    @GetMapping("/{usuarioId}/{prestadorId}")
    public List<Mensagem> listarMensagens(@PathVariable("usuarioId")Long usuarioId, @PathVariable("prestadorId")Long prestadorId){
        return this.mensagemService.listarMensagens(usuarioId, prestadorId);
    }

    @PutMapping("/{id}")
    public Mensagem atualizarMensagem(@RequestBody Mensagem mensagem, @PathVariable("id")Long id){
        Mensagem mensagemBuscada = this.buscarMensagemPorId(id);
        mensagemBuscada.setConteudoMensagem(mensagem.getConteudoMensagem());
        return this.mensagemService.atualizarMensagem(mensagemBuscada);
    }

    @DeleteMapping("/{id}")
    public void deletarMensagem(@PathVariable("id")Long id){
        this.mensagemService.deletarMensagem(id);
    }
}
