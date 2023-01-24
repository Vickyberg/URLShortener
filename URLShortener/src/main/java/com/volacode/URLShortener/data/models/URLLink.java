package com.volacode.URLShortener.data.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@NoArgsConstructor
@Document("URL Links")
public class URLLink {

    @Id
    String id;
    String link;
}
