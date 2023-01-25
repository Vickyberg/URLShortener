package com.volacode.URLShortener.services;

import com.volacode.URLShortener.data.models.URLLink;
import com.volacode.URLShortener.data.repositories.URLRepository;
import com.volacode.URLShortener.dtos.reponses.GetLongURLResponse;
import com.volacode.URLShortener.dtos.reponses.GetShortURLResponse;
import com.volacode.URLShortener.dtos.requests.GetShortURLRequest;
import com.volacode.URLShortener.exceptions.InvalidURLException;
import com.volacode.URLShortener.utils.IDConverter;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class URLServiceImpl implements URLService{

    private  final URLRepository urlRepository;
    @Override
    public GetShortURLResponse getShortURL(GetShortURLRequest getURLRequest) {
        isValidURL(getURLRequest.getLongURL());

        URLLink urlLink = new URLLink();
        urlLink.setLink(getURLRequest.getLongURL());
        urlLink.setId(generateID());
        urlRepository.save(urlLink);

        Dotenv dotenv = Dotenv.configure().directory("C:\\Users\\Olamide\\Desktop\\URLShortener\\URLShortener\\src\\main\\java\\com\\volacode\\URLShortener\\assets\\.env").filename(".env").load();

        GetShortURLResponse response = new GetShortURLResponse();
        response.setShortURL(dotenv.get("LOCAL") + "/" + urlLink.getId());
        return response;
    }

    @Override
    public GetLongURLResponse getLongURL(String shortURL) {
        String id = getRequestID(shortURL);

        GetLongURLResponse response = new GetLongURLResponse();
        response.setLongURL(urlRepository.findURLLinkById(id).getLink());
        return response;
    }

    private String getRequestID(String shortURL) {
        String[] compArray = shortURL.split("/");
        return compArray[compArray.length - 1];
    }

    @Override
    public Long numOfURLs() {
        return urlRepository.count();
    }

    private String generateID() {
        return IDConverter.convertRequestID(urlRepository.count());

    }


    private void isValidURL(String longURL) {
        if (!longURL.matches("^https?:\\/\\/(?:www.)?[-a-zA-Z\\d@:%._\\+~#=]{1,256}" +
                "\\.[a-zA-Z\\d9()]{1,6}\\b(?:[-a-zA-Z\\d@:%._\\+.~#?&\\/=]*)$")) {
            throw new InvalidURLException("Invalid link supplied. Please try again!!.");
        }


    }

}
