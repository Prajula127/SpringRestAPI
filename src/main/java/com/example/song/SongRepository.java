// Write your code here

package com.example.song;
import java.util.*;

interface SongRepository {
    ArrayList<Song> getSongs();
    Song getSongById(int songId);
    Song addSong(Song song);
    Song updateSong(int songId, Song song);

    void deleteSong(int songId);

}