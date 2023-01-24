package com.volacode.URLShortener.services;

import com.volacode.URLShortener.dtos.reponses.GetLongURLResponse;
import com.volacode.URLShortener.dtos.reponses.GetShortURlResponse;
import com.volacode.URLShortener.dtos.requests.GetShortURLRequest;
import org.springframework.stereotype.Service;


@Service
public class URLServiceImpl implements URLService{
    @Override
    public GetShortURlResponse getShortURL(GetShortURLRequest getShortURLRequest) {
        return null;
    }

    @Override
    public GetLongURLResponse getLongURL(String shortURL) {
        return null;
    }
}
