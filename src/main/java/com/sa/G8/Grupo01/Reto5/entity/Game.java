
package com.sa.G8.Grupo01.Reto5.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Novosix
 */
/**
 * anotaciones para determinar a game como entidad
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
/**
 * crea la tabla game
 */
@Table(name="game")
/**
 * crea la clase game
 */
public class Game {
    /**
    * determina el id y el tipo de generacion del mismo
    */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    /**
    * atribudo id que es la llave primaria
    */
    private int id;
    /**
    * atribudo nombre del juego
    */
    private String name;
    /**
    * quien desarrolo el juego
    */    
    private String developer;
    /**
    * en que año se creo
    */  
    private int year;
    /**
    * descripcion del juego
    */  
    private String description;
    /**
    * anotaciones para hacer la relacion de mucho a uno con categoria
    */  
    @ManyToOne
    @JoinColumn(name = "Category_id")
    @JsonIgnoreProperties("games")
    /**
    * el atributo que muestra de categoria
    */  
    private Category category;
    /**
    * anotaciones para hacer la relacion uno a muchos con mensajes
    */  
     @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="game",orphanRemoval = true)
    @JsonIgnoreProperties({"game","client"})
    /**
    * la lista de mensajes que se muestra
    */
    private List<Message> messages;
    /**
    * anotaciones para hacer la relacion uno a muchos con reservaciones
    */  
     @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="game",orphanRemoval = true)
    @JsonIgnoreProperties({"game"})
     /**
    * la lista de reservaciones que muestra
    */
    private List<Reservation> reservations;
    

}
