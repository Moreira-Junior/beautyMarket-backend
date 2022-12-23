package br.ifpb.pweb1.beautyMarket.service;

import br.ifpb.pweb1.beautyMarket.model.Prestador;
import br.ifpb.pweb1.beautyMarket.repository.PrestadoresRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("PrestadorServiceTest")
public class PrestadorServiceTest {

    @MockBean
    private PrestadoresRepository prestadoresRepository;

    @Autowired
    private PrestadorService prestadorService;

    @Test
    public void deveCriarPrestador(){
        Prestador prestador = new Prestador();
        Mockito.when(prestadoresRepository.save(ArgumentMatchers.eq(prestador))).thenReturn(prestador);
        prestadorService.criarOuAtualizarPrestador(prestador);
        Mockito.verify(prestadoresRepository, Mockito.times(1)).save(any(Prestador.class));
    }

    @Test
    public void naoDeveCriarPrestadorNulo(){
        Prestador prestador = null;
        Mockito.when(prestadoresRepository.save(ArgumentMatchers.eq(prestador))).thenThrow(RuntimeException.class);
        Assertions.assertThrows(RuntimeException.class, () -> prestadorService.criarOuAtualizarPrestador(prestador));
    }

    @Test
    public void deveBuscarPorId(){
        Optional<Prestador> prestador = Optional.of(new Prestador());
        prestador.get().setId(1L);
        Mockito.when(prestadoresRepository.findById(1L)).thenReturn(prestador);
        prestadorService.listarPrestador(1L);
        Mockito.verify(prestadoresRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    public void naoDeveAcharPorIdInexistente(){
        Prestador prestador = null;
        Mockito.when(prestadoresRepository.findById(ArgumentMatchers.eq(2L))).thenReturn(Optional.ofNullable(prestador));
        assertEquals(prestadorService.listarPrestador(2L), null);
    }

    @Test
    public void deveRetornarListaDePrestadores(){
        List<Prestador> prestadores = new ArrayList<>();
        Prestador prestador = new Prestador();
        prestadores.add(prestador);
        Mockito.when(prestadoresRepository.findAll()).thenReturn(prestadores);
        prestadorService.listarPrestadores();
        Mockito.verify(prestadoresRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void deveDeletar(){
        prestadorService.deletarPrestador(2L);
        Mockito.verify(prestadoresRepository, Mockito.times(1)).deleteById(2L);
    }

    @Test
    public void deveListarPorNome(){
        String nome = "Teste";
        Prestador prestador = new Prestador();
        prestador.setNomeFantasia(nome);
        Mockito.when(prestadoresRepository.findPrestadorByNome(nome)).thenReturn(List.of(prestador));
        prestadorService.listarPrestadoresPorNome(nome);
        Mockito.verify(prestadoresRepository, Mockito.times(1)).findPrestadorByNome(nome);
    }
}
