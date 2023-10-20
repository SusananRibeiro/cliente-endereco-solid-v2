package com.cadastro.controllers;
import com.cadastro.frameWork.annotions.LogRest;
import com.cadastro.frameWork.utils.ResponseUtil;
import com.cadastro.frameWork.utils.SenacException;
import com.cadastro.useCases.enderecos.domanis.EnderecosRequestDom;
import com.cadastro.useCases.enderecos.domanis.EnderecosResponseDom;
import com.cadastro.useCases.enderecos.impl.EnderecosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/enderecos")
public class EnderecosController {

    @Autowired
    private EnderecosServiceImpl enderecosService;

    @GetMapping("/carregar")
    @LogRest
    public ResponseEntity<List<EnderecosResponseDom>> carregarEnderecos(){
        List<EnderecosResponseDom> out = enderecosService.carregarEnderecos();

        return ResponseEntity.ok(out);
    }

    @PostMapping("/criar")
    @LogRest
    public ResponseEntity<?> criarEndereco(@RequestBody EnderecosRequestDom enderecosRequestDom) throws SenacException {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(enderecosService.criarEndereco(enderecosRequestDom));

        } catch (SenacException e) {
            e.printStackTrace(); // para mostrar o erro no Log, é bom para rastrear o erro depois
            return ResponseEntity.badRequest().body(ResponseUtil.responseMapper(e.getMessages()));
        }

    }

    @PutMapping("/atualizar/{id}")
    @LogRest
    public ResponseEntity<EnderecosResponseDom> atualizarEndereco(@PathVariable Long id, @RequestBody EnderecosRequestDom endereco){
        EnderecosResponseDom out = enderecosService.atualizarEndereco(id, endereco);

        return ResponseEntity.ok(out);
    }

    @DeleteMapping("/deletar/{id}")
    @LogRest
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id){
        enderecosService.deletarEndereco(id);

        return ResponseEntity.ok(null);
    }
}
