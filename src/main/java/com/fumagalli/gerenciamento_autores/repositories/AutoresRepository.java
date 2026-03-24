package com.fumagalli.gerenciamento_autores.repositories;

import com.fumagalli.gerenciamento_autores.models.AutoresModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoresRepository extends JpaRepository<AutoresModel, Long> {
}
