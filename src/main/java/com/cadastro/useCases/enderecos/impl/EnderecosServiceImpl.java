package com.cadastro.useCases.enderecos.impl;
import com.cadastro.frameWork.utils.SenacException;
import com.cadastro.useCases.enderecos.domanis.EnderecosRequestDom;
import com.cadastro.useCases.enderecos.domanis.EnderecosResponseDom;
import com.cadastro.useCases.enderecos.EnderecosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnderecosServiceImpl implements EnderecosService {

    @Autowired
    private EnderecosBusinessImpl enderecosBusiness;

    @Override
    public List<EnderecosResponseDom> carregarEnderecos() {
        return enderecosBusiness.carregarEnderecos();
    }

    @Override
    public EnderecosResponseDom criarEndereco(EnderecosRequestDom endereco) throws SenacException {
        return enderecosBusiness.criarEndereco(endereco);
    }

    @Override
    public EnderecosResponseDom atualizarEndereco(Long id, EnderecosRequestDom endereco) {
        return enderecosBusiness.atualizarEndereco(id, endereco);
    }

    @Override
    public void deletarEndereco(Long id) {
        enderecosBusiness.deletarEndereco(id);
    }
}
