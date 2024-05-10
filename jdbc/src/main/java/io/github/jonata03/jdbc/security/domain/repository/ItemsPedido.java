package io.github.jonata03.jdbc.security.domain.repository;


import io.github.jonata03.jdbc.security.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer> {
}
