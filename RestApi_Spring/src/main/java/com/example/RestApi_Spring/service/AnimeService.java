package com.example.RestApi_Spring.service;

import com.example.RestApi_Spring.Requests.AnimePostRequestBody;
import com.example.RestApi_Spring.Requests.AnimePutRequestBody;
import com.example.RestApi_Spring.domain.Anime;
import com.example.RestApi_Spring.repository.AnimeRepository;
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

    public Anime findByIdOrThrowBadRequestExecption(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));


    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {


        return animeRepository.save(Anime.builder().name(animePostRequestBody.getName()).build());
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestExecption(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
//        ou posso criar uma variavel pra armazenar o id dessa verificação e salvar ela no repository
        findByIdOrThrowBadRequestExecption(animePutRequestBody.getId());
        Anime anime = Anime.builder()
                .id(animePutRequestBody.getId())
                .name(animePutRequestBody.getName()).build();
       animeRepository.save(anime);
    }
}
