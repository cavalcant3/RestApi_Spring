package com.example.RestApi_Spring.controller;

import com.example.RestApi_Spring.util.DateUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

public class AnimeController {
    private final DateUtil dateUtil;
    private final AnimeService animeService;

    public AnimeController(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    @GetMapping
    public ResponseEntity<List<Anime>> list(){
        log.info(dateUtil.formatLocalDateTimeToDataBaseTime(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity.ok(animeService.findById(id){
        return ResponseEntity.ok(animeService.findById(id));
    }
}
