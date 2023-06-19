package com.epicode.fire_alarm_system.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.epicode.fire_alarm_system.models.Feeler;


@RestController
public class alarmController {
   @Autowired 
   Feeler feeler;
    @GetMapping("/alarm") 
    public Object stationResponse() {
        RestTemplate rt = new RestTemplate();
        String baseUrl = "http://localhost:8080/alarm";
        if(feeler.getSmokeLevel() > 5) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
            .queryParam("feeler-id",feeler.getId())
            .queryParam("lat", feeler.getLat())
            .queryParam("lon", feeler.getLon())
            .queryParam("smokelevel", feeler.getSmokeLevel());

            String uri = uriBuilder.toUriString();

        Object response = rt.getForEntity(uri, String.class);
        return response;
        } else {
            return "NESSUN ALLARME";
        }
    }
 
}
