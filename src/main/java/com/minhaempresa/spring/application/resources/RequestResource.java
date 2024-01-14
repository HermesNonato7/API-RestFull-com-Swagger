package com.minhaempresa.spring.application.resources;

import com.minhaempresa.spring.application.dtos.RequestDTO;
import com.minhaempresa.spring.application.services.RequestService;
import com.minhaempresa.spring.infrastructure.models.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestResource {
    @Autowired
    private RequestService requestService;

    @GetMapping //endpoint
    public ResponseEntity<List<Request>> findAll() {
        List<Request> requests = requestService.findAll();
        return ResponseEntity.ok().body(requests);
    }

    @GetMapping(value = "/{id}")//endpoint
    public ResponseEntity<Request> findById(@PathVariable Long id) {
        Request request = requestService.findById(id);
        return ResponseEntity.ok().body(request);
    }

    @PostMapping//endpoint
    public ResponseEntity<Request> insert(@RequestBody RequestDTO requestDTO) {
        Request request = requestService.requestRegistration(requestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping(value = "/{id}")//endpoint
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        requestService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")//endpoint
    public ResponseEntity<Request> update(@PathVariable Long id, @RequestBody RequestDTO requestDTO) {
        Request request = requestService.update(id, requestDTO);
        return ResponseEntity.ok().body(request);
    }
}