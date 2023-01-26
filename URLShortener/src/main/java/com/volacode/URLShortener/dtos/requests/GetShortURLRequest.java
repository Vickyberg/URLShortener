package com.volacode.URLShortener.dtos.requests;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@NoArgsConstructor
public class GetShortURLRequest {


    @NotNull(message = "URL cannot be null")
    @URL(message = "URL is invalid")
    @NotEmpty(message = "URL cannot be empty")
    String longURL;

}
