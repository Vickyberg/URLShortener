package com.volacode.URLShortener.controller;


import com.volacode.URLShortener.dtos.reponses.GetShortURLResponse;
import com.volacode.URLShortener.dtos.requests.GetShortURLRequest;
import com.volacode.URLShortener.exceptions.InvalidURLException;
import com.volacode.URLShortener.services.URLService;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class URLController  {



    private  final URLService urlService;


    @PostMapping("/")
    public ResponseEntity<?> getShortUrl(@RequestBody GetShortURLRequest getShortURLRequest){
        try {
            return new ResponseEntity<>(urlService.getShortURL(getShortURLRequest), HttpStatus.CREATED);
        }catch (InvalidURLException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{shortURL}")
    public ResponseEntity<Void> getLongURL(@PathVariable String shortURL) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(urlService.getLongURL(shortURL).getLongURL()));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}
