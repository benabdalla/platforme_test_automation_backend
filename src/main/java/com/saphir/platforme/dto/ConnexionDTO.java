package com.saphir.platforme.dto;

public class ConnexionDTO {
    String login;
    String password;

    public ConnexionDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public ConnexionDTO() {
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
