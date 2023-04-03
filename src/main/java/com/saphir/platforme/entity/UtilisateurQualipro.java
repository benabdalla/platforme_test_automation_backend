package com.saphir.platforme.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "utilisateurQualipro")
public class UtilisateurQualipro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_user;
    String name;
    String login;
    String password;

    public UtilisateurQualipro(Long id_user, String name, String login, String password) {
        this.id_user = id_user;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public UtilisateurQualipro() {

    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
