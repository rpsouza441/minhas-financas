package br.dev.rodrigopinheiro.dto;

import br.dev.rodrigopinheiro.model.*;
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
public class TransacaoDTO {
    private String descricao = "";

    private String observacao = "";

    private BigDecimal valor = BigDecimal.ZERO;

    private TipoTransacao tipoTransacao;

    private boolean recorrente = false;

    private boolean efetivada = false;

    private Date dataVencimento = null;

    private Date dataLancamento = null;

    private Date dataEfetivado = null;

    private Categoria categoria;

    private UUID contaUuid;

    private Fatura fatura;



}
