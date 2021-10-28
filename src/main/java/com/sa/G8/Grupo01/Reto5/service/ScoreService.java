/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.G8.Grupo01.Reto5.service;




import com.sa.G8.Grupo01.Reto5.entity.Score;
import com.sa.G8.Grupo01.Reto5.repository.ScoreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Novosix
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository repository;
    
    public Score saveScore (Score score){
       return repository.save(score);
    }
    
    public List<Score> getScore(){
        return repository.findAll();
    }
    
    public Score getScoreById(int id){
        return repository.findById(id).orElse(null);
    }
    
      
    public String deleteScore(int id){
        repository.deleteById(id);
        return "Puntaje removido "+id;
    }
    
    public Score updateScore(Score Score){
        Score existingScore=repository.findById(Score.getIdScore()).orElse(null);
       existingScore.setMessage(Score.getMessage());
       existingScore.setValue(Score.getValue());
       return repository.save(existingScore);
    }
    

}
