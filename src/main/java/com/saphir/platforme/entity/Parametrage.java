package com.saphir.platforme.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "parametrage")
public class Parametrage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id_pram;
    String url;
    String verssion;
    String navigateur;

    public Parametrage(long id_pram, String url, String verssion, String navigateur) {
        this.id_pram = id_pram;
        this.url = url;
        this.verssion = verssion;
        this.navigateur = navigateur;
    }

    public Parametrage() {
    }

    public long getId_pram() {
        return id_pram;
    }

    public void setId_pram(long id_pram) {
        this.id_pram = id_pram;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVerssion() {
        return verssion;
    }

    public void setVerssion(String verssion) {
        this.verssion = verssion;
    }

    public String getNavigateur() {
        return navigateur;
    }

    public void setNavigateur(String navigateur) {
        this.navigateur = navigateur;
    }

    @Override
    public String toString() {
        return "Parametrage{" +
                "id_pram=" + id_pram +
                ", url='" + url + '\'' +
                ", verssion='" + verssion + '\'' +
                ", navigateur='" + navigateur + '\'' +
                '}';
    }
}
