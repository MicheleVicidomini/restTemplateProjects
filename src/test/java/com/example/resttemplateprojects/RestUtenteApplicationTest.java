package com.example.resttemplateprojects;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.web.client.RestTemplate;
import service.CustomHttp;
import service.Urls;
import utente.Utente;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RestUtenteApplicationTest {
    String url = Urls.fooResoursceUrl;
@BeforeTestExecution
    public void setServerDefault() {
    RestTemplate restTemplate = new RestTemplate();
    ArrayList<Utente> user = new ArrayList<Utente>();
    for (int j = 0; j < 3; j++) {
        user.add(new Utente("primo", "it", "none", "none","none"));
        user.add(new Utente("secondo", "it", "none", "none","none"));
        user.add(new Utente("terzo", "it", "none", "none","none"));
        restTemplate.postForObject(url, user.get(j), Utente.class);
    }

}
    @Test
    public void checkUserOnServerThenDeleteAllUsers()
            throws JsonProcessingException {
        int userId = 1;
        Utente rsc = CustomHttp.getRsc(url, userId); // ritorna una risorsa presa tranite getEntity all'Url ed iD indicato
        System.out.println(rsc);
        for (int i = 1; i <= 3; i++) {
            CustomHttp.deleteRsc(url, i); // cancelliamo le risorse che abbiamo aggiunto in modo da liberare il server per i prossimi test
        }
    }
@Test
public void givenUserDoesExists_userIsDeleted_then200IsReceived()
        throws IOException {
        int id = 1;
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