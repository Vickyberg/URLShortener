package com.volacode.URLShortener.services;

import com.volacode.URLShortener.data.models.URLLink;
import com.volacode.URLShortener.data.repositories.URLRepository;
import com.volacode.URLShortener.dtos.reponses.GetLongURLResponse;
import com.volacode.URLShortener.dtos.reponses.GetShortURLResponse;
import com.volacode.URLShortener.dtos.requests.GetShortURLRequest;
import com.volacode.URLShortener.utils.IDConverter;
import io.github.cdimascio.dotenv.Dotenv;
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

        Dotenv dotenv = Dotenv.configure().directory("C:\\Users\\Olamide\\Desktop\\URLShortener\\URLShortener\\src\\main\\java\\com\\volacode\\URLShortener\\assets\\.env").filename(".env").load();

        GetShortURLResponse response = new GetShortURLResponse();
        response.setShortURL(dotenv.get("LOCAL") + "/" + urlLink.getId());
        return response;
    }

    private String getId() {
        return IDConverter.convertRequestID(urlRepository.count());
    }

    @Override
    public GetLongURLResponse getLongURL(String shortURL) {
        String id =getRequestId(shortURL);
        GetLongURLResponse response = new GetLongURLResponse();
        response.setLongURL(urlRepository.findURLLinkById(id).getLink());

        return response;
    }

    private String getRequestId(String shortURL) {
        String[] compArray = shortURL.split("/");
        return  compArray[compArray.length -1];
    }

    @Override
    public Long numOfURLs() {
        return  urlRepository.count();
    }
}
