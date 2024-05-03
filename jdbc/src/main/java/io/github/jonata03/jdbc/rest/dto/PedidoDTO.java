package io.github.jonata03.jdbc.rest.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PedidoDTO {
    private Integer cliente;
    private BigDecimal total;
    private List<ItemPedidoDTO> items;
}
