package br.ifpb.pweb1.beautyMarket.controller;

import br.ifpb.pweb1.beautyMarket.model.Prestador;
import br.ifpb.pweb1.beautyMarket.service.PrestadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PrestadorController {

    @Autowired
    PrestadorService prestadorService;

    @GetMapping("/prestadores")
    public List<Prestador> listarPrestadores(){
        return this.prestadorService.listarPrestadores();
    }

    @GetMapping("prestadores/{id}")
    public Prestador listarPrestador(@PathVariable("id") Long id){
        return this.prestadorService.listarPrestador(id);
    }

    @GetMapping("prestadores/nome/{nome}")
    public List<Prestador> listarPrestadoresPorNome(@PathVariable("nome") String nome){
        return this.prestadorService.listarPrestadoresPorNome(nome.toUpperCase());
    }

    @PostMapping("/prestadores")
    public Prestador criarPrestador(@RequestBody Prestador prestador){
        return this.prestadorService.criarOuAtualizarPrestador(prestador);
    }

    @PutMapping("/prestadores/{id}")
    public Prestador atualizarPrestador(@RequestBody Prestador prestador){
        return this.prestadorService.criarOuAtualizarPrestador(prestador);
    }

    @DeleteMapping("/prestadores/{id}")
    public void deletarPrestador(@PathVariable("id") Long id){
        this.prestadorService.deletarPrestador(id);
    }
}
