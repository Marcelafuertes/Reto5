/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.G8.Grupo01.Reto5.controller;

import com.sa.G8.Grupo01.Reto5.entity.Admin;
import com.sa.G8.Grupo01.Reto5.service.AdminService;
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

/**
 *
 * @author Novosix
 */
@RestController
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/api/Admin")
public class AdminController {
    @Autowired
    private AdminService service;
    
    @GetMapping("/all")
    public List<Admin> findAllAdmin(){
        return service.getAdmin();
    }
    
    @GetMapping("/Admin/{id}")    
    public Admin findAdminId(@PathVariable int id){
        return service.getAdminById(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity addAdmin(@RequestBody Admin admin){
        service.saveAdmin(admin);
        return ResponseEntity.status(201).build();
    }
    @PutMapping("/update")
    public ResponseEntity updateAdmin(@RequestBody Admin admin){
        service.updateAdmin(admin);
        return ResponseEntity.status(201).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAdmin(@PathVariable int id){
        service.deleteAdmin(id);
        return ResponseEntity.status(204).build();
    }
}

