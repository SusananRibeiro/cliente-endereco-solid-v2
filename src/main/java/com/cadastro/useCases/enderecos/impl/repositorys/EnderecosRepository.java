package com.cadastro.useCases.enderecos.impl.repositorys;
import com.cadastro.entitys.Enderecos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecosRepository extends JpaRepository<Enderecos, Long> {

}
