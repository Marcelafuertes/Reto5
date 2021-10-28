/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.G8.Grupo01.Reto5.controller;

import com.sa.G8.Grupo01.Reto5.Results.ReportClients;
import com.sa.G8.Grupo01.Reto5.Results.ReportStatus;
import com.sa.G8.Grupo01.Reto5.entity.Reservation;
import com.sa.G8.Grupo01.Reto5.service.ReservationService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
@RequestMapping("/api/Reservation")   

public class ReservationController {
    
    @Autowired
    private ReservationService service;
    
    @GetMapping("/all")    
    public List<Reservation> findAllReservations(){
        return service.getReservation();
    }
    
    @GetMapping("/Reservation/{id}")    
    public Reservation findReservationsId(@PathVariable int id){
        return service.getReservationById(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity addReservation(@RequestBody Reservation reservation){
        service.saveReservation(reservation);
        return ResponseEntity.status(201).build();
    }
        
    @PutMapping("/update")
    public ResponseEntity updateProduct(@RequestBody Reservation reservation){
       service.updateReservation(reservation);
       return ResponseEntity.status(201).build();
    }
       
    @DeleteMapping("/{id}")
    public ResponseEntity deleteReservation(@PathVariable int id){
           service.deleteReservation(id);
           return ResponseEntity.status(204).build();
    }
    
    @GetMapping("/report-dates/{firstDate}/{secondDate}")
    public List<Reservation> reportDates(@PathVariable String firstDate,@PathVariable String secondDate ){
         Calendar Date1 = Calendar.getInstance();
         Calendar Date2 = Calendar.getInstance();
        try {           
            SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
            Date1.setTime(in.parse(firstDate));
            SimpleDateFormat fn = new SimpleDateFormat("yyyy-MM-dd");
            Date2.setTime(fn.parse(secondDate));
                        
        } catch (ParseException ex) {

        }
        if(Date1.before(Date2)){
            return service.reportDates(Date1, Date2);
        }
        else{
            return new ArrayList<>();
        }               
    }
    
    @GetMapping("/report-clients")
    public List<ReportClients> reportClients(){
            
        return service.getReportClients();
    }
    
    @GetMapping("/report-status")
    public ReportStatus reportStatus(){
            
        return service.getReportStatus();
    }
    
}
