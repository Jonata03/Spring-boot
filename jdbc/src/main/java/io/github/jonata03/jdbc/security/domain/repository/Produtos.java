package io.github.jonata03.jdbc.security.domain.repository;

import io.github.jonata03.jdbc.security.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto,Integer> {
}
