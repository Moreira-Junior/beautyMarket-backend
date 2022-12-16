package br.ifpb.pweb1.beautyMarket.repository;

import br.ifpb.pweb1.beautyMarket.model.Prestador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PrestadoresRepository extends JpaRepository<Prestador, Long> {

    @Query(value = "select p from Prestador p where upper(p.nomeFantasia) like ?1%")
    public List<Prestador> findPrestadorByNome(String nome);
}
