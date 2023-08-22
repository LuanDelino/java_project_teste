package com.projetojava.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojava.demo.domain.Client;
import com.projetojava.demo.repositories.ClientRepository;
import com.projetojava.demo.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository _clientRepository;

    public Client search(Integer id) {
        Optional<Client> obj = _clientRepository.findById(id);

        return obj.orElseThrow(
            () -> new ObjectNotFoundException("Objeto nao encontrado! Id: " + id)
        );
    }

}
