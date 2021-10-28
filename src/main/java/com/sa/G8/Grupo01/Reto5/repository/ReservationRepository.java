/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sa.G8.Grupo01.Reto5.repository;

import com.sa.G8.Grupo01.Reto5.entity.Client;
import com.sa.G8.Grupo01.Reto5.entity.Reservation;
import java.util.Calendar;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import org.springframework.data.repository.query.Param;

/**
 *
 * @author Novosix
 */
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
    
    
    @Query("SELECT r FROM Reservation r where startDate between :firstDate and :secondDate")
    List<Reservation> reportDates(@Param("firstDate")Calendar firstDate,@Param("secondDate")Calendar secondDate );
    
    public List<Reservation> findAllByStatus(String status);
    
    @Query ("SELECT r.client, COUNT(r.client) from Reservation as r group by r.client order by COUNT(r.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
}

