package br.ifpb.pweb1.beautyMarket.repository;

import br.ifpb.pweb1.beautyMarket.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    @Query(value = "select m from Mensagem m where m.prestador.id = :prestadorId and m.usuario.id = :usuarioId order by m.dateStamp asc")
    List<Mensagem> listarMensagens(@Param("usuarioId")Long usuarioId, @Param("prestadorId")Long prestadorId);

}
