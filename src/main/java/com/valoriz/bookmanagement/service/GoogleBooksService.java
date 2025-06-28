package com.valoriz.bookmanagement.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoogleBooksService {

    public Map<String, Object> fetchBookDetailsByIsbn(String isbn) {
        String apiUrl = UriComponentsBuilder.fromHttpUrl("https://www.googleapis.com/books/v1/volumes")
                .queryParam("q", "isbn:" + isbn)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> apiResponse = restTemplate.getForObject(apiUrl, Map.class);
        Map<String, Object> responseMap = new HashMap<>();

        if (apiResponse != null && apiResponse.containsKey("items")) {
            List<?> items = (List<?>) apiResponse.get("items");

            for (Object itemObj : items) {
                Map<?, ?> item = (Map<?, ?>) itemObj;
                Map<?, ?> volumeInfo = (Map<?, ?>) item.get("volumeInfo");

                List<?> identifiers = (List<?>) volumeInfo.get("industryIdentifiers");
                if (identifiers != null) {
                    for (Object idObj : identifiers) {
                        Map<?, ?> idMap = (Map<?, ?>) idObj;

                        if (isbn.equals(idMap.get("identifier"))) {

                            responseMap.put("title", volumeInfo.get("title"));
                            responseMap.put("authors", volumeInfo.get("authors"));
                            responseMap.put("description", volumeInfo.get("description"));
                            responseMap.put("publishedDate", volumeInfo.get("publishedDate"));

                            if (volumeInfo.containsKey("imageLinks")) {
                                Map<?, ?> imageLinks = (Map<?, ?>) volumeInfo.get("imageLinks");
                                responseMap.put("thumbnail", imageLinks.get("thumbnail"));
                            }

                            return responseMap;
                        }
                    }
                }
            }
        }

        responseMap.put("error", "No matching book found for exact ISBN.");
        return responseMap;
    }
}
