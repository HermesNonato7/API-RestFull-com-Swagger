package com.minhaempresa.spring.infrastructure.repositories;

import com.minhaempresa.spring.infrastructure.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
