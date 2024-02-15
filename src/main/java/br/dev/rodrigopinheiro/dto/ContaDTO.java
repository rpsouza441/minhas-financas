package br.dev.rodrigopinheiro.dto;

import br.dev.rodrigopinheiro.model.Transacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ContaDTO {

    private UUID uuid;

    private String nome = "";

    private BigDecimal saldo = BigDecimal.ZERO;

    private List<Transacao> transacaoList;

}
