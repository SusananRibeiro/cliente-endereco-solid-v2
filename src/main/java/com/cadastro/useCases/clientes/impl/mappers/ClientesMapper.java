package com.cadastro.useCases.clientes.impl.mappers;

import com.cadastro.entitys.Clientes;
import com.cadastro.entitys.Enderecos;
import com.cadastro.useCases.clientes.domanis.ClientesEnderecosResponseDom;
import com.cadastro.useCases.clientes.domanis.ClientesRequestDom;
import com.cadastro.useCases.clientes.domanis.ClientesResponseDom;

import java.util.List;
import java.util.stream.Collectors;

public class ClientesMapper {
    public static ClientesResponseDom clientesToClientesResponseDom(Clientes clientes){
        ClientesResponseDom out = new ClientesResponseDom();
        out.setId(clientes.getId());
        out.setNome(clientes.getNome());
        out.setEmail(clientes.getEmail());
        out.setSobrenome(clientes.getSobreNome());
        out.setTelefone(clientes.getTelefone());
        out.setDataNascimento(clientes.getDataNascimento());

        return out;
    }

    public static ClientesResponseDom clientesToClientesResponseDom(Clientes clientes, List<Enderecos> enderecos){
        ClientesResponseDom out = ClientesMapper.clientesToClientesResponseDom(clientes);
        List<ClientesEnderecosResponseDom> enderecosResponseDomList = enderecos.stream()
                .map(ClientesMapper::enderecosToClientesEnderecosResponseDom)
                .collect(Collectors.toList());

        out.setEnderecos(enderecosResponseDomList);

        return out;
    }

    public static Clientes clientesRequestDomToClientes
            (ClientesRequestDom clientesRequestDom){
        Clientes out = new Clientes();
        out.setDataNascimento(clientesRequestDom.getDataNascimento());
        out.setEmail(clientesRequestDom.getEmail());
        out.setNome(clientesRequestDom.getNome());
        out.setTelefone(clientesRequestDom.getTelefone());
        out.setSobreNome(clientesRequestDom.getSobrenome());

        return out;
    }

    public static ClientesEnderecosResponseDom enderecosToClientesEnderecosResponseDom(Enderecos endereco){
        ClientesEnderecosResponseDom out = new ClientesEnderecosResponseDom();
        out.setId(endereco.getId());
        out.setBairro(endereco.getBairro());
        out.setCidade(endereco.getCidade());
        out.setRua(endereco.getRua());
        out.setEstado(endereco.getEstado());

        return out;
    }
}
