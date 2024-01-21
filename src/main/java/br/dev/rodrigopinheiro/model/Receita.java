package br.dev.rodrigopinheiro.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "receita")
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;

    @Column(name="descricao", nullable = true, length = 256)
    private String descricao="";

    @Column(name="observacao", nullable = true, length = 256)
    private String observacao= "";

    @Column(name="valor", nullable = false)
    private BigDecimal valor= BigDecimal.ZERO;

    private boolean recorrente = false;

    private boolean efetivada= false;

    @Temporal(TemporalType.DATE)
    @Column(name="data_vencimento", nullable = false)
    private Date dataVencimento = null;

    @Temporal(TemporalType.DATE)
    @Column(name="data_lancamento", nullable = false)
    private Date dataLancamento = null;

    @Temporal(TemporalType.DATE)
    @Column(name="data_efetivado", nullable = true)
    private Date dataEfetivado = null;


    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
