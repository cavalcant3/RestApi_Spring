package com.example.RestApi_Spring.repository;

import com.example.RestApi_Spring.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
