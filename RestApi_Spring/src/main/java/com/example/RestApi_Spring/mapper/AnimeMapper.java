package com.example.RestApi_Spring.mapper;

import com.example.RestApi_Spring.Requests.AnimePostRequestBody;
import com.example.RestApi_Spring.Requests.AnimePutRequestBody;
import com.example.RestApi_Spring.domain.Anime;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);
    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);

}
