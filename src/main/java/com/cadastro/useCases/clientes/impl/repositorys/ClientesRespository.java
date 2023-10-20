package com.cadastro.useCases.clientes.impl.repositorys;
import com.cadastro.entitys.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRespository extends JpaRepository<Clientes, Long> {
}
