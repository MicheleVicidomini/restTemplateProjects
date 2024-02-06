package service;

import interfacce.IObjTest;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.net.URI;

public class HttpCustomRequest implements Serializable,IObjTest {
    private final RestTemplate restTemplate;
    private final HttpEntity<IObjTest> request;
    public HttpCustomRequest(IObjTest obj){
        restTemplate = new RestTemplate();
        request = new HttpEntity<>(obj);
    }
    public IObjTest postForObject(){
        return postForObject(Urls.fooResoursceUrl);
    }

    public IObjTest postForObject(String url){
        return restTemplate.postForObject(url,request,IObjTest.class) ;
    }

    public URI postForLoc() {
        return postForLoc(Urls.fooResoursceUrl);
    }
     public  URI postForLoc(String url) {
        return restTemplate.postForLocation(url,request);
    }
}
