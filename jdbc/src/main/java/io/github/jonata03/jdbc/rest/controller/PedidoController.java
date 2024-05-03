package io.github.jonata03.jdbc.rest.controller;

import io.github.jonata03.jdbc.service.PedidosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private PedidosService service;

    public PedidoController(PedidosService service) {
        this.service = service;
    }
}
