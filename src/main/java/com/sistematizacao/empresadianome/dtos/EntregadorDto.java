package com.sistematizacao.empresadianome.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EntregadorDto(@JsonProperty   Long id, // O uso de @JsonIgnore fará com que o campo id seja ignorado durante a serialização JSON no POST.
                @NotBlank String nome,
                @NotNull Long cpf,
                @NotNull double capacidadeveiculo) {

}