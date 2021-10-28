/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.G8.Grupo01.Reto5.controller;


import com.sa.G8.Grupo01.Reto5.entity.Score;
import com.sa.G8.Grupo01.Reto5.service.ScoreService;
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
@RequestMapping("/api/Score")   
public class ScoreController {
    
    @Autowired
    private ScoreService service;
    
    @GetMapping("/all")    
    public List<Score> findAllGScores(){
        return service.getScore();
    }
    
    @GetMapping("/Score/{id}")    
    public Score findScoresId(@PathVariable int id){
        return service.getScoreById(id);
    }
    
     @PostMapping("/save")
    public ResponseEntity addScore(@RequestBody Score score){
        service.saveScore(score);
        return ResponseEntity.status(201).build();
    }
        
    @PutMapping("/update")
       public ResponseEntity updateProduct(@RequestBody Score score){
       service.updateScore(score);
       return ResponseEntity.status(201).build();
    }
       
    @DeleteMapping("/{id}")
      public ResponseEntity deleteScore(@PathVariable int id){
           service.deleteScore(id);
           return ResponseEntity.status(204).build();
      }
    
}
