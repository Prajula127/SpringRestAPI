// Write your code here
package com.example.player;
import java.util.*;

interface PlayerRepository {
    ArrayList<Player> getPlayer();
    Player getPlayerById(int playerId);
    Player addPlayer(Player player);
    Player updatePlayer(int playerId, Player player);
    void deletePlayer(int playerId);
}