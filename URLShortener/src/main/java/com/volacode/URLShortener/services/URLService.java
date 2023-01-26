package com.volacode.URLShortener.services;

import com.volacode.URLShortener.dtos.reponses.GetLongURLResponse;
import com.volacode.URLShortener.dtos.reponses.GetShortURLResponse;
import com.volacode.URLShortener.dtos.requests.GetLongURLRequest;
import com.volacode.URLShortener.dtos.requests.GetShortURLRequest;

public interface URLService {

    GetShortURLResponse getShortURL(GetShortURLRequest getURLRequest);

    GetLongURLResponse getLongURL(String shortURL);

    Long numOfURLs();
}
