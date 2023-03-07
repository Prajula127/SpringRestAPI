/*
 * You can use the following import statements
 * 
 *
 * 
 */
 // Write your code here.
package com.example.player;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class PlayerController {
    PlayerService apiPlayer = new PlayerService();

    @GetMapping("/players")
    public ArrayList<Player> getPlayer(){
        return apiPlayer.getPlayer();
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayerById(@PathVariable("playerId")int playerId){
        return apiPlayer.getPlayerById(playerId);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        return apiPlayer.addPlayer(player);
    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player player){
        return apiPlayer.updatePlayer(playerId, player); 
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId){
        apiPlayer.deletePlayer(playerId);
    }
    
}
