package br.ifpb.pweb1.beautyMarket.service;

import br.ifpb.pweb1.beautyMarket.model.Prestador;
import br.ifpb.pweb1.beautyMarket.repository.PrestadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrestadorService {

    @Autowired
    PrestadoresRepository prestadoresRepository;

    public List<Prestador> listarPrestadores() {
        return this.prestadoresRepository.findAll();
    }

    @Transactional
    public Prestador criarOuAtualizarPrestador(Prestador prestador) {
        return this.prestadoresRepository.save(prestador);
    }

    public Prestador listarPrestador(Long id){
        return this.prestadoresRepository.findById(id).orElse(null);
    }

    public void deletarPrestador(Long id) {
        this.prestadoresRepository.deleteById(id);
    }

    public List<Prestador> listarPrestadoresPorNome(String nome) {
        return this.prestadoresRepository.findPrestadorByNome(nome);
    }
}
