package com.cadastro.useCases.enderecos.impl;
import com.cadastro.entitys.Clientes;
import com.cadastro.entitys.Enderecos;
import com.cadastro.frameWork.annotions.Business;
import com.cadastro.frameWork.utils.SenacException;
import com.cadastro.useCases.clientes.ClientesBusiness;
import com.cadastro.useCases.enderecos.EnderecosBusiness;
import com.cadastro.useCases.enderecos.domanis.EnderecosRequestDom;
import com.cadastro.useCases.enderecos.domanis.EnderecosResponseDom;
import com.cadastro.useCases.enderecos.impl.mappers.EnderecosMapper;
import com.cadastro.useCases.enderecos.impl.repositorys.EnderecosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Business
public class EnderecosBusinessImpl implements EnderecosBusiness {

    @Autowired
    private EnderecosRepository enderecosRepository;

    @Autowired
    private ClientesBusiness clientesBusiness;

    @Override
    public List<EnderecosResponseDom> carregarEnderecos() {
        List<Enderecos> enderecosList = enderecosRepository.findAll();

        List<EnderecosResponseDom> out = enderecosList.stream()
                .map(EnderecosMapper::enderecosToEnderecosResponseDom)
                .collect(Collectors.toList());

        return out;
    }

    @Override
    public EnderecosResponseDom criarEndereco(EnderecosRequestDom enderecoRequestDom) throws SenacException {
        List<String> messages = new ArrayList<>();

        if(enderecoRequestDom.getRua() == null || enderecoRequestDom.getRua() == "") {
            messages.add("Endereço informado não possui rua!");
        }

        if(enderecoRequestDom.getBairro() == null || enderecoRequestDom.getBairro() == "") {
            messages.add("Endereço informado não possui bairro!");
        }

        if(enderecoRequestDom.getCidade() == null || enderecoRequestDom.getCidade() == "") {
            messages.add("Endereço informado não possui cidade!");
        }

        if(enderecoRequestDom.getEstado() == null || enderecoRequestDom.getEstado() == "") {
            messages.add("Endereço informado não possui estado!");
        }

        if(!messages.isEmpty()) {
            throw new SenacException(messages);

        }

        Clientes cliente = clientesBusiness.carregarClienteEntidade(enderecoRequestDom.getClienteId());

        Enderecos enderecoRetorno = enderecosRepository.save(EnderecosMapper.enderecosResquestDomToEnderecos(enderecoRequestDom, cliente));

        return EnderecosMapper.enderecosToEnderecosResponseDom(enderecoRetorno);
    }

    @Override
    public EnderecosResponseDom atualizarEndereco(Long id, EnderecosRequestDom endereco) {
        Clientes cliente = clientesBusiness.carregarClienteEntidade(endereco.getClienteId());

        Enderecos enderecoRetorno = enderecosRepository.findById(id).map(record -> {
            record.setRua(endereco.getRua());
            record.setBairro(endereco.getBairro());
            record.setCidade(endereco.getCidade());
            record.setEstado(endereco.getEstado());
            record.setCliente(cliente);
            return enderecosRepository.save(record);
        }).get();

        EnderecosResponseDom out = EnderecosMapper.enderecosToEnderecosResponseDom(enderecoRetorno);

        return out;
    }

    @Override
    public void deletarEndereco(Long id) {
        enderecosRepository.deleteById(id);
    }
}
