package io.github.jonata03.jdbc.service.impl;

import io.github.jonata03.jdbc.domain.repository.Pedidos;
import io.github.jonata03.jdbc.service.PedidosService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidosService {
    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}
