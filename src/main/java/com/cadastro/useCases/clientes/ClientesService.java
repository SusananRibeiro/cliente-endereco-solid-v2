package com.cadastro.useCases.clientes;
import com.cadastro.useCases.clientes.domanis.ClientesRequestDom;
import com.cadastro.useCases.clientes.domanis.ClientesResponseDom;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ClientesService {
    List<ClientesResponseDom> carregarClientes();
    ClientesResponseDom criarCliente(ClientesRequestDom clientesRequestDom) throws Exception;
    ClientesResponseDom atualizarCliente(Long id, ClientesRequestDom clientesRequestDom);
    void deletarCliente(Long id);
    ClientesResponseDom carregarClienteById(Long id);
}
