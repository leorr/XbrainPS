package com.pedido.restApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedido.restApi.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
}

