package com.example.RestApi_Spring.repository;

import com.example.RestApi_Spring.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

//    exemplo de método para o banco
    List<Anime> findByName(String name);
}
