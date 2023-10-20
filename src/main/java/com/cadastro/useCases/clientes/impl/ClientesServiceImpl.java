package com.cadastro.useCases.clientes.impl;

import com.cadastro.frameWork.utils.SenacException;
import com.cadastro.useCases.clientes.ClientesBusiness;
import com.cadastro.useCases.clientes.ClientesService;
import com.cadastro.useCases.clientes.domanis.ClientesRequestDom;
import com.cadastro.useCases.clientes.domanis.ClientesResponseDom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private ClientesBusinessImpl clientesBusiness;

    @Override
    public List<ClientesResponseDom> carregarClientes() {
        return clientesBusiness.carregarClientes();
    }

    @Override
    public ClientesResponseDom criarCliente(ClientesRequestDom clientesRequestDom) throws SenacException {

        return clientesBusiness.criarCliente(clientesRequestDom);
    }

    @Override
    public ClientesResponseDom atualizarCliente(Long id, ClientesRequestDom clientesRequestDom) {
        return clientesBusiness.atualizarCliente(id, clientesRequestDom);
    }

    @Override
    public void deletarCliente(Long id) {
        clientesBusiness.deletarCliente(id);
    }

    @Override
    public ClientesResponseDom carregarClienteById(Long id) {
        return clientesBusiness.carregarClienteById(id);
    }
}
