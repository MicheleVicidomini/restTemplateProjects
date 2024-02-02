package com.example.resttemplateprojects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import utente.Utente;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class RestUtenteApplicationTest {

    @BeforeAll
    static void connessione() throws IOException {
        String indirizzoURL =  "https://65bb5fb252189914b5bbe4cf.mockapi.io/api/v1/users";
        URL url = null;
        try {
            url = new URL(indirizzoURL);
        }
        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        URLConnection connection = null;
        try {
            connection = url.openConnection();
            connection.connect();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

    }

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
        String fooResourceUrl =
                "https://65bb5fb252189914b5bbe4cf.mockapi.io/api/v1/users";
        ResponseEntity<String> response =
                restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }
}