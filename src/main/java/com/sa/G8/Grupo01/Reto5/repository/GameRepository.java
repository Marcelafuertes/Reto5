
package com.sa.G8.Grupo01.Reto5.repository;

import com.sa.G8.Grupo01.Reto5.entity.Game;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Novosix
 */
public interface GameRepository extends JpaRepository<Game, Integer>{
 
}

