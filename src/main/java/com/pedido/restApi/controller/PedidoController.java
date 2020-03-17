package com.pedido.restApi.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedido.restApi.exception.ResourceNotFoundException;
import com.pedido.restApi.models.Pedido;
import com.pedido.restApi.repository.PedidoRepository;

//aqui controlamos o h2, temos o localhost:porta/api/v1 como controlador principal rest
@RestController
@RequestMapping("/api/v1")
public class PedidoController {
	@Autowired
	private PedidoRepository pedidoRepository;

	//ja localhost:porta/api/v1/pedido get method encontra todos pedidos
	@GetMapping("/pedido")
	public List < Pedido > getAllPedidos() {
		return pedidoRepository.findAll();
	}
	//ja localhost:porta/api/v1/{id} get method encontra informacoes de um pedido
	@GetMapping("/pedido/{id}")
	public ResponseEntity < Pedido > getPedidoById(@PathVariable(value = "id") Long pedidoId)
    throws ResourceNotFoundException {
		Pedido pedido = pedidoRepository.findById(pedidoId)
			.orElseThrow(() -> new ResourceNotFoundException("Pedido not found for this id :: " + pedidoId));
		return ResponseEntity.ok().body(pedido);
    }
    @PostMapping("/pedido")// postar um pedido e gerar seu id
    public Pedido createPedido(@Valid @RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    //alterar um pedido
    @PutMapping("/pedido/{id}")
    public ResponseEntity < Pedido > updatePedido(@PathVariable(value = "id") Long pedidoId,
        @Valid @RequestBody Pedido pedidoDetails) throws ResourceNotFoundException {
        Pedido pedido = pedidoRepository.findById(pedidoId)
            .orElseThrow(() -> new ResourceNotFoundException("Pedido not found for this id :: " + pedidoId));

        pedido.setCod_cliente(pedidoDetails.getCod_cliente());
        pedido.setCod_produtos(pedidoDetails.getCod_produtos());
        pedido.setValor_total(pedidoDetails.getValor_total());
        pedido.setEndereco(pedidoDetails.getEndereco());
        final Pedido updatedPedido = pedidoRepository.save(pedido);
        return ResponseEntity.ok(updatedPedido);
    }
    //deletar pedidos
    @DeleteMapping("/pedidos/{id}")
    public Map < String, Boolean > deletepedido(@PathVariable(value = "id") Long pedidoId)
    throws ResourceNotFoundException {
        Pedido pedido = pedidoRepository.findById(pedidoId)
            .orElseThrow(() -> new ResourceNotFoundException("pedido not found for this id :: " + pedidoId));

        pedidoRepository.delete(pedido);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
