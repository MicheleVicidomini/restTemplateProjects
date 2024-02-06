package utente;

import inteface.IObjTest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.print.DocFlavor;
import java.io.Serializable;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Utente implements Serializable, IObjTest {
    String name;
    String city;
    String country;
    String secret;
    String id;

    public Utente(){

     }
    }


