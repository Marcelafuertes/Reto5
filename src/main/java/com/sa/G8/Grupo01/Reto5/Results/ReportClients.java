/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.G8.Grupo01.Reto5.Results;

import com.sa.G8.Grupo01.Reto5.entity.Client;
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
public class ReportClients {
   private long total;
   private Client client;       
}
