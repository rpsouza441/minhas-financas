package br.dev.rodrigopinheiro.dto;

import br.dev.rodrigopinheiro.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReceitaDTO {

    private String descricao="";

    private String observacao= "";

    private BigDecimal valor= BigDecimal.ZERO;

    private boolean recorrente = false;

    private boolean efetivada= false;

    private Date dataVencimento = null;

    private Date dataLancamento = null;

     private Date dataEfetivado = null;

    private Categoria categoria;

}
