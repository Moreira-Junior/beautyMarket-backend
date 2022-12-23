package br.ifpb.pweb1.beautyMarket.repository;

import br.ifpb.pweb1.beautyMarket.model.Prestador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrestadoresRepository extends JpaRepository<Prestador, Long> {

    @Query(value = "select distinct p from Prestador p where upper(p.nomeFantasia) like %:nome% or upper(p.especialidade) like %:nome% or upper(p.bairro) like %:nome%")
    List<Prestador> findPrestadorByNome(@Param("nome")String nome);
}
