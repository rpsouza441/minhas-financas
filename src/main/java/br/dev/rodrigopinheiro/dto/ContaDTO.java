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
public class ContaDTO {

    private String nome = "";

    private BigDecimal saldo = BigDecimal.ZERO;

}
