package br.dev.rodrigopinheiro.dto;

import br.dev.rodrigopinheiro.model.CartaoCredito;
import br.dev.rodrigopinheiro.model.DespesaCartao;
import br.dev.rodrigopinheiro.model.Transacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FaturaDTO {
    private UUID uuid;

    private String mes = "";

    private String ano = "";

    private List<DespesaCartao> despesaCartaoList;

    private CartaoCredito cartaoCredito;

    private Transacao transacao;


}
