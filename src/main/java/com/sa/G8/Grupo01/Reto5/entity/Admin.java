/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.G8.Grupo01.Reto5.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Novosix
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="admin")

public class Admin {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idAdmin;
    private String name;
    private String email;
    private String password;

}
