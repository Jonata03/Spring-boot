package io.github.jonata03.jdbc.rest.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemPedidoDTO {
   private Integer produto;
   private Integer quantidade;
}
