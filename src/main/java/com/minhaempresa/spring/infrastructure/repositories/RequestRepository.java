package com.minhaempresa.spring.infrastructure.repositories;

import com.minhaempresa.spring.infrastructure.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
