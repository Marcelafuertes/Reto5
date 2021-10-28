/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.G8.Grupo01.Reto5.controller;

import com.sa.G8.Grupo01.Reto5.entity.Message;
import com.sa.G8.Grupo01.Reto5.service.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/api/Message")   

public class MessageController {
    
    @Autowired
    private MessageService service;
    
    @GetMapping("/all")    
    public List<Message> findAllMessages(){
        return service.getMessage();
    }
    
    @GetMapping("/Message/{id}")    
    public Message findMessagesId(@PathVariable int id){
        return service.getMessageById(id);
    }
    
     @PostMapping("/save")
    public ResponseEntity addMessage(@RequestBody Message message){
        service.saveMessage(message);
        return ResponseEntity.status(201).build();
    }
        
    @PutMapping("/update")
       public ResponseEntity updateProduct(@RequestBody Message message){
       service.updateMessage(message);
       return ResponseEntity.status(201).build();
    }
       
    @DeleteMapping("/{id}")
      public ResponseEntity deleteMessage(@PathVariable int id){
           service.deleteMessage(id);
           return ResponseEntity.status(204).build();
      }
    
    
}
