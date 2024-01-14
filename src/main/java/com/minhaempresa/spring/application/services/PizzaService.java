package com.minhaempresa.spring.application.services;

import com.minhaempresa.spring.application.services.exceptions.DatabaseException;
import com.minhaempresa.spring.application.services.exceptions.ResourceNotFoundException;
import com.minhaempresa.spring.infrastructure.models.Pizza;
import com.minhaempresa.spring.infrastructure.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/*
    Esta classe representa os serviços disponíveis para o cadastro da pizza.
*/
@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public Pizza pizzaRegistration(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Pizza findById(Long id) {
        Optional<Pizza> optional = pizzaRepository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    public List<Pizza> findAllById(List<Long> id) {
        return pizzaRepository.findAllById(id);
    }


    public Pizza update(Long id, Pizza pizza) {
        try {
            Pizza entity = pizzaRepository.getReferenceById(id);
            updateEntity(entity, pizza);
            return pizzaRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateEntity(Pizza entity, Pizza pizza) {
        entity.setPrice(pizza.getPrice());
        entity.setName(pizza.getName());
    }

    public void deleteById(Long id) {
        try {
            pizzaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}