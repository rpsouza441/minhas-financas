package br.dev.rodrigopinheiro.dto;

import br.dev.rodrigopinheiro.model.CartaoCredito;
import br.dev.rodrigopinheiro.model.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DespesaCartaoDTO {
    private String descricao = "";

    private String observacao = "";

    private BigDecimal valor = BigDecimal.ZERO;

    private boolean recorrente = false;

    private boolean efetivada = false;

    private Date mesAnoFatura = null;

    private Date dataLancamento = null;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "cartao_credito")
    private CartaoCredito cartaoCredito;

}
