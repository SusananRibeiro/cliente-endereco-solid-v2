package com.cadastro.useCases.clientes.impl.repositorys;
import com.cadastro.entitys.Enderecos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ClientesEnderecosRespository extends JpaRepository<Enderecos, Long> {
    @Query("select a from enderecos a where a.cliente.id = :id")
    List<Enderecos> carregarEnderecosByClienteId(@Param("id") Long id);
}
