package com.restaurante.sistema_restaurante.service;

import com.restaurante.sistema_restaurante.entity.Pedido;
import com.restaurante.sistema_restaurante.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarPedido(Long id, Pedido pedidoAtualizado) {
        Optional<Pedido> pedidoExistente = pedidoRepository.findById(id);

        if (pedidoExistente.isPresent()) {
            Pedido pedido = pedidoExistente.get();
            // Aqui você define quais atributos do pedido podem ser atualizados
            pedido.setDescricao(pedidoAtualizado.getDescricao());
            pedido.setQuantidade(pedidoAtualizado.getQuantidade());
            pedido.setPreco(pedidoAtualizado.getPreco());
            // atualize outros campos conforme necessário

            return pedidoRepository.save(pedido);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado");
        }
    }
}
