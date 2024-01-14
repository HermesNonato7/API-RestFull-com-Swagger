package com.minhaempresa.spring.application.services;

import com.minhaempresa.spring.application.dtos.RequestDTO;
import com.minhaempresa.spring.application.services.exceptions.DatabaseException;
import com.minhaempresa.spring.application.services.exceptions.ResourceNotFoundException;
import com.minhaempresa.spring.infrastructure.models.Customer;
import com.minhaempresa.spring.infrastructure.models.Pizza;
import com.minhaempresa.spring.infrastructure.models.Request;
import com.minhaempresa.spring.infrastructure.models.pks.CustomerPk;
import com.minhaempresa.spring.infrastructure.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

/*
    Esta classe representa os serviços disponíveis para o pedido.
*/
@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private CustomerService customerService;

    public Request requestRegistration(RequestDTO requestDTO) {
        List<Pizza> pizzas = pizzaService.findAllById(requestDTO.getPizzasId());
        Customer customer = customerService.findById(new CustomerPk(requestDTO.getTelephone(), requestDTO.getCpf()));
        Request request = new Request(LocalDateTime.now(ZoneId.of("UTC")), customer, pizzas, requestDTO.getPrice());
        return requestRepository.save(request);
    }

    public Request findById(Long id) {
        Optional<Request> optional = requestRepository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    public Request update(Long id, RequestDTO requestDTO) {
        try {
            Request entity = requestRepository.getReferenceById(id);
            updateEntity(entity, requestDTO);
            return requestRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateEntity(Request entity, RequestDTO request) {
        entity.setPrice(request.getPrice());
    }

    public void deleteById(Long id) {
        try {
            requestRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
