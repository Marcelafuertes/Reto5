/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.G8.Grupo01.Reto5.service;

import com.sa.G8.Grupo01.Reto5.entity.Admin;
import com.sa.G8.Grupo01.Reto5.repository.AdminRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Novosix
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;
    
    /**
     * Guardar
     */
    
    public Admin saveAdmin(Admin admin){
        return repository.save(admin);
    }
    
    /**
     * Mostrar todos los productos, aqui se debera hacer el get por cada una de las tablas que piden, games, admin...
     */
    
    public List<Admin> getAdmin(){
        return repository.findAll();
    }
    
    public Admin getAdminById(int idAdmin){
    return repository.findById(idAdmin).orElse(null);
    }
    
    public Admin updateAdmin(Admin admin){
        Admin existeAdmin=repository.findById(admin.getIdAdmin()).orElse(null);
        existeAdmin.setName(admin.getName());
        existeAdmin.setEmail(admin.getEmail());
        existeAdmin.setPassword(admin.getPassword());
        return repository.save(existeAdmin);
    }
    
    public String deleteAdmin(int id){
        repository.deleteById(id);
        return "Administrador Eliminado "+id;
    }
}
