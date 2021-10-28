/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.G8.Grupo01.Reto5.service;

import com.sa.G8.Grupo01.Reto5.entity.Message;
import com.sa.G8.Grupo01.Reto5.repository.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lili Diaz
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;
    
    public Message saveMessage(Message message){
       return repository.save(message);
    }
    
    public List<Message> getMessage(){
        return repository.findAll();
    }
    
    public Message getMessageById(int id){
        return repository.findById(id).orElse(null);
    }
    
      
    public String deleteMessage(int id){
        repository.deleteById(id);
        return "Mensaje borrado "+id;
    }
    
    public Message updateMessage(Message message){
       Message existingMessage=repository.findById(message.getIdMessage()).orElse(null);
       existingMessage.setMessageText(message.getMessageText());
       return repository.save(existingMessage);
    }

    
}
