package utente;

import javax.print.DocFlavor;
import java.io.Serializable;

public class Utente implements Serializable {
    String name;
    private String city;
    private String country;
    private String secret;
    private String id;

    public  Utente(String name, String city, String country,String secret, String id) {
        this.name=name;
        this.city= city;
        this.country= country;
        this.secret= secret;
        this.id=id;

    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
