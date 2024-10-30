package com.restaurante.sistema_restaurante.repository;

import com.restaurante.sistema_restaurante.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
