package com.cadastro.controllers;

import com.cadastro.frameWork.annotions.LogRest;
import com.cadastro.frameWork.utils.ResponseUtil;
import com.cadastro.frameWork.utils.SenacException;
import com.cadastro.useCases.clientes.domanis.ClientesRequestDom;
import com.cadastro.useCases.clientes.impl.repositorys.ClientesRespository;
import com.cadastro.useCases.clientes.domanis.ClientesResponseDom;
import com.cadastro.useCases.clientes.impl.ClientesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesServiceImpl clientesService;

    @Autowired
    ClientesRespository clientesRespository;

    @GetMapping(path = "/carregar")
    @LogRest
    public ResponseEntity<List<ClientesResponseDom>> carregarClientes(){
        return ResponseEntity.ok(clientesService.carregarClientes());
    }
// Excluir depois
    @GetMapping("/carregar/{id}")
    @LogRest
    public ResponseEntity<ClientesResponseDom> carregarClienteById(@PathVariable Long id){
        return ResponseEntity.ok(clientesService.carregarClienteById(id));
    }

    // "?" significa que pode retornar qualquer coisa
    @PostMapping("/criar")
    @LogRest
    public ResponseEntity<?> criarCliente
            (@RequestBody ClientesRequestDom clientesRequestDom){

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(clientesService.criarCliente(clientesRequestDom));

        } catch (SenacException e) {
            e.printStackTrace(); // para mostrar o erro no Log, é bom para rastrear o erro depois
            return ResponseEntity.badRequest().body(ResponseUtil.responseMapper(e.getMessages())); // mudar o getMessage(), para o getMessages() que foi criado na classe SenacException
        }

    }

    @PutMapping("/atualizar/{id}")
    @LogRest
    public ResponseEntity<ClientesResponseDom> atualizarCliente
            (@PathVariable Long id,
             @RequestBody ClientesRequestDom clientesRequestDom){
        return ResponseEntity.ok(
                clientesService.atualizarCliente(id, clientesRequestDom));
    }

    @DeleteMapping("/deletar/{id}")
    @LogRest
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clientesService.deletarCliente(id);

        return ResponseEntity.ok(null);
    }
}
