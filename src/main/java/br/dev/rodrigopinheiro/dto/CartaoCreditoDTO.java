package br.dev.rodrigopinheiro.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CartaoCreditoDTO {

    private String nome = "";

    private BigDecimal limite = BigDecimal.ZERO;

    private BigDecimal diaFechamento = BigDecimal.ZERO;

    private BigDecimal diaVencimento = BigDecimal.ZERO;

}
