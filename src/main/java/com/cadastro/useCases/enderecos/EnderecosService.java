package com.cadastro.useCases.enderecos;
import com.cadastro.frameWork.utils.SenacException;
import com.cadastro.useCases.enderecos.domanis.EnderecosRequestDom;
import com.cadastro.useCases.enderecos.domanis.EnderecosResponseDom;
import java.util.List;

public interface EnderecosService {
    List<EnderecosResponseDom> carregarEnderecos();
    EnderecosResponseDom criarEndereco(EnderecosRequestDom endereco) throws SenacException;
    EnderecosResponseDom atualizarEndereco(Long id, EnderecosRequestDom endereco);
    void deletarEndereco(Long id);
}
