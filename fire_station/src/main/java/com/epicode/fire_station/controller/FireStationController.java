package com.epicode.fire_station.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FireStationController {

    @GetMapping("/alarm") 
     public ResponseEntity<String> stationResponse() {
        return ResponseEntity.ok("EVACUARE L'EDIFICIO E SEGUIRE LE NORME DI SICUREZZA. I VIGILI DEL FUOCO STANNO ARRIVANDO.");
     }
}