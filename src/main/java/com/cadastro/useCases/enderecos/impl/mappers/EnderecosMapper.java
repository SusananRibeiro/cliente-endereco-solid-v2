package com.cadastro.useCases.enderecos.impl.mappers;
import com.cadastro.entitys.Clientes;
import com.cadastro.entitys.Enderecos;
import com.cadastro.useCases.enderecos.domanis.EnderecosRequestDom;
import com.cadastro.useCases.enderecos.domanis.EnderecosResponseDom;

public class EnderecosMapper {
    public static EnderecosResponseDom enderecosToEnderecosResponseDom(Enderecos endereco){
        EnderecosResponseDom out = new EnderecosResponseDom();
        out.setId(endereco.getId());
        out.setBairro(endereco.getBairro());
        out.setCidade(endereco.getCidade());
        out.setRua(endereco.getRua());
        out.setEstado(endereco.getEstado());
        out.setClienteId(endereco.getCliente().getId());

        return out;
    }

    public static Enderecos enderecosResquestDomToEnderecos(EnderecosRequestDom enderecos, Clientes cliente){
        Enderecos out = new Enderecos();
        out.setBairro(enderecos.getBairro());
        out.setRua(enderecos.getRua());
        out.setCidade(enderecos.getCidade());
        out.setEstado(enderecos.getEstado());
        out.setCliente(cliente);

        return out;
    }
}
