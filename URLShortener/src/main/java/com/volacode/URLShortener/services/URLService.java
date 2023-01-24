package com.volacode.URLShortener.services;

import com.volacode.URLShortener.dtos.reponses.GetLongURLResponse;
import com.volacode.URLShortener.dtos.reponses.GetShortURlResponse;
import com.volacode.URLShortener.dtos.requests.GetShortURLRequest;

public interface URLService {

    GetShortURlResponse getShortURL(GetShortURLRequest getShortURLRequest);

    GetLongURLResponse getLongURL(String shortURL);

    Long numOfURLs();
}
