/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.G8.Grupo01.Reto5.service;

import com.sa.G8.Grupo01.Reto5.entity.Client;
import com.sa.G8.Grupo01.Reto5.repository.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marce
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    
    /**
     * Guardar
     */
    
    public Client saveClient(Client client){
        return repository.save(client);
    }
    
    /**
     * Mostrar todos los productos, aqui se debera hacer el get por cada una de las tablas que piden, games, client...
     */
    
    public List<Client> getClient(){
        return repository.findAll();
    }
    
    public Client getClientById(int idClient){
    return repository.findById(idClient).orElse(null);
    }
    
    public Client updateClient(Client client){
        Client existeClient=repository.findById(client.getIdClient()).orElse(null);
        existeClient.setName(client.getName());
        existeClient.setEmail(client.getEmail());
        existeClient.setAge(client.getAge());
        existeClient.setPassword(client.getPassword());
        return repository.save(existeClient);
    }
    
    public String deleteClient(int id){
        repository.deleteById(id);
        return "Cliente Eliminado "+id;
    }
}
