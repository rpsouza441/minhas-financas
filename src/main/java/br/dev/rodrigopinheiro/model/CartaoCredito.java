package br.dev.rodrigopinheiro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cartao_credito")
public class CartaoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "nome", nullable = true, length = 256)
    private String nome = "";

    @Column(name = "limite", nullable = false)
    private BigDecimal limite = BigDecimal.ZERO;

    @Column(name = "dia_fechamento", nullable = false)
    private BigDecimal diaFechamento = BigDecimal.ZERO;

    @Column(name = "dia_vencimento", nullable = false)
    private BigDecimal diaVencimento = BigDecimal.ZERO;

    @OneToMany(mappedBy = "cartaoCredito")
    private List<Fatura> faturaList;

}
