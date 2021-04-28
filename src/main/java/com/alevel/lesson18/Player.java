package com.alevel.lesson18;

import java.io.Serializable;

public class Player implements Serializable {
    private String login;
    private int level;

    public Player(String login, int level) {
        this.login = login;
        this.level = level;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Player{" +
                "login='" + login + '\'' +
                ", level=" + level +
                '}';
    }
}
