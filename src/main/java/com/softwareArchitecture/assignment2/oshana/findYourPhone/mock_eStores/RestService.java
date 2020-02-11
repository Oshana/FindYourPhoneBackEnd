package com.softwareArchitecture.assignment2.oshana.findYourPhone.mock_eStores;

import com.softwareArchitecture.assignment2.oshana.findYourPhone.Phone;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Phone getDataFromStore01(String searchLine) {
        String url = "https://localhost/1/"+searchLine;
        return this.restTemplate.getForObject(url, Phone.class);
    }
}
