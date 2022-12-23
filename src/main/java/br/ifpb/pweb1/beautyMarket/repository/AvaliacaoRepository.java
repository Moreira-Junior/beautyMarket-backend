package br.ifpb.pweb1.beautyMarket.repository;

import br.ifpb.pweb1.beautyMarket.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    @Query(value = "select a from Avaliacao a where a.prestador.id = :idPrestador")
    List<Avaliacao> listarAvaliacaoPorEmpresa(@Param("idPrestador") Long idPrestador);
}
