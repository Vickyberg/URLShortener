package com.volacode.URLShortener.services;

import com.volacode.URLShortener.data.models.URLLink;
import com.volacode.URLShortener.data.repositories.URLRepository;
import com.volacode.URLShortener.dtos.reponses.GetLongURLResponse;
import com.volacode.URLShortener.dtos.reponses.GetShortURLResponse;
import com.volacode.URLShortener.dtos.requests.GetShortURLRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@AllArgsConstructor
public class URLServiceImpl implements URLService{

    private  final URLRepository urlRepository;
    @Override
    public GetShortURLResponse getShortURL(GetShortURLRequest getURLRequest) {
        URLLink urlLink = new URLLink();
        urlLink.setLink(getURLRequest.getLongURL());
        urlLink.setId(getId());
        urlRepository.save(urlLink);

        GetShortURLResponse response = new GetShortURLResponse();
        response.setShortURL();
        return null;
    }

    private String getId() {
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
