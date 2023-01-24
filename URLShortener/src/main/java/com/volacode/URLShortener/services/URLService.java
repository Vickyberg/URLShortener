package com.volacode.URLShortener.services;

import com.volacode.URLShortener.dtos.reponses.GetLongURLResponse;
import com.volacode.URLShortener.dtos.reponses.GetShortURLResponse;
import com.volacode.URLShortener.dtos.requests.GetShortURLRequest;

public interface URLService {

    GetShortURLResponse getShortURL(GetShortURLRequest getShortURLRequest);

    GetLongURLResponse getLongURL(String shortURL);

    Long numOfURLs();
}
