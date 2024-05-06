package io.github.jonata03.jdbc.rest.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO {
   private Integer produto;
   private Integer quantidade;
}
