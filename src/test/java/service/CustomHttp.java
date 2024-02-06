package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import interfacce.IObjTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import utente.Utente;

import java.io.Serializable;

public  class CustomHttp implements Serializable,IObjTest{ // Va creato un metodo parametrizzato
   private static final RestTemplate restTemplate = new RestTemplate();
    private static final ObjectMapper objmapper = new ObjectMapper();

    public static Utente getRsc (String url,int userId) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(url + userId, String.class);
        Utente user = objmapper.readValue(response.getBody(), Utente.class);
        return user ;
    }
    public static void postRsc(String url, Utente utente) {
        HttpEntity<Utente> request = new HttpEntity<>(utente);
        restTemplate.postForObject(url, request, Utente.class);
    }
    public static void deleteRsc(String url, int userId) {
        restTemplate.delete(url+userId);
    }



}
