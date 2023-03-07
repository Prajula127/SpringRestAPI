package com.example.song;

import org.springframework.web.bind.annotation.*;
import java.util.*;

/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
@RestController
public class SongController {
    SongService apiSong = new SongService();
    
    @GetMapping("/songs")
    public ArrayList<Song> getSongs() {
        return apiSong.getSongs();
    }
    
    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable("songId") int songId){
        return apiSong.getSongById(songId);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song){
        return apiSong.addSong(song);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable("songId") int songId, @RequestBody Song song){
        return apiSong.updateSong(songId, song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId){
        apiSong.deleteSong(songId);   
    }
}