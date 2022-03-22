package com.example.RestApi_Spring.controller;

import com.example.RestApi_Spring.Requests.AnimePostRequestBody;
import com.example.RestApi_Spring.Requests.AnimePutRequestBody;
import com.example.RestApi_Spring.domain.Anime;
import com.example.RestApi_Spring.service.AnimeService;
import com.example.RestApi_Spring.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    private final DateUtil dateUtil;
    private final AnimeService animeService;
// path vazio---


    @GetMapping
    public ResponseEntity<List<Anime>> list() {
        //  log.info(dateUtil.formatLocalDateTimeToDataBaseTime(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id){
        return ResponseEntity.ok(animeService.findByIdOrThrowBadRequestExecption(id));
    }


    @GetMapping(path = "/find")
//    Request param recebe o nome e se testa com "/find?name=exemplodeNomeAqui"
//    Ele é responsável por esse papel porque path variable daria ambiguidade no projeto
    public ResponseEntity<List<Anime>> findByName(@RequestParam(required = false) String name) {
        return ResponseEntity.ok(animeService.findByName(name));
    }
    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody AnimePostRequestBody animePostRequestBody){

        return new ResponseEntity<>(animeService.save(animePostRequestBody), HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnimePutRequestBody animePutRequestBody) {
        animeService.replace(animePutRequestBody);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
