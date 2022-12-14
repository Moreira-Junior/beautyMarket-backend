package br.ifpb.pweb1.beautyMarket.repository;

import br.ifpb.pweb1.beautyMarket.model.Prestador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PrestadoresRepository extends JpaRepository<Prestador, Long> {
}
