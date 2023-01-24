package com.volacode.URLShortener.services;

import com.volacode.URLShortener.dtos.reponses.GetShortURLResponse;
import com.volacode.URLShortener.dtos.requests.GetShortURLRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class URLServiceImplTest {

    @Autowired
    private  URLService urlService;


    @Test
    void testThatWeCanGetLongURLAndConvertToShortURL() {

        GetShortURLRequest request = new GetShortURLRequest();
        request.setLongURL("https://wehavelongurl.com");
        GetShortURLResponse response = urlService.getShortURL(request);
        assertEquals(1,urlService.numOfURLs());
        assertEquals("https://shortUrl.com", response.getShortURL());

    }

    @Test
    void getLongURL() {
    }
}