package io.github.jonata03.jdbc.security.service;

import io.github.jonata03.jdbc.security.domain.entity.Pedido;
import io.github.jonata03.jdbc.security.domain.enums.StatusPedido;
import io.github.jonata03.jdbc.security.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto );
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
