package com.sistematizacao.empresadianome.models;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "entregador")
public class EntregadorModels implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "entregador_SEQ")
    @SequenceGenerator(name = "entregador_SEQ", sequenceName = "entregador_SEQ", allocationSize = 1)
    private Long id;

    public @NotNull Long getId() {
        return id != null ? id : 0; // ou qualquer valor padrão desejado
    }
    

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private Long cpf;

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    private double capacidadeveiculo;

    public double getCapacidadeveiculo() {
        return capacidadeveiculo;
    }

    public void setCapacidadeveiculo(double capacidadeveiculo) {
        this.capacidadeveiculo = capacidadeveiculo;
    }
}