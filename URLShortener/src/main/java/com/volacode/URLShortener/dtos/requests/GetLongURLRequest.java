package com.volacode.URLShortener.dtos.requests;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetLongURLRequest {

    String shortURL;
}
