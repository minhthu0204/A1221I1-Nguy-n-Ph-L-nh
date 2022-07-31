package com.example.repository;

import com.example.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();
    void save(Song student);

    void delete(int id);
}
