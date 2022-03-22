package com.example.RestApi_Spring.service;

import com.example.RestApi_Spring.Requests.AnimePostRequestBody;
import com.example.RestApi_Spring.Requests.AnimePutRequestBody;
import com.example.RestApi_Spring.domain.Anime;
import com.example.RestApi_Spring.mapper.AnimeMapper;
import com.example.RestApi_Spring.repository.AnimeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AnimeService {
    private final AnimeRepository animeRepository;

    //  private final AnimeRepository animeRepository
    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestExecption(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));


    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {


        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestExecption(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
       Anime savedAnime =  findByIdOrThrowBadRequestExecption(animePutRequestBody.getId());
       Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
       anime.setId(savedAnime.getId());
       animeRepository.save(anime);
    }
}
