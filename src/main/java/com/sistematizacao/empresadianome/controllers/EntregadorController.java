package com.sistematizacao.empresadianome.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistematizacao.empresadianome.models.EntregadorModels;

import jakarta.validation.Valid;

import com.sistematizacao.empresadianome.Repositories.EntregadorRepository;
import com.sistematizacao.empresadianome.dtos.EntregadorDto;

@RestController
public class EntregadorController {
    @Autowired
    EntregadorRepository entregadorRepository;

    @GetMapping("/entregador")
    public ResponseEntity<List<EntregadorDto>> listar() {
        List<EntregadorModels> entregadorList = entregadorRepository.findAll();

        List<EntregadorDto> entregadorDTOList = new ArrayList<>();
        for (EntregadorModels entregador : entregadorList) {
            EntregadorDto entregadorDTO = new EntregadorDto(
                    entregador.getId(),
                    entregador.getNome(),
                    entregador.getCpf(),
                    entregador.getCapacidadeveiculo());
            entregadorDTOList.add(entregadorDTO);
        }

        return ResponseEntity.status(HttpStatus.OK).body(entregadorDTOList); // 200
    }

    @PostMapping("/entregador")
    public ResponseEntity<EntregadorModels> salvar(@RequestBody @Valid EntregadorDto entregadorDto) {
        var entregadorModels = new EntregadorModels();
        BeanUtils.copyProperties(entregadorDto, entregadorModels);
        EntregadorModels savedEntregador = entregadorRepository.save(entregadorModels);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntregador); // 201
    }

    @GetMapping("/entregador/{id}")
public ResponseEntity<Object> detalhar(@PathVariable(value = "id") Long id) {
    Optional<EntregadorModels> entregador = entregadorRepository.findById(id);
    if (entregador.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado");
    }

    EntregadorModels value = entregador.get();
    EntregadorDto entregadorDTO = new EntregadorDto(
            value.getId(),
            value.getNome(),
            value.getCpf(),
            value.getCapacidadeveiculo());

    return ResponseEntity.status(HttpStatus.OK).body(entregadorDTO);
}


    @PutMapping("/entregador/{id}")
    public ResponseEntity<Object> atualizarEntregador(@PathVariable(value = "id") Long id,
            @RequestBody @Valid EntregadorDto entregadorDto) {
        Optional<EntregadorModels> entregador = entregadorRepository.findById(id);
        if (entregador.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado");
        }
        var entregadorModels = entregador.get();
        BeanUtils.copyProperties(entregadorDto, entregadorModels);
        return ResponseEntity.status(HttpStatus.OK).body(entregadorRepository.save(entregadorModels));
    }

    @DeleteMapping("/entregador/{id}")
    public ResponseEntity<Object> deletarEntregador(@PathVariable(value = "id") Long id) {
        Optional<EntregadorModels> entregador = entregadorRepository.findById(id);
        if (entregador.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado");
        }
        entregadorRepository.delete(entregador.get());
        return ResponseEntity.status(HttpStatus.OK).body("O Entregador foi excluído.");
    }
}