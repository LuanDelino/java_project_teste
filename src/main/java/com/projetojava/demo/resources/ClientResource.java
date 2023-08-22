package com.projetojava.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojava.demo.domain.Client;
import com.projetojava.demo.services.ClientService;


@RestController
@RequestMapping(value = "/clientes")
public class ClientResource {
    
    @Autowired
    private ClientService _clientService;

    @GetMapping("/{id}")
    public ResponseEntity<?> listById(@PathVariable Integer id) {

        Client obj = _clientService.search(id);

        return ResponseEntity.ok().body(obj);
    }

    
}
