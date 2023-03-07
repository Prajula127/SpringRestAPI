/*

 * You can use the following import statements
 */

package com.example.song;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

// Don't modify the below code
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();
    int songId = 6;

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    // Don't modify the above code

    // Write your code here
    @Override
    public ArrayList<Song> getSongs() {
        Collection<Song> songObj = playlist.values();
        ArrayList<Song> song = new ArrayList<>(songObj);
        return song;
    }

    @Override
    public Song getSongById(int songId) {
        Song song = playlist.get(songId);

        if (song == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return song;
    }
    
    @Override
    public Song addSong(Song song){
        song.setSongId(songId);
        playlist.put(songId, song);
        songId += 1;
        return song;
    }
    
    @Override
    public Song updateSong(int songId, Song song){
        Song sId = playlist.get(songId);

        if (sId == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (song.getSongName() != null){
            sId.setSongName(song.getSongName());
        }

        if (song.getLyricist() != null){
            song.setLyricist(song.getLyricist());
        }

        if (song.getSinger() != null){
            sId.setSinger(song.getSinger());
        }

        if (song.getMusicDirector() != null){
            sId.setMusicDirector(song.getMusicDirector());
        }
        return sId;
    }

    @Override
    public void deleteSong(int songId) {
        Song song = playlist.get(songId);

        if (song == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            playlist.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}