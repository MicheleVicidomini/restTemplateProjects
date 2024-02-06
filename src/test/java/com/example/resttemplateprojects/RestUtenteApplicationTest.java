package com.example.resttemplateprojects;
import com.fasterxml.jackson.databind.ObjectMapper;
import inteface.IObjTest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.soap.support.SoapUtils;
import service.HttpCustomRequest;
import service.Urls;
import utente.User;
import utente.Utente;
import java.io.IOException;
import java.net.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class RestUtenteApplicationTest {
    String url = Urls.fooResoursceUrl;

    @Test
    public void userIsSaved_userIsDeleted_then200IsReceived_thenUserIsReuploadedInTheLastPosition()
            throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objMapper = new ObjectMapper();

        int userId = 111;
        ResponseEntity<String> response = restTemplate.getForEntity(url + userId, String.class);
        IObjTest userTmp = objMapper.readValue(response.getBody(), Utente.class);
        HttpCustomRequest postObj = new HttpCustomRequest(userTmp);
        restTemplate.delete(url + userId);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        System.out.println(userTmp);
        postObj.postForObject();
    }


    @Test
    public void givenUserDoesExists_userIsDeleted_then200IsReceived()

            throws IOException {
        Random rand = new Random();
        int id = 21;
        int statusCode = 200;
        HttpUriRequest request = new HttpDelete(url + id);
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        Assertions.assertEquals(statusCode, httpResponse.getStatusLine().getStatusCode());
    }  /* il codice di stato http ricevuto è 200 come previsto,ma il test fallisce poichè viene eseguito un confronto nell'assertEquals tra un intero 200 e
     e la stringa "200 OK". abbiamo inserito dunque manualmente 200*/

    @Test
    void setupSuite() throws IOException {
        URL firstUrl = null;
        try {
            firstUrl = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        URLConnection connection = null;
        try {
            connection = firstUrl.openConnection();
            connection.connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void restTemp() {
        RestTemplate restTemplate = new RestTemplate(); // abbiamo richiamato l'istanza dell'oggetto RestTemplate
        ResponseEntity<String> response =
                restTemplate.getForEntity(url + "1", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}