package br.dev.rodrigopinheiro.model;

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
@Entity(name = "despesa_cartao")
public class DespesaCartao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "descricao", nullable = true, length = 256)
    private String descricao = "";

    @Column(name = "observacao", nullable = true, length = 256)
    private String observacao = "";

    @Column(name = "valor", nullable = false)
    private BigDecimal valor = BigDecimal.ZERO;

    @Column(name = "recorrente", nullable = false)
    private boolean recorrente = false;

    @Column(name = "efetivada", nullable = false)
    private boolean efetivada = false;

    @Temporal(TemporalType.DATE)
    @Column(name = "mes_ano_fatura", nullable = false)
    private Date mesAnoFatura = null;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_lancamento", nullable = false)
    private Date dataLancamento = null;


    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    //TO-DO
    /*   @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cartao_de_credito_despesa",
            joinColumns = @JoinColumn(name = "despesa_id"),
            inverseJoinColumns = @JoinColumn(name = "cartao_id")
    )*/
    @ManyToOne
    @JoinColumn(name = "cartao_credito")
    private CartaoCredito cartaoCredito;

}
