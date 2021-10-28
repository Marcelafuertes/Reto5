
package com.sa.G8.Grupo01.Reto5.controller;

import com.sa.G8.Grupo01.Reto5.entity.Game;
import com.sa.G8.Grupo01.Reto5.service.GameService;
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
@RequestMapping("/api/Game")   
public class Gamecontroller {
    
    @Autowired
    private GameService service;
    
    @GetMapping("/all")    
    public List<Game> findAllGames(){
        return service.getGame();
    }
    
    @GetMapping("/Game/{id}")    
    public Game findGamesId(@PathVariable int id){
        return service.getGameById(id);
    }
    
     @PostMapping("/save")
    public ResponseEntity addGame(@RequestBody Game game){
        service.saveGame(game);
        return ResponseEntity.status(201).build();
    }
        
    @PutMapping("/update")
       public ResponseEntity updateProduct(@RequestBody Game game){
       service.updateGame(game);
       return ResponseEntity.status(201).build();
    }
       
    @DeleteMapping("/{id}")
      public ResponseEntity deleteGame(@PathVariable int id){
           service.deleteGame(id);
           return ResponseEntity.status(204).build();
      }
    
}
