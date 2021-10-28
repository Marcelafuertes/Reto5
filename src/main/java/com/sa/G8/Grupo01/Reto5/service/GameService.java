
package com.sa.G8.Grupo01.Reto5.service;
import com.sa.G8.Grupo01.Reto5.entity.Game;
import com.sa.G8.Grupo01.Reto5.repository.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Novosix
 */
@Service
public class GameService {
    @Autowired
    private GameRepository repository;
    
    public Game saveGame(Game game){
       return repository.save(game);
    }
    
    public List<Game> getGame(){
        return repository.findAll();
    }
    
    public Game getGameById(int id){
        return repository.findById(id).orElse(null);
    }
    
      
    public String deleteGame(int id){
        repository.deleteById(id);
        return "Juego removido "+id;
    }
    
    public Game updateGame(Game game){
        Game existingGame=repository.findById(game.getId()).orElse(null);
       existingGame.setDeveloper(game.getDeveloper());
       existingGame.setYear(game.getYear());
       existingGame.setName(game.getName());
       existingGame.setDescription(game.getDescription());
       return repository.save(existingGame);
    }
}