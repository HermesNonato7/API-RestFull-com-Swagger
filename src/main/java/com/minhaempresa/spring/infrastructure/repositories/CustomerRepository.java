package com.minhaempresa.spring.infrastructure.repositories;

import com.minhaempresa.spring.infrastructure.models.Customer;
import com.minhaempresa.spring.infrastructure.models.pks.CustomerPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, CustomerPk> {
}
