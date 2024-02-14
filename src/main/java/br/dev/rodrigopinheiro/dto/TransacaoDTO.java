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

    private Conta conta;

    private Fatura fatura;

    public TransacaoDTO toDTO(Transacao transacao) {
       return  TransacaoDTO.builder()
               .descricao(transacao.getDescricao())
               .observacao(transacao.getObservacao())
               .valor(transacao.getValor())
               .tipoTransacao(transacao.getTipoTransacao())
               .recorrente(transacao.isRecorrente())
               .efetivada(transacao.isEfetivada())
               .dataVencimento(transacao.getDataVencimento())
               .dataLancamento(transacao.getDataEfetivado())
               .categoria(getCategoria())
               .conta(getConta())
               .fatura(getFatura())
               .build();

    }

    public Transacao toTransacao(TransacaoDTO transacaoDTO){
        return new Transacao(null, transacaoDTO.getDescricao(), transacaoDTO.observacao, transacaoDTO.valor,
                transacaoDTO.tipoTransacao, transacaoDTO.recorrente, transacaoDTO.efetivada, transacaoDTO.dataVencimento,
                transacaoDTO.dataLancamento, transacaoDTO.dataEfetivado, transacaoDTO.categoria, transacaoDTO.conta,
                transacaoDTO.fatura);


    }


}
