package com.sistematizacao.empresadianome.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sistematizacao.empresadianome.models.EntregadorModels;

// Definindo uma interface que esta extendendo o objeto JpaRepository
@Repository
public interface EntregadorRepository extends JpaRepository<EntregadorModels, Long> {
    
}
