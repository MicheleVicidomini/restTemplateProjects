package utente;

import interfacce.IObjTest;

import java.io.Serializable;

public class User implements Serializable, IObjTest {
    int userId;
    private int id;
    private String title;


    private String body;


    public  User(int userId, int id, String title, String body) {
        this.userId=userId;
        this.id = id;
        this.title = title;
        this.body= body;


    };

    public int getName() {
        return userId;
    }

    public void setName(int name) {
        this.userId = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSecret() {
        return body;
    }

    public void setSecret(String secret) {
        this.body = secret;
    }


}

