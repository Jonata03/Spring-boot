package io.github.jonata03.jdbc.domain.repository;

import io.github.jonata03.jdbc.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface itemsPedidos extends JpaRepository<ItemPedido,Integer> {
}
