package io.github.jonata03.jdbc.domain.repository;

import io.github.jonata03.jdbc.domain.entity.Cliente;
import io.github.jonata03.jdbc.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
    Set<Pedido> findByCliente(Cliente cliente);
}
