package br.dev.rodrigopinheiro.model;

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
@Entity
@Table(name = "fatura")
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "mes", nullable = true, length = 256)
    private String mes = "";

    @Column(name = "ano", nullable = true, length = 256)
    private String ano = "";

    @OneToMany(mappedBy = "fatura", fetch = FetchType.LAZY)
    private List<DespesaCartao> despesaCartaoList;

    @ManyToOne
    @JoinColumn(name = "cartao_credito_id")
    private CartaoCredito cartaoCredito;

    @OneToOne(cascade = CascadeType.ALL)
    //@MapsId
    @JoinColumn(name = "transacao_id", referencedColumnName = "id")
    private Transacao transacao;


}
