package br.dev.rodrigopinheiro.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Data
@Entity(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="nome", nullable = true, length = 256)
    private String nome;

}
