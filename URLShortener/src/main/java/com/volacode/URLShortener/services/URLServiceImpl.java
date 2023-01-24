package com.volacode.URLShortener.services;

import com.volacode.URLShortener.data.repositories.URLRepository;
import com.volacode.URLShortener.dtos.reponses.GetLongURLResponse;
import com.volacode.URLShortener.dtos.reponses.GetShortURlResponse;
import com.volacode.URLShortener.dtos.requests.GetShortURLRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class URLServiceImpl implements URLService{

    private  final URLRepository urlRepository;
    @Override
    public GetShortURlResponse getShortURL(GetShortURLRequest getShortURLRequest) {
        return null;
    }

    @Override
    public GetLongURLResponse getLongURL(String shortURL) {
        return null;
    }

    @Override
    public Long numOfURLs() {
        return  urlRepository.count();
    }
}
