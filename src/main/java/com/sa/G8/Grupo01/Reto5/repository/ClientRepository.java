/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.G8.Grupo01.Reto5.repository;

import com.sa.G8.Grupo01.Reto5.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author marcela
 */
public interface ClientRepository extends JpaRepository<Client,Integer> {
    
}
