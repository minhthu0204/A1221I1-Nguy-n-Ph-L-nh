package com.example.service;

import com.example.model.Song;
import com.example.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class SongServiceImpl implements ISongService {

        @Autowired
        private ISongRepository repository;

        @Override
        public List<Song> findAll() {
            return repository.findAll();
        }

        @Override
        public void save(Song song) {
            repository.save(song);
        }

        @Override
        public void delete(int id) {
            repository.delete(id);
        }
    }

