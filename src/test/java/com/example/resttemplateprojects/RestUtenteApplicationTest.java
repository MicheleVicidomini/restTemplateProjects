package com.example.resttemplateprojects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import utente.Utente;


public class RestUtenteApplicationTest {

    @Test
    void config() {

        RestTemplate restTemplate = new RestTemplate(); // abbiamo richiamato l'istanza dell'oggetto RestTemplate
        String fooResourceUrl =
                "https://65bb5fb252189914b5bbe4cf.mockapi.io/api/v1/users";
        HttpEntity<Utente> request = new HttpEntity<>(new Utente("Luigi", "Frattamaggiore", "Italia", "f", "2"));
        Utente utente = restTemplate.postForObject(fooResourceUrl, request, Utente.class);
        Assertions.assertNotNull(utente);
    }

    @Test
    void restTemp() {

        RestTemplate restTemplate = new RestTemplate(); // abbiamo richiamato l'istanza dell'oggetto RestTemplate
        String fooeResourceUrl =
                "https://65bb5fb252189914b5bbe4cf.mockapi.io/api/v1/users";
        ResponseEntity<String> response =
                restTemplate.getForEntity(fooeResourceUrl + "/1", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }
}